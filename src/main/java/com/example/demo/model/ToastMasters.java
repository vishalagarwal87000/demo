package com.example.demo.model;

public class ToastMasters {
	private int id;
    private String location;
    private String type;
    private int NoOfEvents;
    private int NoOfYears;
    
    
	public ToastMasters(int id, String location, String type, int noOfEvents, int noOfYears) {
		super();
		this.id = id;
		this.location = location;
		this.type = type;
		NoOfEvents = noOfEvents;
		NoOfYears = noOfYears;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNoOfEvents() {
		return NoOfEvents;
	}
	public void setNoOfEvents(int noOfEvents) {
		NoOfEvents = noOfEvents;
	}
	public int getNoOfYears() {
		return NoOfYears;
	}
	public void setNoOfYears(int noOfYears) {
		NoOfYears = noOfYears;
	}
    
    

}
