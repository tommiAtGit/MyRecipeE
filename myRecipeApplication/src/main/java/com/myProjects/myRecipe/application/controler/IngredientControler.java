package com.myProjects.myRecipe.application.controler;

import java.util.List;

import com.myProjects.myRecipe.domain.Ingredient;

public interface IngredientControler {

	/**
	 * Add new ingredient to system
	 * url: /recipe/ingredient/add
	 * @param ing
	 * @return
	 */
	Ingredient addIgredient(Ingredient ing);

	/**
	 * Return list of ingredients
	 * @return
	 */

	List<Ingredient> getIngredients();

	/**
	 * 
	 * @param ingredient
	 * @return
	 */
	Ingredient getIngredient(Ingredient ingredient);

	/**
	 * Return list of ingredient sorted by manufacture
	 * @param manufacture
	 * @return
	 */
	List<Ingredient> getIngredientsByManufacture(String manufacture);

	/**
	 * Delete selected incredient
	 * @param ing
	 */
	void deleteIncredient(Ingredient ing);

}