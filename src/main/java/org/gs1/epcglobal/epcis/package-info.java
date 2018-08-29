//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//

@javax.xml.bind.annotation.XmlSchema(xmlns = {
		@javax.xml.bind.annotation.XmlNs(namespaceURI = "urn:epcglobal:epcis:xsd:1", prefix = "epcis"),
		@javax.xml.bind.annotation.XmlNs(namespaceURI = "http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader", prefix = "p"),
		@javax.xml.bind.annotation.XmlNs(namespaceURI = "http://ns.example.com/epcisapp/bus", prefix = "bus"),
		@javax.xml.bind.annotation.XmlNs(namespaceURI = "http://ns.example.com/epcisapp/driver", prefix = "driver")
})
package org.gs1.epcglobal.epcis;
