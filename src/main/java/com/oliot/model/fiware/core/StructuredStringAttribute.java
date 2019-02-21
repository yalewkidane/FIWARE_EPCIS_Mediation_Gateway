package com.oliot.model.fiware.core;

import java.util.List;
import java.util.Map;

public class StructuredStringAttribute {
	private String type;
	private List<String> value;
	private Map<?, ?> metadat;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}
	public Map<?, ?> getMetadat() {
		return metadat;
	}
	public void setMetadat(Map<?, ?> metadat) {
		this.metadat = metadat;
	}
	
	
	

}
