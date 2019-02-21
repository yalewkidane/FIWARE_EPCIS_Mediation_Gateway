package com.oliot.model.fiware.Bus;

import com.oliot.model.fiware.core.StringAttribute;
import com.oliot.model.fiware.core.StructuredStringAttribute;

public class BusLine {
	
	private String id;
	private String type;
	private StringAttribute busLineType;
	private StringAttribute dateModified;
	private StringAttribute endTime;
	private StringAttribute intervalHoli;
	private StringAttribute intervalNorm;
	private StringAttribute intervalPeak;
	private StringAttribute localID;
	private StringAttribute name;
	private StructuredStringAttribute refBusStops;
	private StringAttribute refEndBusStop;
	private StringAttribute refStartBusStop;
	private StringAttribute shortID;
	private StringAttribute startTime;
	
	
	
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
	public StringAttribute getBusLineType() {
		return busLineType;
	}
	public void setBusLineType(StringAttribute busLineType) {
		this.busLineType = busLineType;
	}
	public StringAttribute getDateModified() {
		return dateModified;
	}
	public void setDateModified(StringAttribute dateModified) {
		this.dateModified = dateModified;
	}
	public StringAttribute getEndTime() {
		return endTime;
	}
	public void setEndTime(StringAttribute endTime) {
		this.endTime = endTime;
	}
	public StringAttribute getIntervalHoli() {
		return intervalHoli;
	}
	public void setIntervalHoli(StringAttribute intervalHoli) {
		this.intervalHoli = intervalHoli;
	}
	public StringAttribute getIntervalNorm() {
		return intervalNorm;
	}
	public void setIntervalNorm(StringAttribute intervalNorm) {
		this.intervalNorm = intervalNorm;
	}
	public StringAttribute getIntervalPeak() {
		return intervalPeak;
	}
	public void setIntervalPeak(StringAttribute intervalPeak) {
		this.intervalPeak = intervalPeak;
	}
	public StringAttribute getLocalID() {
		return localID;
	}
	public void setLocalID(StringAttribute localID) {
		this.localID = localID;
	}
	public StringAttribute getName() {
		return name;
	}
	public void setName(StringAttribute name) {
		this.name = name;
	}
	public StructuredStringAttribute getRefBusStops() {
		return refBusStops;
	}
	public void setRefBusStops(StructuredStringAttribute refBusStops) {
		this.refBusStops = refBusStops;
	}
	public StringAttribute getRefEndBusStop() {
		return refEndBusStop;
	}
	public void setRefEndBusStop(StringAttribute refEndBusStop) {
		this.refEndBusStop = refEndBusStop;
	}
	public StringAttribute getRefStartBusStop() {
		return refStartBusStop;
	}
	public void setRefStartBusStop(StringAttribute refStartBusStop) {
		this.refStartBusStop = refStartBusStop;
	}
	public StringAttribute getShortID() {
		return shortID;
	}
	public void setShortID(StringAttribute shortID) {
		this.shortID = shortID;
	}
	public StringAttribute getStartTime() {
		return startTime;
	}
	public void setStartTime(StringAttribute startTime) {
		this.startTime = startTime;
	}
	
	
	
	

}
