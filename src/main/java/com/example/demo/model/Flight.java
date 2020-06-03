package com.example.demo.model;

public class Flight {
	
	private String FLightId;
    private String Departure_From;
    private String Arrival_To;
    private double duration;
    private boolean Meal_available;
    
    
	public Flight(String fLightId, String departure_From, String arrival_To, double duration, boolean meal_available) {
		super();
		FLightId = fLightId;
		Departure_From = departure_From;
		Arrival_To = arrival_To;
		this.duration = duration;
		Meal_available = meal_available;
	}
	public String getFLightId() {
		return FLightId;
	}
	public void setFLightId(String fLightId) {
		FLightId = fLightId;
	}
	public String getDeparture_From() {
		return Departure_From;
	}
	public void setDeparture_From(String departure_From) {
		Departure_From = departure_From;
	}
	public String getArrival_To() {
		return Arrival_To;
	}
	public void setArrival_To(String arrival_To) {
		Arrival_To = arrival_To;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public boolean isMeal_available() {
		return Meal_available;
	}
	public void setMeal_available(boolean meal_available) {
		Meal_available = meal_available;
	}
    
    

}
