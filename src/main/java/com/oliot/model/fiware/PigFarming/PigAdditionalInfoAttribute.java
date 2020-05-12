package com.oliot.model.fiware.PigFarming;

import java.util.Map;

public class PigAdditionalInfoAttribute {
	private String type;
	private PigAdditionalInfo value;
	private Map<?, ?> metadat;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public PigAdditionalInfo getValue() {
		return value;
	}
	public void setValue(PigAdditionalInfo value) {
		this.value = value;
	}
	public Map<?, ?> getMetadat() {
		return metadat;
	}
	public void setMetadat(Map<?, ?> metadat) {
		this.metadat = metadat;
	}
	
	
	

}
