package com.oliot.mediation.service.ngsild.eventFactory.agrifood;

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
import org.gs1.epcglobal.epcis.EPCISEventExtensionType;
import org.gs1.epcglobal.epcis.EPCListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ReadPointType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.oliot.model.ngsi_ld.Agrifood.Animal;

public class AgrifoodConvertUtility {
	/*
				"id"
	"species",
    "relatedSource",
    "legalId",
    "birthdate",
    "sex",
    "breed",
    "calvedBy",
    "siredBy",
    	"location",
    "weight",
    "ownedBy",
    	"locatedAt",
    "phenologicalCondition",
    "reproductiveCondition",
    "healthCondition",
    "fedWith",
    "welfareCondition"
    */
	
	public static ObjectEventType welfaretTranslate(Animal animal) {
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
		epc1.setValue(animal.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:welfarecheckup");
		
		objectEventType.setDisposition("urn:epcglobal:cbv:disp:welfarechecked");
		
		ReadPointType readPoint = new ReadPointType();
		if(animal.getLocation()!=null) {
			if(animal.getLocation().getValue().getCoordinates()!=null) {
				List<Double> coordinates = animal.getLocation().getValue().getCoordinates();
				//geo:127.049644, 35.835483
				readPoint.setId("geo:"+coordinates.get(0) + ", "+coordinates.get(1));
				objectEventType.setReadPoint(readPoint);
			}
		}else {
			if(animal.getLocatedAt()!=null) {
				readPoint.setId(animal.getLocatedAt().getObject());
				objectEventType.setReadPoint(readPoint);
			}
		}
		
		if(animal.getLocatedAt()!=null) {
			BusinessLocationType businessLocation = new BusinessLocationType();
			//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
			businessLocation.setId(animal.getLocatedAt().getObject());
			objectEventType.setBizLocation(businessLocation);
		}
		
		List<Object> elementList = new ArrayList<Object>();
		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			
			if(animal.getWelfareCondition()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/welfareCondition", "oliot:Fiware");
				id.setTextContent(animal.getWelfareCondition().getValue());
				elementList.add(id);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);
		
		
		
		return objectEventType;
	}
	
	public static ObjectEventType healthTranslate(Animal animal) {
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
		epc1.setValue(animal.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:healthcheckup");
		
		objectEventType.setDisposition("urn:epcglobal:cbv:disp:healthchecked");
		
		ReadPointType readPoint = new ReadPointType();
		if(animal.getLocation()!=null) {
			if(animal.getLocation().getValue().getCoordinates()!=null) {
				List<Double> coordinates = animal.getLocation().getValue().getCoordinates();
				//geo:127.049644, 35.835483
				readPoint.setId("geo:"+coordinates.get(0) + ", "+coordinates.get(1));
				objectEventType.setReadPoint(readPoint);
			}
		}else {
			if(animal.getLocatedAt()!=null) {
				readPoint.setId(animal.getLocatedAt().getObject());
				objectEventType.setReadPoint(readPoint);
			}
		}
		
		if(animal.getLocatedAt()!=null) {
			BusinessLocationType businessLocation = new BusinessLocationType();
			//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
			businessLocation.setId(animal.getLocatedAt().getObject());
			objectEventType.setBizLocation(businessLocation);
		}
		
		List<Object> elementList = new ArrayList<Object>();
		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			
			if(animal.getWelfareCondition()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/healthCondition", "oliot:ngsi_ld");
				id.setTextContent(animal.getHealthCondition().getValue());
				elementList.add(id);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);
		
		
		
		return objectEventType;
	}

}
