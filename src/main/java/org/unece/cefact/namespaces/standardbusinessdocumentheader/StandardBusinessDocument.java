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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>StandardBusinessDocument complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="StandardBusinessDocument"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.unece.org/cefact/namespaces/StandardBusinessDocumentHeader}StandardBusinessDocumentHeader" minOccurs="0"/&gt;
 *         &lt;any processContents='lax' namespace='##other'/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardBusinessDocument", propOrder = {
    "standardBusinessDocumentHeader",
    "any"
})
@XmlRootElement(name = "StandardBusinessDocument")
public class StandardBusinessDocument
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "StandardBusinessDocumentHeader")
    protected StandardBusinessDocumentHeader standardBusinessDocumentHeader;
    @XmlAnyElement
    protected Element any;

    /**
     * standardBusinessDocumentHeader 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link StandardBusinessDocumentHeader }
     *     
     */
    public StandardBusinessDocumentHeader getStandardBusinessDocumentHeader() {
        return standardBusinessDocumentHeader;
    }

    /**
     * standardBusinessDocumentHeader 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link StandardBusinessDocumentHeader }
     *     
     */
    public void setStandardBusinessDocumentHeader(StandardBusinessDocumentHeader value) {
        this.standardBusinessDocumentHeader = value;
    }

    /**
     * any 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public Element getAny() {
        return any;
    }

    /**
     * any 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void setAny(Element value) {
        this.any = value;
    }

}
