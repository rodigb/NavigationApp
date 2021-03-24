import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoadUser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void RoadUser() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoadUser window = new RoadUser();
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
	public RoadUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 417, 255);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddRoadUser = new JButton("Add Road User");
		btnAddRoadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddRoadUser nw = new AddRoadUser();
				nw.AddRoadUser();
				
			}
		});
		btnAddRoadUser.setBounds(24, 60, 156, 64);
		frame.getContentPane().add(btnAddRoadUser);
		
		JButton btnRemoveRoadUser = new JButton("Remove Road User");// 2 buttons made to move to 2 separate forms.
		btnRemoveRoadUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserRemoveForm nw = new UserRemoveForm();
				nw.UserRemoveForm();
				
			}
		});
		btnRemoveRoadUser.setBounds(217, 60, 156, 64);
		frame.getContentPane().add(btnRemoveRoadUser);
	}
}
