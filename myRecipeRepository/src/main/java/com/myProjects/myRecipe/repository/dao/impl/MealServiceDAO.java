package com.myProjects.myRecipe.repository.dao.impl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.myProjects.myRecipe.domain.Meal;


public class MealServiceDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Meal meal){
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(meal);
        tx.commit();
        session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Meal> fetchListOf(){
		 Session session = this.sessionFactory.openSession();
	        List<Meal> mealList = session.createQuery("from Meal").list();
	        session.close();
	        return mealList;
	}
	public Meal getMealWithName(Meal theMeal){

		if(theMeal.getName() == null){
			return null;
		}
		else{
			Session session = this.sessionFactory.openSession();
			Meal thisMeal = (Meal)session.createQuery("from Meal where Meal_Name = 'theMeal.getName()' ");
			session.close();
			return thisMeal;
		}
	}
	public Meal getMeal(Meal meal){
		long mealId = 0;
		if (meal.getId() > 0){
			mealId = meal.getId();
		}
		else{
			return null;
		}
			
		 Session session = this.sessionFactory.openSession();
	        Meal theMeal = (Meal)session.createQuery("from Meal where Meal_ID = ' mealId' ");
	        session.close();
	        return theMeal;
	}
}
