package com.myProjects.myRecipe.repository.dao;

import java.util.List;

import com.myProjects.myRecipe.domain.Ingredient;

public interface IngredientServiceDAO {

	/**
	 * Save ingredinet information to database 
	 * @param ing
	 * @return
	 */
	Ingredient save(Ingredient ing);

	/**
	 * Fetsh list of ingredients
	 * @return
	 */
	List<Ingredient> fetchListOf();

	/**
	 * Remove selected ingredient
	 * @param ing
	 */
	void removeIngredient(Ingredient ing);
	
	Ingredient findIngredient(Ingredient ing);
	List<Ingredient> findByManufacture(String manafacturer);

}