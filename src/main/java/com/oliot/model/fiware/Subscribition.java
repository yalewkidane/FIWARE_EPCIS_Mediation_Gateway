package com.oliot.model.fiware;

public class Subscribition {

	private String subscriptionId;
	private Object[] data;
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public Object[] getData() {
		return data;
	}
	public void setData(Object[] data) {
		this.data = data;
	}
	
	
}
