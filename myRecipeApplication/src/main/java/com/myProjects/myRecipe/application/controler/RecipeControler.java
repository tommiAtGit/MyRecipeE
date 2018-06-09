package com.myProjects.myRecipe.application.controler;


import java.util.ArrayList;
import java.util.List;

import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.domain.RecipeItem;
import com.myProjects.myRecipe.repository.dao.RecipeServiceDAO;
import com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAOImpl;

public class RecipeControler {

	private RecipeServiceDAO recipeService = null;
	
	public RecipeControler(String persistenceUnitName) {
		recipeService  = new RecipeServiceDAOImpl(persistenceUnitName);
	}
	/**
	 * Add new recipe to system
	 * @param recipe
	 * @return
	 */
	public Recipe addRecipe(Recipe recipe){
		
		Recipe returnRes = null;
		if (recipe != null) {
			returnRes = recipeService.saveRecipe(recipe);
		}
		return returnRes;
	}
	
	/**
	 * Find recipe using recipe name
	 * @param name
	 * @return
	 */
	public Recipe findRecipeByName(String name){
		Recipe recipe = null;
		return recipe;
	}
	
	/**
	 * Find single recipe
	 * @param recipe
	 * @return
	 */
	public Recipe findRecipe(Recipe recipe) {
		Recipe rc = null;
		if (recipe != null) {
			rc = recipeService.findRecipe(recipe);
		}
		return rc;
	}
	
	/**
	 * Get all saved recipes from system
	 * @return
	 */
	public List<Recipe>getAllRecipes(){
		List<Recipe>rcs = new ArrayList<Recipe>();
		rcs = recipeService.listOf();
		return rcs;
	}
	
	/**
	 * Remove selected recipe
	 */
	public void removeRecipe(Recipe recipe) {
		if (recipe != null) {
			recipeService.deleteRecipe(recipe);
		}
	}
	
	/**
	 * Add new item to recipe
	 * @param recipe
	 * @param item
	 * @return
	 */
	public Recipe AddResipeItem(Recipe recipe, RecipeItem item) {
		Recipe updateRes = null;
		if(recipe != null && item != null) {
			recipe.getRecipeItems().add(item);
			updateRes = recipeService.updateRecipe(recipe);
		}
		return updateRes;
	}
	
	/**
	 * Remove selected item from recipe
	 * @param recipe
	 * @param item
	 * @return
	 */
	public Recipe RemoveResipeItem(Recipe recipe, RecipeItem item) {
		Recipe updateRes = null;
		if(recipe != null && item != null) {
			recipe.getRecipeItems().remove(item);
			updateRes = recipeService.updateRecipe(recipe);
		}
		return updateRes;
	}
}
