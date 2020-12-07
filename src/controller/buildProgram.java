package controller;
import model.Flight;

//Generates flights to choose from
public class buildProgram {
	public static Flight[] createFlights() {
		Flight flight1 = new Flight(1, "Delta", "Seattle", "Des Moines");
		Flight flight2 = new Flight(2, "USAir", "Des Moines", "Atlanta");
		Flight flight3 = new Flight(3, "Delta", "Atlanta", "New York City");
		Flight flight4 = new Flight(4, "American Air", "Salt Lake City", "Minneapolis");
		Flight flight5 = new Flight(5, "Southwest Airlines", "Omaha", "Miami");
		Flight[] flights = new Flight[] {flight1, flight2, flight3, flight4, flight5};
		return flights;
	}
}
