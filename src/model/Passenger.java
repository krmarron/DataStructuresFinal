package model;

//Passenger Class
public class Passenger {
	private int id;
	private String name;
	private int status;
	
	//Constructor Methods
	public Passenger() {
		
	}
	
	public Passenger(int id) {
		this.id = getId();
	}
	
	public Passenger(String name, int status) {
		this.name = name;
		this.status = status;
	}
	
	public Passenger(int id, String name, int status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	//Getters And Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	//Display Method (Not Used)
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
	
}
