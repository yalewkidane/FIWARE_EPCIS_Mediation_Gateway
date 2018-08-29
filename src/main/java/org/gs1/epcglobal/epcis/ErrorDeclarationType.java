//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.gs1.epcglobal.epcis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.w3._2001.xmlschema.Adapter1;
import org.w3c.dom.Element;


/**
 * <p>ErrorDeclarationType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="ErrorDeclarationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="declarationTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="reason" type="{urn:epcglobal:epcis:xsd:1}ErrorReasonIDType" minOccurs="0"/&gt;
 *         &lt;element name="correctiveEventIDs" type="{urn:epcglobal:epcis:xsd:1}CorrectiveEventIDsType" minOccurs="0"/&gt;
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:1}ErrorDeclarationExtensionType" minOccurs="0"/&gt;
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ErrorDeclarationType", propOrder = {
    "declarationTime",
    "reason",
    "correctiveEventIDs",
    "extension",
    "anies"
})
public class ErrorDeclarationType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar declarationTime;
    @XmlSchemaType(name = "anyURI")
    protected String reason;
    protected CorrectiveEventIDsType correctiveEventIDs;
    protected ErrorDeclarationExtensionType extension;
    @XmlAnyElement
    protected List<Element> anies;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * declarationTime �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getDeclarationTime() {
        return declarationTime;
    }

    /**
     * declarationTime �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclarationTime(Calendar value) {
        this.declarationTime = value;
    }

    /**
     * reason �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * reason �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * correctiveEventIDs �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link CorrectiveEventIDsType }
     *     
     */
    public CorrectiveEventIDsType getCorrectiveEventIDs() {
        return correctiveEventIDs;
    }

    /**
     * correctiveEventIDs �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectiveEventIDsType }
     *     
     */
    public void setCorrectiveEventIDs(CorrectiveEventIDsType value) {
        this.correctiveEventIDs = value;
    }

    /**
     * extension �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link ErrorDeclarationExtensionType }
     *     
     */
    public ErrorDeclarationExtensionType getExtension() {
        return extension;
    }

    /**
     * extension �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorDeclarationExtensionType }
     *     
     */
    public void setExtension(ErrorDeclarationExtensionType value) {
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
