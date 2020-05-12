package com.oliot.model.fiware.PigFarming;

import java.util.List;

public class PigList {
	
	private String subsciption;
	private List<Pig> data;
	public String getSubsciption() {
		return subsciption;
	}
	public void setSubsciption(String subsciption) {
		this.subsciption = subsciption;
	}
	public List<Pig> getData() {
		return data;
	}
	public void setData(List<Pig> data) {
		this.data = data;
	}
	
	

}
