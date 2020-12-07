package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.Passenger;

//Passenger Creation JPanel
public class AddPassengerJPanel extends JPanel {
	private JTextField txtPassengerId;
	private JTextField txtPassengerName;
	private JTextField txtPassengerStatus;
	JButton btnClear = new JButton("Clear");
	JButton btnSubmit = new JButton("Submit");
	JButton btnBackToMain = new JButton("Back to Main Menu");
	JLabel lblError = new JLabel("");
	private static ArrayList<Passenger> allPassengers = new ArrayList<Passenger>();	//Stores passengers
	
	//Getter method for passenger ArrayList for ticket creation
	public static ArrayList<Passenger> getAllPassengers() {
		return allPassengers;
	}
	
	//Create Panel
	public AddPassengerJPanel() {
		setLayout(new BorderLayout());
		JPanel form = new JPanel();
		form.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, 
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, 
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, 
						FormSpecs.DEFAULT_ROWSPEC, }));
		
		//generate and position elements
		JLabel lblEnterANew = new JLabel("Enter A New Passenger");
		add(lblEnterANew, BorderLayout.NORTH);
		
		JLabel lblPassengerId = new JLabel("ID: ");
		form.add(lblPassengerId, "4, 4, right, default");
		
		txtPassengerId = new JTextField();
		form.add(txtPassengerId, "6, 4, fill, default");
		txtPassengerId.setColumns(10);
		
		JLabel lblPassengerName = new JLabel("Name: ");
		form.add(lblPassengerName, "4, 6, right, default");
		
		txtPassengerName = new JTextField();
		form.add(txtPassengerName, "6, 6, fill, default");
		txtPassengerName.setColumns(10);
		
		JLabel lblStatus = new JLabel("Preferred Class (1-3): ");
		form.add(lblStatus, "4, 8, right, default");
		
		txtPassengerStatus = new JTextField();
		form.add(txtPassengerStatus, "6, 8, fill, default");
		txtPassengerStatus.setColumns(10);
		
		
		form.add(lblError, "4, 10, right, default");
		
		//implement button listener
		buttonListener bl = new buttonListener();
		btnSubmit.addActionListener(bl);
		btnClear.addActionListener(bl);
		btnBackToMain.addActionListener(bl);
		
		form.add(btnSubmit, "6, 10");
		form.add(btnClear, "6, 12");
		
		add(form,BorderLayout.CENTER);
		
		form.add(btnBackToMain, "6, 14");
	}
	
	//Action Listener Class
	class buttonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmit) {
				try {
					Passenger passengerToAdd;
					passengerToAdd = new Passenger(Integer.parseInt(txtPassengerId.getText()), txtPassengerName.getText(), Integer.parseInt(txtPassengerStatus.getText()));
			
					allPassengers.add(passengerToAdd);
				} catch (Exception e2) {
					lblError.setText("All fields are required");
				}
				clearAllFields();
			} else if (e.getSource() == btnClear) {
				clearAllFields();
			}else if (e.getSource() == btnBackToMain) {
				removeAll();
				MainMenuJPanel newPanel = new MainMenuJPanel();
				add(newPanel);
				validate();
				setVisible(true);
			}
		}
		
		private void clearAllFields() {
			txtPassengerId.setText("");
			txtPassengerName.setText("");
			txtPassengerStatus.setText("");
		}
	}
}
