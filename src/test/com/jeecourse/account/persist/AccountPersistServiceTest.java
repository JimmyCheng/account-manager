package com.jeecourse.account.persist;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/com/jeecourse/account/persist/account-persist.xml" })
public class AccountPersistServiceTest implements ApplicationContextAware {
	private AccountPersistService service;
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Before
	public void prepare() throws Exception {
		File persistDataFile = new File("target/test-classes/persist-data.xml");

		if (persistDataFile.exists()) {
			persistDataFile.delete();
		}

		service = (AccountPersistService) applicationContext.getBean("accountPersistService");

		Account account = new Account();
		account.setId("1001");
		account.setName("Jimmy Cheng");
		account.setAge(35);

		service.createAccount(account);
	}

	@Test
	public void testReadAccount() throws Exception {
		Account account = service.readAccount("1001");

		assertNotNull(account);
		assertEquals("1001", account.getId());
		assertEquals("Jimmy Cheng", account.getName());
		assertEquals(35, account.getAge());
	}

	@Test
	public void testDeleteAccount() throws Exception {
		assertNotNull(service.readAccount("1001"));
		service.deleteAccount("1001");
		assertNull(service.readAccount("1001"));
	}

	@Test
	public void testCreateAccount() throws Exception {
		assertNull(service.readAccount("mike"));

		Account account = new Account();
		account.setId("1002");
		account.setName("Mike");
		account.setAge(20);

		service.createAccount(account);

		assertNotNull(service.readAccount("1002"));
	}

	@Test
	public void testUpdateAccount() throws Exception {
		Account account = service.readAccount("1001");

		account.setName("Jimmy Cheng 1");
		account.setAge(28);

		service.updateAccount(account);

		account = service.readAccount("1001");

		assertEquals("Jimmy Cheng 1", account.getName());
		assertEquals(28, account.getAge());
	}

}
