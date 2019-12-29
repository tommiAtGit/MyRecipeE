package com.myProjects.myRecipe.repository.dao;

import java.util.List;

import com.myProjects.myRecipe.domain.Recipe;

public interface RecipeServiceDAO {

	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#saveRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	Recipe saveRecipe(Recipe recipe)throws Exception;

	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#listOf()
	 */
	List<Recipe> listOf()throws Exception;

	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#findRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	Recipe findRecipe(Recipe res)throws Exception;

	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#deleteRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	void deleteRecipe(Recipe recipe)throws Exception;

	/**
	 * Update information of existing recipe
	 * @param recipe
	 * @return
	 */
	Recipe updateRecipe(Recipe recipe)throws Exception;
	
	Recipe findRecipeByName(String argument) throws Exception;

}