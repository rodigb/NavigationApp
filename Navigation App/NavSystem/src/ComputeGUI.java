import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ComputeGUI {

	private JFrame frame;
	private JButton btnRead;
	private JButton btnSelect;
	private JButton btnCompute;
	private JTable table;
	String TF1 = "";
	String TF2 = "";
	String TF3 = "";
	String TF4 = "";
	String TF5 = "";
	String ped = "pedestrian";
	String ska = "skateboard";
	String car = "car";
	String bic = "bicycle";
	String mot = "motorcycle";
	String lor = "lorry";
	Double g = 9.81;
	int sw = 3;
	int bw = 6;
	int mw = 30;
	int cw = 1300;
	int lw = 44000; //mass of the vehicles in kg
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void ComputeGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComputeGUI window = new ComputeGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public ComputeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 386);
		
		frame.getContentPane().setLayout(null);

		btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				((DefaultTableModel) table.getModel()).setNumRows(0);

				Path path = Paths.get("RoadUser.txt");
				String filepath = "RoadUser.txt";
				File file = new File(filepath);

				if (!Files.exists(path))
					JOptionPane.showMessageDialog(null, "No File", "No data", JOptionPane.OK_OPTION);

				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr); //reads the file, makes it editable in a table and presented in it too

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					Object[] lines = br.lines().toArray();

					for (int i = 0; i < lines.length; i++) {
						String[] row = lines[i].toString().split(",");
						model.addRow(row);
					}

				} catch (FileNotFoundException e1) {

					e1.printStackTrace();
				}

			}

		});

		btnRead.setBounds(12, 45, 97, 25);
		frame.getContentPane().add(btnRead);

		btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				
				

				TF1 = (String) model.getValueAt(table.getSelectedRow(), 0);//name
				TF2 = (String) model.getValueAt(table.getSelectedRow(), 1);//max speed
				TF3 = (String) model.getValueAt(table.getSelectedRow(), 2); //vehicle //when a user selects a row, then clicks select
				TF4 = (String) model.getValueAt(table.getSelectedRow(), 3);//height
				TF5 = (String) model.getValueAt(table.getSelectedRow(), 4);//weight

				System.out.println(TF1);
				System.out.println(TF2);
				System.out.println(TF3);
				System.out.println(TF4);
				System.out.println(TF5);
				
				

			}
		});
		btnSelect.setBounds(12, 83, 97, 25);
		frame.getContentPane().add(btnSelect);

		btnCompute = new JButton("Compute ");
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 

				if (TF3.toLowerCase().indexOf(ped.toLowerCase()) != -1) {

					int a = (int) ((13 * (Integer.valueOf(TF5)) + 480 * (Integer.valueOf(TF4)) - 6 * 30 + 88) * (2.3 + ((Integer.valueOf(TF2)) - 1.7) * 1.3)
							* 0.048425);
					System.out.print(a);
					System.out.println(" Watts"); //formula and calculations for maximum power consumption
					
					JOptionPane.showMessageDialog(null, "Your total power consumption is " + a + " Watts!" , "Maximum power consumption!", JOptionPane.PLAIN_MESSAGE);
					
				} else if (TF3.toLowerCase().indexOf(ska.toLowerCase()) != -1) {

					int a = (int) ((13 * ((Integer.valueOf(TF5))+(sw)) + 480 * (Integer.valueOf(TF4)) - 6 * 30 + 88) * (5. + ((Integer.valueOf(TF2)) - 4) * 0.5)
							* 0.048425);
					System.out.print(a);
					System.out.println(" Watts");
					
					JOptionPane.showMessageDialog(null, "Your total power consumption is " + a + " Watts!" , "Maximum power consumption!", JOptionPane.PLAIN_MESSAGE);

				} else if (TF3.toLowerCase().indexOf(bic.toLowerCase()) != -1) {

					int a = (int) (0.6 * java.lang.Math.pow(((Integer.valueOf(TF2)) * 0.447), 3) * 0.7 * (Integer.valueOf(TF4))
							+ ((Integer.valueOf(TF4)) * 0.447) * (Integer.valueOf(TF5) + bw) * (g) * 0.005);
					System.out.print(a);
					System.out.println(" Watts");
					
					JOptionPane.showMessageDialog(null, "Your total power consumption is " + a + " Watts!" , "Maximum power consumption!", JOptionPane.PLAIN_MESSAGE);

				}

				else if (TF3.toLowerCase().indexOf(mot.toLowerCase()) != -1) {

					int a = (int) ((0.6 * java.lang.Math.pow(((Integer.valueOf(TF2)) * 0.447), 3) * 0.81 * 0.7
							+ ((Integer.valueOf(TF2)) * 0.447) * (Integer.valueOf(TF5) + mw) * (g) * 0.02));
					System.out.print(a);
					System.out.println(" Watts");
					
					JOptionPane.showMessageDialog(null, "Your total power consumption is " + a + " Watts!" , "Maximum power consumption!", JOptionPane.PLAIN_MESSAGE);

				}

				else if (TF3.toLowerCase().indexOf(car.toLowerCase()) != -1) {

					int a = (int) ((0.6 * java.lang.Math.pow(((Integer.valueOf(TF2)) * 0.447), 3) * 2 * 0.25
							+ ((Integer.valueOf(TF2)) * 0.447) * (Integer.valueOf(TF5) + cw) * (g) * 0.01));
					System.out.print(a);
					System.out.println(" Watts");
					
					JOptionPane.showMessageDialog(null, "Your total power consumption is " + a + " Watts!" , "Maximum power consumption!", JOptionPane.PLAIN_MESSAGE);

				}

				else if (TF3.toLowerCase().indexOf(lor.toLowerCase()) != -1) {

					int a = (int) ((0.6 * java.lang.Math.pow(((Integer.valueOf(TF2)) * 0.447), 3) * 8 * 0.5
							+ ((Integer.valueOf(TF2)) * 0.447) * (Integer.valueOf(TF5) + lw) * (g) * 0.006));
					
					System.out.print(a);
					System.out.println(" Watts");

					
					JOptionPane.showMessageDialog(null, "Your total power consumption is " + a + " Watts!" , "Maximum power consumption!", JOptionPane.PLAIN_MESSAGE);
					
				}

				else {
					JOptionPane.showMessageDialog(null, "Invalid method of travel! Please edit the data properly" , "Maximum power consumption!", JOptionPane.WARNING_MESSAGE);
					System.out.println("Invalid method of travel");
				}

			}
		});
		btnCompute.setBounds(12, 121, 97, 25);
		frame.getContentPane().add(btnCompute);

		table = new JTable();

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "User Name", "Max Speed", "Vehicle", "Height", "Weight" } //colums for table

		));
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.setBounds(131, 28, 397, 284);
		frame.getContentPane().add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(131, 28, 397, 284);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblcompute = new JLabel("Compute");
		lblcompute.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcompute.setBounds(32, 13, 134, 16);
		frame.getContentPane().add(lblcompute);
	}

}
