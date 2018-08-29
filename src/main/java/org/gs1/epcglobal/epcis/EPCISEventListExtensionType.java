//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.gs1.epcglobal.epcis;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>EPCISEventListExtensionType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="EPCISEventListExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="TransformationEvent" type="{urn:epcglobal:epcis:xsd:1}TransformationEventType"/&gt;
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:1}EPCISEventListExtension2Type"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EPCISEventListExtensionType", propOrder = {
    "extension",
    "transformationEvent"
})
public class EPCISEventListExtensionType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    protected EPCISEventListExtension2Type extension;
    @XmlElement(name = "TransformationEvent")
    protected TransformationEventType transformationEvent;

    /**
     * extension �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EPCISEventListExtension2Type }
     *     
     */
    public EPCISEventListExtension2Type getExtension() {
        return extension;
    }

    /**
     * extension �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EPCISEventListExtension2Type }
     *     
     */
    public void setExtension(EPCISEventListExtension2Type value) {
        this.extension = value;
    }

    /**
     * transformationEvent �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link TransformationEventType }
     *     
     */
    public TransformationEventType getTransformationEvent() {
        return transformationEvent;
    }

    /**
     * transformationEvent �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link TransformationEventType }
     *     
     */
    public void setTransformationEvent(TransformationEventType value) {
        this.transformationEvent = value;
    }

}
