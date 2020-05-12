package com.oliot.mediation.service.epcis;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.gs1.epcglobal.EPC;
import org.gs1.epcglobal.epcis.ActionType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.BusinessTransactionListType;
import org.gs1.epcglobal.epcis.BusinessTransactionType;
import org.gs1.epcglobal.epcis.EPCISEventExtensionType;
import org.gs1.epcglobal.epcis.EPCListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ReadPointType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.oliot.mediation.configuration.Configuration;
import com.oliot.model.fiware.Alert.Alert;
import com.oliot.model.fiware.Building.Building;
import com.oliot.model.fiware.Building.BuildingOperation;
import com.oliot.model.fiware.Bus.BusEstimation;
import com.oliot.model.fiware.Bus.BusLine;
import com.oliot.model.fiware.Bus.BusStop;
import com.oliot.model.fiware.CivicIssueTracking.Open311ServiceRequest;
import com.oliot.model.fiware.CivicIssueTracking.Open311ServiceType;
import com.oliot.model.fiware.Device.Device;
import com.oliot.model.fiware.Device.DeviceModel;
import com.oliot.model.fiware.Environment.AeroAllergenObserved;
import com.oliot.model.fiware.Environment.AirQualityObserved;
import com.oliot.model.fiware.Environment.NoiseLevelObserved;
import com.oliot.model.fiware.Environment.WaterQualityObserved;
import com.oliot.model.fiware.Indicator.KeyPerformanceIndicator;
import com.oliot.model.fiware.Parking.OffStreetParking;
import com.oliot.model.fiware.Parking.OnStreetParking;
import com.oliot.model.fiware.Parking.ParkingAccess;
import com.oliot.model.fiware.Parking.ParkingGroup;
import com.oliot.model.fiware.Parking.ParkingSpot;
import com.oliot.model.fiware.ParksAndGardens.FlowerBed;
import com.oliot.model.fiware.ParksAndGardens.Garden;
import com.oliot.model.fiware.ParksAndGardens.GreenspaceRecord;
import com.oliot.model.fiware.ParksAndGardens.Park;
import com.oliot.model.fiware.PigFarming.BuildingAdditonalInfo;
import com.oliot.model.fiware.PigFarming.Pig;
import com.oliot.model.fiware.PigFarming.PigAdditionalInfo;
import com.oliot.model.fiware.PigFarming.PigList;
import com.oliot.model.fiware.PointOfInterest.Beach;
import com.oliot.model.fiware.PointOfInterest.Museum;
import com.oliot.model.fiware.PointOfInterest.PointOfInterest;
import com.oliot.model.fiware.PointOfInterest.TouristInformationCenter;
import com.oliot.model.fiware.StreetLighting.Streetlight;
import com.oliot.model.fiware.StreetLighting.StreetlightControlCabinet;
import com.oliot.model.fiware.StreetLighting.StreetlightGroup;
import com.oliot.model.fiware.StreetLighting.StreetlightModel;
import com.oliot.model.fiware.Test.Car;
import com.oliot.model.fiware.Test.Room;
import com.oliot.model.fiware.Transportation.Road;
import com.oliot.model.fiware.Transportation.TrafficFlowObserved;
import com.oliot.model.fiware.Transportation.Vehicle;
import com.oliot.model.fiware.Transportation.VehicleModel;
import com.oliot.model.fiware.WasteManagement.WasteContainer;
import com.oliot.model.fiware.WasteManagement.WasteContainerIsle;
import com.oliot.model.fiware.WasteManagement.WasteContainerModel;
import com.oliot.model.fiware.Weather.WeatherAlarm;
import com.oliot.model.fiware.Weather.WeatherForecast;
import com.oliot.model.fiware.Weather.WeatherObserved;

public class ConvertUtility {
	
	public static Room getRoom(String body) {
		Room room =new Room();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			room = gson.fromJson(body, Room.class); 
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
		}
		return room;
	}
	
	public static Car getCar(String body) {
		Car car =new Car();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			car = gson.fromJson(body, Car.class);
		}
		return car;
	}
	
	//--------------------------------Bus System 
	public static BusEstimation getBusEstimation(String body) {
		System.out.println(body);
		BusEstimation busEstimation=new BusEstimation();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			busEstimation = gson.fromJson(body, BusEstimation.class);
		}
		return busEstimation;
		
	}
	
	public static List<BusEstimation> getBusEstimationList(String body) {
		System.out.println(body);
		List<BusEstimation> busEstimationList=new ArrayList<BusEstimation>();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			Type BusStopListType=new TypeToken<ArrayList<BusEstimation>>() {}.getType();
			busEstimationList = gson.fromJson(body, BusStopListType);
		}
		return busEstimationList;
		
	}
	
	public static BusStop getBusStop(String body) {
		BusStop busStop=new BusStop();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			busStop = gson.fromJson(body, BusStop.class);
		}
		return busStop;
		
	}
	public static List<BusStop> getBusStopList(String body) {
		List<BusStop> busStopList=new ArrayList<BusStop>();
		if(body!=null) {
			Type BusStopListType=new TypeToken<ArrayList<BusStop>>() {}.getType();
			Gson gson = new GsonBuilder().serializeNulls().create();
			busStopList = gson.fromJson(body, BusStopListType);
		}
		return busStopList;
		
	}
	
	public static BusLine getBusLine(String body) {
		BusLine busLine=new BusLine();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			busLine = gson.fromJson(body, BusLine.class);
		}
		return busLine;
		
	}
	public static List<BusLine> getBusLineList(String body) {
		List<BusLine> busLineList=new ArrayList<BusLine>();
		if(body!=null) {
			Type BusLineListType=new TypeToken<ArrayList<BusLine>>() {}.getType();
			Gson gson = new GsonBuilder().serializeNulls().create();
			busLineList = gson.fromJson(body, BusLineListType);
		}
		return busLineList;
		
	}
	
	public static List<Pig> getFarmPigList(String body) {
		List<Pig> farmPigList=new ArrayList<Pig>();
		if(body!=null) {
			Type FarmPigType=new TypeToken<ArrayList<Pig>>() {}.getType();
			Gson gson = new GsonBuilder().serializeNulls().create();
			farmPigList = gson.fromJson(body, FarmPigType);
		}
		return farmPigList;
		
	}
	
	public static PigList getFarmPigList_2(String body) {
		PigList farmPigList=new PigList();
		if(body!=null) {
			Type FarmPigType=new TypeToken<PigList>() {}.getType();
			Gson gson = new GsonBuilder().serializeNulls().create();
			farmPigList = gson.fromJson(body, FarmPigType);
		}
		return farmPigList;
		
	}
	
	public static List<com.oliot.model.fiware.PigFarming.Building> getFarmBuildingList(String body) {
		List<com.oliot.model.fiware.PigFarming.Building> farmBuildingList=
				new ArrayList<com.oliot.model.fiware.PigFarming.Building>();
		if(body!=null) {
			Type FarmBuildingType=new TypeToken<ArrayList<com.oliot.model.fiware.PigFarming.Building>>() {}.getType();
			Gson gson = new GsonBuilder().serializeNulls().create();
			farmBuildingList = gson.fromJson(body, FarmBuildingType);
		}
		return farmBuildingList;
		
	}
	
	public static Alert getAlert(String body) {
		Alert alert =new Alert();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			alert = gson.fromJson(body, Alert.class);
		}
		return alert;
	}
	
	public static Building getBuilding(String body) {
		Building building =new Building();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			building = gson.fromJson(body, Building.class);
		}
		return building;
	}
	
	public static BuildingOperation getBuildingOperation(String body) {
		BuildingOperation buildingOperation =new BuildingOperation();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			buildingOperation = gson.fromJson(body, BuildingOperation.class);
		}
		return buildingOperation;
	}
	
	public static Open311ServiceRequest getOpen311ServiceRequest(String body) {
		Open311ServiceRequest open311ServiceRequest =new Open311ServiceRequest();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			open311ServiceRequest = gson.fromJson(body, Open311ServiceRequest.class);
		}
		return open311ServiceRequest;
	}
	
	public static Open311ServiceType getOpen311ServiceType(String body) {
		Open311ServiceType open311ServiceType =new Open311ServiceType();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			open311ServiceType = gson.fromJson(body, Open311ServiceType.class);
		}
		return open311ServiceType;
	}
	public static Device getDevice(String body) {
		Device device =new Device();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			device = gson.fromJson(body, Device.class);
		}
		return device;
	}
	
	public static DeviceModel getDeviceModel(String body) {
		DeviceModel deviceModel =new DeviceModel();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			deviceModel = gson.fromJson(body, DeviceModel.class);
		}
		return deviceModel;
	}
	
	public static AeroAllergenObserved getAeroAllergenObserved(String body) {
		AeroAllergenObserved aeroAllergenObserved =new AeroAllergenObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			aeroAllergenObserved = gson.fromJson(body, AeroAllergenObserved.class);
		}
		return aeroAllergenObserved;
	}
	
	public static AirQualityObserved getAirQualityObserved(String body) {
		AirQualityObserved airQualityObserved =new AirQualityObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			airQualityObserved = gson.fromJson(body, AirQualityObserved.class);
		}
		return airQualityObserved;
	}
	
	public static NoiseLevelObserved getNoiseLevelObserved(String body) {
		NoiseLevelObserved noiseLevelObserved =new NoiseLevelObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			noiseLevelObserved = gson.fromJson(body, NoiseLevelObserved.class);
		}
		return noiseLevelObserved;
	}
	
	public static WaterQualityObserved getWaterQualityObserved(String body) {
		WaterQualityObserved waterQualityObserved =new WaterQualityObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			waterQualityObserved = gson.fromJson(body, WaterQualityObserved.class);
		}
		return waterQualityObserved;
	}
	
	public static KeyPerformanceIndicator getKeyPerformanceIndicator(String body) {
		KeyPerformanceIndicator keyPerformanceIndicator =new KeyPerformanceIndicator();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			keyPerformanceIndicator = gson.fromJson(body, KeyPerformanceIndicator.class);
		}
		return keyPerformanceIndicator;
	}
	
	public static OffStreetParking getOffStreetParking(String body) {
		OffStreetParking offStreetParking =new OffStreetParking();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			offStreetParking = gson.fromJson(body, OffStreetParking.class);
		}
		return offStreetParking;
	}
	
	public static OnStreetParking getOnStreetParking(String body) {
		OnStreetParking onStreetParking =new OnStreetParking();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			onStreetParking = gson.fromJson(body, OnStreetParking.class);
		}
		return onStreetParking;
	}
	
	public static ParkingAccess getParkingAccess(String body) {
		ParkingAccess parkingAccess =new ParkingAccess();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			parkingAccess = gson.fromJson(body, ParkingAccess.class);
		}
		return parkingAccess;
	}
	
	public static ParkingGroup getParkingGroup(String body) {
		ParkingGroup parkingGroup =new ParkingGroup();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			parkingGroup = gson.fromJson(body, ParkingGroup.class);
		}
		return parkingGroup;
	}
	
	public static ParkingSpot getParkingSpot(String body) {
		ParkingSpot parkingSpot =new ParkingSpot();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			parkingSpot = gson.fromJson(body, ParkingSpot.class);
		}
		return parkingSpot;
	}
	
	public static FlowerBed getFlowerBed(String body) {
		FlowerBed flowerBed =new FlowerBed();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			flowerBed = gson.fromJson(body, FlowerBed.class);
		}
		return flowerBed;
	}
	
	public static Garden getGarden(String body) {
		Garden garden =new Garden();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			garden = gson.fromJson(body, Garden.class);
		}
		return garden;
	}
	
	public static GreenspaceRecord getGreenspaceRecord(String body) {
		GreenspaceRecord greenspaceRecord =new GreenspaceRecord();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			greenspaceRecord = gson.fromJson(body, GreenspaceRecord.class);
		}
		return greenspaceRecord;
	}
	
	public static Park getPark(String body) {
		Park park =new Park();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			park = gson.fromJson(body, Park.class);
		}
		return park;
	}
	
	public static Beach getBeach(String body) {
		Beach beach =new Beach();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			beach = gson.fromJson(body, Beach.class);
		}
		return beach;
	}
	
	public static Museum getMuseum(String body) {
		Museum museum =new Museum();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			museum = gson.fromJson(body, Museum.class);
		}
		return museum;
	}
	
	public static PointOfInterest getPointOfInterest(String body) {
		PointOfInterest pointOfInterest =new PointOfInterest();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			pointOfInterest = gson.fromJson(body, PointOfInterest.class);
		}
		return pointOfInterest;
	}
	
	public static TouristInformationCenter getTouristInformationCenter(String body) {
		TouristInformationCenter touristInformationCenter =new TouristInformationCenter();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			touristInformationCenter = gson.fromJson(body, TouristInformationCenter.class);
		}
		return touristInformationCenter;
	}
	
	public static Streetlight getStreetlight(String body) {
		Streetlight streetlight =new Streetlight();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			streetlight = gson.fromJson(body, Streetlight.class);
		}
		return streetlight;
	}
	
	public static StreetlightControlCabinet getStreetlightControlCabinet(String body) {
		StreetlightControlCabinet streetlightControlCabinet =new StreetlightControlCabinet();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			streetlightControlCabinet = gson.fromJson(body, StreetlightControlCabinet.class);
		}
		return streetlightControlCabinet;
	}
	
	public static StreetlightGroup getStreetlightGroup(String body) {
		StreetlightGroup streetlightGroup =new StreetlightGroup();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			streetlightGroup = gson.fromJson(body, StreetlightGroup.class);
		}
		return streetlightGroup;
	}
	
	public static StreetlightModel getStreetlightModel(String body) {
		StreetlightModel streetlightModel =new StreetlightModel();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			streetlightModel = gson.fromJson(body, StreetlightModel.class);
		}
		return streetlightModel;
	}
	
	public static Road getRoad(String body) {
		Road road =new Road();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			road = gson.fromJson(body, Road.class);
		}
		return road;
	}
	
	public static TrafficFlowObserved getTrafficFlowObserved(String body) {
		TrafficFlowObserved trafficFlowObserved =new TrafficFlowObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			trafficFlowObserved = gson.fromJson(body, TrafficFlowObserved.class);
		}
		return trafficFlowObserved;
	}
	
	public static Vehicle getVehicle(String body) {
		Vehicle vehicle =new Vehicle();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			vehicle = gson.fromJson(body, Vehicle.class);
		}
		return vehicle;
	}
	
	public static VehicleModel getVehicleModel(String body) {
		VehicleModel vehicleModel =new VehicleModel();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			vehicleModel = gson.fromJson(body, VehicleModel.class);
		}
		return vehicleModel;
	}
	
	public static WasteContainer getWasteContainer(String body) {
		WasteContainer wasteContainer =new WasteContainer();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			wasteContainer = gson.fromJson(body, WasteContainer.class);
		}
		return wasteContainer;
	}
	
	public static WasteContainerIsle getWasteContainerIsle(String body) {
		WasteContainerIsle wasteContainerIsle =new WasteContainerIsle();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			wasteContainerIsle = gson.fromJson(body, WasteContainerIsle.class);
		}
		return wasteContainerIsle;
	}
	
	public static WasteContainerModel getWasteContainerModel(String body) {
		WasteContainerModel wasteContainerModel =new WasteContainerModel();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			wasteContainerModel = gson.fromJson(body, WasteContainerModel.class);
		}
		return wasteContainerModel;
	}
	
	public static WeatherAlarm getWeatherAlarm(String body) {
		WeatherAlarm weatherAlarm =new WeatherAlarm();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			weatherAlarm = gson.fromJson(body, WeatherAlarm.class);
		}
		return weatherAlarm;
	}
	
	public static WeatherForecast getWeatherForecast(String body) {
		WeatherForecast weatherForecast =new WeatherForecast();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			weatherForecast = gson.fromJson(body, WeatherForecast.class);
		}
		return weatherForecast;
	}
	
	public static WeatherObserved geWeatherObserved(String body) {
		WeatherObserved weatherObserved =new WeatherObserved();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			weatherObserved = gson.fromJson(body, WeatherObserved.class);
		}
		return weatherObserved;
	}
	
	
	
	public static ObjectEventType translate(Room room) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		objectEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue("urn:epc:id:sgtin:88000269." + room.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
		//objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:driving");
		
		objectEventType.setDisposition("urn:epcglobal:cbv:disp:on_the line");

		ReadPointType readPoint = new ReadPointType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		readPoint.setId("urn:epc:id:sgln:8800026900016." + room.getId());
		objectEventType.setReadPoint(readPoint);

		BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
		businessLocation.setId("urn:epc:id:sgln:8800026900016.103." + room.getId());
		objectEventType.setBizLocation(businessLocation);

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType("urn:epcglobal:cbv:Bus:status");
		businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:Sensing");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			
			if(room.getId()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/id", "oliot:Fiware");
				id.setTextContent(room.getId());
				elementList.add(id);
			}
			
			

			if(room.getType()!=null) {
				Element type = doc.createElementNS("http://ns.oliot.com/type", "oliot:Fiware");
				type.setTextContent(room.getType());
				elementList.add(type);
			}
			
			if(room.getTemperature()!=null) {
				Element temprature = doc.createElementNS("http://ns.oliot.com/temprature", "oliot:Fiware");
				
				if(room.getTemperature().getType()!=null) {
					Element tempratureType = doc.createElementNS("http://ns.oliot.com/temprature/type", "oliot:Fiware");
					tempratureType.setTextContent(room.getTemperature().getType());
					
					temprature.appendChild(tempratureType);
				}
				if(room.getTemperature().getValue()!=null) {
					Element tempratureValue = doc.createElementNS("http://ns.oliot.com/temprature/value", "oliot:Fiware");
					tempratureValue.setTextContent(room.getTemperature().getValue().toString());
					
					temprature.appendChild(tempratureValue);
				}
				if(room.getTemperature().getMetadat()!=null) {
					Element tempratureMetadat = doc.createElementNS("http://ns.oliot.com/temprature/metadata", "oliot:Fiware");
					tempratureMetadat.setTextContent(room.getTemperature().getValue().toString());
					
					temprature.appendChild(tempratureMetadat);
				}
				
				elementList.add(temprature);
			}
			if(room.getPressure()!=null) {
				Element pressure = doc.createElementNS("http://ns.oliot.com/Pressure", "oliot:Fiware");
				
				if(room.getPressure().getType()!=null) {
					Element PressureType = doc.createElementNS("http://ns.oliot.com/Pressure/type", "oliot:Fiware");
					PressureType.setTextContent(room.getPressure().getType());
					
					pressure.appendChild(PressureType);
				}
				if(room.getPressure().getValue()!=null) {
					Element PressureValue = doc.createElementNS("http://ns.oliot.com/pressure/value", "oliot:Fiware");
					PressureValue.setTextContent(room.getPressure().getValue().toString());
					
					pressure.appendChild(PressureValue);
				}
				if(room.getPressure().getMetadat()!=null) {
					Element PressureMetadat = doc.createElementNS("http://ns.oliot.com/pressure/metadata", "oliot:Fiware");
					PressureMetadat.setTextContent(room.getPressure().getMetadat().toString());
					
					pressure.appendChild(PressureMetadat);
				}
				
				elementList.add(pressure);
			}
			
			
			
			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
	
	public static ObjectEventType translate(com.oliot.model.fiware.PigFarming.Building building) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		objectEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue("urn:epc:id:sgln:8800026900016.245." + building.getBuildingId().getValue());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
		//objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:monitoring");
		
		//objectEventType.setDisposition("urn:epcglobal:cbv:disp:on_the line");

		ReadPointType readPoint = new ReadPointType();
		BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		readPoint.setId("urn:epc:id:sgln:8800026900016.245." + building.getBuildingId().getValue());
		objectEventType.setReadPoint(readPoint);
		
		businessLocation.setId("urn:epc:id:sgln:8800026900016.245." + building.getBuildingId().getValue());
		objectEventType.setBizLocation(businessLocation);
		
		

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType("urn:gs1:epcisapp:PigFarming:status");
		businessTransaction1.setValue("urn:gs1:epcisapp:PigFarming:Monitoring");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			String namespace = "urn:gs1:epcisapp:pigFarm";
			
			//id
			if(building.getId()!=null) {
				Element id = doc.createElementNS(namespace,"PF:ID");
				id.setTextContent(building.getId());
				elementList.add(id);
			}
			//type
			if(building.getType()!=null) {
				Element type = doc.createElementNS(namespace,"PF:Type");
				type.setTextContent(building.getType());
				elementList.add(type);
			}
			//additionalInfo
			if(building.getAdditionalInfo().getValue()!=null) {
				BuildingAdditonalInfo addtionalInfo= building.getAdditionalInfo().getValue();
				Element additonalInfo = doc.createElementNS(namespace,"PF:AdditionalInfo");
				
				if(addtionalInfo.getSensorName()!=null) {
					Element sensorName = doc.createElementNS(namespace,"PF:SensorName");
					//Element duration = doc.createElementNS("http://gs1.org/voc/PigFarming", "PF:duration");
					sensorName.setTextContent(addtionalInfo.getSensorName());
					
					additonalInfo.appendChild(sensorName);
				}
				if(addtionalInfo.getCurrentReading()!=null) {
					Element currentReading = doc.createElementNS(namespace,"PF:CurrentReading");
					//Element duration = doc.createElementNS("http://gs1.org/voc/PigFarming", "PF:duration");
					currentReading.setTextContent(addtionalInfo.getCurrentReading());
					
					additonalInfo.appendChild(currentReading);
				}
				//all others additional informations will be included if needed 
				
			}
			//CO2
			if(building.getCO2().getValue()!=null) {
				Element CO2 = doc.createElementNS(namespace,"PF:CO2");
				CO2.setTextContent(building.getCO2().getValue());
				elementList.add(CO2);
			}
			//buildingId
			if(building.getBuildingId().getValue()!=null) {
				Element buildingId = doc.createElementNS(namespace,"PF:BuildingId");
				buildingId.setTextContent(building.getBuildingId().getValue());
				elementList.add(buildingId);
			}
			//companyId
			if(building.getCompanyId().getValue()!=null) {
				Element companyId = doc.createElementNS(namespace,"PF:CompanyId");
				companyId.setTextContent(building.getCompanyId().getValue());
				elementList.add(companyId);
			}
			//farmId
			if(building.getFarmId()!=null) {
				Element farmId = doc.createElementNS(namespace,"PF:FarmId");
				farmId.setTextContent(building.getFarmId().getValue());
				elementList.add(farmId);
			}
			//humidity
			if(building.getHumidity().getValue()!=null) {
				Element humidity = doc.createElementNS(namespace,"PF:Humidity");
				humidity.setTextContent(building.getHumidity().getValue());
				elementList.add(humidity);
			}
			//luminosity
			if(building.getLuminosity().getValue()!=null) {
				Element luminosity = doc.createElementNS(namespace,"PF:Luminosity");
				luminosity.setTextContent(building.getBuildingId().getValue());
				elementList.add(luminosity);
			}
			//name
			if(building.getName().getValue()!=null) {
				Element name = doc.createElementNS(namespace,"PF:Name");
				name.setTextContent(building.getBuildingId().getValue());
				elementList.add(name);
			}
			//temperature
			if(building.getTemperature().getValue()!=null) {
				Element temperature = doc.createElementNS(namespace,"PF:Temperature");
				temperature.setTextContent(building.getTemperature().getValue());
				elementList.add(temperature);
			}
			
			
			
			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
	public static ObjectEventType translate_growth(Pig pig, Double growth) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		objectEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(Configuration.sgtin+Configuration.ilvo_CompanyPrefix+"."+
				Configuration.Pig_ItemReference+"." + pig.getPigId().getValue());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
		//objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep(Configuration.farm_pig+":growth");
		
		objectEventType.setDisposition(Configuration.sgln+Configuration.ilvo_CompanyPrefix+
				"."+Configuration.Pig_ItemReference+"."+pig.getPenId().getValue());

		ReadPointType readPoint = new ReadPointType();
		//BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		
		if(pig.getAdditionalInfo().getValue().getLocation()!=null) {
			readPoint.setId(Configuration.sgln+Configuration.ilvo_CompanyPrefix+"." +
					Configuration.Pig_ItemReference+"."+ pig.getPenId());
			objectEventType.setReadPoint(readPoint);
		}
		

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType(Configuration.farm_pig+":status");
		businessTransaction1.setValue(Configuration.farm_pig+":growth");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			String namespace = Configuration.farm_pig;
			
			//id
			if(pig.getId()!=null) {
				Element id = doc.createElementNS(namespace,"PF:ID");
				id.setTextContent(pig.getPigId().getValue());
				elementList.add(id);
			}
			
			//Type
			if(pig.getType()!=null) {
				Element type = doc.createElementNS(namespace,"PF:Type");
				type.setTextContent(pig.getType());
				elementList.add(type);
			}
			
			
			//buildingId
			if(pig.getBuildingId()!=null) {
				Element buildingId = doc.createElementNS(namespace,"PF:buildingId");
				buildingId.setTextContent(pig.getBuildingId().getValue());
				elementList.add(buildingId);
			}
			
			//companyId
			if(pig.getCompanyId()!=null) {
				Element companyId = doc.createElementNS(namespace,"PF:companyId");
				companyId.setTextContent(pig.getCompanyId().getValue());
				elementList.add(companyId);
			}
			
			//farmId
			if(pig.getFarmId()!=null) {
				Element farmId = doc.createElementNS(namespace,"PF:farmId");
				farmId.setTextContent(pig.getFarmId().getValue());
				elementList.add(farmId);
			}
			
			//penId
			if(pig.getPenId().getValue()!=null) {
				Element penId = doc.createElementNS(namespace,"PF:penId");
				penId.setTextContent(pig.getPenId().getValue());
				elementList.add(penId);
			}
			//pigId
			if(pig.getPigId().getValue()!=null) {
				Element pigId = doc.createElementNS(namespace,"PF:pigId");
				pigId.setTextContent(pig.getPigId().getValue());
				elementList.add(pigId);
			}
			//compartmentId
			if(pig.getCompartmentId()!=null) {
				Element compartmentId = doc.createElementNS(namespace,"PF:compartmentId");
				compartmentId.setTextContent(pig.getCompartmentId().getValue());
				elementList.add(compartmentId);
			}
			
			//sex
			if(pig.getSex()!=null) {
				Element sex = doc.createElementNS(namespace,"PF:sex");
				sex.setTextContent(pig.getSex().getValue());
				elementList.add(sex);
			}
			
			//growth_element
			if(growth !=null) {
				Element growth_element = doc.createElementNS(namespace,"PF:growth");
				growth_element.setTextContent(growth.toString());
				elementList.add(growth_element);
			}
			
			//totalConsumedWater
			/*if(Configuration.jedi.hget(pig.getPigId().getValue(), "water_intake")!=null) {
				Element totalConsumedWater = doc.createElementNS(namespace, "PF:totalConsumedWater");
				totalConsumedWater.setTextContent(Configuration.jedi.hget(pig.getPigId().getValue(), "water_intake"));
				elementList.add(totalConsumedWater);
			}*/
			
			if (!Configuration.table.contains(pig.getPigId().getValue(),"water_intake")) {
				Element totalConsumedWater = doc.createElementNS(namespace, "PF:totalConsumedWater");
				totalConsumedWater.setTextContent((Configuration.table.get(pig.getPigId().getValue(), "water_intake")).toString());
				elementList.add(totalConsumedWater);
			}
			
			//totalConsumedFood
			/*if(Configuration.jedi.hget(pig.getPigId().getValue(), "feed_intake")!=null) {
				Element totalConsumedFood = doc.createElementNS(namespace, "PF:totalConsumedFood");
				totalConsumedFood.setTextContent(Configuration.jedi.hget(pig.getPigId().getValue(), "feed_intake"));
				elementList.add(totalConsumedFood);
			}*/
			
			if (!Configuration.table.contains(pig.getPigId().getValue(),"feed_intake")) {
				Element totalConsumedFood = doc.createElementNS(namespace, "PF:totalConsumedFood");
				totalConsumedFood.setTextContent((Configuration.table.get(pig.getPigId().getValue(), "feed_intake")).toString());
				elementList.add(totalConsumedFood);
			}
			
			
			
			//weight
			if(pig.getWeight()!=null) {
				Element weight = doc.createElementNS(namespace,"PF:weight");
				weight.setTextContent(pig.getWeight().getValue().toString());
				elementList.add(weight);
			}
			
			
			
			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
	public static ObjectEventType translate_water_intakes(Pig pig) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		objectEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(Configuration.sgtin+Configuration.ilvo_CompanyPrefix+"."+
				Configuration.Pig_ItemReference+"." + pig.getPigId().getValue());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
		//objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep(Configuration.farm_pig+":water_intake");
		
		objectEventType.setDisposition(Configuration.sgln+Configuration.ilvo_CompanyPrefix+
				"."+Configuration.Pig_ItemReference+"."+pig.getPenId().getValue());

		ReadPointType readPoint = new ReadPointType();
		//BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		
		if(pig.getAdditionalInfo().getValue().getLocation()!=null) {
			readPoint.setId(Configuration.sgln+Configuration.ilvo_CompanyPrefix+"." +
					Configuration.Pig_ItemReference+ "."+ pig.getPenId());
			objectEventType.setReadPoint(readPoint);
		}
		

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType(Configuration.farm_pig+":status");
		businessTransaction1.setValue(Configuration.farm_pig+":water_intake");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			String namespace = Configuration.farm_pig;
			
			//id
			if(pig.getId()!=null) {
				Element id = doc.createElementNS(namespace,"PF:ID");
				id.setTextContent(pig.getPigId().getValue());
				elementList.add(id);
			}
			
			//Type
			if(pig.getType()!=null) {
				Element type = doc.createElementNS(namespace,"PF:Type");
				type.setTextContent(pig.getType());
				elementList.add(type);
			}
			
			//arrivalTimestamp
			if(pig.getArrivalTimestamp()!=null) {
				Element arrivalTimestamp = doc.createElementNS(namespace,"PF:arrivalTimestamp");
				arrivalTimestamp.setTextContent(pig.getArrivalTimestamp().getValue());
				elementList.add(arrivalTimestamp);
			}
			
			//buildingId
			if(pig.getBuildingId()!=null) {
				Element buildingId = doc.createElementNS(namespace,"PF:buildingId");
				buildingId.setTextContent(pig.getBuildingId().getValue());
				elementList.add(buildingId);
			}
			
			//companyId
			if(pig.getCompanyId()!=null) {
				Element companyId = doc.createElementNS(namespace,"PF:companyId");
				companyId.setTextContent(pig.getCompanyId().getValue());
				elementList.add(companyId);
			}
			
			//farmId
			if(pig.getFarmId()!=null) {
				Element farmId = doc.createElementNS(namespace,"PF:farmId");
				farmId.setTextContent(pig.getFarmId().getValue());
				elementList.add(farmId);
			}
			
			//lastUpdate
			if(pig.getLastUpdate().getValue()!=null) {
				Element lastUpdate = doc.createElementNS(namespace,"PF:lastUpdate");
				lastUpdate.setTextContent(pig.getLastUpdate().getValue());
				elementList.add(lastUpdate);
			}
			//penId
			if(pig.getPenId().getValue()!=null) {
				Element penId = doc.createElementNS(namespace,"PF:penId");
				penId.setTextContent(pig.getPenId().getValue());
				elementList.add(penId);
			}
			//pigId
			if(pig.getPigId().getValue()!=null) {
				Element pigId = doc.createElementNS(namespace,"PF:pigId");
				pigId.setTextContent(pig.getPigId().getValue());
				elementList.add(pigId);
			}
			//compartmentId
			if(pig.getCompartmentId()!=null) {
				Element compartmentId = doc.createElementNS(namespace,"PF:compartmentId");
				compartmentId.setTextContent(pig.getCompartmentId().getValue());
				elementList.add(compartmentId);
			}
			//endTimestampAcquisition
			if(pig.getEndTimestampAcquisition()!=null) {
				Element endTimestampAcquisition = doc.createElementNS(namespace,"PF:endTimestampAcquisition");
				endTimestampAcquisition.setTextContent(pig.getEndTimestampAcquisition().getValue().toString());
				elementList.add(endTimestampAcquisition);
			}
			//endTimestampMonitoring
			if(pig.getEndTimestampMonitoring()!=null) {
				Element endTimestampMonitoring = doc.createElementNS(namespace,"PF:endTimestampMonitoring");
				endTimestampMonitoring.setTextContent(pig.getEndTimestampMonitoring().getValue().toString());
				elementList.add(endTimestampMonitoring);
			}
			//sex
			if(pig.getSex()!=null) {
				Element sex = doc.createElementNS(namespace,"PF:sex");
				sex.setTextContent(pig.getSex().getValue());
				elementList.add(sex);
			}
			//startTimestampAcquisition
			if(pig.getStartTimestampAcquisition()!=null) {
				Element startTimestampAcquisition = doc.createElementNS(namespace,"PF:startTimestampAcquisition");
				startTimestampAcquisition.setTextContent(pig.getStartTimestampAcquisition().getValue().toString());
				elementList.add(startTimestampAcquisition);
			}
			//startTimestampMonitoring
			if(pig.getStartTimestampMonitoring()!=null) {
				Element startTimestampMonitoring = doc.createElementNS(namespace,"PF:startTimestampMonitoring");
				startTimestampMonitoring.setTextContent(pig.getStartTimestampMonitoring().getValue().toString());
				elementList.add(startTimestampMonitoring);
			}
			
			//totalConsumedWater
			if(pig.getTotalConsumedWater()!=null) {
				Element consumedWater = doc.createElementNS(namespace, "PF:consumedWater");
				consumedWater.setTextContent(pig.getTotalConsumedWater().getValue().toString());
				elementList.add(consumedWater);
				
				/*if(Configuration.jedi.hget(pig.getPigId().getValue(), "water_intake")!=null) {
					Element totalConsumedWater = doc.createElementNS(namespace, "PF:totalConsumedWater");
					totalConsumedWater.setTextContent(Configuration.jedi.hget(pig.getPigId().getValue(), "water_intake"));
					elementList.add(totalConsumedWater);
				}*/
				if (!Configuration.table.contains(pig.getPigId().getValue(),"water_intake")) {
					Element totalConsumedWater = doc.createElementNS(namespace, "PF:totalConsumedWater");
					totalConsumedWater.setTextContent((Configuration.table.get(pig.getPigId().getValue(), "water_intake")).toString());
					elementList.add(totalConsumedWater);
				}
			}
			//totalTimeConsumedWater
			if(pig.getTotalTimeConsumedWater().getValue()!=null) {
				Element timeConsumedWater = doc.createElementNS(namespace, "PF:timeConsumedWater");
				timeConsumedWater.setTextContent(pig.getTotalTimeConsumedWater().getValue().toString());
				elementList.add(timeConsumedWater);
				
				/*if(Configuration.jedi.hget(pig.getPigId().getValue(), "water_intake_time")!=null) {
					Element totalTimeConsumedWater = doc.createElementNS(namespace, "PF:totalTimeConsumedWater");
					totalTimeConsumedWater.setTextContent(Configuration.jedi.hget(pig.getPigId().getValue(), "water_intake_time"));
					elementList.add(totalTimeConsumedWater);
				}*/
				
				if (!Configuration.table.contains(pig.getPigId().getValue(),"water_intake_time")) {
					Element totalTimeConsumedWater = doc.createElementNS(namespace, "PF:totalTimeConsumedWater");
					totalTimeConsumedWater.setTextContent((Configuration.table.get(pig.getPigId().getValue(), "water_intake_time")).toString());
					elementList.add(totalTimeConsumedWater);
				}
				
			}
			
			//weight
			if(pig.getWeight()!=null) {
				Element weight = doc.createElementNS(namespace,"PF:weight");
				weight.setTextContent(pig.getWeight().getValue().toString());
				elementList.add(weight);
			}
			
			
			
			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
	
	public static ObjectEventType translate_feed_intakes(Pig pig) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		objectEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(Configuration.sgtin+Configuration.ilvo_CompanyPrefix+"."+
				Configuration.Pig_ItemReference+"." + pig.getPigId().getValue());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
		//objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep(Configuration.farm_pig+":feed_intake");
		
		objectEventType.setDisposition(Configuration.sgln+Configuration.ilvo_CompanyPrefix+
				"."+Configuration.Pig_ItemReference+"."+pig.getPenId().getValue());

		ReadPointType readPoint = new ReadPointType();
		//BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		
		if(pig.getAdditionalInfo().getValue().getLocation()!=null) {
			readPoint.setId(Configuration.sgln+Configuration.ilvo_CompanyPrefix+"." +
					Configuration.Pig_ItemReference+"."+ pig.getPenId());
			objectEventType.setReadPoint(readPoint);
		}
		

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType(Configuration.farm_pig+":status");
		businessTransaction1.setValue(Configuration.farm_pig+":feed_intake");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			String namespace = Configuration.farm_pig;
			
			//id
			if(pig.getId()!=null) {
				Element id = doc.createElementNS(namespace,"PF:ID");
				id.setTextContent(pig.getPigId().getValue());
				elementList.add(id);
			}
			
			//Type
			if(pig.getType()!=null) {
				Element type = doc.createElementNS(namespace,"PF:Type");
				type.setTextContent(pig.getType());
				elementList.add(type);
			}
			
			//arrivalTimestamp
			if(pig.getArrivalTimestamp()!=null) {
				Element arrivalTimestamp = doc.createElementNS(namespace,"PF:arrivalTimestamp");
				arrivalTimestamp.setTextContent(pig.getArrivalTimestamp().getValue());
				elementList.add(arrivalTimestamp);
			}
			
			//buildingId
			if(pig.getBuildingId()!=null) {
				Element buildingId = doc.createElementNS(namespace,"PF:buildingId");
				buildingId.setTextContent(pig.getBuildingId().getValue());
				elementList.add(buildingId);
			}
			
			//companyId
			if(pig.getCompanyId()!=null) {
				Element companyId = doc.createElementNS(namespace,"PF:companyId");
				companyId.setTextContent(pig.getCompanyId().getValue());
				elementList.add(companyId);
			}
			
			//farmId
			if(pig.getFarmId()!=null) {
				Element farmId = doc.createElementNS(namespace,"PF:farmId");
				farmId.setTextContent(pig.getFarmId().getValue());
				elementList.add(farmId);
			}
			
			//lastUpdate
			if(pig.getLastUpdate().getValue()!=null) {
				Element lastUpdate = doc.createElementNS(namespace,"PF:lastUpdate");
				lastUpdate.setTextContent(pig.getLastUpdate().getValue());
				elementList.add(lastUpdate);
			}
			//penId
			if(pig.getPenId().getValue()!=null) {
				Element penId = doc.createElementNS(namespace,"PF:penId");
				penId.setTextContent(pig.getPenId().getValue());
				elementList.add(penId);
			}
			//pigId
			if(pig.getPigId().getValue()!=null) {
				Element pigId = doc.createElementNS(namespace,"PF:pigId");
				pigId.setTextContent(pig.getPigId().getValue());
				elementList.add(pigId);
			}
			//compartmentId
			if(pig.getCompartmentId()!=null) {
				Element compartmentId = doc.createElementNS(namespace,"PF:compartmentId");
				compartmentId.setTextContent(pig.getCompartmentId().getValue());
				elementList.add(compartmentId);
			}
			
			//endTimestampAcquisition
			if(pig.getEndTimestampAcquisition()!=null) {
				Element endTimestampAcquisition = doc.createElementNS(namespace,"PF:endTimestampAcquisition");
				endTimestampAcquisition.setTextContent(pig.getEndTimestampAcquisition().getValue().toString());
				elementList.add(endTimestampAcquisition);
			}
			
			//endTimestampMonitoring
			if(pig.getEndTimestampMonitoring()!=null) {
				Element endTimestampMonitoring = doc.createElementNS(namespace,"PF:endTimestampMonitoring");
				endTimestampMonitoring.setTextContent(pig.getEndTimestampMonitoring().getValue().toString());
				elementList.add(endTimestampMonitoring);
			}
			//sex
			if(pig.getSex()!=null) {
				Element sex = doc.createElementNS(namespace,"PF:sex");
				sex.setTextContent(pig.getSex().getValue());
				elementList.add(sex);
			}
			
			//startTimestampAcquisition
			if(pig.getStartTimestampAcquisition()!=null) {
				Element startTimestampAcquisition = doc.createElementNS(namespace,"PF:startTimestampAcquisition");
				startTimestampAcquisition.setTextContent(pig.getStartTimestampAcquisition().getValue().toString());
				elementList.add(startTimestampAcquisition);
			}
			
			//startTimestampMonitoring
			if(pig.getStartTimestampMonitoring()!=null) {
				Element startTimestampMonitoring = doc.createElementNS(namespace,"PF:startTimestampMonitoring");
				startTimestampMonitoring.setTextContent(pig.getStartTimestampMonitoring().getValue().toString());
				elementList.add(startTimestampMonitoring);
			}
			
			//totalConsumedFood
			if(pig.getTotalConsumedFood().getValue()!=null) {
				Element ConsumedFood = doc.createElementNS(namespace, "PF:consumedFood");
				ConsumedFood.setTextContent(pig.getTotalConsumedFood().getValue().toString());
				elementList.add(ConsumedFood);
				/*
				if(Configuration.jedi.hget(pig.getPigId().getValue(), "feed_intake")!=null) {
					Element totalConsumedFood = doc.createElementNS(namespace, "PF:totalConsumedFood");
					totalConsumedFood.setTextContent(Configuration.jedi.hget(pig.getPigId().getValue(), "feed_intake"));
					elementList.add(totalConsumedFood);
				}
				*/
				if (!Configuration.table.contains(pig.getPigId().getValue(),"feed_intake")) {
					Element totalConsumedFood = doc.createElementNS(namespace, "PF:totalConsumedFood");
					totalConsumedFood.setTextContent((Configuration.table.get(pig.getPigId().getValue(), "feed_intake")).toString());
					elementList.add(totalConsumedFood);
				}
			}
			
			//totalTimeConsumedFood
			if(pig.getTotalTimeConsumedFood().getValue()!=null) {
				Element timeConsumedFood = doc.createElementNS(namespace, "PF:timeConsumedFood");
				timeConsumedFood.setTextContent(pig.getTotalTimeConsumedFood().getValue().toString());
				elementList.add(timeConsumedFood);
				/*
				if(Configuration.jedi.hget(pig.getPigId().getValue(), "feed_intake_time")!=null) {
					Element totalTimeConsumedFood = doc.createElementNS(namespace, "PF:totalTimeConsumedFood");
					totalTimeConsumedFood.setTextContent(Configuration.jedi.hget(pig.getPigId().getValue(), "feed_intake_time"));
					elementList.add(totalTimeConsumedFood);
				}
				*/
				
				if (!Configuration.table.contains(pig.getPigId().getValue(),"feed_intake_time")) {
					Element totalTimeConsumedFood = doc.createElementNS(namespace, "PF:totalTimeConsumedFood");
					totalTimeConsumedFood.setTextContent((Configuration.table.get(pig.getPigId().getValue(), "feed_intake_time")).toString());
					elementList.add(totalTimeConsumedFood);
				}
				
			}
			
			//weight
			if(pig.getWeight()!=null) {
				Element weight = doc.createElementNS(namespace,"PF:weight");
				weight.setTextContent(pig.getWeight().getValue().toString());
				elementList.add(weight);
			}
			
			
			
			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
	
	public static ObjectEventType translate(Pig pig) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		objectEventType.setEventTime(Calendar.getInstance());
		objectEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		objectEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		objectEventType.setBaseExtension(epcisEventExtension);

		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue("urn:epc:id:sgtin:88000269." + pig.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
		//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
		//objectEventType.setBaseExtension(eventExtention);

		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:monitoring");
		
		objectEventType.setDisposition("urn:epcglobal:cbv:disp:on_the line");

		ReadPointType readPoint = new ReadPointType();
		BusinessLocationType businessLocation = new BusinessLocationType();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		
		if(pig.getAdditionalInfo().getValue().getLocation()!=null) {
			readPoint.setId("urn:epc:id:sgln:8800026900016." + pig.getAdditionalInfo().getValue().getLocation());
			objectEventType.setReadPoint(readPoint);
			businessLocation.setId("urn:epc:id:sgln:8800026900016.103." + pig.getAdditionalInfo().getValue().getLocation());
			objectEventType.setBizLocation(businessLocation);
		}else if(pig.getAdditionalInfo().getValue().getLocation_() != null) {
			readPoint.setId("urn:epc:id:sgln:8800026900016." + pig.getAdditionalInfo().getValue().getLocation_());
			objectEventType.setReadPoint(readPoint);
			businessLocation.setId("urn:epc:id:sgln:8800026900016.103." + pig.getAdditionalInfo().getValue().getLocation_());
			objectEventType.setBizLocation(businessLocation);
		}
		

		BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
		BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
		businessTransaction1.setType("urn:epcglobal:cbv:PigFarming:status");
		businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:Monitoring");
		businessTransactionList.getBizTransactions().add(businessTransaction1);
		objectEventType.setBizTransactionList(businessTransactionList);

		List<Object> elementList = new ArrayList<Object>();

		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			String namespace = "http://ns.example.com/epcisapp/pigFarm";
			
			if(pig.getId()!=null) {
				Element id = doc.createElementNS(namespace,"PF:ID");
				id.setTextContent(pig.getId());
				elementList.add(id);
			}
			
			

			if(pig.getType()!=null) {
				Element type = doc.createElementNS(namespace,"PF:Type");
				type.setTextContent(pig.getType());
				elementList.add(type);
			}
			
			if(pig.getAdditionalInfo().getValue()!=null) {
				
				PigAdditionalInfo additionaValue = pig.getAdditionalInfo().getValue();
				
				Element additonalInfo = doc.createElementNS(namespace,"PF:AdditionalInfo");
				
				if(additionaValue.getDuration()!=null) {
					Element duration = doc.createElementNS(namespace,"PF:duration");
					//Element duration = doc.createElementNS("http://gs1.org/voc/PigFarming", "PF:duration");
					duration.setTextContent(additionaValue.getDuration());
					
					additonalInfo.appendChild(duration);
				}
				if(additionaValue.getSourceFileNameCsvReader()!=null) {
					Element sourceFileNameCsvReaderValue = doc.createElementNS(namespace,"PF:sourceFileNameCsvReader");
					sourceFileNameCsvReaderValue.setTextContent(additionaValue.getSourceFileNameCsvReader());
					
					additonalInfo.appendChild(sourceFileNameCsvReaderValue);
				}
				if(additionaValue.getFeed_intake()!=null) {
					Element feed_intakeValue = doc.createElementNS(namespace, "PF:feed_intake");
					feed_intakeValue.setTextContent(additionaValue.getFeed_intake());
					
					additonalInfo.appendChild(feed_intakeValue);
				}
				if(additionaValue.getVisit_time()!=null) {
					Element visit_timeValue = doc.createElementNS(namespace, "PF:visit_time");
					visit_timeValue.setTextContent(additionaValue.getVisit_time());
					
					additonalInfo.appendChild(visit_timeValue);
				}
				if(additionaValue.getLifenumber()!=null) {
					Element lifenumberValue = doc.createElementNS(namespace,"PF:lifenumber");
					lifenumberValue.setTextContent(additionaValue.getLifenumber());
					
					additonalInfo.appendChild(lifenumberValue);
				}
				if(additionaValue.getResponder()!=null) {
					Element responderValue = doc.createElementNS(namespace,"PF:responder");
					responderValue.setTextContent(additionaValue.getResponder());
					
					additonalInfo.appendChild(responderValue);
				}
				if(additionaValue.getWeight()!=null) {
					Element weightValue = doc.createElementNS(namespace,"PF:weight");
					weightValue.setTextContent(additionaValue.getWeight());
					
					additonalInfo.appendChild(weightValue);
				}
				if(additionaValue.getLocation()!=null) {
					Element locationValue = doc.createElementNS(namespace,"PF:location");
					locationValue.setTextContent(additionaValue.getLocation());
					
					additonalInfo.appendChild(locationValue);
				}
				if(additionaValue.getState()!=null) {
					Element stateValue = doc.createElementNS(namespace,"PF:state");
					stateValue.setTextContent(additionaValue.getState());
					
					additonalInfo.appendChild(stateValue);
				}
				if(additionaValue.getAnimal_number()!=null) {
					Element animal_numberValue = doc.createElementNS(namespace,"PF:animal_number");
					animal_numberValue.setTextContent(additionaValue.getAnimal_number());
					
					additonalInfo.appendChild(animal_numberValue);
				}
				if(additionaValue.getCycles()!=null) {
					Element CyclesValue = doc.createElementNS(namespace,"PF:Cycles");
					CyclesValue.setTextContent(additionaValue.getCycles());
					
					additonalInfo.appendChild(CyclesValue);
				}
				if(additionaValue.getLast()!=null) {
					Element sLastValue = doc.createElementNS(namespace, "PF:Last");
					sLastValue.setTextContent(additionaValue.getLast());
					
					additonalInfo.appendChild(sLastValue);
				}
				if(additionaValue.getPort()!=null) {
					Element PortValue = doc.createElementNS(namespace,"PF:Port");
					PortValue.setTextContent(additionaValue.getPort());
					
					additonalInfo.appendChild(PortValue);
				}
				if(additionaValue.getSerialnumber()!=null) {
					Element SerialnumberValue = doc.createElementNS(namespace,"PF:Serialnumber");
					SerialnumberValue.setTextContent(additionaValue.getSerialnumber());
					
					additonalInfo.appendChild(SerialnumberValue);
				}
				if(additionaValue.getFirst()!=null) {
					Element FirstValue = doc.createElementNS(namespace, "PF:First");
					FirstValue.setTextContent(additionaValue.getFirst());
					
					additonalInfo.appendChild(FirstValue);
				}
				if(additionaValue.getName()!=null) {
					Element NameValue = doc.createElementNS(namespace,"PF:Name");
					NameValue.setTextContent(additionaValue.getName());
					
					additonalInfo.appendChild(NameValue);
				}
				if(additionaValue.getLocation_()!=null) {
					Element LocationValue = doc.createElementNS(namespace,"PF:Location");
					LocationValue.setTextContent(additionaValue.getLocation_());
					
					additonalInfo.appendChild(LocationValue);
				}
				
				elementList.add(additonalInfo);
			}
			
			if(pig.getBuildingId().getValue()!=null) {
				Element buildingId = doc.createElementNS(namespace,"PF:buildingId");
				buildingId.setTextContent(pig.getBuildingId().getValue());
				elementList.add(buildingId);
			}
			
			if(pig.getFarmId().getValue()!=null) {
				Element farmId = doc.createElementNS(namespace,"PF:farmId");
				farmId.setTextContent(pig.getFarmId().getValue());
				elementList.add(farmId);
			}
			if(pig.getLastUpdate().getValue()!=null) {
				Element lastUpdate = doc.createElementNS(namespace,"PF:lastUpdate");
				lastUpdate.setTextContent(pig.getLastUpdate().getValue());
				elementList.add(lastUpdate);
			}
			if(pig.getPenId().getValue()!=null) {
				Element penId = doc.createElementNS(namespace,"PF:penId");
				penId.setTextContent(pig.getPenId().getValue());
				elementList.add(penId);
			}
			if(pig.getPigId().getValue()!=null) {
				Element pigId = doc.createElementNS(namespace,"PF:pigId");
				pigId.setTextContent(pig.getPigId().getValue());
				elementList.add(pigId);
			}
			if(pig.getSerialNumber().getValue()!=null) {
				Element serialNumber = doc.createElementNS(namespace,"PF:serialNumber");
				serialNumber.setTextContent(pig.getSerialNumber().getValue());
				elementList.add(serialNumber);
			}
			if(pig.getTotalConsumedFood().getValue()!=null) {
				Element totalConsumedFood = doc.createElementNS(namespace, "PF:totalConsumedFood");
				totalConsumedFood.setTextContent(pig.getTotalConsumedFood().getValue().toString());
				elementList.add(totalConsumedFood);
			}
			if(pig.getTotalConsumedWater().getValue()!=null) {
				Element totalConsumedWater = doc.createElementNS(namespace, "PF:totalConsumedWater");
				totalConsumedWater.setTextContent(pig.getTotalConsumedWater().getValue());
				elementList.add(totalConsumedWater);
			}
			if(pig.getTotalTimeConsumedFood().getValue()!=null) {
				Element totalTimeConsumedFood = doc.createElementNS(namespace, "PF:totalTimeConsumedFood");
				totalTimeConsumedFood.setTextContent(pig.getTotalTimeConsumedFood().getValue().toString());
				elementList.add(totalTimeConsumedFood);
			}
			if(pig.getTotalTimeConsumedWater().getValue()!=null) {
				Element totalTimeConsumedWater = doc.createElementNS(namespace, "PF:totalTimeConsumedWater");
				totalTimeConsumedWater.setTextContent(pig.getTotalTimeConsumedWater().getValue());
				elementList.add(totalTimeConsumedWater);
			}
			if(pig.getWeight().getValue()!=null) {
				Element weight = doc.createElementNS(namespace,"PF:weight");
				weight.setTextContent(pig.getWeight().getValue().toString());
				elementList.add(weight);
			}
			
			
			
			

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);

		return objectEventType;
	}
	
	public static ObjectEventType translate(Car car) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
				//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
				objectEventType.setEventTime(Calendar.getInstance());
				objectEventType.setRecordTime(Calendar.getInstance());
				int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
				//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
				String offset="00";
				if(offsetInt<10 && offsetInt>=0) {
					offset="+0"+offsetInt;
				}else if(offsetInt>-10 && offsetInt<0) {
					offset="-0"+(-offsetInt);
				}
				//System.out.println("offset : "+offset);
				objectEventType.setEventTimeZoneOffset(offset+":00");
				
				//System.out.println(objectEventType.getEventTimeZoneOffset());

				//objectEventType.setEventTimeZoneOffset("-06:00");

				EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
				epcisEventExtension.setEventID(UUID.randomUUID().toString());
				objectEventType.setBaseExtension(epcisEventExtension);

				EPCListType objectEventEPCs = new EPCListType();
				EPC epc1 = new EPC();
				//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
				epc1.setValue("urn:epc:id:sgtin:88000269." + car.getId());	
				objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
				objectEventType.setEpcList(objectEventEPCs);
				
				//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
				//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + car.getId());
				//objectEventType.setBaseExtension(eventExtention);

				
				objectEventType.setAction(ActionType.fromValue("OBSERVE"));
				
				objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:car");
				
				objectEventType.setDisposition("urn:epcglobal:cbv:disp:carSensor");

				ReadPointType readPoint = new ReadPointType();
				//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
				readPoint.setId("urn:epc:id:sgln:8800026900016." + car.getId());
				objectEventType.setReadPoint(readPoint);

				BusinessLocationType businessLocation = new BusinessLocationType();
				//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
				businessLocation.setId("urn:epc:id:sgln:8800026900016.103." + car.getId());
				objectEventType.setBizLocation(businessLocation);

				BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
				BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
				businessTransaction1.setType("urn:epcglobal:cbv:Bus:status");
				businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:Sensing");
				businessTransactionList.getBizTransactions().add(businessTransaction1);
				objectEventType.setBizTransactionList(businessTransactionList);

				List<Object> elementList = new ArrayList<Object>();

				try {
					Document doc;
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = dbf.newDocumentBuilder();
					doc = builder.newDocument();

					if(car.getId()!=null) {
						Element id = doc.createElementNS("http://ns.oliot.com/id", "oliot:Fiware");
						id.setTextContent(car.getId());
						elementList.add(id);
					}
					

					if(car.getType()!=null) {
						Element type = doc.createElementNS("http://ns.oliot.com/type", "oliot:Fiware");
						type.setTextContent(car.getType());
						elementList.add(type);
					}
						
					if(car.getSpeed()!=null) {
						Element speed = doc.createElementNS("http://ns.oliot.com/speed", "oliot:Fiware");
						
						if(car.getSpeed().getType()!=null) {
							Element tempratureType = doc.createElementNS("http://ns.oliot.com/speed/type", "oliot:Fiware");
							tempratureType.setTextContent(car.getSpeed().getType());
							
							speed.appendChild(tempratureType);
						}
						if(car.getSpeed().getValue()!=null) {
							Element tempratureValue = doc.createElementNS("http://ns.oliot.com/speed/value", "oliot:Fiware");
							tempratureValue.setTextContent(car.getSpeed().getValue().toString());
							
							speed.appendChild(tempratureValue);
						}
						if(car.getSpeed().getMetadat()!=null) {
							Element tempratureMetadat = doc.createElementNS("http://ns.oliot.com/speed/metadata", "oliot:Fiware");
							tempratureMetadat.setTextContent(car.getSpeed().getMetadat().toString());
							
							speed.appendChild(tempratureMetadat);
						}
						
						elementList.add(speed);
					}
					
					
					
					

				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				objectEventType.setAnies(elementList);
				
		return objectEventType;
	}
	
	public static ObjectEventType translate(BusEstimation busEstimation) {
		ObjectEventType objectEventType=new ObjectEventType();
		
		
		//GregorianCalendar gRecordTime = new GregorianCalendar();
				//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
				objectEventType.setEventTime(Calendar.getInstance());
				objectEventType.setRecordTime(Calendar.getInstance());
				int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
				//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
				String offset="00";
				if(offsetInt<10 && offsetInt>=0) {
					offset="+0"+offsetInt;
				}else if(offsetInt>-10 && offsetInt<0) {
					offset="-0"+(-offsetInt);
				}
				//System.out.println("offset : "+offset);
				objectEventType.setEventTimeZoneOffset(offset+":00");
				
				//System.out.println(objectEventType.getEventTimeZoneOffset());

				//objectEventType.setEventTimeZoneOffset("-06:00");

				EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
				epcisEventExtension.setEventID(UUID.randomUUID().toString());
				objectEventType.setBaseExtension(epcisEventExtension);

				EPCListType objectEventEPCs = new EPCListType();
				EPC epc1 = new EPC();
				//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
				epc1.setValue(busEstimation.getId());	
				objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
				objectEventType.setEpcList(objectEventEPCs);
				
				//EPCISEventExtensionType eventExtention=new EPCISEventExtensionType();
				//eventExtention.setEventID("urn:epc:id:sgtin:88000269." + room.getId());
				//objectEventType.setBaseExtension(eventExtention);

				
				objectEventType.setAction(ActionType.fromValue("OBSERVE"));
				
				objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:driving");
				
				objectEventType.setDisposition("urn:epcglobal:cbv:disp:on_the_line");
                
				
				if(busEstimation.getGeolocation()!=null)
					if(busEstimation.getGeolocation().getValue()!= null)
						if(busEstimation.getGeolocation().getValue().getType().equals("Point"))
							System.out.println(busEstimation.getGeolocation().getValue().getType());
							if(busEstimation.getGeolocation().getValue().getCoordinates()!=null) {
								List<Double> coordinates=busEstimation.getGeolocation().getValue().getCoordinates();
								String sgln=Utility.coordinta_sgln_converter(coordinates.get(0),coordinates.get(1));
								
								ReadPointType readPoint = new ReadPointType();
								//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
								
								readPoint.setId(sgln);
								objectEventType.setReadPoint(readPoint);

								BusinessLocationType businessLocation = new BusinessLocationType();
								//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
								businessLocation.setId(sgln);
								objectEventType.setBizLocation(businessLocation);
							}
				

				BusinessTransactionListType businessTransactionList = new BusinessTransactionListType();
				BusinessTransactionType businessTransaction1 = new BusinessTransactionType();
				businessTransaction1.setType("urn:epcglobal:cbv:Bus:status");
				businessTransaction1.setValue("http://transaction.acme.com/po/urn:epcglobal:cbv:bizstep:Sensing");
				businessTransactionList.getBizTransactions().add(businessTransaction1);
				objectEventType.setBizTransactionList(businessTransactionList);

				List<Object> elementList = new ArrayList<Object>();

				try {
					Document doc;
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = dbf.newDocumentBuilder();
					doc = builder.newDocument();
					
					if(busEstimation.getId()!=null) {
						Element id = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:id", "oliot:Fiware");
						id.setTextContent(busEstimation.getId());
						elementList.add(id);
					}
										

					if(busEstimation.getType()!=null) {
						Element type = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:type", "oliot:Fiware");
						type.setTextContent(busEstimation.getType());
						elementList.add(type);
					}
					
					if(busEstimation.getCompanyName()!=null) {
						Element companyName = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:companyName", "oliot:Fiware");
						
						if(busEstimation.getCompanyName().getType()!=null) {
							Element shortIDType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:companyName:type", "oliot:Fiware");
							shortIDType.setTextContent(busEstimation.getCompanyName().getType());
							
							companyName.appendChild(shortIDType);
						}
						if(busEstimation.getCompanyName().getValue()!=null) {
							Element shortIDValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:companyName:value", "oliot:Fiware");
							shortIDValue.setTextContent(busEstimation.getCompanyName().getValue().toString());
							
							companyName.appendChild(shortIDValue);
						}
						if(busEstimation.getCompanyName().getMetadat()!=null) {
							Element shortIDMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:companyName:metadata", "oliot:Fiware");
							shortIDMetadat.setTextContent(busEstimation.getCompanyName().getValue().toString());
							
							companyName.appendChild(shortIDMetadat);
						}
						
						elementList.add(companyName);
					}
					
					if(busEstimation.getDestinationBusLines()!=null) {
						Element destinationBusLines = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:destinationBusLines", "oliot:Fiware");
						
						if(busEstimation.getDestinationBusLines().getType()!=null) {
							Element destinationBusLinesType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:destinationBusLines:type", "oliot:Fiware");
							destinationBusLinesType.setTextContent(busEstimation.getDestinationBusLines().getType());
							
							destinationBusLines.appendChild(destinationBusLinesType);
						}
						if(busEstimation.getDestinationBusLines().getValue()!=null) {
							Element destinationBusLinesDValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:destinationBusLines:value", "oliot:Fiware");
							String listDestination="[";
							for(int i=0; i<busEstimation.getDestinationBusLines().getValue().size(); i++) 
								listDestination+=busEstimation.getDestinationBusLines().getValue().get(i)+",";
							
							listDestination=listDestination.substring(0,listDestination.length()-1)+"]";
							destinationBusLinesDValue.setTextContent(listDestination);
							
							destinationBusLines.appendChild(destinationBusLinesDValue);
						}
						if(busEstimation.getDestinationBusLines().getMetadat()!=null) {
							Element destinationBusLinesMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:destinationBusLines:metadata", "oliot:Fiware");
							destinationBusLinesMetadat.setTextContent(busEstimation.getDestinationBusLines().getValue().toString());
							
							destinationBusLines.appendChild(destinationBusLinesMetadat);
						}
						
						elementList.add(destinationBusLines);
					}
					
					if(busEstimation.getDateModified()!=null) {
						Element dateModified = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:dateModified", "oliot:Fiware");
						
						if(busEstimation.getDateModified().getType()!=null) {
							Element dateModifiedType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:dateModified:type", "oliot:Fiware");
							dateModifiedType.setTextContent(busEstimation.getDateModified().getType());
							
							dateModified.appendChild(dateModifiedType);
						}
						if(busEstimation.getDateModified().getValue()!=null) {
							Element dateModifiedValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:dateModified:value", "oliot:Fiware");
							dateModifiedValue.setTextContent(busEstimation.getDateModified().getValue().toString());
							
							dateModified.appendChild(dateModifiedValue);
						}
						if(busEstimation.getDateModified().getMetadat()!=null) {
							Element dateModifiedMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:dateModified:metadata", "oliot:Fiware");
							dateModifiedMetadat.setTextContent(busEstimation.getDateModified().getValue().toString());
							
							dateModified.appendChild(dateModifiedMetadat);
						}
						
						elementList.add(dateModified);
					}
					
					if(busEstimation.getRefBusLine()!=null) {
						Element refBusLine = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusLine", "oliot:Fiware");
						
						if(busEstimation.getRefBusLine().getType()!=null) {
							Element refBusLineType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusLine:type", "oliot:Fiware");
							refBusLineType.setTextContent(busEstimation.getRefBusLine().getType());
							
							refBusLine.appendChild(refBusLineType);
						}
						if(busEstimation.getRefBusLine().getValue()!=null) {
							Element refBusLineValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusLine:value", "oliot:Fiware");
							refBusLineValue.setTextContent(busEstimation.getRefBusLine().getValue().toString());
							
							refBusLine.appendChild(refBusLineValue);
						}
						if(busEstimation.getShortID().getMetadat()!=null) {
							Element refBusLineMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusLine:metadata", "oliot:Fiware");
							refBusLineMetadat.setTextContent(busEstimation.getRefBusLine().getValue().toString());
							
							refBusLine.appendChild(refBusLineMetadat);
						}
						
						elementList.add(refBusLine);
					}
					
					if(busEstimation.getRefBusStop()!=null) {
						Element refBusStop = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusStop", "oliot:Fiware");
						
						if(busEstimation.getRefBusStop().getType()!=null) {
							Element refBusStopType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusStop:type", "oliot:Fiware");
							refBusStopType.setTextContent(busEstimation.getRefBusStop().getType());
							
							refBusStop.appendChild(refBusStopType);
						}
						if(busEstimation.getRefBusStop().getValue()!=null) {
							Element refBusStopValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusStop:value", "oliot:Fiware");
							refBusStopValue.setTextContent(busEstimation.getRefBusStop().getValue().toString());
							
							refBusStop.appendChild(refBusStopValue);
						}
						if(busEstimation.getRefBusStop().getMetadat()!=null) {
							Element refBusStopMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:refBusStop:metadata", "oliot:Fiware");
							refBusStopMetadat.setTextContent(busEstimation.getRefBusStop().getValue().toString());
							
							refBusStop.appendChild(refBusStopMetadat);
						}
						
						elementList.add(refBusStop);
					}
					
					if(busEstimation.getRemainingDistances()!=null) {
						Element remainingDistances = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID", "oliot:Fiware");
						
						if(busEstimation.getRemainingDistances().getType()!=null) {
							Element remainingDistancesType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingDistances:type", "oliot:Fiware");
							remainingDistancesType.setTextContent(busEstimation.getShortID().getType());
							
							remainingDistances.appendChild(remainingDistancesType);
						}
						if(busEstimation.getRemainingDistances().getValue()!=null) {
							Element remainingDistancesDValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingDistances:value", "oliot:Fiware");
							String listRemainingDist="[";
							for(int i=0; i<busEstimation.getRemainingDistances().getValue().size(); i++) 
								listRemainingDist+=busEstimation.getRemainingDistances().getValue().get(i)+",";
							
							listRemainingDist=listRemainingDist.substring(0,listRemainingDist.length()-1)+"]";
							remainingDistancesDValue.setTextContent(listRemainingDist);
							
							remainingDistances.appendChild(remainingDistancesDValue);
						}
						if(busEstimation.getRemainingDistances().getMetadat()!=null) {
							Element remainingDistancesMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingDistances:metadata", "oliot:Fiware");
							remainingDistancesMetadat.setTextContent(busEstimation.getShortID().getValue().toString());
							
							remainingDistances.appendChild(remainingDistancesMetadat);
						}
						
						elementList.add(remainingDistances);
					}
					
					if(busEstimation.getRemainingStations()!=null) {
						Element remainingStations = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingStations", "oliot:Fiware");
						
						if(busEstimation.getRemainingStations().getType()!=null) {
							Element remainingStationsType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingStations:type", "oliot:Fiware");
							remainingStationsType.setTextContent(busEstimation.getRemainingStations().getType());
							
							remainingStations.appendChild(remainingStationsType);
						}
						if(busEstimation.getRemainingStations().getValue()!=null) {
							Element remainingStationsValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingStations:value", "oliot:Fiware");
							remainingStationsValue.setTextContent(busEstimation.getRemainingStations().getValue().toString());
							
							remainingStations.appendChild(remainingStationsValue);
						}
						if(busEstimation.getRemainingStations().getMetadat()!=null) {
							Element remainingStationsMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingStations:metadata", "oliot:Fiware");
							remainingStationsMetadat.setTextContent(busEstimation.getRemainingStations().getValue().toString());
							
							remainingStations.appendChild(remainingStationsMetadat);
						}
						
						elementList.add(remainingStations);
					}
					
					if(busEstimation.getRemainingTimes()!=null) {
						Element remainingTimes = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingTimes", "oliot:Fiware");
						
						if(busEstimation.getRemainingTimes().getType()!=null) {
							Element remainingTimesType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingTimes:type", "oliot:Fiware");
							remainingTimesType.setTextContent(busEstimation.getRemainingTimes().getType());
							
							remainingTimes.appendChild(remainingTimesType);
						}
						if(busEstimation.getRemainingTimes().getValue()!=null) {
							Element remainingTimesValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingTimes:value", "oliot:Fiware");
							remainingTimesValue.setTextContent(busEstimation.getRemainingTimes().getValue().toString());
							
							remainingTimes.appendChild(remainingTimesValue);
						}
						if(busEstimation.getRemainingTimes().getMetadat()!=null) {
							Element remainingTimesMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:remainingTimes:metadata", "oliot:Fiware");
							remainingTimesMetadat.setTextContent(busEstimation.getRemainingTimes().getValue().toString());
							
							remainingTimes.appendChild(remainingTimesMetadat);
						}
						
						elementList.add(remainingTimes);
					}
					
					if(busEstimation.getShortID()!=null) {
						Element shortID = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID", "oliot:Fiware");
						
						if(busEstimation.getShortID().getType()!=null) {
							Element shortIDType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID:type", "oliot:Fiware");
							shortIDType.setTextContent(busEstimation.getShortID().getType());
							
							shortID.appendChild(shortIDType);
						}
						if(busEstimation.getShortID().getValue()!=null) {
							Element shortIDValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID:value", "oliot:Fiware");
							shortIDValue.setTextContent(busEstimation.getShortID().getValue().toString());
							
							shortID.appendChild(shortIDValue);
						}
						if(busEstimation.getShortID().getMetadat()!=null) {
							Element shortIDMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:ShortID:metadata", "oliot:Fiware");
							shortIDMetadat.setTextContent(busEstimation.getShortID().getValue().toString());
							
							shortID.appendChild(shortIDMetadat);
						}
						
						elementList.add(shortID);
					}
					
					if(busEstimation.getGeolocation()!=null) {
						Element geolocation = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:", "oliot:Fiware");
						
						if(busEstimation.getGeolocation().getType()!=null) {
							Element geolocationType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:type", "oliot:Fiware");
							geolocationType.setTextContent(busEstimation.getGeolocation().getType());
							
							geolocation.appendChild(geolocationType);
						}
						if(busEstimation.getGeolocation().getValue()!=null) {
							Element geolocationValue = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:value", "oliot:Fiware");
							if(busEstimation.getGeolocation().getValue().getType()!=null) {
								Element geolocationValueType = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:value:type", "oliot:Fiware");
								geolocationValueType.setTextContent(busEstimation.getGeolocation().getValue().getType());
								geolocationValue.appendChild(geolocationValueType);
							}
							
							if(busEstimation.getGeolocation().getValue().getCoordinates()!=null) {
								Element geolocationValueCoordinate = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:value:coordinate", "oliot:Fiware");
								String coordinates="[";
								for(int i=0; i< busEstimation.getGeolocation().getValue().getCoordinates().size(); i++)coordinates+=busEstimation.getGeolocation().getValue().getCoordinates().get(i) +",";
								coordinates=coordinates.substring(0,coordinates.length()-1);
								coordinates+="]";
								geolocationValueCoordinate.setTextContent(coordinates);
								geolocationValue.appendChild(geolocationValueCoordinate);
							}
							
							
							
							geolocation.appendChild(geolocationValue);
						}
						if(busEstimation.getGeolocation().getMetadat()!=null) {
							Element geolocationMetadat = doc.createElementNS("urn:autidlabsk:epcisapp:bis:bus:estimation:geolocation:metadata", "oliot:Fiware");
							geolocationMetadat.setTextContent(busEstimation.getGeolocation().getMetadat().toString());
							
							geolocation.appendChild(geolocationMetadat);
						}
						
						elementList.add(geolocation);
					}
					
					
					
					

				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				objectEventType.setAnies(elementList);
				
				
		return objectEventType;
	}

	public static ObjectEventType translate(Alert alert) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	/*public static ObjectEventType translate(Building building) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}*/
	

	public static ObjectEventType translate(BuildingOperation buildingOperation) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Open311ServiceRequest open311ServiceRequest) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Open311ServiceType open311ServiceType) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Device device) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(DeviceModel deviceModel) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(AeroAllergenObserved aeroAllergenObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(AirQualityObserved airQualityObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(NoiseLevelObserved noiseLevelObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(WaterQualityObserved WaterQualityObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(KeyPerformanceIndicator keyPerformanceIndicator) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(OffStreetParking offStreetParking) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(OnStreetParking onStreetParking) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(ParkingAccess parkingAccess) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(ParkingGroup parkingGroup) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(ParkingSpot parkingSpot) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(FlowerBed flowerBed) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Garden garden) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(GreenspaceRecord greenspaceRecord) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Park park) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Beach beach) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Museum museum) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(PointOfInterest pointOfInterest) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(TouristInformationCenter touristInformationCenter) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	

	public static ObjectEventType translate(Streetlight streetlight) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(StreetlightControlCabinet streetlightControlCabinet) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(StreetlightGroup streetlightGroup) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(StreetlightModel streetlightModel) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(Road road) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(TrafficFlowObserved trafficFlowObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(Vehicle vehicle) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(VehicleModel vehicleModel) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WasteContainer WasteContainer) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WasteContainerIsle wasteContainerIsle) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WasteContainerModel wasteContainerModel) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WeatherAlarm weatherAlarm) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WeatherForecast weatherForecast) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	public static ObjectEventType translate(WeatherObserved weatherObserved) {
		ObjectEventType objectEventType=new ObjectEventType();
		return objectEventType;
	}
	
	

}
