package com.oliot.mediation.service.epcis;


import java.util.Calendar;

import org.gs1.epcglobal.epcis.VocabularyType;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.DocumentIdentification;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.Partner;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.PartnerIdentification;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.StandardBusinessDocumentHeader;

public abstract class MasterDataManager {

	protected EPCISVocabularyMarshaller marshaller;
	protected StandardBusinessDocumentHeader sbdh;
	protected VocabularyType voc;

	public MasterDataManager() {

		marshaller = new EPCISVocabularyMarshaller();
		sbdh = new StandardBusinessDocumentHeader();
		voc = new VocabularyType();
	}

	protected void headerModeling() {

		sbdh.setHeaderVersion("1.2");

		Partner sender = new Partner();
		Partner receiver = new Partner();

		PartnerIdentification senderId = new PartnerIdentification();
		senderId.setAuthority("admin");
		senderId.setValue("resl");
		sender.setIdentifier(senderId);

		PartnerIdentification receiverId = new PartnerIdentification();
		receiverId.setAuthority("user");
		receiverId.setValue("user");
		receiver.setIdentifier(receiverId);

		sbdh.getSenders().add(sender);
		sbdh.getReceivers().add(receiver);

		DocumentIdentification docId = new DocumentIdentification();
		docId.setStandard("EPCglobal");
		docId.setTypeVersion("1.2");
		docId.setInstanceIdentifier("instanceIdentifier");
		docId.setType("MasterData");
		docId.setMultipleType(true);
		docId.setCreationDateAndTime(Calendar.getInstance());

		sbdh.setDocumentIdentification(docId);
	}

}
