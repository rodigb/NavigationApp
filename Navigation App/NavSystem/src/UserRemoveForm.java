import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class UserRemoveForm {
	
	DefaultListModel<String> listModel;

	private JFrame frame;
	private Scanner x;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	
	public static void UserRemoveForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRemoveForm window = new UserRemoveForm();
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
	public UserRemoveForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 700, 400);
		
		frame.getContentPane().setLayout(null);
		
		JButton btnReadFile = new JButton("Read File");
		btnReadFile.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				((DefaultTableModel)table.getModel()).setNumRows(0); // button, so when pressed it reads the file if it exists
				
				Path path = Paths.get("RoadUser.txt");
				String filepath = "RoadUser.txt";
				File file = new File(filepath);
				
				if( !Files.exists(path))
					JOptionPane.showMessageDialog(null, "No File", "No data", JOptionPane.OK_OPTION);
					
				
				try {
					FileReader fr = new FileReader(file);
					@SuppressWarnings("resource")
					BufferedReader br = new BufferedReader(fr);
					
					DefaultTableModel model = (DefaultTableModel)table.getModel(); //inputs file data into table
					Object[] lines = br.lines().toArray();
					
					for(int i = 0; i< lines.length; i++) {
						String[] row = lines[i].toString().split(",");
						model.addRow(row);
					}
						
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				
				
				}
				
			
		});

		btnReadFile.setBounds(12, 71, 97, 25);
		frame.getContentPane().add(btnReadFile);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(true);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //button to delete the data from a row in a table
				
				
				
				int p = JOptionPane.showConfirmDialog(null,"Do you want to delete this row?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) {
				
				try {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int SelectedRowIndex = table.getSelectedRow();
				model.removeRow(SelectedRowIndex);
				}
				catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "No data selected", "No data", JOptionPane.OK_OPTION);
					
					//if none is selected it gives error message
					
				}
				
				}
				
				
				
			}
		});
		
		
		
		btnDelete.setBounds(12, 106, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Save");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null,"Do you want to save this data?", "Save", JOptionPane.YES_NO_OPTION);
				if(p==0) {
				
				
					File file = new File ("RoadUser.txt"); // if user saves it, it saves the file
					
				
				
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
		btnUpdate.setBounds(12, 144, 97, 25);
		frame.getContentPane().add(btnUpdate);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User Name", "Maximum Speed", "Vehicle", "Height", "Weight" //table columns
			}
			
			
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.setBounds(158, 25, 500, 300);
		frame.getContentPane().add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(131, 28, 397, 284);
		frame.getContentPane().add(scrollPane);
		
		JLabel lblremove = new JLabel("Remove user");
		lblremove.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblremove.setBounds(32, 13, 134, 16);
		frame.getContentPane().add(lblremove);
		
	}
}
