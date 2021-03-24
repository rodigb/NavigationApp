import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class UserWrite {
	
	DefaultListModel<String> listModel;

	private JFrame frame;
	private Scanner x;
	private JTable table;
	String a = "";

	/**
	 * Launch the application.
	 */
	public static void UserWrite(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWrite window = new UserWrite();
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
	public UserWrite() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 1300, 800);
		
		frame.getContentPane().setLayout(null);
		
		JButton btnAddRoads = new JButton("Save Roads");
		btnAddRoads.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null,"Do you want to save this data? This will overwrite the applications own file.", "Save", JOptionPane.YES_NO_OPTION);
				if(p==0) {
				
				
					File file = new File ("RoadList.txt"); //makes it so that the roads can be saved
					
				
				
				FileWriter fw = null;
				try {
					fw = new FileWriter(file.getAbsoluteFile());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BufferedWriter bw = new BufferedWriter(fw);
				
				int rowcount = table.getRowCount();
				int columncount = table.getColumnCount();
				
					for(int i = 0;i<rowcount;i++) {
						for(int j = 0; j < table.getColumnCount();j++) {
							try {
								bw.write((String)table.getModel().getValueAt(i, j) + ",");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						try {
							bw.write("\n");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					try {
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				}
				
			
		});

		btnAddRoads.setBounds(12, 71, 108, 25);
		frame.getContentPane().add(btnAddRoads);
		
		JButton btnChoose = new JButton("Choose file");
		btnChoose.setEnabled(true);
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new java.io.File("./src"));
				
				fc.setDialogTitle(".");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				if (fc.showOpenDialog(btnChoose) == JFileChooser.APPROVE_OPTION) { //finding the location of the users selected file
					
				}
				System.out.println(fc.getSelectedFile().getAbsolutePath());
				
				a = fc.getSelectedFile().getAbsolutePath();

				}

			
		});
		
		btnChoose.setBounds(12, 106, 108, 25);
		frame.getContentPane().add(btnChoose);
		
		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				
				String filepath = a;
				System.out.println(a);
				File file = new File(filepath); //gets filepath and opens the file to read it
				
				try {
					FileReader fr = new FileReader(file); 
					BufferedReader br = new BufferedReader(fr);
					
					DefaultTableModel model1 = (DefaultTableModel)table.getModel();
					Object[] lines = br.lines().toArray();
					
					for(int i = 0; i< lines.length; i++) {
						String[] row = lines[i].toString().split(",");
						model1.addRow(row);
					}
						
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnRead.setBounds(12, 144, 108, 25);
		frame.getContentPane().add(btnRead);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Road Name", "Intersection1", "Intersection2", "Length", "Speed", "One Way", "Height", "State", "Pedestrians", "Skateboards", "Bicycles", "Motorcycles", "Cars", "Lorries" //columns for table
			}
			
			
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.setBounds(158, 45, 1100, 600);
		frame.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(158, 45, 1052, 600);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblUserWriteRoads = new JLabel("User Write roads");
		lblUserWriteRoads.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserWriteRoads.setBounds(12, 24, 138, 16);
		frame.getContentPane().add(lblUserWriteRoads);
		
	}
}
