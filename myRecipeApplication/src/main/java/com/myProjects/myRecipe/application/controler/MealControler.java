package com.myProjects.myRecipe.application.controler;


import java.util.List;

import javax.xml.bind.ValidationException;

import org.apache.log4j.Logger;

import com.myProjects.myRecipe.domain.Meal;
import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.repository.dao.MealServiceDAO;
import com.myProjects.myRecipe.repository.dao.impl.MealServiceDAOImpl;

public class MealControler {

	private static final int MEAL_NAME_VALIDATION_ERROR = 1;
	private static final int MEAL_RESIPE_VALIDATION_ERROR = 2;
	private static final int MEAL_QUANTITY_VALIDATION_ERROR = 3;
	static Logger log = Logger.getLogger(MealControler.class.getName());
	private MealServiceDAO mealService = null;


	
	public MealControler(String persistenceUnitName) {
		mealService  = new MealServiceDAOImpl(persistenceUnitName);
	
	}
	
	/**
	 * Save new meal to database
	 * @param meal
	 * @return
	 * @throws ValidationException 
	 */
	public Meal saveMeal(Meal meal ) throws ValidationException{
		log.info("At start of meal save");
		Meal savedMeal = null;
		
		if (meal != null){
			if(this.validateMeal(meal)< 1) {
				savedMeal = mealService.saveMeal(meal);
				return savedMeal;
			}
			else {
				log.error("Meal validatoin error occured");
				throw new ValidationException("Meal argument is null");
			}
			
		}
		else{
			log.error("Agument exception occured. Meal argment is null");
			throw new IllegalArgumentException("Meal argument is null");
		}	
	}
	
	public List<Meal>fetshMelas(){
		log.info("fetch meals...");
		List<Meal> meals = mealService.fetchListOf();
		return meals;
	}

		
	/**
	 * Delete selected meal
	 * @param meal
	 */
	public void deleteMeal(Meal meal) {
		log.info("Delete meal...");
		if (meal != null) {
			mealService.deleteMeal(meal);
		}
		else {
			log.error("Agument exception occured. Meal argment is null");
			throw new IllegalArgumentException("Meal argument is null");
		}
		
	}

	/**
	 * Add new recipe to excising meal
	 * @param meal
	 * @param resipe
	 * @return
	 */
	public Meal addNewRecipeToMeal(Meal meal, Recipe resipe){
		log.info("Add new recipe to the meal...");
		Meal me = null;
		
		if ((meal != null) && (resipe != null)){
			meal.getRecipe().add(resipe);
			me = mealService.updateMeal(meal);
			return me;
		}
		else{
			log.error("Agument exception occured. Meal or recipe argment is null");
			throw new IllegalArgumentException("Meal or recipe argument is null");
		}
		
	}
	
	/**
	 * Remove recipe from meal
	 * @param meal
	 * @param recipe
	 * @return
	 */
	public Meal removeRecipeFromMeal(Meal meal, Recipe recipe) {
		log.info("Remove recipe from the meal");
		Meal me = null;
		if ((meal != null) && (recipe != null)){
			meal.getRecipe().remove(recipe);
			me = mealService.updateMeal(meal);
			return me;
		}
		else{
			log.error("Agument exception occured. Meal argment is null");
			throw new IllegalArgumentException("Meal argument is null");
		}
	}
	private int validateMeal(Meal meal) {
		
		int result = 0;
		if ((meal.getName() == null) || (meal.getName().isEmpty())){
			result = MEAL_NAME_VALIDATION_ERROR;
		}
		else if(meal.getRecipe() == null){
			result = MEAL_RESIPE_VALIDATION_ERROR;
		}
		else if (meal.getQuantity()< 1) {
			result = MEAL_QUANTITY_VALIDATION_ERROR;
		}
		else {
			
		}
		
		return result;
	}
	
}
