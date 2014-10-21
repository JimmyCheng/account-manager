package com.jeecourse.account.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jeecourse.account.domain.Account;

@Repository
public class AccountDAO {
	private EntityManager entityManager;
	private static Logger logger = LoggerFactory.getLogger(AccountDAO.class);

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Account account) {
		logger.debug("DAO creates an account");
		entityManager.persist(account);
	}

	public Account read(Long id) {
		logger.debug("DAO reads an account");
		try {
			Account account = (Account) entityManager.createQuery("FROM Account acc WHERE acc.id = :id")
					.setParameter("id", id).getSingleResult();
			return account;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Account readByName(String name) {
		logger.debug("DAO reads an account");
		try {
			Account account = (Account) entityManager.createQuery("FROM Account acc WHERE acc.name = :name")
					.setParameter("name", name).getSingleResult();
			return account;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Account> readAll() {
		logger.debug("DAO reads all account");
		try {
			Query query = entityManager.createQuery("FROM Account");
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void update(Account account) {
		logger.debug("DAO updats an account");
		entityManager.persist(account);
	}

	public void deleteAccount(Account account) {
		logger.debug("DAO delete an account");
		entityManager.remove(account);
	}

}
