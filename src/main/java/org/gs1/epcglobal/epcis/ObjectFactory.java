//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.11 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2016.10.14 �ð� 10:10:29 PM KST 
//


package org.gs1.epcglobal.epcis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the epcglobal.epcis.xsd._1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _EPCISDocument_QNAME = new QName("urn:epcglobal:epcis:xsd:1", "EPCISDocument");
	private final static QName _EPCISBody_QNAME = new QName("", "EPCISBody");
	private final static QName _EventList_QNAME = new QName("", "EventList");
    private final static QName _EventListTypeObjectEvent_QNAME = new QName("", "ObjectEvent");
    private final static QName _EventListTypeAggregationEvent_QNAME = new QName("", "AggregationEvent");
    private final static QName _EventListTypeQuantityEvent_QNAME = new QName("", "QuantityEvent");
    private final static QName _EventListTypeTransactionEvent_QNAME = new QName("", "TransactionEvent");
    private final static QName _EventListTypeExtension_QNAME = new QName("", "extension");
    private final static QName _VocabularyList_QNAME = new QName("", "VocabularyList");
    private final static QName _Vocabulary_QNAME = new QName("", "Vocabulary");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: epcglobal.epcis.xsd._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EPCISDocument }
     * 
     */
    public EPCISDocument createEPCISDocument() {
        return new EPCISDocument();
    }

    /**
     * Create an instance of {@link EPCISHeaderType }
     * 
     */
    public EPCISHeaderType createEPCISHeaderType() {
        return new EPCISHeaderType();
    }

    /**
     * Create an instance of {@link EPCISBodyType }
     * 
     */
    public EPCISBodyType createEPCISBodyType() {
        return new EPCISBodyType();
    }

    /**
     * Create an instance of {@link EPCISDocumentExtensionType }
     * 
     */
    public EPCISDocumentExtensionType createEPCISDocumentExtensionType() {
        return new EPCISDocumentExtensionType();
    }

    /**
     * Create an instance of {@link EPCISHeaderExtensionType }
     * 
     */
    public EPCISHeaderExtensionType createEPCISHeaderExtensionType() {
        return new EPCISHeaderExtensionType();
    }

    /**
     * Create an instance of {@link EPCISHeaderExtension2Type }
     * 
     */
    public EPCISHeaderExtension2Type createEPCISHeaderExtension2Type() {
        return new EPCISHeaderExtension2Type();
    }

    /**
     * Create an instance of {@link EPCISMasterDataType }
     * 
     */
    public EPCISMasterDataType createEPCISMasterDataType() {
        return new EPCISMasterDataType();
    }

    /**
     * Create an instance of {@link EPCISMasterDataExtensionType }
     * 
     */
    public EPCISMasterDataExtensionType createEPCISMasterDataExtensionType() {
        return new EPCISMasterDataExtensionType();
    }

    /**
     * Create an instance of {@link VocabularyListType }
     * 
     */
    public VocabularyListType createVocabularyListType() {
        return new VocabularyListType();
    }

    /**
     * Create an instance of {@link VocabularyType }
     * 
     */
    public VocabularyType createVocabularyType() {
        return new VocabularyType();
    }

    /**
     * Create an instance of {@link VocabularyElementListType }
     * 
     */
    public VocabularyElementListType createVocabularyElementListType() {
        return new VocabularyElementListType();
    }

    /**
     * Create an instance of {@link VocabularyElementType }
     * 
     */
    public VocabularyElementType createVocabularyElementType() {
        return new VocabularyElementType();
    }

    /**
     * Create an instance of {@link AttributeType }
     * 
     */
    public AttributeType createAttributeType() {
        return new AttributeType();
    }

    /**
     * Create an instance of {@link IDListType }
     * 
     */
    public IDListType createIDListType() {
        return new IDListType();
    }

    /**
     * Create an instance of {@link VocabularyExtensionType }
     * 
     */
    public VocabularyExtensionType createVocabularyExtensionType() {
        return new VocabularyExtensionType();
    }

    /**
     * Create an instance of {@link VocabularyElementExtensionType }
     * 
     */
    public VocabularyElementExtensionType createVocabularyElementExtensionType() {
        return new VocabularyElementExtensionType();
    }

    /**
     * Create an instance of {@link EPCISBodyExtensionType }
     * 
     */
    public EPCISBodyExtensionType createEPCISBodyExtensionType() {
        return new EPCISBodyExtensionType();
    }

    /**
     * Create an instance of {@link EventListType }
     * 
     */
    public EventListType createEventListType() {
        return new EventListType();
    }

    /**
     * Create an instance of {@link EPCISEventListExtensionType }
     * 
     */
    public EPCISEventListExtensionType createEPCISEventListExtensionType() {
        return new EPCISEventListExtensionType();
    }

    /**
     * Create an instance of {@link EPCISEventListExtension2Type }
     * 
     */
    public EPCISEventListExtension2Type createEPCISEventListExtension2Type() {
        return new EPCISEventListExtension2Type();
    }

    /**
     * Create an instance of {@link EPCListType }
     * 
     */
    public EPCListType createEPCListType() {
        return new EPCListType();
    }

    /**
     * Create an instance of {@link QuantityElementType }
     * 
     */
    public QuantityElementType createQuantityElementType() {
        return new QuantityElementType();
    }

    /**
     * Create an instance of {@link QuantityListType }
     * 
     */
    public QuantityListType createQuantityListType() {
        return new QuantityListType();
    }

    /**
     * Create an instance of {@link ReadPointType }
     * 
     */
    public ReadPointType createReadPointType() {
        return new ReadPointType();
    }

    /**
     * Create an instance of {@link ReadPointExtensionType }
     * 
     */
    public ReadPointExtensionType createReadPointExtensionType() {
        return new ReadPointExtensionType();
    }

    /**
     * Create an instance of {@link BusinessLocationType }
     * 
     */
    public BusinessLocationType createBusinessLocationType() {
        return new BusinessLocationType();
    }

    /**
     * Create an instance of {@link BusinessLocationExtensionType }
     * 
     */
    public BusinessLocationExtensionType createBusinessLocationExtensionType() {
        return new BusinessLocationExtensionType();
    }

    /**
     * Create an instance of {@link BusinessTransactionType }
     * 
     */
    public BusinessTransactionType createBusinessTransactionType() {
        return new BusinessTransactionType();
    }

    /**
     * Create an instance of {@link BusinessTransactionListType }
     * 
     */
    public BusinessTransactionListType createBusinessTransactionListType() {
        return new BusinessTransactionListType();
    }

    /**
     * Create an instance of {@link SourceDestType }
     * 
     */
    public SourceDestType createSourceDestType() {
        return new SourceDestType();
    }

    /**
     * Create an instance of {@link SourceListType }
     * 
     */
    public SourceListType createSourceListType() {
        return new SourceListType();
    }

    /**
     * Create an instance of {@link DestinationListType }
     * 
     */
    public DestinationListType createDestinationListType() {
        return new DestinationListType();
    }

    /**
     * Create an instance of {@link ILMDType }
     * 
     */
    public ILMDType createILMDType() {
        return new ILMDType();
    }

    /**
     * Create an instance of {@link ILMDExtensionType }
     * 
     */
    public ILMDExtensionType createILMDExtensionType() {
        return new ILMDExtensionType();
    }

    /**
     * Create an instance of {@link CorrectiveEventIDsType }
     * 
     */
    public CorrectiveEventIDsType createCorrectiveEventIDsType() {
        return new CorrectiveEventIDsType();
    }

    /**
     * Create an instance of {@link ErrorDeclarationType }
     * 
     */
    public ErrorDeclarationType createErrorDeclarationType() {
        return new ErrorDeclarationType();
    }

    /**
     * Create an instance of {@link ErrorDeclarationExtensionType }
     * 
     */
    public ErrorDeclarationExtensionType createErrorDeclarationExtensionType() {
        return new ErrorDeclarationExtensionType();
    }

    /**
     * Create an instance of {@link EPCISEventExtensionType }
     * 
     */
    public EPCISEventExtensionType createEPCISEventExtensionType() {
        return new EPCISEventExtensionType();
    }

    /**
     * Create an instance of {@link EPCISEventExtension2Type }
     * 
     */
    public EPCISEventExtension2Type createEPCISEventExtension2Type() {
        return new EPCISEventExtension2Type();
    }

    /**
     * Create an instance of {@link ObjectEventType }
     * 
     */
    public ObjectEventType createObjectEventType() {
        return new ObjectEventType();
    }

    /**
     * Create an instance of {@link ObjectEventExtensionType }
     * 
     */
    public ObjectEventExtensionType createObjectEventExtensionType() {
        return new ObjectEventExtensionType();
    }

    /**
     * Create an instance of {@link ObjectEventExtension2Type }
     * 
     */
    public ObjectEventExtension2Type createObjectEventExtension2Type() {
        return new ObjectEventExtension2Type();
    }

    /**
     * Create an instance of {@link AggregationEventType }
     * 
     */
    public AggregationEventType createAggregationEventType() {
        return new AggregationEventType();
    }

    /**
     * Create an instance of {@link AggregationEventExtensionType }
     * 
     */
    public AggregationEventExtensionType createAggregationEventExtensionType() {
        return new AggregationEventExtensionType();
    }

    /**
     * Create an instance of {@link AggregationEventExtension2Type }
     * 
     */
    public AggregationEventExtension2Type createAggregationEventExtension2Type() {
        return new AggregationEventExtension2Type();
    }

    /**
     * Create an instance of {@link QuantityEventType }
     * 
     */
    public QuantityEventType createQuantityEventType() {
        return new QuantityEventType();
    }

    /**
     * Create an instance of {@link QuantityEventExtensionType }
     * 
     */
    public QuantityEventExtensionType createQuantityEventExtensionType() {
        return new QuantityEventExtensionType();
    }

    /**
     * Create an instance of {@link TransactionEventType }
     * 
     */
    public TransactionEventType createTransactionEventType() {
        return new TransactionEventType();
    }

    /**
     * Create an instance of {@link TransactionEventExtensionType }
     * 
     */
    public TransactionEventExtensionType createTransactionEventExtensionType() {
        return new TransactionEventExtensionType();
    }

    /**
     * Create an instance of {@link TransactionEventExtension2Type }
     * 
     */
    public TransactionEventExtension2Type createTransactionEventExtension2Type() {
        return new TransactionEventExtension2Type();
    }

    /**
     * Create an instance of {@link TransformationEventType }
     * 
     */
    public TransformationEventType createTransformationEventType() {
        return new TransformationEventType();
    }

    /**
     * Create an instance of {@link TransformationEventExtensionType }
     * 
     */
    public TransformationEventExtensionType createTransformationEventExtensionType() {
        return new TransformationEventExtensionType();
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EPCISDocumentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EPCISDocument")
    public JAXBElement<EPCISDocument> createEPCISDocument(EPCISDocument value) {
        return new JAXBElement<EPCISDocument>(_EPCISDocument_QNAME, EPCISDocument.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EPCISBodyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EPCISBody")
    public JAXBElement<EPCISBodyType> createEPCISBody(EPCISBodyType value) {
        return new JAXBElement<EPCISBodyType>(_EPCISBody_QNAME, EPCISBodyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "EventList")
    public JAXBElement<EventListType> createEventList(EventListType value) {
        return new JAXBElement<EventListType>(_EventList_QNAME, EventListType.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObjectEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ObjectEvent", scope = EventListType.class)
    public JAXBElement<ObjectEventType> createEventListTypeObjectEvent(ObjectEventType value) {
        return new JAXBElement<ObjectEventType>(_EventListTypeObjectEvent_QNAME, ObjectEventType.class, EventListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggregationEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AggregationEvent", scope = EventListType.class)
    public JAXBElement<AggregationEventType> createEventListTypeAggregationEvent(AggregationEventType value) {
        return new JAXBElement<AggregationEventType>(_EventListTypeAggregationEvent_QNAME, AggregationEventType.class, EventListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantityEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QuantityEvent", scope = EventListType.class)
    public JAXBElement<QuantityEventType> createEventListTypeQuantityEvent(QuantityEventType value) {
        return new JAXBElement<QuantityEventType>(_EventListTypeQuantityEvent_QNAME, QuantityEventType.class, EventListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionEventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TransactionEvent", scope = EventListType.class)
    public JAXBElement<TransactionEventType> createEventListTypeTransactionEvent(TransactionEventType value) {
        return new JAXBElement<TransactionEventType>(_EventListTypeTransactionEvent_QNAME, TransactionEventType.class, EventListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EPCISEventListExtensionType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "extension", scope = EventListType.class)
    public JAXBElement<EPCISEventListExtensionType> createEventListTypeExtension(EPCISEventListExtensionType value) {
        return new JAXBElement<EPCISEventListExtensionType>(_EventListTypeExtension_QNAME, EPCISEventListExtensionType.class, EventListType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VocabularyListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VocabularyList")
    public JAXBElement<VocabularyListType> createVocabularyList(VocabularyListType value) {
        return new JAXBElement<VocabularyListType>(_VocabularyList_QNAME, VocabularyListType.class, null, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VocabularyListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Vocabulary")
    public JAXBElement<VocabularyType> createVocabulary(VocabularyType value) {
        return new JAXBElement<VocabularyType>(_Vocabulary_QNAME, VocabularyType.class, null, value);
    }
}
