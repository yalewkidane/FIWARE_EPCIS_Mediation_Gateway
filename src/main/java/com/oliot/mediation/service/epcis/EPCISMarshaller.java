package com.oliot.mediation.service.epcis;


import java.io.File;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.gs1.epcglobal.epcis.EPCISBodyType;
import org.gs1.epcglobal.epcis.EPCISDocument;
import org.gs1.epcglobal.epcis.ObjectFactory;
import org.xml.sax.SAXException;

public class EPCISMarshaller {
	protected ObjectFactory of;
	protected EPCISDocument epcisDoc;
	protected EPCISBodyType epcisBody;
	protected SchemaFactory sf;
	protected Schema schema;
	protected JAXBContext jc;
	protected Marshaller m;

	public EPCISMarshaller() {

		of = new ObjectFactory();
		epcisDoc = of.createEPCISDocument();
		epcisBody = of.createEPCISBodyType();
		sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		try {
			String path =EPCISMarshaller.class.getClassLoader().getResource("").getPath();
			path = path+ "/org/gs1/epcglobal/epcis/schema/EPCglobal-epcis-1_2.xsd";
			///root/Downloads/Project/FIWARE/Fiware_Oliot_Mediation/git/FIWARE_EPCIS_Mediation_Gateway/src/main/java/com/oliot/epcis/schema/EPCglobal-epcis-1_2.xsd";
			//path = path.substring(0, path.indexOf("/target/classes"));
			//path = path+ "/src/main/java/com/oliot/epcis/schema/EPCglobal-epcis-1_2.xsd";
			//System.out.println(path);
			schema = sf.newSchema(new File(path));
		} catch (SAXException e2) {
			//e2.printStackTrace();
		}
		
		try {
			jc = JAXBContext.newInstance(EPCISDocument.class);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		
		try {
			m = jc.createMarshaller();
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}
		
		try {
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch (PropertyException e1) {
			e1.printStackTrace();
		}
		
		//m.setSchema(schema);
	}

	public String marshal() {

		JAXBElement<EPCISDocument> e = of.createEPCISDocument(epcisDoc);

		Writer writer = new StringWriter();
		try {
			m.marshal(e, writer);
		} catch (JAXBException e1) {
			e1.printStackTrace();
		}

		String s = writer.toString();

		return s;
	}
}
