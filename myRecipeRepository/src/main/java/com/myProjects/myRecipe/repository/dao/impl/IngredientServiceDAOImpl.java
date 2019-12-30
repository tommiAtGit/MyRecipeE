package com.myProjects.myRecipe.repository.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;



/**
 * Created by osboxes on 21/05/17.
 */


import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.repository.dao.DaoBase;
import com.myProjects.myRecipe.repository.dao.IngredientServiceDAO;


public class IngredientServiceDAOImpl extends DaoBase implements IngredientServiceDAO {

	static Logger log = Logger.getLogger(IngredientServiceDAOImpl.class.getName());
	
	public IngredientServiceDAOImpl(String persistenceUnit) {
		super(persistenceUnit);
		
	}

	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.IngredientServiceDAO#save(com.myProjects.myRecipe.domain.Ingredient)
	 */
	public Ingredient save(Ingredient ing){
		
		if (ing != null) {
			try {
				
				if(!em.getTransaction().isActive()) {
					em.getTransaction().begin();
				}
				
				//em.persist(housingApartment);
				em.merge(ing);
				em.getTransaction().commit();
				//em.close();
				return ing;
				
			}
			catch(Exception ex) {
				log.error("Error occured while saving ingredient: "+ ex.getMessage());
				throw ex;
			}
		}
		else {
			throw new IllegalArgumentException("Ingredient argument is null");
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.IngredientServiceDAO#fetchListOf()
	 */
	@SuppressWarnings("unchecked")
	public List<Ingredient> fetchListOf(){
		List<Ingredient> ingList = null; 
		Query q  = em.createQuery("from Ingredient");
		 try {
			 ingList = (List<Ingredient>) q.getResultList();
			 return ingList;
		 }
		catch(Exception ex) {
			log.error("Error occured: " + ex.getMessage());
			throw ex;
		}
		
	}
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.IngredientServiceDAO#removeIngredient(com.myProjects.myRecipe.domain.Ingredient)
	 */
	public void removeIngredient(Ingredient ing) {
		if(ing != null) {
			Ingredient hA = em.find(Ingredient.class, ing.getId());
			
			try {
				em.getTransaction().begin();
				em.remove(hA);
				em.getTransaction().commit();
			} catch (Exception ex) {
				log.error("Error occured while removing ingredinet: " + ex.getMessage());
				throw ex;
			}
		}
	}
	/*
	 * Fetch single object form database
	 */
	public Ingredient findIngredient(Ingredient ing) {
		Ingredient hA = null;
		if (ing != null) {
			 try {
				 hA =em.find(Ingredient.class, ing.getId());
				 return hA;
			 }
			catch(Exception ex) {
				log.error("Error occures while finding ingredient:" + ex.getMessage());
				throw ex;
			}
		}
		else {
			throw new IllegalArgumentException("Ingredient argument is null");
		}
		
		
	}
	
	/*
	 * Find ingredient by manufacturer 
	 */
	@SuppressWarnings("unchecked")
	public List<Ingredient> findByManufacture(String mf){
		List<Ingredient> ingList = null; 
		if ((mf.isEmpty())&&(mf != null)) {
			Query q  = em.createQuery("select m from Ingredient m where m.manufacturer = :mf");
			q.setParameter("manufacturer", mf);
			 try {
				 ingList = (List<Ingredient>) q.getResultList();
				 return ingList;
			 }
			catch(Exception ex) {
				log.error("Error occured while finding by manafacture: " + ex.getMessage());
				throw ex;
			}
			
		}
		else {
			log.error("Argument error occured");
			throw new IllegalArgumentException("Error ocured in arguments");
		}

	}
	
	

}
