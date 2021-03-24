import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class AddRoadUser {

	private JFrame frame;
	private JTextField TFn;
	private JTextField TFms;
	private JTextField TFv;
	private JTextField TFh;
	private JTextField TFw;

	/**
	 * Launch the application.
	 */
	public static void AddRoadUser(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoadUser window = new AddRoadUser();
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
	public AddRoadUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 288, 314);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showConfirmDialog(null,"Do you want to save this data?", "Save", JOptionPane.YES_NO_OPTION);
				
				
				
				if (TFn.getText().isEmpty() || TFms.getText().isEmpty() || TFv.getText().isEmpty() || TFh.getText().isEmpty()
						|| TFw.getText().isEmpty()
						)
				{
					System.err.println("error");
					JOptionPane.showMessageDialog(null,"You have some empty fields for required fields!", "Empty fields", JOptionPane.ERROR_MESSAGE);
				
				} //Makes it so that when the fields are empty, it will give an error to the user, gives a message if it is

				
				
				else {
					
				String name = TFn.getText().toString();
				String maxs = TFms.getText().toString();
				String veh = TFv.getText().toString();
				String hei = TFh.getText().toString();
				String wei = TFw.getText().toString();
				//gets the values from the text fields and puts it into the variables as strings
				
				if(!veh.equals("car") && !veh.equals("lorry")&&!veh.equals("pedestrian")&&!veh.equals("bicycle")&&!veh.equals("motorcycle")&&!veh.equals("skateboard")) {
					System.out.println(veh);
					JOptionPane.showMessageDialog(null,"Your vehicle field must be: car, bicycle, pedestrian, motorcycle, skateboard or lorry", "Wrong fields", JOptionPane.ERROR_MESSAGE);
					
					}
				
				else {
				
				
				
					try {
					
						Integer x = Integer.parseInt(maxs);
						Integer y = Integer.parseInt(hei);
						Integer z = Integer.parseInt(wei);
					
						System.out.println(x);
						System.out.println(y);
						System.out.println(z);
					
						}catch (NumberFormatException ex) {
							System.out.println("error");
							System.err.println("error"); // makes it so that the user inputs values that are integers, if not it gives an error message
					
							JOptionPane.showMessageDialog(null,"You have some fields that must be integers!", "Empty fields", JOptionPane.ERROR_MESSAGE);
						}
				
					try {
					
					File f = new File("RoadUser.txt");
					if(!f.exists()){
					  f.createNewFile();
					}else{
					  System.out.println("File already exists"); //if a file doesnt exist, one will be created
					}
					
					FileWriter writer = new FileWriter("RoadUser.txt", true);
					
					
					
					writer.write(name);
				    writer.write("," + maxs);
					writer.write("," + veh);
					writer.write("," + hei);
					writer.write("," + wei + "\n"); //values are written on to text file and saved.
					
					
					writer.close();
					System.out.println("Success");}
					
					catch(Exception e1){
						
					}
					
				
				
				
				}
				}
			}
				
		});
		btnSubmit.setBounds(80, 217, 97, 25); //GUI design
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 47, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblMaximumSpeed = new JLabel("Maximum Speed");
		lblMaximumSpeed.setBounds(12, 76, 97, 16);
		frame.getContentPane().add(lblMaximumSpeed);
		
		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setBounds(12, 105, 56, 16);
		frame.getContentPane().add(lblVehicle);
		
		JLabel lblHeight = new JLabel("Height (cm)");
		lblHeight.setBounds(12, 134, 72, 16);
		frame.getContentPane().add(lblHeight);
		
		TFn = new JTextField();
		TFn.setBounds(131, 44, 116, 22);
		frame.getContentPane().add(TFn);
		TFn.setColumns(10);
		
		TFms = new JTextField();
		TFms.setColumns(10);
		TFms.setBounds(131, 73, 116, 22);
		frame.getContentPane().add(TFms);
		
		TFv = new JTextField();
		TFv.setColumns(10);
		TFv.setBounds(131, 102, 116, 22);
		frame.getContentPane().add(TFv);
		
		TFh = new JTextField();
		TFh.setColumns(10);
		TFh.setBounds(131, 131, 116, 22);
		frame.getContentPane().add(TFh);
		
		JLabel lblAddRoadUser = new JLabel("Add Road User");
		lblAddRoadUser.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddRoadUser.setBounds(62, 13, 134, 16);
		frame.getContentPane().add(lblAddRoadUser);
		
		TFw = new JTextField();
		TFw.setColumns(10);
		TFw.setBounds(131, 166, 116, 22);
		frame.getContentPane().add(TFw);
		
		JLabel lblWeightkg = new JLabel("Weight (kg)");
		lblWeightkg.setBounds(12, 169, 72, 16);
		frame.getContentPane().add(lblWeightkg);
	}
}
