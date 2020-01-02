package com.myProjects.myRecipe.repository.dao;

import java.util.List;

import com.myProjects.myRecipe.domain.Ingredient;

public interface IngredientServiceDAO {

	/**
	 * Save ingredinet information to database 
	 * @param ing
	 * @return
	 */
	Ingredient save(Ingredient ing) throws Exception;

	/**
	 * Fetsh list of ingredients
	 * @return
	 */
	List<Ingredient> fetchListOf()throws Exception;

	/**
	 * Remove selected ingredient
	 * @param ing
	 */
	void removeIngredient(Ingredient ing)throws Exception;
	/**
	 * 
	 * @param ing
	 * @return
	 * @throws Exception
	 */
	Ingredient findIngredient(Ingredient ing)throws Exception;
	/**
	 * 
	 * @param manafacturer
	 * @return
	 * @throws Exception
	 */
	List<Ingredient> findByManufacture(String manafacturer)throws Exception;

}