//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.gs1.epcglobal.epcis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>EventListType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="EventListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element name="ObjectEvent" type="{urn:epcglobal:epcis:xsd:1}ObjectEventType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="AggregationEvent" type="{urn:epcglobal:epcis:xsd:1}AggregationEventType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="QuantityEvent" type="{urn:epcglobal:epcis:xsd:1}QuantityEventType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TransactionEvent" type="{urn:epcglobal:epcis:xsd:1}TransactionEventType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:1}EPCISEventListExtensionType"/&gt;
 *         &lt;any processContents='lax' namespace='##other'/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventListType", propOrder = {
    "objectEventsAndAggregationEventsAndQuantityEvents"
})
public class EventListType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElementRefs({
        @XmlElementRef(name = "QuantityEvent", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ObjectEvent", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "extension", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AggregationEvent", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "TransactionEvent", type = JAXBElement.class, required = false)
    })
    @XmlAnyElement
    protected List<Object> objectEventsAndAggregationEventsAndQuantityEvents;

    /**
     * Gets the value of the objectEventsAndAggregationEventsAndQuantityEvents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectEventsAndAggregationEventsAndQuantityEvents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectEventsAndAggregationEventsAndQuantityEvents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link EPCISEventListExtensionType }{@code >}
     * {@link JAXBElement }{@code <}{@link QuantityEventType }{@code >}
     * {@link JAXBElement }{@code <}{@link AggregationEventType }{@code >}
     * {@link JAXBElement }{@code <}{@link TransactionEventType }{@code >}
     * {@link JAXBElement }{@code <}{@link ObjectEventType }{@code >}
     * {@link Element }
     * 
     * 
     */
    public List<Object> getObjectEventsAndAggregationEventsAndQuantityEvents() {
        if (objectEventsAndAggregationEventsAndQuantityEvents == null) {
            objectEventsAndAggregationEventsAndQuantityEvents = new ArrayList<Object>();
        }
        return this.objectEventsAndAggregationEventsAndQuantityEvents;
    }

}
