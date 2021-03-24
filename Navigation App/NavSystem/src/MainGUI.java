import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class MainGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Navigation System");
		frame.setBounds(100, 100, 297, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add Road");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddGUI nw = new AddGUI();
				nw.AddGUI();
				
			}
		});
		btnAdd.setBounds(89, 29, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteForm nw = new DeleteForm();
				nw.DeleteForm(); //makes it so that the button goes to another page
				
			}
		});
		btnEdit.setBounds(89, 104, 97, 25);
		frame.getContentPane().add(btnEdit);
		
		JButton btnWrite = new JButton("Write and add roads");
		btnWrite.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				UserWrite nw = new UserWrite();
				nw.UserWrite(); //makes it so that the button goes to another page
				
			
				
				
			}
		});
		btnWrite.setBounds(48, 142, 178, 25);
		frame.getContentPane().add(btnWrite);
		
		JButton btnAddUser = new JButton("Users");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RoadUser nw = new RoadUser();
				nw.RoadUser(); //makes it so that the button goes to another page
				
			}
		});
		btnAddUser.setBounds(89, 66, 97, 25);
		frame.getContentPane().add(btnAddUser); //GUI Button creation
		
		JButton btnCompute = new JButton("Compute");
		btnCompute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ComputeGUI nw = new ComputeGUI();
				nw.ComputeGUI(); //makes it so that the button goes to another page
				
			}
		});
		btnCompute.setBounds(89, 180, 97, 25);
		frame.getContentPane().add(btnCompute);
	}
}
