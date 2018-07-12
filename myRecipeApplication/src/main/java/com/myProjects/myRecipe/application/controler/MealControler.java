package com.myProjects.myRecipe.application.controler;


import java.util.ArrayList;
import java.util.List;

import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.domain.Meal;
import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.domain.RecipeItem;
import com.myProjects.myRecipe.repository.dao.MealServiceDAO;
import com.myProjects.myRecipe.repository.dao.RecipeServiceDAO;
import com.myProjects.myRecipe.repository.dao.impl.MealServiceDAOImpl;
import com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAOImpl;

public class MealControler {

	
	private MealServiceDAO mealService = null;


	
	public MealControler(String persistenceUnitName) {
		mealService  = new MealServiceDAOImpl(persistenceUnitName);
	
	}
	
	/**
	 * Save new meal to database
	 * @param meal
	 * @return
	 */
	public Meal saveMeal(Meal meal ){

		Meal savedMeal = null;
		if (meal != null){
			savedMeal = mealService.saveMeal(meal);
			return savedMeal;
		}
		else{
			return null;
		}	
	}
	
	public List<Meal>fetshMelas(){
		List<Meal> meals = mealService.fetchListOf();
		return meals;
	}

		
	/**
	 * Delete selected meal
	 * @param meal
	 */
	public void deleteMeal(Meal meal) {
		if (meal != null) {
			mealService.deleteMeal(meal);
		}
		
	}

	/**
	 * Add new recipe to excising meal
	 * @param meal
	 * @param resipe
	 * @return
	 */
	public Meal addNewRecipeToMeal(Meal meal, Recipe resipe){
		Meal me = null;
		
		if ((meal != null) && (resipe != null)){
			meal.getRecipe().add(resipe);
			me = mealService.updateMeal(meal);
			return me;
		}
		else{
			return null;
		}
		
	}
	
	/**
	 * Remove recipe from meal
	 * @param meal
	 * @param recipe
	 * @return
	 */
	public Meal removeRecipeFromMeal(Meal meal, Recipe recipe) {
		Meal me = null;
		if ((meal != null) && (recipe != null)){
			meal.getRecipe().remove(recipe);
			me = mealService.updateMeal(meal);
			return me;
		}
		else{
			return null;
		}
	}
	
}
