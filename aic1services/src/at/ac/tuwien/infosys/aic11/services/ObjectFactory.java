
package at.ac.tuwien.infosys.aic11.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.ac.tuwien.infosys.aic11.services package. 
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

    private final static QName _WsdlEndpoint_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "wsdl_endpoint");
    private final static QName _Query_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "query");
    private final static QName _InvalidParameter_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "invalid_parameter");
    private final static QName _DisbursementPreference_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "disbursement_preference");
    private final static QName _QueryResponse_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "queryResponse");
    private final static QName _Cheque_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "cheque");
    private final static QName _BankTransfer_QNAME = new QName("http://services.aic11.infosys.tuwien.ac.at/", "bank_transfer");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.ac.tuwien.infosys.aic11.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WsdlEndpoint }
     * 
     */
    public WsdlEndpoint createWsdlEndpoint() {
        return new WsdlEndpoint();
    }

    /**
     * Create an instance of {@link Query }
     * 
     */
    public Query createQuery() {
        return new Query();
    }

    /**
     * Create an instance of {@link QueryResponse }
     * 
     */
    public QueryResponse createQueryResponse() {
        return new QueryResponse();
    }

    /**
     * Create an instance of {@link InvalidParameter }
     * 
     */
    public InvalidParameter createInvalidParameter() {
        return new InvalidParameter();
    }

    /**
     * Create an instance of {@link Cheque }
     * 
     */
    public Cheque createCheque() {
        return new Cheque();
    }

    /**
     * Create an instance of {@link BankTransfer }
     * 
     */
    public BankTransfer createBankTransfer() {
        return new BankTransfer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsdlEndpoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "wsdl_endpoint")
    public JAXBElement<WsdlEndpoint> createWsdlEndpoint(WsdlEndpoint value) {
        return new JAXBElement<WsdlEndpoint>(_WsdlEndpoint_QNAME, WsdlEndpoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Query }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "query")
    public JAXBElement<Query> createQuery(Query value) {
        return new JAXBElement<Query>(_Query_QNAME, Query.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidParameter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "invalid_parameter")
    public JAXBElement<InvalidParameter> createInvalidParameter(InvalidParameter value) {
        return new JAXBElement<InvalidParameter>(_InvalidParameter_QNAME, InvalidParameter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisbursementPreference }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "disbursement_preference")
    public JAXBElement<DisbursementPreference> createDisbursementPreference(DisbursementPreference value) {
        return new JAXBElement<DisbursementPreference>(_DisbursementPreference_QNAME, DisbursementPreference.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "queryResponse")
    public JAXBElement<QueryResponse> createQueryResponse(QueryResponse value) {
        return new JAXBElement<QueryResponse>(_QueryResponse_QNAME, QueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cheque }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "cheque")
    public JAXBElement<Cheque> createCheque(Cheque value) {
        return new JAXBElement<Cheque>(_Cheque_QNAME, Cheque.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.aic11.infosys.tuwien.ac.at/", name = "bank_transfer")
    public JAXBElement<BankTransfer> createBankTransfer(BankTransfer value) {
        return new JAXBElement<BankTransfer>(_BankTransfer_QNAME, BankTransfer.class, null, value);
    }

}
