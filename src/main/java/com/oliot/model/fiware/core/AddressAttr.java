package com.oliot.model.fiware.core;

import java.util.Map;

public class AddressAttr {
	private String type;
	private AddressValue value;
	private Map<?, ?> metadat;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public AddressValue getValue() {
		return value;
	}
	public void setValue(AddressValue value) {
		this.value = value;
	}
	public Map<?, ?> getMetadat() {
		return metadat;
	}
	public void setMetadat(Map<?, ?> metadat) {
		this.metadat = metadat;
	}
	
	
	
}
