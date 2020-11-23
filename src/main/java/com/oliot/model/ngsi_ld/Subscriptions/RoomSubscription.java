package com.oliot.model.ngsi_ld.Subscriptions;

import java.util.List;

import com.oliot.model.ngsi_ld.Test.Room;

public class RoomSubscription {
	private String id;
	private String type;
	private String subscriptionId;
	private String notifiedAt;
	private List<Room> room;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getNotifiedAt() {
		return notifiedAt;
	}
	public void setNotifiedAt(String notifiedAt) {
		this.notifiedAt = notifiedAt;
	}
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}
	
	

}
