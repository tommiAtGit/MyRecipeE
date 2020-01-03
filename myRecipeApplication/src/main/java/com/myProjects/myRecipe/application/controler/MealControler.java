package com.myProjects.myRecipe.application.controler;

import java.util.List;

import com.myProjects.myRecipe.domain.Meal;
import com.myProjects.myRecipe.domain.Recipe;

public interface MealControler {

	/**
	 * Save new meal to database
	 * @param meal
	 * @return
	 * @throws ValidationException 
	 */
	Meal saveMeal(Meal meal);

	List<Meal> fetshMelas();

	/**
	 * Delete selected meal
	 * @param meal
	 */
	void deleteMeal(Meal meal);

	/**
	 * Add new recipe to excising meal
	 * @param meal
	 * @param resipe
	 * @return
	 */
	Meal addNewRecipeToMeal(Meal meal, Recipe resipe);

	/**
	 * Remove recipe from meal
	 * @param meal
	 * @param recipe
	 * @return
	 */
	Meal removeRecipeFromMeal(Meal meal, Recipe recipe);

}