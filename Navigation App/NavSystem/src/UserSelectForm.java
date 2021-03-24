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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class UserSelectForm {
	
	DefaultListModel<String> listModel;

	private JFrame frame;
	private Scanner x;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void UserSelectForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSelectForm window = new UserSelectForm();
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
	public UserSelectForm() {
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
				
				((DefaultTableModel)table.getModel()).setNumRows(0);
				
				Path path = Paths.get("RoadUser.txt");
				String filepath = "RoadUser.txt";
				File file = new File(filepath); //finds the path for the file, if it doesnt exist an error will be shown
				
				if( !Files.exists(path))
					JOptionPane.showMessageDialog(null, "No File", "No data", JOptionPane.OK_OPTION);
					
				
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					Object[] lines = br.lines().toArray();
					
					for(int i = 0; i< lines.length; i++) {
						String[] row = lines[i].toString().split(","); //reads the file to input it into the rows of the table
						model.addRow(row);
					}
						
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				
				
				}
				
			
		});
		
	

		btnReadFile.setBounds(12, 71, 97, 25);
		frame.getContentPane().add(btnReadFile);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User Name", "Maximum Speed", "Vehicle", "Height", "Weight" //makes the table have different columns
			}
			
			
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.setBounds(158, 25, 500, 300);
		frame.getContentPane().add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(131, 28, 397, 284);
		frame.getContentPane().add(scrollPane);
	}
}
