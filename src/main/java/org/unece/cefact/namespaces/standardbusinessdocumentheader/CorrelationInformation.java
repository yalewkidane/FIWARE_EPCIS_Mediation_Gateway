//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2016.10.14 시간 10:10:29 PM KST 
//


package org.unece.cefact.namespaces.standardbusinessdocumentheader;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.w3._2001.xmlschema.Adapter1;


/**
 * <p>CorrelationInformation complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="CorrelationInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RequestingDocumentCreationDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="RequestingDocumentInstanceIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExpectedResponseDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrelationInformation", propOrder = {
    "requestingDocumentCreationDateTime",
    "requestingDocumentInstanceIdentifier",
    "expectedResponseDateTime"
})
public class CorrelationInformation implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "RequestingDocumentCreationDateTime", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar requestingDocumentCreationDateTime;
    @XmlElement(name = "RequestingDocumentInstanceIdentifier")
    protected String requestingDocumentInstanceIdentifier;
    @XmlElement(name = "ExpectedResponseDateTime", type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar expectedResponseDateTime;

    /**
     * requestingDocumentCreationDateTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getRequestingDocumentCreationDateTime() {
        return requestingDocumentCreationDateTime;
    }

    /**
     * requestingDocumentCreationDateTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestingDocumentCreationDateTime(Calendar value) {
        this.requestingDocumentCreationDateTime = value;
    }

    /**
     * requestingDocumentInstanceIdentifier 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestingDocumentInstanceIdentifier() {
        return requestingDocumentInstanceIdentifier;
    }

    /**
     * requestingDocumentInstanceIdentifier 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestingDocumentInstanceIdentifier(String value) {
        this.requestingDocumentInstanceIdentifier = value;
    }

    /**
     * expectedResponseDateTime 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getExpectedResponseDateTime() {
        return expectedResponseDateTime;
    }

    /**
     * expectedResponseDateTime 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedResponseDateTime(Calendar value) {
        this.expectedResponseDateTime = value;
    }

}
