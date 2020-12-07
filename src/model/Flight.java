package model;

//Flight class
public class Flight extends Passenger{
	private int id;					//Flight id
	private String airline;			//Airline name
	private String origin;			//Flight origin
	private String destination;		//Flight Destination
	
	//Constructor Methods
	public Flight() {
		
	}
	public Flight(int passengerId, int id, String origin, String destination) {
		super(passengerId);
		this.id = getId();
		this.origin = getOrigin();
		this.destination = getDestination();
	}
	public Flight(int id, String airline, String origin, String destination) {
		this.id = id;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
	}

	//Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	//To String method for display

	@Override
	public String toString() {
		return "Flight " + id + ": Airline: " + airline + ", Origin: " + origin + ", Destination: " + destination + ".";
	}
	
	
}
