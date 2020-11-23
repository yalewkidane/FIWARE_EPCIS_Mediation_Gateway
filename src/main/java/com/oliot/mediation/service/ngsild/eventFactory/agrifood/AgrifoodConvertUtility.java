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
import org.gs1.epcglobal.epcis.AttributeType;
import org.gs1.epcglobal.epcis.BusinessLocationType;
import org.gs1.epcglobal.epcis.EPCISEventExtensionType;
import org.gs1.epcglobal.epcis.EPCListType;
import org.gs1.epcglobal.epcis.ObjectEventType;
import org.gs1.epcglobal.epcis.ReadPointType;
import org.gs1.epcglobal.epcis.TransactionEventType;
import org.gs1.epcglobal.epcis.VocabularyElementListType;
import org.gs1.epcglobal.epcis.VocabularyElementType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.oliot.model.ngsi_ld.Agrifood.Animal;

public class AgrifoodConvertUtility {
	
	
	public static ObjectEventType intiateObjectEvent() {
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
		return objectEventType;
	}
	
	public static TransactionEventType intiateTransactionEvent() {
		TransactionEventType transactionEventType=new TransactionEventType();
		//GregorianCalendar gRecordTime = new GregorianCalendar();
		//gRecordTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gRecordTime);
		transactionEventType.setEventTime(Calendar.getInstance());
		transactionEventType.setRecordTime(Calendar.getInstance());
		int offsetInt=(Calendar.getInstance().getTimeZone().getRawOffset()/(60*60*1000));
		//(offsetInt<10 && offsetInt>-10 ? "0":"")+ offsetInt;
		String offset="00";
		if(offsetInt<10 && offsetInt>=0) {
			offset="+0"+offsetInt;
		}else if(offsetInt>-10 && offsetInt<0) {
			offset="-0"+(-offsetInt);
		}
		//System.out.println("offset : "+offset);
		transactionEventType.setEventTimeZoneOffset(offset+":00");
		
		//System.out.println(objectEventType.getEventTimeZoneOffset());

		//objectEventType.setEventTimeZoneOffset("-06:00");

		EPCISEventExtensionType epcisEventExtension = new EPCISEventExtensionType();
		epcisEventExtension.setEventID(UUID.randomUUID().toString());
		transactionEventType.setBaseExtension(epcisEventExtension);
		return transactionEventType;
	}
	public static ObjectEventType welfaretTranslate(Animal animal) {
		
		
		ObjectEventType objectEventType=intiateObjectEvent();
		
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
		
		ObjectEventType objectEventType=intiateObjectEvent();
		
		
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
	
	public static ObjectEventType breadingTranslate(Animal animal) {
		
		ObjectEventType objectEventType=intiateObjectEvent();
		
		
		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(animal.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:breading");
		
		if(animal.getReproductiveCondition()!=null) {
			objectEventType.setDisposition("urn:epcglobal:cbv:disp:"+animal.getReproductiveCondition().getValue());
		}
		
		
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
			
			if(animal.getReproductiveCondition()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/reproductiveCondition", "oliot:ngsi_ld");
				id.setTextContent(animal.getReproductiveCondition().getValue());
				elementList.add(id);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);
		
		
		
		return objectEventType;
	}
	public static ObjectEventType phenologyTranslate(Animal animal) {
		
		ObjectEventType objectEventType=intiateObjectEvent();
		
		
		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(animal.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:phenology");
		
		if(animal.getReproductiveCondition()!=null) {
			objectEventType.setDisposition("urn:epcglobal:cbv:disp:"+animal.getPhenologicalCondition().getValue());
		}
		
		
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
			
			if(animal.getReproductiveCondition()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/phenologicalCondition", "oliot:ngsi_ld");
				id.setTextContent(animal.getPhenologicalCondition().getValue());
				elementList.add(id);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);
		
		
		
		return objectEventType;
	}
	
	public static ObjectEventType transportationTranslate(Animal animal) {
		
		ObjectEventType objectEventType=intiateObjectEvent();
		
		
		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(animal.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:transporting");
		
		if(animal.getReproductiveCondition()!=null) {
			objectEventType.setDisposition("urn:epcglobal:cbv:disp:transported");
		}
		
		
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
			
			if(animal.getLocatedAt()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/locatedAt", "oliot:ngsi_ld");
				id.setTextContent(animal.getLocatedAt().getObject());
				elementList.add(id);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);
		
		
		
		return objectEventType;
	}
	
	public static TransactionEventType transactionTranslate(Animal animal) {
		
		TransactionEventType transactionEventType=intiateTransactionEvent();
		
		
		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(animal.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		transactionEventType.setEpcList(objectEventEPCs);
		
		transactionEventType.setAction(ActionType.fromValue("ADD"));
		
		transactionEventType.setBizStep("urn:epcglobal:cbv:bizstep:sell");
		
		if(animal.getReproductiveCondition()!=null) {
			transactionEventType.setDisposition("urn:epcglobal:cbv:disp:solled");
		}
		
		
		ReadPointType readPoint = new ReadPointType();
		if(animal.getLocation()!=null) {
			if(animal.getLocation().getValue().getCoordinates()!=null) {
				List<Double> coordinates = animal.getLocation().getValue().getCoordinates();
				//geo:127.049644, 35.835483
				readPoint.setId("geo:"+coordinates.get(0) + ", "+coordinates.get(1));
				transactionEventType.setReadPoint(readPoint);
			}
		}else {
			if(animal.getLocatedAt()!=null) {
				readPoint.setId(animal.getLocatedAt().getObject());
				transactionEventType.setReadPoint(readPoint);
			}
		}
		
		if(animal.getLocatedAt()!=null) {
			BusinessLocationType businessLocation = new BusinessLocationType();
			//urn:epc:id:sgln:CompanyPrefix.ItemReference.SerialNumber
			businessLocation.setId(animal.getLocatedAt().getObject());
			transactionEventType.setBizLocation(businessLocation);
		}
		
		List<Element> elementList = new ArrayList<Element>();
		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.newDocument();
			
			if(animal.getOwnedBy()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/OwnedBy", "oliot:ngsi_ld");
				id.setTextContent(animal.getOwnedBy().getObject());
				elementList.add(id);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		transactionEventType.setAnies(elementList);
		
		
		
		
		return transactionEventType;
	}
	
	public static VocabularyType animalMasterDataTranslate(List<Animal> animals) {
		VocabularyType vocabulary = new  VocabularyType();
		vocabulary.setType("urn:ngsi-ld:Animal");
		VocabularyElementListType vocElementList = new VocabularyElementListType();
		for(Animal animal : animals) {
			VocabularyElementType vocElement = new VocabularyElementType();
			if(animal.getId()!=null) {
				vocElement.setId(animal.getId());
			}
			
			if(animal.getSpecies()!=null) {
				AttributeType id = new AttributeType();
				id.setId("urn:ngsi-ld:Animal:species");
				id.getContent().add(animal.getSpecies().getValue());
				vocElement.getAttributes().add(id);
			}
		    
		    if(animal.getRelatedSource()!=null) {
				AttributeType id = new AttributeType();
				id.setId("urn:ngsi-ld:Animal:relatedSource");
				id.getContent().add(animal.getRelatedSource().getValue().getApplication());
				id.getContent().add(animal.getRelatedSource().getValue().getApplicationEntityId());
				vocElement.getAttributes().add(id);
			}
		    
		    if(animal.getLegalId()!=null) {
				AttributeType id = new AttributeType();
				id.setId("urn:ngsi-ld:Animal:legalId");
				id.getContent().add(animal.getLegalId().getValue());
				vocElement.getAttributes().add(id);
			}
		    
		    if(animal.getBirthdate().getValue().getValue()!=null) {
				AttributeType id = new AttributeType();
				id.setId("urn:ngsi-ld:Animal:birthdate");
				id.getContent().add(animal.getBirthdate().getValue().getValue().toString());
				vocElement.getAttributes().add(id);
			}
		    
		    if(animal.getSex()!=null) {
				AttributeType id = new AttributeType();
				id.setId("urn:ngsi-ld:Animal:sex");
				id.getContent().add(animal.getSex().getValue());
				vocElement.getAttributes().add(id);
			}
		    
		    if(animal.getBreed()!=null) {
				AttributeType id = new AttributeType();
				id.setId("urn:ngsi-ld:Animal:breed");
				id.getContent().add(animal.getBreed().getValue());
				vocElement.getAttributes().add(id);
			}
		    
		    if(animal.getCalvedBy()!=null) {
				AttributeType id = new AttributeType();
				id.setId("urn:ngsi-ld:Animal:calvedBy");
				id.getContent().add(animal.getCalvedBy().getObject());
				vocElement.getAttributes().add(id);
			}
		    
		    if(animal.getSiredBy()!=null) {
				AttributeType id = new AttributeType();
				id.setId("urn:ngsi-ld:Animal:siredBy");
				id.getContent().add(animal.getSiredBy().getObject());
				vocElement.getAttributes().add(id);
			}
		    
		    vocElementList.getVocabularyElements().add(vocElement);
		}
		vocabulary.setVocabularyElementList(vocElementList);
		return vocabulary;
		
	}
	
    public static ObjectEventType calveTranslate(Animal animal) {
		
		ObjectEventType objectEventType=intiateObjectEvent();
		
		
		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(animal.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:calve");
		
		if(animal.getReproductiveCondition()!=null) {
			objectEventType.setDisposition("urn:epcglobal:cbv:disp:calved");
		}
		
		
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
			
			if(animal.getLocatedAt()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/calvedBy", "oliot:ngsi_ld");
				id.setTextContent(animal.getCalvedBy().getObject());
				elementList.add(id);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);
		
		
		
		return objectEventType;
	}
    
    public static ObjectEventType growthEventTranslate(Animal animal, double growth) {
		
		ObjectEventType objectEventType=intiateObjectEvent();
		
		
		EPCListType objectEventEPCs = new EPCListType();
		EPC epc1 = new EPC();
		//urn:epc:id:sgtin:CompanyPrefix.ItemReference.SerialNumber 
		epc1.setValue(animal.getId());	
		objectEventEPCs.getEpcs().add(epc1);//.getEpc().add(epc1);
		objectEventType.setEpcList(objectEventEPCs);
		
		objectEventType.setAction(ActionType.fromValue("OBSERVE"));
		
		objectEventType.setBizStep("urn:epcglobal:cbv:bizstep:growth");
		
		if(animal.getReproductiveCondition()!=null) {
			objectEventType.setDisposition("urn:epcglobal:cbv:disp:growing");
		}
		
		
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
			
			if(animal.getLocatedAt()!=null) {
				Element id = doc.createElementNS("http://ns.oliot.com/weight", "oliot:ngsi_ld");
				id.setTextContent(String.valueOf(animal.getWeight().getValue()));
				elementList.add(id);
				
				Element growth_el = doc.createElementNS("http://ns.oliot.com/growth", "oliot:ngsi_ld");
				growth_el.setTextContent(String.valueOf(growth));
				elementList.add(growth_el);
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		objectEventType.setAnies(elementList);
		
		
		
		return objectEventType;
	}

}
