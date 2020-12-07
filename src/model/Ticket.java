package model;

//Ticket Class
public class Ticket extends Flight {
	private int passengerId;
	private int flightId;
	private int seat;
	private String orig;
	private String dest;
	
	//Constructors
	public Ticket() {
		super(); //collects flightId, PassengerId, Origin, and Destination
	}
	
	public Ticket(int passengerId, int flightId, int seat, String orig, String dest) {
		super(passengerId, flightId, orig, dest);
		this.seat = seat;
	}

	//Getters and Setters
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getOrig() {
		return orig;
	}

	public void setOrig(String orig) {
		this.orig = orig;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}
	
	//Display Method used for ticket display system
	@Override
	public String toString() {
		return "Passenger ID: " + passengerId + "\nFlight Id: " + flightId + "\nSeat: " + seat +
				"\nFlight Origin: " + orig + "\nFlight Destination: " + dest;

	}
	
	
}
