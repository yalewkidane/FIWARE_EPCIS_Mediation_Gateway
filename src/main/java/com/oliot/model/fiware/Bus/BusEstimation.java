package com.oliot.model.fiware.Bus;

import java.util.List;

import com.oliot.model.fiware.core.Geolocation;
import com.oliot.model.fiware.core.IntegerAttribute;
import com.oliot.model.fiware.core.StringAttribute;
import com.oliot.model.fiware.core.StructuredIntAttribute;
import com.oliot.model.fiware.core.StructuredStringAttribute;

public class BusEstimation {
	
	private String id;
	private String type;
	private StringAttribute refBusStop;
	private StringAttribute refBusLine;
	private StringAttribute shortID;
	private StructuredStringAttribute remainingTimes;
	private StructuredIntAttribute remainingDistances;
	private IntegerAttribute remainingStations;
	private StructuredStringAttribute destinationBusLines;
	private StringAttribute companyName;
	private Geolocation geolocation;
	private StringAttribute dateModified;
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
	public StringAttribute getRefBusStop() {
		return refBusStop;
	}
	public void setRefBusStop(StringAttribute refBusStop) {
		this.refBusStop = refBusStop;
	}
	public StringAttribute getRefBusLine() {
		return refBusLine;
	}
	public void setRefBusLine(StringAttribute refBusLine) {
		this.refBusLine = refBusLine;
	}
	public StringAttribute getShortID() {
		return shortID;
	}
	public void setShortID(StringAttribute shortID) {
		this.shortID = shortID;
	}
	public StructuredStringAttribute getRemainingTimes() {
		return remainingTimes;
	}
	public void setRemainingTimes(StructuredStringAttribute remainingTimes) {
		this.remainingTimes = remainingTimes;
	}
	public StructuredIntAttribute getRemainingDistances() {
		return remainingDistances;
	}
	public void setRemainingDistances(StructuredIntAttribute remainingDistances) {
		this.remainingDistances = remainingDistances;
	}
	public IntegerAttribute getRemainingStations() {
		return remainingStations;
	}
	public void setRemainingStations(IntegerAttribute remainingStations) {
		this.remainingStations = remainingStations;
	}
	public StructuredStringAttribute getDestinationBusLines() {
		return destinationBusLines;
	}
	public void setDestinationBusLines(StructuredStringAttribute destinationBusLines) {
		this.destinationBusLines = destinationBusLines;
	}
	public StringAttribute getCompanyName() {
		return companyName;
	}
	public void setCompanyName(StringAttribute companyName) {
		this.companyName = companyName;
	}
	public Geolocation getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(Geolocation geolocation) {
		this.geolocation = geolocation;
	}
	public StringAttribute getDateModified() {
		return dateModified;
	}
	public void setDateModified(StringAttribute dateModified) {
		this.dateModified = dateModified;
	}
	
	
	
	
	

}
