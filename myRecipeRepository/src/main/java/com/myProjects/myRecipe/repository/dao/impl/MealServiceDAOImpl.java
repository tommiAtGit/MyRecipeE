package com.myProjects.myRecipe.repository.dao.impl;



import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.myProjects.myRecipe.domain.Meal;
import com.myProjects.myRecipe.repository.dao.DaoBase;
import com.myProjects.myRecipe.repository.dao.MealServiceDAO;


public class MealServiceDAOImpl extends DaoBase implements MealServiceDAO{

	static Logger log = Logger.getLogger(MealServiceDAOImpl.class.getName());
	public MealServiceDAOImpl(String persistenceUnit) {
		super(persistenceUnit);

	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO#saveMeal(com.myProjects.myRecipe.domain.Meal)
	 */
	public Meal saveMeal(Meal meal){
		log.info("Save meal...");
		if (meal != null) {
			try {
				if(!em.getTransaction().isActive()) {
					em.getTransaction().begin();
				}
				em.persist(meal);
				em.getTransaction().commit();
				//em.close();
				return meal;
			}
			catch(Exception ex) {
				log.error("Error occured while saving meal", ex);
				throw ex;
			}
		}
		else {
			log.error("Argument error occured");
			throw new IllegalArgumentException("Argument error occured");
		}
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO#fetchListOf()
	 */
	@SuppressWarnings("unchecked")
	public List<Meal> fetchListOf(){
		log.info("Fetching list of...");
		
		List<Meal> mealList = null; 
		Query q  = em.createQuery("from Meal");
		 try {
			 mealList = (List<Meal>) q.getResultList();
		 }
		catch(Exception ex) {
			log.error("Error occured while fetching list of..", ex);
			throw ex;
		}
		return mealList;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO#findMeal(com.myProjects.myRecipe.domain.Meal)
	 */
	public Meal findMeal(Meal meal) {
		Meal fm = null;
		
		
		if (meal != null) {
			try {
				fm =em.find(Meal.class, meal.getId());
				return fm;
			 }
			catch(Exception ex) {
				log.error("Error occured while finding meal with Id: " + meal.getId());
				throw ex;
			}
		}
		else {
			log.error("Argument error occured");
			throw new IllegalArgumentException("Argument error occured");
		}
	
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO#deleteMeal(com.myProjects.myRecipe.domain.Meal)
	 */
	public void deleteMeal(Meal meal) {
		
		if(meal != null) {
			Meal me = em.find(Meal.class, meal.getId());
			if (me != null) {
				try {
					em.getTransaction().begin();
					em.remove(me);
					em.getTransaction().commit();
				} catch (Exception ex) {
					log.error("Error occured while deleting meal :" + ex.getMessage());
					throw ex;
				}
			}
			else {
				//TODO: Replace me with some kind of logging
				log.info("Meal not found with id: " + meal.getId()); 
			}
			
		}
		else {
			log.error("Argument error occured while deleting meal: meal is null");
			throw new IllegalArgumentException("Argument error occured");
			
		}
	}
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO#updateMeal(com.myProjects.myRecipe.domain.Meal)
	 */
	public Meal updateMeal(Meal meal) {
		Meal updMeal = null;
		
		if (meal != null) {
			try {
				if(!em.getTransaction().isActive()) {
					em.getTransaction().begin();
				}
				//em.persist(housingApartment);
				updMeal = em.merge(meal);
				em.getTransaction().commit();
				//em.close();
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- updateRecipe(): Error occured: " + ex.getMessage());
				ex.printStackTrace();
			}
			return updMeal;
		}
		else {
			//TODO: Replace me with some kind of logging
			System.out.println(this.getClass().getName() + "-- updateMeal(): Meal equals null -- ");
			return null;
		}
		
	}
}
