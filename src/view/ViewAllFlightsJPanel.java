package view;
import controller.buildProgram;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.Flight;
import model.Passenger;
import model.Ticket;
import model.Flight;

//View All Flights/Flight Selection Panel
public class ViewAllFlightsJPanel extends JPanel {
	Flight[] flights = buildProgram.createFlights(); //generates flights into an array
	JButton btnBackToMain = new JButton("Back to Main Menu"); //return to main menu
	JButton btnSelectFlight = new JButton("Select Flight");	//Select a flight and generate ticket
	
	//Flight selector radio Buttons
	JRadioButton flightButton1 = new JRadioButton(flights[0].toString());
	JRadioButton flightButton2 = new JRadioButton(flights[1].toString());
	JRadioButton flightButton3 = new JRadioButton(flights[2].toString());
	JRadioButton flightButton4 = new JRadioButton(flights[3].toString());
	JRadioButton flightButton5 = new JRadioButton(flights[4].toString());
	
	private JTextField txtPassengerName = new JTextField();	//Text Field to enter passenger name
	private static LinkedList<Ticket> tickets = new LinkedList<Ticket>();	//Linked list that holds all generated tickets
	
	//Get tickets method for ticket display class
	public static LinkedList<Ticket> getTickets() {
		return tickets;
	}
	
	//Create the panel
	
	public ViewAllFlightsJPanel() {
		setLayout(new BorderLayout());
		JPanel form = new JPanel();
		JLabel title = new JLabel("List of Flights");
		
		//group flight buttons
		ButtonGroup group = new ButtonGroup();
		group.add(flightButton1);
		group.add(flightButton2);
		group.add(flightButton3);
		group.add(flightButton4);
		group.add(flightButton5);
		
		//add elements to panel
		form.add(flightButton1, BorderLayout.WEST);
		form.add(flightButton2, BorderLayout.WEST);
		form.add(flightButton3, BorderLayout.WEST);
		form.add(flightButton4, BorderLayout.WEST);
		form.add(flightButton5, BorderLayout.WEST);
		JLabel passengerName = new JLabel("Passenger Name");
		form.add(passengerName);
		form.add(txtPassengerName, "6, 6, fill");
		txtPassengerName.setColumns(30);
		form.add(btnSelectFlight);
		form.add(btnBackToMain);
		JLabel lblSelectFlight = new JLabel("Select a Flight");
		add(lblSelectFlight, BorderLayout.NORTH);
		add(form);
		
		//Implement button listener
		ButtonListener bl = new ButtonListener();
		btnSelectFlight.addActionListener(bl);
		btnBackToMain.addActionListener(bl);
		flightButton1.addActionListener(bl);
		flightButton2.addActionListener(bl);
		flightButton3.addActionListener(bl);
		flightButton4.addActionListener(bl);
		flightButton5.addActionListener(bl);
		
	}
	
	//Selection Sort Method
	public void sort(LinkedList<Ticket> t) {
		int n = t.size();
		
		for (int i = 0; i < n-1; i++) {
			int min =  i;
			for (int j = i+1; j < n; j++) {
				if (t.get(j).getPassengerId() < t.get(min).getPassengerId()) {
					min = j;
				}
			}
			Ticket temp = t.get(min);
			Ticket curr = t.get(i);
			t.set(i, temp);
			t.set(min, curr);
		}
	}
	
	//Number gen for seat assignment
	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	//Action Listener class
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<Passenger> allPassengers = AddPassengerJPanel.getAllPassengers();
			if (e.getSource() == btnSelectFlight) {
				Ticket t = new Ticket();
				int seat = getRandomNumber(1, 100);
				for(Passenger passenger : allPassengers) {
					if (passenger.getName().equals(txtPassengerName.getText())) {
						t.setPassengerId(passenger.getId());
					}
				}
				//Flight 1
				if (flightButton1.isSelected()) {
					t.setFlightId(flights[0].getId());
					t.setOrig(flights[0].getOrigin());
					t.setDest(flights[0].getDestination());
					t.setSeat(seat);
				//Flight 2
				} else if (flightButton2.isSelected()) {
					t.setFlightId(flights[1].getId());
					t.setOrig(flights[1].getOrigin());
					t.setDest(flights[1].getDestination());
					t.setSeat(seat);
				//Flight 3
				} else if (flightButton3.isSelected()) {
					t.setFlightId(flights[2].getId());
					t.setOrig(flights[2].getOrigin());
					t.setDest(flights[2].getDestination());
					t.setSeat(seat);
				//Flight 4
				} else if (flightButton4.isSelected()) {
					t.setFlightId(flights[3].getId());
					t.setOrig(flights[3].getOrigin());
					t.setDest(flights[3].getDestination());
					t.setSeat(seat);
				//Flight 5
				} else if (flightButton5.isSelected()) {
					t.setFlightId(flights[4].getId());
					t.setOrig(flights[4].getOrigin());
					t.setDest(flights[4].getDestination());
					t.setSeat(seat);
				}
				txtPassengerName.setText("");
				tickets.push(t); //Add ticket to linked list
				sort(tickets);	 //Sort linked list
				
			//Return to main menu
			}else if (e.getSource() == btnBackToMain) {
				removeAll();
				MainMenuJPanel newPanel = new MainMenuJPanel();
				add(newPanel);
				validate();
				setVisible(true);
			}
		}
	}
}
