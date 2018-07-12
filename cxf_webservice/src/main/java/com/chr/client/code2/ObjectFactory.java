
package com.chr.client.code2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.chr.client.code2 package. 
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

    private final static QName _SelectAllResponse_QNAME = new QName("http://service.web.server.chr.com/", "selectAllResponse");
    private final static QName _UpdateEmp_QNAME = new QName("http://service.web.server.chr.com/", "updateEmp");
    private final static QName _SelectAll_QNAME = new QName("http://service.web.server.chr.com/", "selectAll");
    private final static QName _UpdateEmpResponse_QNAME = new QName("http://service.web.server.chr.com/", "updateEmpResponse");
    private final static QName _InsertEmp_QNAME = new QName("http://service.web.server.chr.com/", "insertEmp");
    private final static QName _DeleteEmpResponse_QNAME = new QName("http://service.web.server.chr.com/", "deleteEmpResponse");
    private final static QName _SelectOne_QNAME = new QName("http://service.web.server.chr.com/", "selectOne");
    private final static QName _SelectOneResponse_QNAME = new QName("http://service.web.server.chr.com/", "selectOneResponse");
    private final static QName _DeleteEmp_QNAME = new QName("http://service.web.server.chr.com/", "deleteEmp");
    private final static QName _InsertEmpResponse_QNAME = new QName("http://service.web.server.chr.com/", "insertEmpResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.chr.client.code2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SelectOneResponse }
     * 
     */
    public SelectOneResponse createSelectOneResponse() {
        return new SelectOneResponse();
    }

    /**
     * Create an instance of {@link InsertEmpResponse }
     * 
     */
    public InsertEmpResponse createInsertEmpResponse() {
        return new InsertEmpResponse();
    }

    /**
     * Create an instance of {@link DeleteEmp }
     * 
     */
    public DeleteEmp createDeleteEmp() {
        return new DeleteEmp();
    }

    /**
     * Create an instance of {@link InsertEmp }
     * 
     */
    public InsertEmp createInsertEmp() {
        return new InsertEmp();
    }

    /**
     * Create an instance of {@link SelectOne }
     * 
     */
    public SelectOne createSelectOne() {
        return new SelectOne();
    }

    /**
     * Create an instance of {@link DeleteEmpResponse }
     * 
     */
    public DeleteEmpResponse createDeleteEmpResponse() {
        return new DeleteEmpResponse();
    }

    /**
     * Create an instance of {@link UpdateEmpResponse }
     * 
     */
    public UpdateEmpResponse createUpdateEmpResponse() {
        return new UpdateEmpResponse();
    }

    /**
     * Create an instance of {@link SelectAllResponse }
     * 
     */
    public SelectAllResponse createSelectAllResponse() {
        return new SelectAllResponse();
    }

    /**
     * Create an instance of {@link UpdateEmp }
     * 
     */
    public UpdateEmp createUpdateEmp() {
        return new UpdateEmp();
    }

    /**
     * Create an instance of {@link SelectAll }
     * 
     */
    public SelectAll createSelectAll() {
        return new SelectAll();
    }

    /**
     * Create an instance of {@link Emp }
     * 
     */
    public Emp createEmp() {
        return new Emp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "selectAllResponse")
    public JAXBElement<SelectAllResponse> createSelectAllResponse(SelectAllResponse value) {
        return new JAXBElement<SelectAllResponse>(_SelectAllResponse_QNAME, SelectAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "updateEmp")
    public JAXBElement<UpdateEmp> createUpdateEmp(UpdateEmp value) {
        return new JAXBElement<UpdateEmp>(_UpdateEmp_QNAME, UpdateEmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "selectAll")
    public JAXBElement<SelectAll> createSelectAll(SelectAll value) {
        return new JAXBElement<SelectAll>(_SelectAll_QNAME, SelectAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "updateEmpResponse")
    public JAXBElement<UpdateEmpResponse> createUpdateEmpResponse(UpdateEmpResponse value) {
        return new JAXBElement<UpdateEmpResponse>(_UpdateEmpResponse_QNAME, UpdateEmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertEmp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "insertEmp")
    public JAXBElement<InsertEmp> createInsertEmp(InsertEmp value) {
        return new JAXBElement<InsertEmp>(_InsertEmp_QNAME, InsertEmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "deleteEmpResponse")
    public JAXBElement<DeleteEmpResponse> createDeleteEmpResponse(DeleteEmpResponse value) {
        return new JAXBElement<DeleteEmpResponse>(_DeleteEmpResponse_QNAME, DeleteEmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectOne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "selectOne")
    public JAXBElement<SelectOne> createSelectOne(SelectOne value) {
        return new JAXBElement<SelectOne>(_SelectOne_QNAME, SelectOne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SelectOneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "selectOneResponse")
    public JAXBElement<SelectOneResponse> createSelectOneResponse(SelectOneResponse value) {
        return new JAXBElement<SelectOneResponse>(_SelectOneResponse_QNAME, SelectOneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEmp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "deleteEmp")
    public JAXBElement<DeleteEmp> createDeleteEmp(DeleteEmp value) {
        return new JAXBElement<DeleteEmp>(_DeleteEmp_QNAME, DeleteEmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertEmpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.web.server.chr.com/", name = "insertEmpResponse")
    public JAXBElement<InsertEmpResponse> createInsertEmpResponse(InsertEmpResponse value) {
        return new JAXBElement<InsertEmpResponse>(_InsertEmpResponse_QNAME, InsertEmpResponse.class, null, value);
    }

}
