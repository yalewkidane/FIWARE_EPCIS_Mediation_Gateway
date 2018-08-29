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
 * <p>EPCISMasterDataType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="EPCISMasterDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VocabularyList" type="{urn:epcglobal:epcis:xsd:1}VocabularyListType"/&gt;
 *         &lt;element name="extension" type="{urn:epcglobal:epcis:xsd:1}EPCISMasterDataExtensionType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EPCISMasterDataType", propOrder = {
    "vocabularyList",
    "extension"
})
public class EPCISMasterDataType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "VocabularyList", required = true)
    protected VocabularyListType vocabularyList;
    protected EPCISMasterDataExtensionType extension;

    /**
     * vocabularyList �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link VocabularyListType }
     *     
     */
    public VocabularyListType getVocabularyList() {
        return vocabularyList;
    }

    /**
     * vocabularyList �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link VocabularyListType }
     *     
     */
    public void setVocabularyList(VocabularyListType value) {
        this.vocabularyList = value;
    }

    /**
     * extension �Ӽ��� ���� �����ɴϴ�.
     * 
     * @return
     *     possible object is
     *     {@link EPCISMasterDataExtensionType }
     *     
     */
    public EPCISMasterDataExtensionType getExtension() {
        return extension;
    }

    /**
     * extension �Ӽ��� ���� �����մϴ�.
     * 
     * @param value
     *     allowed object is
     *     {@link EPCISMasterDataExtensionType }
     *     
     */
    public void setExtension(EPCISMasterDataExtensionType value) {
        this.extension = value;
    }

}
