package com.myProjects.myRecipe.application.controler;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.domain.RecipeItem;
import com.myProjects.myRecipe.repository.dao.RecipeServiceDAO;
import com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAOImpl;

public class RecipeControler {

	
	private RecipeServiceDAO recipeService = null;
	static Logger log = Logger.getLogger(RecipeControler.class.getName());
	
	private static final int RESIPE_NAME_VALIDATION_ERROR = 1;
	private static final int RESIPE_ITEM_VALIDATION_ERROR = 2;
	
	public RecipeControler(String persistenceUnitName) {
		recipeService  = new RecipeServiceDAOImpl(persistenceUnitName);
	}
	/**
	 * Add new recipe to system
	 * @param recipe
	 * @return
	 * @throws Exception 
	 */
	public Recipe addRecipe(Recipe recipe) throws Exception{
		
		log.info("Adding new recipe...");
		Recipe returnRes = null;
		if (recipe != null) {
			if (this.ValidateRecipe(recipe)> 0) {
				log.error("Recipe validaton error occured");
				throw new Exception("Recipe validaton error occured");
			}
			returnRes = recipeService.saveRecipe(recipe);
			return returnRes;
		}
		else {
			log.error("Agument exception occured: Recipe is null");
			throw new IllegalArgumentException("Recipe argument is null");
		}
		
	}
	
	/**
	 * Find recipe using recipe name
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	public Recipe findRecipeByName(String name) throws Exception{
		Recipe recipe = null;
		log.info("finding recipe by name");
		
		if ((!name.isEmpty()) && (name != null)) {
			try {
				recipe = recipeService.findRecipeByName(name);
			} catch (Exception e) {
				log.error("Errror occured while finding recipe by name: " + e.getMessage());
				throw e;
				
			} 
			return recipe;
		}
		else {
			log.error("Agument exception occured: Recipe is null");
			throw new IllegalArgumentException("Recipe argument is null");
		}
		
	}
	
	/**
	 * Find single recipe
	 * @param recipe
	 * @return
	 * @throws Exception 
	 */
	public Recipe findRecipe(Recipe recipe) throws Exception {
		Recipe rc = null;
		log.info("Finding recipe:");
		if (recipe != null) {
			try {
				rc = recipeService.findRecipe(recipe);
			} catch (Exception e) {
				log.error("Errror occured while finding recipe by name: " + e.getMessage());
				throw e;
			}
			return rc;
		}
		else {
			log.error("Agument exception occured: Recipe is null");
			throw new IllegalArgumentException("Recipe argument is null");
		}
		
	}
	
	/**
	 * Get all saved recipes from system
	 * @return
	 * @throws Exception 
	 */
	public List<Recipe>getAllRecipes() throws Exception{
		List<Recipe>rcs = new ArrayList<Recipe>();
		try {
			rcs = recipeService.listOf();
		} catch (Exception e) {
			log.error("Errror occured while fetching list of recipes: " + e.getMessage());
			throw e;
		}
		return rcs;
	}
	
	/**
	 * Remove selected recipe
	 * @throws Exception 
	 */
	public void removeRecipe(Recipe recipe) throws Exception {
		if (recipe != null) {
			try {
				recipeService.deleteRecipe(recipe);
			} catch (Exception e) {
				log.error("Errror occured while removeing recipe: " + e.getMessage());
				throw e;
			}
		}
	}
	
	/**
	 * Add new item to recipe
	 * @param recipe
	 * @param item
	 * @return
	 * @throws Exception 
	 */
	public Recipe AddResipeItem(Recipe recipe, RecipeItem item) throws Exception {
		Recipe updateRes = null;
		if(recipe != null && item != null) {
			recipe.getRecipeItems().add(item);
			try {
				updateRes = recipeService.updateRecipe(recipe);
			} catch (Exception e) {
				log.error("Errror occured while adding new recipe item: " + e.getMessage());
				throw e;
			}
			return updateRes;
		}
		else {
			log.error("Agument exception occured: Recipe is null");
			throw new IllegalArgumentException("Recipe arguments is null");
			
		}
		
	}
	
	/**
	 * Remove selected item from recipe
	 * @param recipe
	 * @param item
	 * @return
	 * @throws Exception 
	 */
	public Recipe RemoveResipeItem(Recipe recipe, RecipeItem item) throws Exception {
		Recipe updateRes = null;
		if(recipe != null && item != null) {
			recipe.getRecipeItems().remove(item);
			try {
				updateRes = recipeService.updateRecipe(recipe);
			} catch (Exception e) {
				log.error("Errror occured while removing recipe item: " + e.getMessage());
				throw e;
			}
			return updateRes;
		}
		else {
			log.error("Agument exception occured: Recipe is null");
			throw new IllegalArgumentException("Recipe arguments is null");
		}
		
	}
	private int ValidateRecipe(Recipe recipe) {
		
		if (recipe.getName().isEmpty()) {
			log.error("Validatoin error: Recipe don't have name");
			return RESIPE_NAME_VALIDATION_ERROR;
		}
		else if (recipe.getRecipeItems().size() < 1) {
			log.error("Validatoin error: Recipe don't have any items");
			return RESIPE_ITEM_VALIDATION_ERROR;
		}
		else {
			return 0;
		}
	}
}
