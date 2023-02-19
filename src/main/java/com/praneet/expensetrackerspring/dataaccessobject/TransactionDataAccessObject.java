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
	public long getTotalExpense() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Long> theQuery = currentSession.createQuery("select sum(transaction.transactionAmount) from TransactionEntity transaction where transaction.transactionType=:transaction_type",Long.class); 
		
		theQuery.setParameter("transaction_type", 2);
		
		long totalExpense = theQuery.list().get(0);
		return totalExpense;
	}

	@Override
	@Transactional
	public void addTransaction(TransactionEntity theTransaction) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.persist(theTransaction);
	}

	@Override
	@Transactional
	public long getTotalCredit() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Long> query = currentSession.createQuery("select sum(transaction.transactionAmount)from TransactionEntity transaction where transaction.transactionType=:transaction_type", Long.class);
		
		query.setParameter("transaction_type", 1);
		
		long totalCredit = query.list().get(0);
		
		return totalCredit;
	}

}
