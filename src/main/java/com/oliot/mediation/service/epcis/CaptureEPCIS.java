package com.oliot.mediation.service.epcis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.gs1.epcglobal.epcis.ObjectEventType;

import com.oliot.mediation.configuration.Configuration;
import com.oliot.mediation.service.gs1Source.CaptureGs1Source;
import com.oliot.model.fiware.Bus.BusEstimation;
import com.oliot.model.fiware.Bus.BusLine;
import com.oliot.model.fiware.Bus.BusStop;
import com.oliot.model.fiware.PigFarming.Building;
import com.oliot.model.fiware.PigFarming.Pig;

public class CaptureEPCIS extends EventDataManager{
	
	Double weight_test =1.0;
	
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
			
		}else if(model=="Farm/Pig") {
			
			//List<Pig> farmPigList= ConvertUtility.getFarmPigList(body);
			List<Pig> farmPigList= ConvertUtility.getFarmPigList_2(body).getData();
			
			for(int i=0; i<farmPigList.size(); i++) {
				Pig pig=farmPigList.get(i);
				
				//System.out.println("PigID : " + farmPigList.get(i).getPigId().getValue());
				
				//System.out.println("Food Intakes event ----");
				//Food intakes event 
				if(pig.getTotalConsumedFood()!=null && !pig.getTotalConsumedFood().getValue().equals("")) {
					if(Double.valueOf(pig.getTotalConsumedFood().getValue())>=0) {
						//System.out.println("Food Intakes event process started");
						/*
						String feed_intake = Configuration.jedi.hget(farmPigList.get(i).getPigId().getValue(),"feed_intake");
						if(feed_intake!=null) {
							Double total_feed_intake=Double.parseDouble(feed_intake)+
									farmPigList.get(i).getTotalConsumedFood().getValue();
							Configuration.jedi.hset(farmPigList.get(i).getPigId().getValue(),
									"feed_intake",total_feed_intake.toString());
						}else {
							Configuration.jedi.hset(farmPigList.get(i).getPigId().getValue(),"feed_intake",
									pig.getTotalConsumedFood().getValue().toString());
						}
						*/
						if (!Configuration.table.contains(farmPigList.get(i).getPigId().getValue(),"feed_intake")) {
							Configuration.table.put(farmPigList.get(i).getPigId().getValue(),"feed_intake",
									Double.valueOf(pig.getTotalConsumedFood().getValue()));
						}else {
							Double feed_intake = Configuration.table.get(farmPigList.get(i).getPigId().getValue(),"feed_intake");
							Double total_feed_intake=feed_intake + Double.valueOf(farmPigList.get(i).getTotalConsumedFood().getValue());
							Configuration.table.put(farmPigList.get(i).getPigId().getValue(),"feed_intake", total_feed_intake);
						}
						
						if(pig.getTotalTimeConsumedFood()!=null && !pig.getTotalTimeConsumedFood().equals("")) {
							if(Double.valueOf(pig.getTotalTimeConsumedFood().getValue())>=0) {
								
								/*
								String feed_intake_time = Configuration.jedi.hget(pig.getPigId().getValue(),"feed_intake_time");
								//System.out.println("feed_intake_time: " +feed_intake_time);
								if(feed_intake_time!=null) {
									Double total_feed_intake_time=Double.parseDouble(feed_intake_time)+
											pig.getTotalTimeConsumedFood().getValue();
									//System.out.println("total_feed_intake_time: " +total_feed_intake_time);
									Configuration.jedi.hset(pig.getPigId().getValue(),
											"feed_intake_time",total_feed_intake_time.toString());
								}else {
									Configuration.jedi.hset(pig.getPigId().getValue(),"feed_intake_time",
											pig.getTotalTimeConsumedFood().getValue().toString());
								}
								
								*/
								
								if (!Configuration.table.contains(pig.getPigId().getValue(),"feed_intake_time")) {
									Configuration.table.put(farmPigList.get(i).getPigId().getValue(),"feed_intake_time",
											Double.valueOf(pig.getTotalTimeConsumedFood().getValue()));
								}else {
									Double feed_intake_time = Configuration.table.get(farmPigList.get(i).getPigId().getValue(),"feed_intake_time");
									Double total_feed_intake_time=feed_intake_time + Double.valueOf(pig.getTotalTimeConsumedFood().getValue());
									Configuration.table.put(pig.getPigId().getValue(),"feed_intake_time", total_feed_intake_time);
								}
								
							}
						}
						
						//Food Intakes event 
						ObjectEventType feed_intakes_Object= new ObjectEventType();
						feed_intakes_Object=ConvertUtility.translate_feed_intakes(pig);
						this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(feed_intakes_Object);
						//System.out.println("Food Intakes event processed");
						
					}
				}
				
			
				//System.out.println("Water Intakes event ----");
				//Water intakes event 
				if(pig.getTotalConsumedWater()!=null) {
					if(!pig.getTotalConsumedWater().getValue().equals("")) {
						//Water Consume Event 
						//System.out.println("Water Intakes event process started");
						/*
						String water_intake = Configuration.jedi.hget(pig.getPigId().getValue(),"water_intake");
						if(water_intake!=null) {
							Double total_water_intakes=Double.parseDouble(water_intake)+
									Double.parseDouble(pig.getTotalConsumedWater().getValue());
							Configuration.jedi.hset(pig.getPigId().getValue(),"water_intake",
									total_water_intakes.toString());
						}else {
							Configuration.jedi.hset(pig.getPigId().getValue(),"water_intake",
									farmPigList.get(i).getTotalConsumedWater().getValue());
						}*/
						
						if (!Configuration.table.contains(pig.getPigId().getValue(),"water_intake")) {
							Configuration.table.put(pig.getPigId().getValue(),"water_intake",
									Double.parseDouble(pig.getTotalConsumedWater().getValue()));
						}else {
							Double water_intake = Configuration.table.get(farmPigList.get(i).getPigId().getValue(),"water_intake");
							Double total_water_intakes=water_intake + Double.parseDouble(farmPigList.get(i).getTotalConsumedWater().getValue());
							Configuration.table.put(farmPigList.get(i).getPigId().getValue(),"water_intake", total_water_intakes);
						}
						
						if(pig.getTotalTimeConsumedWater()!=null) {
							if(!pig.getTotalTimeConsumedWater().getValue().contentEquals("")) {
								
								/*
								String water_intake_time = Configuration.jedi.hget(pig.getPigId().getValue(),"water_intake_time");
								if(water_intake_time!=null) {
									Double total_water_intakes_time=Double.parseDouble(water_intake_time)+
											Double.parseDouble(pig.getTotalTimeConsumedWater().getValue());
									Configuration.jedi.hset(pig.getPigId().getValue(),"water_intake_time",
											total_water_intakes_time.toString());
								}else {
									Configuration.jedi.hset(pig.getPigId().getValue(),"water_intake_time",
											pig.getTotalTimeConsumedWater().getValue());
								}*/
								
								if (!Configuration.table.contains(pig.getPigId().getValue(),"water_intake_time")) {
									Configuration.table.put(pig.getPigId().getValue(),"water_intake_time",
											Double.parseDouble(pig.getTotalTimeConsumedWater().getValue()));
								}else {
									Double water_intake_time = Configuration.table.get(farmPigList.get(i).getPigId().getValue(),"water_intake_time");
									Double total_water_intakes_time=water_intake_time + Double.parseDouble(farmPigList.get(i).getTotalTimeConsumedWater().getValue());
									Configuration.table.put(farmPigList.get(i).getPigId().getValue(),"water_intake_time", total_water_intakes_time);
								}
							}
						}
						
						
						//Water Consume Event 
						ObjectEventType water_intakes_Object= new ObjectEventType();
						water_intakes_Object=ConvertUtility.translate_water_intakes(pig);
						this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(water_intakes_Object);
						//System.out.println("Water Intakes event processed");
					}
				}
				
				//System.out.println("Growth event ----");
				//Growth event
				//Configuration.increase_weight ++;
				//weight_test= weight_test + (3.0*Configuration.increase_weight);
				//System.out.println("weight_test: " +weight_test);
				//pig.getWeight().setValue(pig.getWeight().getValue()+weight_test);
				if(!pig.getWeight().getValue().equals("")){
					if (!Configuration.table.contains(pig.getPigId().getValue(),"weight_total")) {
						Configuration.table.put(pig.getPigId().getValue(),"weight_total",
								Double.valueOf(pig.getWeight().getValue()));
						Configuration.table.put(pig.getPigId().getValue(),"day_total",
								Double.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
						Configuration.table.put(pig.getPigId().getValue(),"number_total",1.0);
					}else {
						Double day_total = Double.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

						if (day_total==Configuration.table.get(pig.getPigId().getValue(),"day_total")) {
							
							Double weight_valu=Configuration.table.get(pig.getPigId().getValue(),"weight_total");
							weight_valu+=Double.valueOf(pig.getWeight().getValue());
							Configuration.table.put(pig.getPigId().getValue(),"weight_total",weight_valu);
							
							Double number_valu=Configuration.table.get(pig.getPigId().getValue(),"number_total");
							number_valu+=1;
							Configuration.table.put(pig.getPigId().getValue(),"number_total",number_valu);
							
						}else if(Configuration.table.get(pig.getPigId().getValue(),"number_total")>0){
							Double weight_valu=Configuration.table.get(pig.getPigId().getValue(),"weight_total");
							Double number_valu=Configuration.table.get(pig.getPigId().getValue(),"number_total");
							System.out.println("pig.getPigId().getValue() : - " +pig.getPigId().getValue());
							System.out.println("weight_valu : - " +weight_valu);
							System.out.println("number_valu : - " +number_valu);
							Double weight_avg=weight_valu/number_valu;
							if (!Configuration.table.contains(pig.getPigId().getValue(),"weight_avg")) {
								Configuration.table.put(pig.getPigId().getValue(),"weight_avg", weight_avg);
								
								Configuration.table.put(pig.getPigId().getValue(),"weight_total", 0.0);
								Configuration.table.put(pig.getPigId().getValue(),"number_total", 0.0);
							}else {
								Double weight_avg_prev=Configuration.table.get(pig.getPigId().getValue(),"weight_avg");
								System.out.println("Diff : - " +weight_avg_prev +"-" +weight_avg);
								if(Math.abs(weight_avg_prev-weight_avg)>2) {
									Double growth=weight_avg_prev-weight_avg;
									ObjectEventType growth_Object= new ObjectEventType();
									growth_Object=ConvertUtility.translate_growth(pig, growth);
									this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(growth_Object);
									System.out.println("Growth event processed");
									Configuration.table.put(pig.getPigId().getValue(),"weight_avg", weight_avg);
								}
								Configuration.table.put(pig.getPigId().getValue(),"weight_total", 0.0);
								Configuration.table.put(pig.getPigId().getValue(),"number_total", 0.0);
								Configuration.table.put(pig.getPigId().getValue(),"day_total",
										Double.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)));
							}
						}
						
					}
				}
				
				/*
				String weight = Configuration.jedi.hget(farmPigList.get(i).getPigId().getValue(),"weight");
				//System.out.println("weight: " +weight);
				//System.out.println("Growth event");
				if(weight!=null) {
					Double prvious_weight=Double.parseDouble(weight);
					
					
					//System.out.println("prvious_weight: "+prvious_weight);
					//System.out.println("Current_weight: "+pig.getWeight().getValue());
					if(Math.abs(prvious_weight-pig.getWeight().getValue())>2) {
						//Growth event here
						Double growth=prvious_weight-pig.getWeight().getValue();
						ObjectEventType growth_Object= new ObjectEventType();
						growth_Object=ConvertUtility.translate_growth(pig, growth);
						this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(growth_Object);
						//System.out.println("Growth event processed");
					//	Configuration.jedi.hset(pig.getPigId().getValue(),"weight",pig.getWeight().getValue().toString());
					}
					
				}else {
				//	Configuration.jedi.hset(pig.getPigId().getValue(),"weight",pig.getWeight().getValue().toString());
				}*/
				
			}
			int no_events= eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().size();
			//System.out.println("no_events: "+no_events);
			if(no_events>0) {
				marshaller.make(eventList);
				String epcdoc = marshaller.marshal();
				Configuration.epcis_Ststus =true;
				Configuration.epcis_String = epcdoc;
				//System.out.println(epcdoc);
				//int status=0;
				int status=CaptureUtility.registerEPCIS(epcdoc);
				//System.out.println("Oliot Status: "+status);
				
				try {
					status = CaptureUtility.registerEPCISAuth(epcdoc);
					//System.out.println("EECC Status: " +status);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//result="status..." +status;
				//System.out.println(result);
				
			}
			result = no_events +" events captured";
			return result;
			
		}else if(model=="Farm/Farm") {
			
		}else if(model=="Farm/Building") {
			System.out.println("model==Farm/Building");
			List<Building> farmBuildingList= ConvertUtility.getFarmBuildingList(body);
			
			for(int i=0; i<farmBuildingList.size(); i++) {
				
				/*System.out.println("farmBuildingList.get(i).getId()    :   "+ farmBuildingList.get(i).getId());
				System.out.println("farmBuildingList.get(i).getId()    :   "+ farmBuildingList.get(i).getType());
				System.out.println("farmBuildingList.BuildingId    :   "+ farmBuildingList.get(i).getBuildingId().getValue());
				System.out.println("farmBuildingList.getCompanyId    :   "+ farmBuildingList.get(i).getCompanyId().getValue());
				System.out.println("farmBuildingList.getFarmId    :   "+ farmBuildingList.get(i).getFarmId().getValue());
				System.out.println("farmBuildingList.getCompanyId    :   "+ farmBuildingList.get(i).getCompanyId().getValue());
				System.out.println("farmBuildingList.getCO2    :   "+ farmBuildingList.get(i).getCO2().getValue());
				System.out.println("farmBuildingList.getHumidity    :   "+ farmBuildingList.get(i).getHumidity().getValue());
				System.out.println("farmBuildingList.getLuminosity    :   "+ farmBuildingList.get(i).getLuminosity().getValue());
				System.out.println("farmBuildingList.getTemperature    :   "+ farmBuildingList.get(i).getTemperature().getValue());
				*/
				
				ObjectEventType farmObject= new ObjectEventType();
				farmObject=ConvertUtility.translate(farmBuildingList.get(i));
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(farmObject);
			
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println("Oliot Status: "+status);
			status=0;
			try {
				status = CaptureUtility.registerEPCISAuth(epcdoc);
				System.out.println("EECC Status: ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*int status=0;
			try {
				status = new CaptureUtility().registerEPCIS(epcdoc,"auth");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//System.out.println(epcdoc);
			result="status..." +status;
			System.out.println(result);
			
			return result;
			
			
			
		}else if(model=="Farm/Compartment") {
			
		}else if(model=="Farm/Pen") {
			
		}else if(model=="Farm/SlaughterHouse") {
			
		}else if(model=="Farm/SlaughteredPig") {
			
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
