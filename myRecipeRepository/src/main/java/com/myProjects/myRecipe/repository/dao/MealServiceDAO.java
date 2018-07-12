package com.myProjects.myRecipe.repository.dao;

import java.util.List;

import com.myProjects.myRecipe.domain.Meal;

public interface MealServiceDAO {

	/**
	 * Save the meal
	 * @param meal
	 */
	Meal saveMeal(Meal meal);

	/**
	 * Get list of saved meals
	 * @return
	 */
	List<Meal> fetchListOf();

	Meal findMeal(Meal meal);

	/**
	 * Delete selected meal
	 * @param meal
	 */
	void deleteMeal(Meal meal);

	/**
	 * Update content of selected meal
	 * @param meal
	 * @return
	 */
	Meal updateMeal(Meal meal);

}