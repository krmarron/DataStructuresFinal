/**************************************************************
* Name        : Data Structures Fall 2020 Final
* Author      : Kasey Marron
* Created     : 12/7/2020
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : Creates a JPanel GUI that allows the user to add passengers
* 				and then select a flight. Once a flight is selected a plane
* 				ticket is generated and stored to a linked list where it is
* 				sorted based on Passenger Id. The user can also see all stored
* 				tickets to verify their flight information.
*               Input:  Create Passenger
*               		Select Flight
*               
*               Output: Ticket generation
*               
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/


import java.lang.reflect.Array;

import javax.swing.JFrame;

import model.*;
import view.MainMenuJPanel;

//Starts GUI and loads Main Menu Screen
public class Driver {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MainMenuJPanel panel = new MainMenuJPanel();
		frame.add(panel);
		
		frame.setSize(500, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
