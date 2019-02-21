package com.oliot.model.fiware.Bus;



import com.oliot.model.fiware.core.AddressAttr;
import com.oliot.model.fiware.core.Geolocation;
import com.oliot.model.fiware.core.StringAttribute;
import com.oliot.model.fiware.core.StructuredStringAttribute;

public class BusStop {
	private String id;
	private String type;
	private StringAttribute shortID;
    private StringAttribute name;
    private AddressAttr address;
    private StructuredStringAttribute refBusLines;
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
	public StringAttribute getShortID() {
		return shortID;
	}
	public void setShortID(StringAttribute shortID) {
		this.shortID = shortID;
	}
	public StringAttribute getName() {
		return name;
	}
	public void setName(StringAttribute name) {
		this.name = name;
	}
	public AddressAttr getAddress() {
		return address;
	}
	public void setAddress(AddressAttr address) {
		this.address = address;
	}
	public StructuredStringAttribute getRefBusLines() {
		return refBusLines;
	}
	public void setRefBusLines(StructuredStringAttribute refBusLines) {
		this.refBusLines = refBusLines;
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
