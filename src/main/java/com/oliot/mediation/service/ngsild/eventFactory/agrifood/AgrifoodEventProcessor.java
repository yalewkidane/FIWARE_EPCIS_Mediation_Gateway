package com.oliot.mediation.service.ngsild.eventFactory.agrifood;

import java.util.List;

import org.gs1.epcglobal.epcis.ObjectEventType;

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

}
