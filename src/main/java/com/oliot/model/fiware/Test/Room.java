package com.oliot.model.fiware.Test;

public class Room {
	
	private String id;
	private String type;
	private Pressure pressure;
	private Temperature temperature;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Pressure getPressure() {
		return pressure;
	}
	public void setPressure(Pressure pressure) {
		this.pressure = pressure;
	}
	public Temperature getTemperature() {
		return temperature;
	}
	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
	
	
	

}


