package com.oliot.model.fiware.core;

import java.util.Map;

public class IntegerAttribute {
	private String type;
	private String value;
	private Map<?, ?> metadat;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Map<?, ?> getMetadat() {
		return metadat;
	}
	public void setMetadat(Map<?, ?> metadat) {
		this.metadat = metadat;
	}
	
	
}
