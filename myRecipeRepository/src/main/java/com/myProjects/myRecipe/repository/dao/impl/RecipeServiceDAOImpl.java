package com.myProjects.myRecipe.repository.dao.impl;

import java.util.List;

import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.repository.dao.DaoBase;

public class RecipeServiceDAOImpl extends DaoBase {

	public RecipeServiceDAOImpl(String persistenceUnit) {
		super(persistenceUnit);
		
	}
	
	/**
	 * Save new recipe to system
	 * @param recipe
	 * @return
	 */
	public Recipe saveRecipe(Recipe recipe) {
		Recipe newRecipe = null;
		
		return newRecipe;
	}
	
	/**
	 * Return list of recipes
	 * @return
	 */
	public List<Recipe> listOf() {
		List<Recipe> listOf = null;
		
		return listOf;
	}
	
	/**
	 * Find single recipe
	 * @param res
	 * @return
	 */
	public Recipe findRecipe(Recipe res) {
		Recipe recipe = null;
		
		return recipe;
	}
	
	/**
	 * Delete selected recipe
	 * @param recipe
	 */
	public void deleteRecipe(Recipe recipe) {
		
	}
	
}
