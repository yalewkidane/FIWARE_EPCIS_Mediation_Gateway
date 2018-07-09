package com.oliot.mediation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Subscriptions {
	
	@RequestMapping(value="/Subscribe/Test", method = RequestMethod.POST)
	public void SubscribeTest(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Meat", method = RequestMethod.POST)
	public void SubscribeMeat(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Alert", method = RequestMethod.POST)
	public void SubscribeAlert(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Building", method = RequestMethod.POST)
	public void SubscribeBuilding(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Building/Building", method = RequestMethod.POST)
	public void SubscribeBuildingBuilding(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Building/BuildingOperation", method = RequestMethod.POST)
	public void SubscribeBuildingBuildingOperation(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/CivicIssueTracking", method = RequestMethod.POST)
	public void SubscribeCivicIssueTracking(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/CivicIssueTracking/Open311ServiceRequest", method = RequestMethod.POST)
	public void SubscribeCivicIssueTrackingOpen311ServiceRequest(@RequestBody String body){
		System.out.println(body);
		
	}
	//CivicIssueTracking/Open311ServiceType /Device
	@RequestMapping(value="/Subscribe/CivicIssueTracking/Open311ServiceType", method = RequestMethod.POST)
	public void SubscribeCivicIssueTrackingOpen311ServiceType(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Device", method = RequestMethod.POST)
	public void SubscribeDevice(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Device/Device", method = RequestMethod.POST)
	public void SubscribeDeviceDevice(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Device/DeviceModel", method = RequestMethod.POST)
	public void SubscribeDeviceDeviceModel(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Environment", method = RequestMethod.POST)
	public void SubscribeEnvironment(@RequestBody String body){
		System.out.println(body);	
	}
	@RequestMapping(value="/Subscribe/Environment/AeroAllergenObserved", method = RequestMethod.POST)
	public void SubscribeEnvironmentAeroAllergenObserved(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Environment/AirQualityObserved", method = RequestMethod.POST)
	public void SubscribeEnvironmentAirQualityObserved(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Environment/NoiseLevelObserved", method = RequestMethod.POST)
	public void SubscribeEnvironmentNoiseLevelObserved(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Environment/WaterQualityObserved", method = RequestMethod.POST)
	public void SubscribeEnvironmentWaterQualityObserved(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Indicator/KeyPerformanceIndicator", method = RequestMethod.POST)
	public void SubscribeIndicatorKeyPerformanceIndicator(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Parking", method = RequestMethod.POST)
	public void SubscribeParking(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Parking/OffStreetParking", method = RequestMethod.POST)
	public void SubscribeParkingOffStreetParking(@RequestBody String body){
		System.out.println(body);
		
	}
	
	@RequestMapping(value="/Subscribe/Parking/OnStreetParking", method = RequestMethod.POST)
	public void SubscribeParkingOnStreetParking(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Parking/ParkingAccess", method = RequestMethod.POST)
	public void SubscribeParkingParkingAccess(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Parking/ParkingGroup", method = RequestMethod.POST)
	public void SubscribeParkingParkingGroup(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Parking/ParkingSpot", method = RequestMethod.POST)
	public void SubscribeParkingParkingSpot(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/ParksAndGardens", method = RequestMethod.POST)
	public void SubscribeParksAndGardens(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/ParksAndGardens/FlowerBed", method = RequestMethod.POST)
	public void SubscribeParksAndGardensFlowerBed(@RequestBody String body){
		System.out.println(body);
		
	}
	
	@RequestMapping(value="/Subscribe/ParksAndGardens/Garden", method = RequestMethod.POST)
	public void SubscribeParksAndGardensGarden(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/ParksAndGardens/GreenspaceRecord", method = RequestMethod.POST)
	public void SubscribeParksAndGardensGreenspaceRecord(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/ParksAndGardens/Park", method = RequestMethod.POST)
	public void SubscribeParksAndGardensPark(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/PointOfInterest", method = RequestMethod.POST)
	public void SubscribePointOfInterest(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/PointOfInterest/Beach", method = RequestMethod.POST)
	public void SubscribePointOfInterestBeach(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/PointOfInterest/Museum", method = RequestMethod.POST)
	public void SubscribePointOfInterestMuseum(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/PointOfInterest/PointOfInterest", method = RequestMethod.POST)
	public void SubscribePointOfInterestPointOfInterest(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/PointOfInterest/TouristInformationCenter", method = RequestMethod.POST)
	public void SubscribePointOfInterestTouristInformationCenter(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/StreetLighting", method = RequestMethod.POST)
	public void SubscribeStreetLighting(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/StreetLighting/Streetlight", method = RequestMethod.POST)
	public void SubscribeStreetLightingStreetlight(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/StreetLighting/StreetlightControlCabinet", method = RequestMethod.POST)
	public void SubscribeStreetLightingStreetlightControlCabinet(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/StreetLighting/StreetlightGroup", method = RequestMethod.POST)
	public void SubscribeStreetLightingStreetlightGroup(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/StreetLighting/StreetlightModel", method = RequestMethod.POST)
	public void SubscribeStreetLightingStreetlightModel(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Transportation", method = RequestMethod.POST)
	public void SubscribeTransportation(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Transportation/Road", method = RequestMethod.POST)
	public void SubscribeTransportationRoad(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Transportation/TrafficFlowObserved", method = RequestMethod.POST)
	public void SubscribeTransportationTrafficFlowObserved(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Transportation/Vehicle", method = RequestMethod.POST)
	public void SubscribeTransportationVehicle(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Transportation/VehicleModel", method = RequestMethod.POST)
	public void SubscribeTransportationVehicleModel(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/WasteManagement", method = RequestMethod.POST)
	public void SubscribeWasteManagement(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/WasteManagement/WasteContainer", method = RequestMethod.POST)
	public void SubscribeWasteManagementWasteContainer(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/WasteManagement/WasteContainerIsle", method = RequestMethod.POST)
	public void SubscribeWasteManagementWasteContainerIsle(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/WasteManagement/WasteContainerModel", method = RequestMethod.POST)
	public void SubscribeWasteManagementWasteContainerModel(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Weather", method = RequestMethod.POST)
	public void SubscribeWeather(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Weather/WeatherAlarm", method = RequestMethod.POST)
	public void SubscribeWeatherWeatherAlarm(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Weather/WeatherForecast", method = RequestMethod.POST)
	public void SubscribeWeatherWeatherForecast(@RequestBody String body){
		System.out.println(body);
		
	}
	@RequestMapping(value="/Subscribe/Weather/WeatherObserved", method = RequestMethod.POST)
	public void SubscribeWeatherWeatherObserved(@RequestBody String body){
		System.out.println(body);
		
	}
	

}
