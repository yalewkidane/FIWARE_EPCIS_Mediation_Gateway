package com.oliot.model.ngsi_ld.Agrifood;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BirthdateValue {
	 @JsonProperty("@type") 
	 private String type;
	 @JsonProperty("@value") 
	 private Date value;
	 
	 
	 
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getValue() {
		return value;
	}
	public void setValue(Date value) {
		this.value = value;
	}
	 
	 
	 
	 
}
