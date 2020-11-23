package com.oliot.mediation.service.ngsild.eventFactory.agrifood;

import java.util.List;

import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.TransactionEventType;

import com.oliot.mediation.configuration.Configuration;
import com.oliot.mediation.service.epcis.CaptureUtility;
import com.oliot.mediation.service.epcis.EventDataManager;
import com.oliot.model.ngsi_ld.Agrifood.Animal;

public class AgrifoodEventProcessor extends EventDataManager{
	
	public String welfareCheckup(List<Animal> animals) {
		String result="Staus";
		
		if(animals!=null) {
			ObjectEventType animalObject= new ObjectEventType();
			for(Animal animal : animals) {
				animalObject = AgrifoodConvertUtility.welfaretTranslate(animal);
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(animalObject);
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
		}
		
		
		
		return result;
	}
	
	public String healthCheckup(List<Animal> animals) {
		String result="Staus";
		
		if(animals!=null) {
			ObjectEventType animalObject= new ObjectEventType();
			for(Animal animal : animals) {
				animalObject = AgrifoodConvertUtility.healthTranslate(animal);
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(animalObject);
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
		}
		
		
		
		return result;
	}
	
	public String breading(List<Animal> animals) {
		String result="Staus";
		
		if(animals!=null) {
			ObjectEventType animalObject= new ObjectEventType();
			for(Animal animal : animals) {
				animalObject = AgrifoodConvertUtility.breadingTranslate(animal);
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(animalObject);
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
		}
		
		
		
		return result;
	}
	public String phenology(List<Animal> animals) {
		String result="Staus";
		
		if(animals!=null) {
			ObjectEventType animalObject= new ObjectEventType();
			for(Animal animal : animals) {
				animalObject = AgrifoodConvertUtility.phenologyTranslate(animal);
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(animalObject);
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
		}
		
		
		
		return result;
	}
	public String transportation(List<Animal> animals) {
		String result="Staus";
		
		if(animals!=null) {
			ObjectEventType animalObject= new ObjectEventType();
			for(Animal animal : animals) {
				animalObject = AgrifoodConvertUtility.transportationTranslate(animal);
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(animalObject);
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
		}
		
		
		
		return result;
	}
	public String transaction(List<Animal> animals) {
		String result="Staus";
		
		if(animals!=null) {
			TransactionEventType animalObject= new TransactionEventType();
			for(Animal animal : animals) {
				animalObject = AgrifoodConvertUtility.transactionTranslate(animal);
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(animalObject);
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
		}
		
		
		
		return result;
	}
	public String calve(List<Animal> animals) {
		String result="Staus";
		
		if(animals!=null) {
			ObjectEventType animalObject= new ObjectEventType();
			for(Animal animal : animals) {
				animalObject = AgrifoodConvertUtility.calveTranslate(animal);
				this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(animalObject);
			}
			
			marshaller.make(eventList);
			String epcdoc = marshaller.marshal();
			int status=CaptureUtility.registerEPCIS(epcdoc);
			System.out.println(epcdoc);
			result="status..." +status;
		}
		
		
		
		return result;
	}
	public String growthEvent(List<Animal> animals) {
		String result="Staus";
		
		if(animals!=null) {
			ObjectEventType animalObject= new ObjectEventType();
			for(Animal animal : animals) {
				if(animal.getWeight()!=null) {
					if (!Configuration.table.contains(animal.getId(),"weight_total")) {
						System.out.println("first time : - " );
						Configuration.table.put(animal.getId(),"weight_total",
								animal.getWeight().getValue());
					}else {
						double weight_total=Configuration.table.get(animal.getId(),"weight_total");
						System.out.println("weight_total : - " + weight_total);
						double growth = animal.getWeight().getValue()-weight_total;
						if(Math.abs(growth)>2) {
							animalObject = AgrifoodConvertUtility.growthEventTranslate(animal, growth);
							this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().add(animalObject);
						}else {
							
						}
					}
				}
			}
			
			marshaller.make(eventList);
			if(!this.eventList.getObjectEventsAndAggregationEventsAndQuantityEvents().isEmpty()) {
				String epcdoc = marshaller.marshal();
				int status=CaptureUtility.registerEPCIS(epcdoc);
				System.out.println(epcdoc);
				result="status..." +status;
			}
			
		}
		
		
		
		return result;
	}

}
