import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
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
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class DeleteForm {
	
	DefaultListModel<String> listModel;

	private JFrame frame;
	private Scanner x;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void DeleteForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteForm window = new DeleteForm();
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
	public DeleteForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 1300, 800);
		
		frame.getContentPane().setLayout(null);
		
		JButton btnReadFile = new JButton("Read File");
		btnReadFile.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				((DefaultTableModel)table.getModel()).setNumRows(0);
				
				String filepath = "RoadList.txt";
				File file = new File(filepath);
				
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					
					DefaultTableModel model = (DefaultTableModel)table.getModel(); // reads the file
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
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null,"Do you want to delete this row?", "Delete", JOptionPane.YES_NO_OPTION);
				if(p==0) { // makes the rows deletable from the table
				
				try {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int SelectedRowIndex = table.getSelectedRow();
				model.removeRow(SelectedRowIndex);
				}
				catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "No data selected, Please go to Write and Add Roads to add a file.", "No data", JOptionPane.OK_OPTION);
					
					
					
				}
				
				}
				
				
				
			}
		});
		
		
		
		btnDelete.setBounds(12, 106, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null,"Do you want to save this data?", "Save", JOptionPane.YES_NO_OPTION);
				if(p==0) { //makes the values in the table save to the text file
				
				
					File file = new File ("RoadList.txt");
					
				
				
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
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        

        
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Road Name", "Intersection1", "Intersection2", "Length", "Speed", "One Way", "Height", "State", "Pedestrians", "Skateboards", "Bicycles", "Motorcycles", "Cars", "Lorries"
			}
			
			
		));
		
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.setBounds(158, 45, 1100, 600);
		frame.getContentPane().add(table);
		
		JLabel lblEditAndDelete = new JLabel("Edit and Delete");
		lblEditAndDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditAndDelete.setBounds(12, 13, 141, 16);
		frame.getContentPane().add(lblEditAndDelete);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(158, 45, 1052, 600);
		frame.getContentPane().add(scrollPane);
	}
}
