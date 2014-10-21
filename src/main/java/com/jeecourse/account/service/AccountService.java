package com.jeecourse.account.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecourse.account.dao.AccountDAO;
import com.jeecourse.account.domain.Account;

@Service
@Transactional(readOnly = true)
public class AccountService {
	private AccountDAO accountDAO;
	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	@Autowired
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	@Transactional(readOnly = false)
	public void createAccount(Account account) {
		logger.debug("Service adds an account");
		accountDAO.create(account);
	}

	public Account readAccount(Long id) {
		logger.debug("Service reads an account");
		return accountDAO.read(id);
	}

	public Account readAccountByName(String name) {
		logger.debug("Service reads an account");
		return accountDAO.readByName(name);
	}

	public List<Account> readAllAccount() {
		logger.debug("Service reads all account");
		return accountDAO.readAll();
	}

	@Transactional(readOnly = false)
	public void updateAccount(Account account) {
		logger.debug("Service updates an account");

		Account existingAccount = accountDAO.read(account.getId());
		if (existingAccount != null) {
			existingAccount.setAge(account.getAge());
			existingAccount.setName(account.getName());
			accountDAO.update(existingAccount);
		} else {
			throw new AccountServiceException("Account was not found!");
		}
	}
	
	@Transactional(readOnly = false)
	public void updateAccountByName(Account account) {
		logger.debug("Service updates an account by name");
		
		Account existingAccount = accountDAO.readByName(account.getName());
		if (existingAccount != null) {
			existingAccount.setAge(account.getAge());
			accountDAO.update(existingAccount);
		} else {
			throw new AccountServiceException("Account was not found!");
		}
		
	}

	@Transactional(readOnly = false)
	public void deleteAccount(Long id){
		logger.debug("Service deletes an account");
		Account existingAccount = accountDAO.read(id);

		if (existingAccount != null) {
			accountDAO.deleteAccount(existingAccount);
		} else {
			throw new AccountServiceException("Account was not found!");
		}
	}


}
