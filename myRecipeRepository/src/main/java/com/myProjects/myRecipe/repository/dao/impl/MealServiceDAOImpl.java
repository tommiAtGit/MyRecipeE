package com.myProjects.myRecipe.repository.dao.impl;



import java.util.List;

import javax.persistence.Query;

import com.myProjects.myRecipe.domain.Meal;
import com.myProjects.myRecipe.repository.dao.DaoBase;
import com.myProjects.myRecipe.repository.dao.MealServiceDAO;


public class MealServiceDAOImpl extends DaoBase implements MealServiceDAO{


	public MealServiceDAOImpl(String persistenceUnit) {
		super(persistenceUnit);

	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO#saveMeal(com.myProjects.myRecipe.domain.Meal)
	 */
	public Meal saveMeal(Meal meal){
		if (meal != null) {
			try {
				if(!em.getTransaction().isActive()) {
					em.getTransaction().begin();
				}
				em.persist(meal);
				em.getTransaction().commit();
				//em.close();
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- saveMeal(): Error occured: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
		
		return meal;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO#fetchListOf()
	 */
	@SuppressWarnings("unchecked")
	public List<Meal> fetchListOf(){
		List<Meal> mealList = null; 
		Query q  = em.createQuery("from Meal");
		 try {
			 mealList = (List<Meal>) q.getResultList();
		 }
		catch(Exception ex) {
					//TODO: Replace me with some kind of logging
					System.out.println(this.getClass().getName() + "-- fetchListOf(): Error occured: " + ex.getMessage());
					ex.printStackTrace(); 
		}
		return mealList;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO#findMeal(com.myProjects.myRecipe.domain.Meal)
	 */
	public Meal findMeal(Meal meal) {
		Meal fm = null;
		
		if (meal == null) {
			//TODO: Replace me with some kind of logging
			System.out.println(this.getClass().getName() + "-- findMeal(): Meal equals null -- ");
			return null; 
		}
		else {
			try {
				fm =em.find(Meal.class, meal.getId());
			 }
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- findMeal(): Error occured: " + ex.getMessage());
				ex.printStackTrace(); 
			}
			
			return fm;	
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
				} catch (Exception e) {
					//TODO: Replace me with some kind of logging
					System.out.println(this.getClass().getName() + "-- deleteRecipe(): Error occured: " + e.getMessage());
					e.printStackTrace(); 
				}
			}
			else {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- deleteMeal(): No meal found with id: " + meal.getId() + " -- "); 
			}
			
		}
		else {
			//TODO: Replace me with some kind of logging
			System.out.println(this.getClass().getName() + "-- deleteMeal(): Meal equals null -- "); 
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
