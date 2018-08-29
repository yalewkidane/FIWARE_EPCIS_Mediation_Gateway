//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.gs1.epcglobal.epcis;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3._2001.xmlschema.Adapter1;


/**
 * 
 *       base type for all EPCIS events.
 *       
 * 
 * <p>EPCISEventType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="EPCISEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eventTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="recordTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="eventTimeZoneOffset" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="baseExtension" type="{urn:epcglobal:epcis:xsd:1}EPCISEventExtensionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EPCISEventType", propOrder = {
    "eventTime",
    "recordTime",
    "eventTimeZoneOffset",
    "baseExtension"
})
@XmlSeeAlso({
    ObjectEventType.class,
    AggregationEventType.class,
    QuantityEventType.class,
    TransactionEventType.class,
    TransformationEventType.class
})
public abstract class EPCISEventType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar eventTime;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar recordTime;
    @XmlElement(required = true)
    protected String eventTimeZoneOffset;
    protected EPCISEventExtensionType baseExtension;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * eventTime �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getEventTime() {
        return eventTime;
    }

    /**
     * eventTime �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventTime(Calendar value) {
        this.eventTime = value;
    }

    /**
     * recordTime �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getRecordTime() {
        return recordTime;
    }

    /**
     * recordTime �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordTime(Calendar value) {
        this.recordTime = value;
    }

    /**
     * eventTimeZoneOffset �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventTimeZoneOffset() {
        return eventTimeZoneOffset;
    }

    /**
     * eventTimeZoneOffset �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventTimeZoneOffset(String value) {
        this.eventTimeZoneOffset = value;
    }

    /**
     * baseExtension �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EPCISEventExtensionType }
     *     
     */
    public EPCISEventExtensionType getBaseExtension() {
        return baseExtension;
    }

    /**
     * baseExtension �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EPCISEventExtensionType }
     *     
     */
    public void setBaseExtension(EPCISEventExtensionType value) {
        this.baseExtension = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
