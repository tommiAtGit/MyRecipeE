package com.myProjects.myRecipe.repository.dao;

import java.util.List;

import com.myProjects.myRecipe.domain.Meal;

public interface MealServiceDAO {

	/**
	 * Save the meal
	 * @param meal
	 */
	Meal saveMeal(Meal meal) throws Exception;


	/**
	 * Get list of saved meals
	 * @return
	 */
	List<Meal> fetchListOf()throws Exception;

	Meal findMeal(Meal meal)throws Exception;

	/**
	 * Delete selected meal
	 * @param meal
	 */
	void deleteMeal(Meal meal)throws Exception;

	/**
	 * Update content of selected meal
	 * @param meal
	 * @return
	 */
	Meal updateMeal(Meal meal)throws Exception;

}