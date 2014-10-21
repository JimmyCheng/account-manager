
package com.jeecourse.account.ws.v1.beans;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jeecourse.account.ws.v1.beans package. 
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

    private final static QName _GetAccountsRequest_QNAME = new QName("http://www.jeecourse.com/account/v1", "getAccountsRequest");
    private final static QName _UpdateAccountRequest_QNAME = new QName("http://www.jeecourse.com/account/v1", "updateAccountRequest");
    private final static QName _CreateAccountRequest_QNAME = new QName("http://www.jeecourse.com/account/v1", "createAccountRequest");
    private final static QName _UpdateAccountResponse_QNAME = new QName("http://www.jeecourse.com/account/v1", "updateAccountResponse");
    private final static QName _DeleteAccountRequest_QNAME = new QName("http://www.jeecourse.com/account/v1", "deleteAccountRequest");
    private final static QName _CreateAccountResponse_QNAME = new QName("http://www.jeecourse.com/account/v1", "createAccountResponse");
    private final static QName _DeleteAccountResponse_QNAME = new QName("http://www.jeecourse.com/account/v1", "deleteAccountResponse");
    private final static QName _GetAccountRequest_QNAME = new QName("http://www.jeecourse.com/account/v1", "getAccountRequest");
    private final static QName _GetAccountResponse_QNAME = new QName("http://www.jeecourse.com/account/v1", "getAccountResponse");
    private final static QName _GetAccountsResponse_QNAME = new QName("http://www.jeecourse.com/account/v1", "getAccountsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jeecourse.account.ws.v1.beans
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountReq }
     * 
     */
    public AccountReq createAccountReq() {
        return new AccountReq();
    }

    /**
     * Create an instance of {@link PaginationInfo }
     * 
     */
    public PaginationInfo createPaginationInfo() {
        return new PaginationInfo();
    }

    /**
     * Create an instance of {@link Empty }
     * 
     */
    public Empty createEmpty() {
        return new Empty();
    }

    /**
     * Create an instance of {@link WsException }
     * 
     */
    public WsException createWsException() {
        return new WsException();
    }

    /**
     * Create an instance of {@link AccountRsp }
     * 
     */
    public AccountRsp createAccountRsp() {
        return new AccountRsp();
    }

    /**
     * Create an instance of {@link Accounts }
     * 
     */
    public Accounts createAccounts() {
        return new Accounts();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaginationInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "getAccountsRequest")
    public JAXBElement<PaginationInfo> createGetAccountsRequest(PaginationInfo value) {
        return new JAXBElement<PaginationInfo>(_GetAccountsRequest_QNAME, PaginationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "updateAccountRequest")
    public JAXBElement<AccountReq> createUpdateAccountRequest(AccountReq value) {
        return new JAXBElement<AccountReq>(_UpdateAccountRequest_QNAME, AccountReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "createAccountRequest")
    public JAXBElement<AccountReq> createCreateAccountRequest(AccountReq value) {
        return new JAXBElement<AccountReq>(_CreateAccountRequest_QNAME, AccountReq.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "updateAccountResponse")
    public JAXBElement<Empty> createUpdateAccountResponse(Empty value) {
        return new JAXBElement<Empty>(_UpdateAccountResponse_QNAME, Empty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "deleteAccountRequest")
    public JAXBElement<Long> createDeleteAccountRequest(Long value) {
        return new JAXBElement<Long>(_DeleteAccountRequest_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "createAccountResponse")
    public JAXBElement<AccountRsp> createCreateAccountResponse(AccountRsp value) {
        return new JAXBElement<AccountRsp>(_CreateAccountResponse_QNAME, AccountRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Empty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "deleteAccountResponse")
    public JAXBElement<Empty> createDeleteAccountResponse(Empty value) {
        return new JAXBElement<Empty>(_DeleteAccountResponse_QNAME, Empty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "getAccountRequest")
    public JAXBElement<Long> createGetAccountRequest(Long value) {
        return new JAXBElement<Long>(_GetAccountRequest_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "getAccountResponse")
    public JAXBElement<AccountRsp> createGetAccountResponse(AccountRsp value) {
        return new JAXBElement<AccountRsp>(_GetAccountResponse_QNAME, AccountRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Accounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jeecourse.com/account/v1", name = "getAccountsResponse")
    public JAXBElement<Accounts> createGetAccountsResponse(Accounts value) {
        return new JAXBElement<Accounts>(_GetAccountsResponse_QNAME, Accounts.class, null, value);
    }

}
