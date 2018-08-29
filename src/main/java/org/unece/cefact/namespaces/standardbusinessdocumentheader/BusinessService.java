//
// 이 파일은 JAXB(JavaTM Architecture for XML Binding) 참조 구현 2.2.11 버전을 통해 생성되었습니다. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>를 참조하십시오. 
// 이 파일을 수정하면 소스 스키마를 재컴파일할 때 수정 사항이 손실됩니다. 
// 생성 날짜: 2016.10.14 시간 10:10:29 PM KST 
//


package org.unece.cefact.namespaces.standardbusinessdocumentheader;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BusinessService complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="BusinessService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BusinessServiceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ServiceTransaction" type="{http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader}ServiceTransaction" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessService", propOrder = {
    "businessServiceName",
    "serviceTransaction"
})
public class BusinessService implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "BusinessServiceName")
    protected String businessServiceName;
    @XmlElement(name = "ServiceTransaction")
    protected ServiceTransaction serviceTransaction;

    /**
     * businessServiceName 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessServiceName() {
        return businessServiceName;
    }

    /**
     * businessServiceName 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessServiceName(String value) {
        this.businessServiceName = value;
    }

    /**
     * serviceTransaction 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTransaction }
     *     
     */
    public ServiceTransaction getServiceTransaction() {
        return serviceTransaction;
    }

    /**
     * serviceTransaction 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTransaction }
     *     
     */
    public void setServiceTransaction(ServiceTransaction value) {
        this.serviceTransaction = value;
    }

}
