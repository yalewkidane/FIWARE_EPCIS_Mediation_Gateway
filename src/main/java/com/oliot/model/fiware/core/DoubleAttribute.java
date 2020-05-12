package com.oliot.model.fiware.core;

import java.util.Map;

public class DoubleAttribute {
	private String type;
	private Double value;
	private Map<?, ?> metadat;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Map<?, ?> getMetadat() {
		return metadat;
	}
	public void setMetadat(Map<?, ?> metadat) {
		this.metadat = metadat;
	}
	
	
	

}
