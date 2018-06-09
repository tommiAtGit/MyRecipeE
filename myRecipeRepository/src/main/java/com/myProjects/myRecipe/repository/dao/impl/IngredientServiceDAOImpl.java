package com.myProjects.myRecipe.repository.dao.impl;

import java.util.List;

import javax.persistence.Query;

/**
 * Created by osboxes on 21/05/17.
 */


import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.repository.dao.DaoBase;
import com.myProjects.myRecipe.repository.dao.IngredientServiceDAO;


public class IngredientServiceDAOImpl extends DaoBase implements IngredientServiceDAO {

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
				
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- save(): Error occured: " + ex.getMessage());
				ex.printStackTrace();
				
			}
			
		}
		return ing;
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
		 }
		catch(Exception ex) {
					//TODO: Replace me with some kind of logging
					System.out.println(this.getClass().getName() + "-- fetchListOf(): Error occured: " + ex.getMessage());
					ex.printStackTrace(); 
		}
		return ingList;
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * Fetch single object form database
	 */
	public Ingredient findIngredient(Ingredient ing) {
		Ingredient hA = null;
		
		 try {
			 hA =em.find(Ingredient.class, ing.getId());
		 }
		catch(Exception ex) {
					//TODO: Replace me with some kind of logging
					System.out.println(this.getClass().getName() + "-- findIngredient(): Error occured: " + ex.getMessage());
					ex.printStackTrace(); 
		}
		return hA;
	}
	
	/*
	 * Find ingredient by manufacturer 
	 */
	@SuppressWarnings("unchecked")
	public List<Ingredient> findByManufacture(String mf){
		List<Ingredient> ingList = null; 
		Query q  = em.createQuery("select m from Ingredient m where m.manufacturer = :mf");
		q.setParameter("manufacturer", mf);
		 try {
			 ingList = (List<Ingredient>) q.getResultList();
		 }
		catch(Exception ex) {
					//TODO: Replace me with some kind of logging
					System.out.println(this.getClass().getName() + "-- findByManufacture(): Error occured: " + ex.getMessage());
					ex.printStackTrace(); 
		}
		return ingList;
	}
	
	

}
