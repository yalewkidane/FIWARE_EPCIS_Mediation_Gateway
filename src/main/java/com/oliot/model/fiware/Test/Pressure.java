package com.oliot.model.fiware.Test;

import java.util.Map;

public class Pressure {
	
	private String type;
	private Integer value;
	private Map<?, ?> metadat;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Map<?, ?> getMetadat() {
		return metadat;
	}
	public void setMetadat(Map<?, ?> metadat) {
		this.metadat = metadat;
	}
	
	

}
