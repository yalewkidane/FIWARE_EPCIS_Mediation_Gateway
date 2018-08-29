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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * 
 *       Quantity Event captures an event that takes place with respect to a specified quantity of
 *       object class.
 *       
 * 
 * <p>QuantityEventType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="QuantityEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:epcglobal:epcis:xsd:1}EPCISEventType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="epcClass" type="{urn:epcglobal:epcis:xsd:1}EPCClassType"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="bizStep" type="{urn:epcglobal:epcis:xsd:1}BusinessStepIDType" minOccurs="0"/&gt;
 *         &lt;element name="disposition" type="{urn:epcglobal:epcis:xsd:1}DispositionIDType" minOccurs="0"/&gt;
 *         &lt;element name="readPoint" type="{urn:epcglobal:epcis:xsd:1}ReadPointType" minOccurs="0"/&gt;
 *         &lt;element name="bizLocation" type="{urn:epcglobal:epcis:xsd:1}BusinessLocationType" minOccurs="0"/&gt;
 *         &lt;element name="bizTransactionList" type="{urn:epcglobal:epcis:xsd:1}BusinessTransactionListType" minOccurs="0"/&gt;
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:1}QuantityEventExtensionType" minOccurs="0"/&gt;
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuantityEventType", propOrder = {
    "epcClass",
    "quantity",
    "bizStep",
    "disposition",
    "readPoint",
    "bizLocation",
    "bizTransactionList",
    "extension",
    "anies"
})
public class QuantityEventType
    extends EPCISEventType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String epcClass;
    protected int quantity;
    @XmlSchemaType(name = "anyURI")
    protected String bizStep;
    @XmlSchemaType(name = "anyURI")
    protected String disposition;
    protected ReadPointType readPoint;
    protected BusinessLocationType bizLocation;
    protected BusinessTransactionListType bizTransactionList;
    protected QuantityEventExtensionType extension;
    @XmlAnyElement
    protected List<Element> anies;

    /**
     * epcClass �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpcClass() {
        return epcClass;
    }

    /**
     * epcClass �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpcClass(String value) {
        this.epcClass = value;
    }

    /**
     * quantity �Ӽ��� ���� �����ɴϴ�.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * quantity �Ӽ��� ���� �����մϴ�.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * bizStep �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizStep() {
        return bizStep;
    }

    /**
     * bizStep �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizStep(String value) {
        this.bizStep = value;
    }

    /**
     * disposition �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisposition() {
        return disposition;
    }

    /**
     * disposition �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisposition(String value) {
        this.disposition = value;
    }

    /**
     * readPoint �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link ReadPointType }
     *     
     */
    public ReadPointType getReadPoint() {
        return readPoint;
    }

    /**
     * readPoint �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadPointType }
     *     
     */
    public void setReadPoint(ReadPointType value) {
        this.readPoint = value;
    }

    /**
     * bizLocation �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link BusinessLocationType }
     *     
     */
    public BusinessLocationType getBizLocation() {
        return bizLocation;
    }

    /**
     * bizLocation �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessLocationType }
     *     
     */
    public void setBizLocation(BusinessLocationType value) {
        this.bizLocation = value;
    }

    /**
     * bizTransactionList �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link BusinessTransactionListType }
     *     
     */
    public BusinessTransactionListType getBizTransactionList() {
        return bizTransactionList;
    }

    /**
     * bizTransactionList �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessTransactionListType }
     *     
     */
    public void setBizTransactionList(BusinessTransactionListType value) {
        this.bizTransactionList = value;
    }

    /**
     * extension �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link QuantityEventExtensionType }
     *     
     */
    public QuantityEventExtensionType getExtension() {
        return extension;
    }

    /**
     * extension �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityEventExtensionType }
     *     
     */
    public void setExtension(QuantityEventExtensionType value) {
        this.extension = value;
    }

    /**
     * Gets the value of the anies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> getAnies() {
        if (anies == null) {
            anies = new ArrayList<Element>();
        }
        return this.anies;
    }

}
