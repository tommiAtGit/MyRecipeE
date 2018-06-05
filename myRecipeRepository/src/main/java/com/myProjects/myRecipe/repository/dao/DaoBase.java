package com.myProjects.myRecipe.repository.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class DaoBase {
	@PersistenceContext
	protected EntityManager em;
	private static EntityManagerFactory factory;
	
	public DaoBase(String persistenceUnit) {
		factory = Persistence.createEntityManagerFactory(persistenceUnit);
		em = factory.createEntityManager();
		
	}
	public void closeEntityFactory() {
		//factory.close();
	}

}
