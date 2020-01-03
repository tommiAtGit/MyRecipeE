package com.myProjects.myRecipe.application.controler;

import java.util.List;

import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.domain.RecipeItem;

public interface RecipeControler {

	/**
	 * Add new recipe to system
	 * @param recipe
	 * @return
	 * @throws Exception 
	 */
	Recipe addRecipe(Recipe recipe) throws Exception;

	/**
	 * Find recipe using recipe name
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	Recipe findRecipeByName(String name) throws Exception;

	/**
	 * Find single recipe
	 * @param recipe
	 * @return
	 * @throws Exception 
	 */
	Recipe findRecipe(Recipe recipe) throws Exception;

	/**
	 * Get all saved recipes from system
	 * @return
	 * @throws Exception 
	 */
	List<Recipe> getAllRecipes() throws Exception;

	/**
	 * Remove selected recipe
	 * @throws Exception 
	 */
	void removeRecipe(Recipe recipe) throws Exception;

	/**
	 * Add new item to recipe
	 * @param recipe
	 * @param item
	 * @return
	 * @throws Exception 
	 */
	Recipe AddResipeItem(Recipe recipe, RecipeItem item) throws Exception;

	/**
	 * Remove selected item from recipe
	 * @param recipe
	 * @param item
	 * @return
	 * @throws Exception 
	 */
	Recipe RemoveResipeItem(Recipe recipe, RecipeItem item) throws Exception;

}