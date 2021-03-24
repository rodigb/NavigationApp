import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class AddGUI {

	private JFrame frame;
	private JTextField TFint1;
	private JTextField TFint2;
	private JTextField TFlen;
	private JTextField TFspe;
	private JTextField TFow;
	private JTextField TFsta;
	private JTextField TFp;
	private JTextField TFs;
	private JTextField TFb;
	private JTextField TFm;
	private JTextField TFc;
	private JTextField TFl;
	private JTextField TFr;
	

	
	/**
	 * Launch the application.
	 */
	public static void AddGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGUI window = new AddGUI();
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
	public AddGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 482, 588);
		
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String road = TFr.getText().toString();
				String int1 = TFint1.getText().toString();
				String int2 = TFint2.getText().toString();
				String len = TFlen.getText().toString();
				String spe = TFspe.getText().toString();
				String ow = TFow.getText().toString();
				String sta = TFsta.getText().toString();
				String ped = TFp.getText().toString();
				String ska = TFs.getText().toString();
				String bic= TFb.getText().toString();
				String mot = TFm.getText().toString();
				String car = TFc.getText().toString();
				String lor = TFl.getText().toString();
				
				if ((TFr.getText().isEmpty() || TFint1.getText().isEmpty() || TFint2.getText().isEmpty() || TFlen.getText().isEmpty()
						|| TFspe.getText().isEmpty()|| TFow.getText().isEmpty()|| TFsta.getText().isEmpty()) ) //if the fields are empty, an error is given
				{
					System.err.println("error");
					JOptionPane.showMessageDialog(null,"You have some empty fields for required fields!", "Empty fields", JOptionPane.ERROR_MESSAGE);
				}
				else if (!sta.equals("0")&&  !sta.equals("1") && !sta.equals("-1")){
					System.out.println(sta);
					JOptionPane.showMessageDialog(null,"You're state is invalid, use 0, 1 or -1!", "Invalid input", JOptionPane.ERROR_MESSAGE);
				} //if the values for state is not -1, 0 or 1 it gives another error
				
				else {
					
					JOptionPane.showConfirmDialog(null,"Do you want to save this data?", "Save", JOptionPane.YES_NO_OPTION);
				
				try {
					
					FileWriter writer = new FileWriter("RoadList.txt", true); //gets file and saves values enterd to the file
					
					writer.write("\n" + road);
					
				    writer.write("," + int1);
				    
					writer.write("," + int2);
					writer.write("," + len);
					writer.write("," + spe);
					writer.write("," + ow);
					writer.write("," + sta);
					writer.write("," + ped);
					writer.write("," + ska);
					writer.write("," + bic);
					writer.write("," + mot);
					writer.write("," + car);
					writer.write("," + lor);

					writer.close();
					System.out.println("Success");
					
					
					
				}catch (Exception e1) {
					System.out.println("error");
					
					
					
				}
				}
				
				}
				
				}
				
			
		);
		btnSubmit.setBounds(250, 473, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblAddRoad = new JLabel("Add Road");
		lblAddRoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddRoad.setBounds(26, 0, 97, 44);
		frame.getContentPane().add(lblAddRoad);
		
		JLabel lblIntersection = new JLabel("Intersection 1*");
		lblIntersection.setBounds(44, 80, 97, 16);
		frame.getContentPane().add(lblIntersection);
		
		JLabel lblIntersection_1 = new JLabel("Intersection 2*");
		lblIntersection_1.setBounds(44, 109, 97, 16);
		frame.getContentPane().add(lblIntersection_1);
		
		JLabel lblLength = new JLabel("Length*");
		lblLength.setBounds(44, 138, 56, 16);
		frame.getContentPane().add(lblLength);
		
		JLabel lblSpeed = new JLabel("Speed*");
		lblSpeed.setBounds(44, 169, 56, 16);
		frame.getContentPane().add(lblSpeed);
		
		JLabel lblOneWay = new JLabel("One way*");
		lblOneWay.setBounds(44, 198, 56, 16);
		frame.getContentPane().add(lblOneWay);
		
		JLabel lblState = new JLabel("State*");
		lblState.setBounds(44, 227, 56, 16);
		frame.getContentPane().add(lblState);
		
		JLabel lblPedestrians = new JLabel("Pedestrians");
		lblPedestrians.setBounds(44, 256, 97, 16);
		frame.getContentPane().add(lblPedestrians);
		
		JLabel lblSkateboards = new JLabel("Skateboards");
		lblSkateboards.setBounds(46, 284, 97, 16);
		frame.getContentPane().add(lblSkateboards);
		
		JLabel lblBicycles = new JLabel("Bicycles");
		lblBicycles.setBounds(46, 313, 56, 16);
		frame.getContentPane().add(lblBicycles);
		
		JLabel lblMotorcycles = new JLabel("Motorcycles");
		lblMotorcycles.setBounds(46, 342, 78, 16);
		frame.getContentPane().add(lblMotorcycles);
		
		JLabel lblCars = new JLabel("Cars");
		lblCars.setBounds(46, 371, 56, 16);
		frame.getContentPane().add(lblCars);
		
		JLabel lblLorries = new JLabel("Lorries");
		lblLorries.setBounds(46, 401, 56, 16);
		frame.getContentPane().add(lblLorries);
		
		TFint1 = new JTextField();
		TFint1.setBounds(167, 77, 265, 22);
		frame.getContentPane().add(TFint1);
		TFint1.setColumns(10);
		
		TFint2 = new JTextField();
		TFint2.setColumns(10);
		TFint2.setBounds(167, 106, 265, 22);
		frame.getContentPane().add(TFint2);
		
		TFlen = new JTextField();
		TFlen.setColumns(10);
		TFlen.setBounds(167, 135, 265, 22);
		frame.getContentPane().add(TFlen);
		
		TFspe = new JTextField();
		TFspe.setColumns(10);
		TFspe.setBounds(167, 166, 265, 22);
		frame.getContentPane().add(TFspe);
		
		TFow = new JTextField();
		TFow.setColumns(10);
		TFow.setBounds(167, 195, 265, 22);
		frame.getContentPane().add(TFow);
		
		TFsta = new JTextField();
		TFsta.setColumns(10);
		TFsta.setBounds(167, 224, 265, 22);
		frame.getContentPane().add(TFsta);
		
		TFp = new JTextField();
		TFp.setColumns(10);
		TFp.setBounds(167, 253, 265, 22);
		frame.getContentPane().add(TFp);
		
		TFs = new JTextField();
		TFs.setColumns(10);
		TFs.setBounds(169, 281, 265, 22);
		frame.getContentPane().add(TFs);
		
		TFb = new JTextField();
		TFb.setColumns(10);
		TFb.setBounds(169, 310, 265, 22);
		frame.getContentPane().add(TFb);
		
		TFm = new JTextField();
		TFm.setColumns(10);
		TFm.setBounds(169, 339, 265, 22);
		frame.getContentPane().add(TFm);
		
		TFc = new JTextField();
		TFc.setColumns(10);
		TFc.setBounds(169, 368, 265, 22);
		frame.getContentPane().add(TFc);
		
		TFl = new JTextField();
		TFl.setColumns(10);
		TFl.setBounds(169, 398, 265, 22);
		frame.getContentPane().add(TFl);
		
		JLabel Road = new JLabel("Road name*");
		Road.setBounds(44, 51, 97, 16);
		frame.getContentPane().add(Road);
		
		TFr = new JTextField();
		TFr.setColumns(10);
		TFr.setBounds(167, 48, 265, 22);
		frame.getContentPane().add(TFr);
	}
}
