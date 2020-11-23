package com.oliot.mediation.service.epcis;


import java.math.BigDecimal;
import java.util.Calendar;

import org.gs1.epcglobal.epcis.EPCISHeaderExtensionType;
import org.gs1.epcglobal.epcis.EPCISHeaderType;
import org.gs1.epcglobal.epcis.EPCISMasterDataType;
import org.gs1.epcglobal.epcis.EventListType;
import org.gs1.epcglobal.epcis.VocabularyListType;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.StandardBusinessDocumentHeader;

public class EPCISVocabularyMarshaller extends EPCISMarshaller {

	private EPCISHeaderType epcisHeader;
	private EPCISHeaderExtensionType headerExtension;
	private EPCISMasterDataType masterdata;
	private VocabularyListType vocList;
	private EventListType eventList;

	public EPCISVocabularyMarshaller() {
		
		epcisHeader = of.createEPCISHeaderType();
		headerExtension = of.createEPCISHeaderExtensionType();
		masterdata = of.createEPCISMasterDataType();
		vocList = of.createVocabularyListType();
		eventList = of.createEventListType();
		
		masterdata.setVocabularyList(vocList);
		headerExtension.setEPCISMasterData(masterdata);
		epcisHeader.setExtension(headerExtension);
		epcisDoc.setEPCISHeader(epcisHeader);
		
		epcisBody.setEventList(eventList);
		epcisDoc.setEPCISBody(epcisBody);
		
		epcisDoc.setCreationDate(Calendar.getInstance());
		epcisDoc.setSchemaVersion(new BigDecimal("1.2"));
	}

	public void make(StandardBusinessDocumentHeader sbdh, VocabularyType voc) {
		
		epcisHeader.setStandardBusinessDocumentHeader(sbdh);
		vocList.getVocabularies().add(voc);
	}

	
	
}
