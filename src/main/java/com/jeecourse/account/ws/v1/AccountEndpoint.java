package com.jeecourse.account.ws.v1;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jeecourse.account.domain.Account;
import com.jeecourse.account.service.AccountService;
import com.jeecourse.account.service.AccountServiceException;
import com.jeecourse.account.ws.v1.beans.AccountRsp;
import com.jeecourse.account.ws.v1.beans.Accounts;
import com.jeecourse.account.ws.v1.beans.Empty;
import com.jeecourse.account.ws.v1.beans.ObjectFactory;
import com.jeecourse.account.ws.v1.beans.PaginationInfo;

@Endpoint
public class AccountEndpoint {

    private static final String NAMESPACE_URI = "http://www.jeecourse.com/account/v1";

    @Autowired
    private AccountService accountService;

    private static final ObjectFactory OBJ_FACTORY = new ObjectFactory();
    

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createAccountRequest")
    @ResponsePayload
    public JAXBElement<AccountRsp> handleCreateAccountRequest(@RequestPayload JAXBElement<AccountRsp> createAccountReq) {
        String name = createAccountReq.getValue().getName();
        int age = createAccountReq.getValue().getAge();

        Account account = new Account();
        account.setAge(age);
        account.setName(name);
        accountService.createAccount(account);
        
        account = accountService.readAccountByName(name);
        
        AccountRsp accountRsp = new AccountRsp();
        accountRsp.setAge(account.getAge());
        accountRsp.setID(account.getId());
        accountRsp.setName(account.getName());
        
        return OBJ_FACTORY.createCreateAccountResponse(accountRsp);
    }    

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountRequest")
    @ResponsePayload
    public JAXBElement<AccountRsp> handleGetAccountRequest(@RequestPayload JAXBElement<Long> id) {

        Account returnAccount = accountService.readAccount(id.getValue());

        if (returnAccount == null) {
            throw new AccountWsException(AccountWsException.ACCOUNT_NOT_FOUND, "No Account was found!");
        }

        // Below code is not good, try to find out a better practice for this.
        AccountRsp accountRsp = new AccountRsp();
        accountRsp.setAge(returnAccount.getAge());
        accountRsp.setID(returnAccount.getId());
        accountRsp.setName(returnAccount.getName());

        return OBJ_FACTORY.createGetAccountResponse(accountRsp);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateAccountRequest")
    @ResponsePayload
    public JAXBElement<Empty> handleUpdateAccountRequest(@RequestPayload JAXBElement<AccountRsp> updateAccountReq) {
        String name = updateAccountReq.getValue().getName();
        int age = updateAccountReq.getValue().getAge();

        Account toBeUpdate = new Account();
        toBeUpdate.setAge(age);
        toBeUpdate.setName(name);

        try {
            accountService.updateAccountByName(toBeUpdate);
        } catch (AccountServiceException e) {
            throw new AccountWsException(AccountWsException.INTERNAL_ERROR, e.getMessage());
        }

        return OBJ_FACTORY.createUpdateAccountResponse(new Empty());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteAccountRequest")
    @ResponsePayload
    public JAXBElement<Empty> handleDeleteAccountRequest(@RequestPayload JAXBElement<Long> id) {
        try {
            accountService.deleteAccount(id.getValue());
        } catch (AccountServiceException e) {
            throw new AccountWsException(AccountWsException.INTERNAL_ERROR, e.getMessage());
        }
        return OBJ_FACTORY.createDeleteAccountResponse(new Empty());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountsRequest")
    @ResponsePayload
    public JAXBElement<Accounts> handleGetAccountsRequest(@RequestPayload JAXBElement<PaginationInfo> getAccountsRequest) {
        Accounts accounts = new Accounts();
        for (Account account : accountService.readAllAccount()) {
            AccountRsp accountRsp = new AccountRsp();
            accountRsp.setAge(account.getAge());
            accountRsp.setID(account.getId());
            accountRsp.setName(account.getName());
            accounts.getAccounts().add(accountRsp);
        }

        return OBJ_FACTORY.createGetAccountsResponse(accounts);
    }
}
