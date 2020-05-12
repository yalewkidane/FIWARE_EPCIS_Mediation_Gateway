package com.oliot.model.fiware.PigFarming;

import com.oliot.model.fiware.core.StringAttribute;

public class Building {
	
	private String id;
	private String type;
	private BuildingAdditonalInfoAttribute additionalInfo;
	private StringAttribute CO2;
	private StringAttribute buildingId;
	private StringAttribute companyId;
	private StringAttribute farmId;
	private StringAttribute humidity;
	private StringAttribute lastUpdate;
	private StringAttribute luminosity;
	private StringAttribute name;
	private StringAttribute temperature;
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
	public BuildingAdditonalInfoAttribute getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(BuildingAdditonalInfoAttribute additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public StringAttribute getCO2() {
		return CO2;
	}
	public void setCO2(StringAttribute cO2) {
		CO2 = cO2;
	}
	public StringAttribute getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(StringAttribute buildingId) {
		this.buildingId = buildingId;
	}
	public StringAttribute getCompanyId() {
		return companyId;
	}
	public void setCompanyId(StringAttribute companyId) {
		this.companyId = companyId;
	}
	public StringAttribute getFarmId() {
		return farmId;
	}
	public void setFarmId(StringAttribute farmId) {
		this.farmId = farmId;
	}
	public StringAttribute getHumidity() {
		return humidity;
	}
	public void setHumidity(StringAttribute humidity) {
		this.humidity = humidity;
	}
	public StringAttribute getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(StringAttribute lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public StringAttribute getLuminosity() {
		return luminosity;
	}
	public void setLuminosity(StringAttribute luminosity) {
		this.luminosity = luminosity;
	}
	public StringAttribute getName() {
		return name;
	}
	public void setName(StringAttribute name) {
		this.name = name;
	}
	public StringAttribute getTemperature() {
		return temperature;
	}
	public void setTemperature(StringAttribute temperature) {
		this.temperature = temperature;
	}
	
	
	
	

}
