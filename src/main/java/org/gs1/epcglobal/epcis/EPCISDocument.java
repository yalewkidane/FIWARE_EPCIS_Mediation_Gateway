//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.gs1.epcglobal.epcis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.gs1.epcglobal.Document;
import org.w3c.dom.Element;


/**
 * 
 *       document that contains a Header and a Body.
 *               
 * 
 * <p>EPCISDocumentType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="EPCISDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:epcglobal:xsd:1}Document"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EPCISHeader" type="{urn:epcglobal:epcis:xsd:1}EPCISHeaderType" minOccurs="0"/&gt;
 *         &lt;element name="EPCISBody" type="{urn:epcglobal:epcis:xsd:1}EPCISBodyType"/&gt;
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:1}EPCISDocumentExtensionType" minOccurs="0"/&gt;
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
@XmlType(name = "EPCISDocumentType", propOrder = {
    "epcisHeader",
    "epcisBody",
    "extension",
    "anies"
})
@XmlRootElement(name = "EPCISDocument")
public class EPCISDocument
    extends Document
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "EPCISHeader")
    protected EPCISHeaderType epcisHeader;
    @XmlElement(name = "EPCISBody", required = true)
    protected EPCISBodyType epcisBody;
    protected EPCISDocumentExtensionType extension;
    @XmlAnyElement
    protected List<Element> anies;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * epcisHeader �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EPCISHeaderType }
     *     
     */
    public EPCISHeaderType getEPCISHeader() {
        return epcisHeader;
    }

    /**
     * epcisHeader �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EPCISHeaderType }
     *     
     */
    public void setEPCISHeader(EPCISHeaderType value) {
        this.epcisHeader = value;
    }

    /**
     * epcisBody �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EPCISBodyType }
     *     
     */
    public EPCISBodyType getEPCISBody() {
        return epcisBody;
    }

    /**
     * epcisBody �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EPCISBodyType }
     *     
     */
    public void setEPCISBody(EPCISBodyType value) {
        this.epcisBody = value;
    }

    /**
     * extension �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EPCISDocumentExtensionType }
     *     
     */
    public EPCISDocumentExtensionType getExtension() {
        return extension;
    }

    /**
     * extension �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EPCISDocumentExtensionType }
     *     
     */
    public void setExtension(EPCISDocumentExtensionType value) {
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
