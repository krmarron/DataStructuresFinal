package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Main menu class
public class MainMenuJPanel extends JPanel {
	JButton btnAddNewPassenger = new JButton("Add New Passenger");	//Create Passenger
	JButton btnViewAllFlights = new JButton("Select a Flight");		//Select Flight
	JButton btnViewTickets = new JButton("View Tickets");			//Ticket Display
	
	//Create Panel
	public MainMenuJPanel() {
		JLabel instructions = new JLabel(" SELECT AN OPTION TO CONTINUE ");
		
		//Implement Button Listener
		ButtonListener bl = new ButtonListener();
		btnAddNewPassenger.addActionListener(bl);
		btnViewAllFlights.addActionListener(bl);
		btnViewTickets.addActionListener(bl);
		
		//add elements to panel
		JPanel buttons = new JPanel();
		setLayout(new BorderLayout());
		add(instructions, BorderLayout.NORTH);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
		buttons.add(btnAddNewPassenger);
		buttons.add(btnViewAllFlights);
		buttons.add(btnViewTickets);
		
		add(buttons, BorderLayout.CENTER);
	}
	
	//Action Listener Class
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel newPanel = new JPanel();
			if (e.getSource() == btnAddNewPassenger) {
				newPanel = new AddPassengerJPanel();
			} else if (e.getSource() == btnViewAllFlights) {
				newPanel = new ViewAllFlightsJPanel();
			} else if (e.getSource() == btnViewTickets) {
				newPanel = new ViewTicketsJPanel();
			}
			
			sendToNewPanel(newPanel);
		}
		
		private void sendToNewPanel(JPanel newPanel) {
			removeAll();
			setVisible(false);
			add(newPanel);
			validate();
			setVisible(true);
		}
	}
}
