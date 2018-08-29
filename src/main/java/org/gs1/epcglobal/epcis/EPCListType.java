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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.gs1.epcglobal.EPC;


/**
 * <p>EPCListType complex type�� ���� Java Ŭ�����Դϴ�.
 * 
 * <p>���� ��Ű�� ������ �� Ŭ������ ���ԵǴ� �ʿ��� �������� �����մϴ�.
 * 
 * <pre>
 * &lt;complexType name="EPCListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="epc" type="{urn:epcglobal:xsd:1}EPC" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EPCListType", propOrder = {
    "epcs"
})
public class EPCListType
    implements Serializable
{

    private final static long serialVersionUID = -1L;
    @XmlElement(name = "epc")
    protected List<EPC> epcs;

    /**
     * Gets the value of the epcs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the epcs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpcs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EPC }
     * 
     * 
     */
    public List<EPC> getEpcs() {
        if (epcs == null) {
            epcs = new ArrayList<EPC>();
        }
        return this.epcs;
    }

	public void setEpcs(List<EPC> epcs) {
		this.epcs = epcs;
	}

}
