package com.example.demo.currencydemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.currencydemo.entity.Cripto;;

@Repository
public class CriptoDAOHibernateImpl implements CriptoDAO{

	// define field for entityManager
	// set up constructor injection
	
	private EntityManager entityManager;
	
	@Autowired
	public CriptoDAOHibernateImpl(EntityManager theEntityManager) {
	
		this.entityManager = theEntityManager;
		
	}
	
	
	@Override
	public List<Cripto> findAll() {
		
		/*
		 * get the current hibernate session
		 * create a query
		 * execute query and get result list
		 * return the results
		 */
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Cripto> theQuery = currentSession.createQuery("from Cripto",Cripto.class);
		List<Cripto> criptos = theQuery.getResultList();
		
		return criptos;
	}


	@Override
	public Cripto findById(int theId) {
		
		/*
		 * get the current hibernate session
		 * get the cripto
		 * return cripto
		 */
		
		Session currentSession = entityManager.unwrap(Session.class);
		Cripto theCripto = currentSession.get(Cripto.class, theId);
		return theCripto;
	}


	@Override
	public void save(Cripto theCripto) {
		/*
		 * get the current hibernate session
		 * save cripto
		 */
		
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCripto); // if id=0 save/insert else update
		
	}


	@Override
	public void deleteById(int theId) {
		/*
		 * get the current hibernate session
		 * delete object with primary key
		 */
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Cripto where id=:id");
		
		theQuery.setParameter("id",theId);
		theQuery.executeUpdate();
		
		
		
	}

	
	
}


















