package com.oliot.mediation.service.epcis;

import org.gs1.epcglobal.epcis.ObjectEventType;

public class CaptureEPCIS extends EventDataManager{
	
	public String capture(String body, String model) {
		String result="Staus";
		
		if(model=="Test/Room") {
			ObjectEventType roomObject= new ObjectEventType();
			roomObject=ConvertUtility.translate(ConvertUtility.getRoom(body));
			this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(roomObject);
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
			
			return result;
			
			
		}else if(model=="Test/Car") {
			ObjectEventType carObject= new ObjectEventType();
			carObject=ConvertUtility.translate(ConvertUtility.getCar(body));
			this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(carObject);
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
			
			return result;
			
		}else if(model=="Meat") {
			
		}else if(model=="Alert") {
			
		}else if(model=="Building/Building") {
			
		}else if(model=="Building/BuildingOperation") {
			
		}else if(model=="CivicIssueTracking/Open311ServiceRequest") {
			
		}else if(model=="CivicIssueTracking/Open311ServiceType") {
			
		}else if(model=="Device/Device") {
			
		}else if(model=="Device/DeviceModel") {
			
		}else if(model=="Environment/AeroAllergenObserved") {
			
		}else if(model=="Environment/AirQualityObserved") {
			
		}else if(model=="Environment/NoiseLevelObserved") {
			
		}else if(model=="Environment/WaterQualityObserved") {
			
		}else if(model=="Indicator/KeyPerformanceIndicator") {
			
		}else if(model=="Parking/OffStreetParking") {
			
		}else if(model=="Parking/OnStreetParking") {
			
		}else if(model=="Parking/ParkingAccess") {
			
		}else if(model=="Parking/ParkingGroup") {
			
		}else if(model=="Parking/ParkingSpot") {
			
		}else if(model=="ParksAndGardens/FlowerBed") {
			
		}else if(model=="ParksAndGardens/Garden") {
			
		}else if(model=="ParksAndGardens/GreenspaceRecord") {
			
		}else if(model=="ParksAndGardens/Park") {
			
		}else if(model=="PointOfInterest/PointOfInterest") {
			
		}else if(model=="PointOfInterest/Beach") {
			
		}else if(model=="PointOfInterest/Museum") {
			
		}else if(model=="PointOfInterest/TouristInformationCenter") {
			
		}else if(model=="StreetLighting/Streetlight") {
			
		}else if(model=="StreetLighting/StreetlightControlCabinet") {
			
		}else if(model=="StreetLighting/StreetlightGroup") {
			
		}else if(model=="StreetLighting/StreetlightModel") {
			
		}else if(model=="Transportation/Road") {
			
		}else if(model=="Transportation/TrafficFlowObserved") {
			
		}else if(model=="Transportation/Vehicle") {
			
		}else if(model=="Transportation/VehicleModel") {
			
		}else if(model=="WasteManagement/WasteContainer") {
			
		}else if(model=="WasteManagement/WasteContainerIsle") {
			
		}else if(model=="WasteManagement/WasteContainerModel") {
			
		}else if(model=="Weather/WeatherAlarm") {
			
		}else if(model=="Weather/WeatherForecast") {
			
		}else if(model=="Weather/WeatherObserved") {
			
		}else {
			
		}
		
		return result;
	}

}
