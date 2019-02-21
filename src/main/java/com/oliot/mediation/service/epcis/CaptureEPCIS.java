package com.oliot.mediation.service.epcis;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.gs1.epcglobal.epcis.ObjectEventType;

import com.oliot.mediation.service.gs1Source.CaptureGs1Source;
import com.oliot.model.fiware.Bus.BusEstimation;
import com.oliot.model.fiware.Bus.BusLine;
import com.oliot.model.fiware.Bus.BusStop;

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
			
		}else if(model=="Bus/BusEstimation") {
			List<BusEstimation> busEstimationList= ConvertUtility.getBusEstimationList(body);
			
			for(int i=0; i<busEstimationList.size(); i++) {
				ObjectEventType busEstimationObject= new ObjectEventType();
				busEstimationObject=ConvertUtility.translate(busEstimationList.get(i));
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(busEstimationObject);
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			//System.out.println(epcdoc);
			result="status..." +status;
			System.out.println(result);
			
			return result;
			
		}else if(model=="Bus/BusStop") {
			/*BusStop busStop=new BusStop();
			busStop=ConvertUtility.getBusStop(body);
			
			System.out.println(busStop.getId());
			System.out.println(busStop.getType());
			System.out.println(busStop.getAddress().getValue().getAddressLocality());
			System.out.println(busStop.getGeolocation().getValue().getCoordinates().get(0));
			System.out.println(busStop.getRefBusLines().getValue().get(0));
			System.out.println(busStop.getName().getValue());
			System.out.println(busStop.getShortID().getValue());
			System.out.println(busStop.getDateModified().getValue());
			*/
			
			List<BusStop> busStopList=new ArrayList<BusStop>();
			busStopList=ConvertUtility.getBusStopList(body);
			
			for(int i=0; i<busStopList.size(); i++) {
				String buStopXml=CaptureGs1Source.getBusStopxml(busStopList.get(i));
				System.out.println(buStopXml);
				String status;
				try {
					status = CaptureGs1Source.registerGS1Source(buStopXml, "editor")+"";
					System.out.println("--------------------");
					System.out.println(status);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			return result;
			
		}else if(model=="Bus/BusLine") {
			/*BusLine busLine=new BusLine();
			busLine=ConvertUtility.getBusLine(body);
			
			System.out.println(busLine.getId());
			System.out.println(busLine.getType());
			System.out.println(busLine.getBusLineType().getValue());
			System.out.println(busLine.getDateModified().getValue());
			System.out.println(busLine.getEndTime().getValue());
			System.out.println(busLine.getIntervalHoli().getValue());
			System.out.println(busLine.getIntervalNorm().getValue());
			System.out.println(busLine.getIntervalPeak().getValue());
			System.out.println(busLine.getLocalID().getValue());
			System.out.println(busLine.getName().getValue());
			System.out.println(busLine.getRefBusStops().getValue().get(0));
			System.out.println(busLine.getRefEndBusStop().getValue());
			System.out.println(busLine.getRefStartBusStop().getValue());
			System.out.println(busLine.getShortID().getValue());
			System.out.println(busLine.getStartTime().getValue());
			*/
			List<BusLine> busLineList=new ArrayList<BusLine>();
			busLineList=ConvertUtility.getBusLineList(body);
			for(int i=0; i<busLineList.size(); i++) {
				String buLineXml=CaptureGs1Source.getBusLineXml(busLineList.get(i));
				System.out.println(buLineXml);
				String status;
				try {
					status = CaptureGs1Source.registerGS1Source(buLineXml, "editor")+"";
					System.out.println("--------------------");
					System.out.println(status);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
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
