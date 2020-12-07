package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Ticket;

//Ticket Display System
public class ViewTicketsJPanel extends JPanel{
	public LinkedList<Ticket> tickets = ViewAllFlightsJPanel.getTickets();
	JButton btnBackToMain  = new JButton("Back to Main Menu");
	JButton btnNext = new JButton("View Next Ticket");
	JButton btnPrev = new JButton("View Previous Ticket");
	JTextArea ticketDisplay;
	
	//Create Panel
	public ViewTicketsJPanel() {
		setLayout(new BorderLayout());
		JPanel view = new JPanel();
		JLabel title = new JLabel("View all Tickets");
		
		//Generate Elements
		ticketDisplay = new JTextArea(tickets.peekFirst().toString());
		ticketDisplay.setSize(200, 50);
		ticketDisplay.setEditable(false);
		
		//Add Elements to Panel
		view.add(title);
		view.add(ticketDisplay);
		view.add(btnNext, BorderLayout.SOUTH);
		view.add(btnPrev, BorderLayout.SOUTH);
		view.add(btnBackToMain, BorderLayout.SOUTH);
		
		add(view);
		
		//Implement Button Listener
		ButtonListener bl = new ButtonListener();
		btnBackToMain.addActionListener(bl);
		btnNext.addActionListener(bl);
		btnPrev.addActionListener(bl);
		
		
	}
	
	//Action Listener Class
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnBackToMain) {
				removeAll();
				MainMenuJPanel newPanel = new MainMenuJPanel();
				add(newPanel);
				validate();
				setVisible(true);
			} else if (e.getSource() == btnNext) {
				Ticket temp = new Ticket();
				temp = tickets.removeFirst();
				tickets.addLast(temp);
				ticketDisplay.setText(tickets.peekFirst().toString());
			} else if (e.getSource() == btnPrev) {
				Ticket temp = new Ticket();
				temp = tickets.removeLast();
				tickets.addFirst(temp);
				ticketDisplay.setText(tickets.peekFirst().toString());
			}
		}
	}
		
}
