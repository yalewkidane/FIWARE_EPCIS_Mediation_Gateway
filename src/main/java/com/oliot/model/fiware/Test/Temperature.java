package com.oliot.model.fiware.Test;

import java.util.Map;

public class Temperature {
	private String type;
	private Float value;
	private Map<?, ?> metadat;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public Map<?, ?> getMetadat() {
		return metadat;
	}
	public void setMetadat(Map<?, ?> metadat) {
		this.metadat = metadat;
	}
}
