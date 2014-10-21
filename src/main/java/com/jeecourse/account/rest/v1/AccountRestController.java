package com.jeecourse.account.rest.v1;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.jeecourse.account.domain.Account;
import com.jeecourse.account.service.AccountService;

/**
 * Account的Restful API的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/api/v1/account")
public class AccountRestController {

	private static Logger logger = LoggerFactory.getLogger(AccountRestController.class);

	public final static String JSON_UTF_8 = "application/json; charset=UTF-8";

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Account> GetAll() {
		return accountService.readAllAccount();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Account getAccount(@PathVariable("id") Long id) {
		Account account = null;
		account = accountService.readAccount(id);

		if (account == null) {
			String message = "Account is not found!";
			logger.warn(message);
			throw new RestException(HttpStatus.NOT_FOUND, message);
		}
		return account;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody Account account, UriComponentsBuilder uriBuilder) {
		accountService.createAccount(account);

		Long id = account.getId();
		URI uri = uriBuilder.path("/account/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody Account account) {
		accountService.updateAccount(account);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		accountService.deleteAccount(id);
	}

}
