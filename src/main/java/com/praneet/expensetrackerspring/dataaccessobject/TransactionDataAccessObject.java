package com.praneet.expensetrackerspring.dataaccessobject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.praneet.expensetrackerspring.entity.TransactionEntity;

import jakarta.persistence.EntityManager;

@Repository
public class TransactionDataAccessObject implements ExpenseTrackerDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public TransactionDataAccessObject(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public List<TransactionEntity> getAllTransactionInfo() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<TransactionEntity> theQuery = currentSession.createQuery("from TransactionEntity",TransactionEntity.class);
		
		List<TransactionEntity> transactionList = theQuery.getResultList();
		
		return transactionList;
	}

	@Override
	@Transactional
	public void addTransaction(TransactionEntity theTransaction) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.persist(theTransaction);
	}

}
