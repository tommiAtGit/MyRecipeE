package com.myProjects.myRecipe.repository.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.repository.dao.DaoBase;
import com.myProjects.myRecipe.repository.dao.RecipeServiceDAO;

public class RecipeServiceDAOImpl extends DaoBase implements RecipeServiceDAO {

	public RecipeServiceDAOImpl(String persistenceUnit) {
		super(persistenceUnit);
		
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#saveRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#saveRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	public Recipe saveRecipe(Recipe recipe) {
		
		if (recipe != null) {
			try {
				if(!em.getTransaction().isActive()) {
					em.getTransaction().begin();
				}
				em.persist(recipe);
				em.getTransaction().commit();
				//em.close();
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- saveRecipe(): Error occured: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
		return recipe;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#listOf()
	 */
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#listOf()
	 */
	@SuppressWarnings("unchecked")
	public List<Recipe> listOf() {
		List<Recipe> recipeList = null; 
		Query q  = em.createQuery("from Recipe");
		 try {
			 recipeList = (List<Recipe>) q.getResultList();
		 }
		catch(Exception ex) {
					//TODO: Replace me with some kind of logging
					System.out.println(this.getClass().getName() + "-- fetchListOf(): Error occured: " + ex.getMessage());
					ex.printStackTrace(); 
		}
		return recipeList;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#findRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#findRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	public Recipe findRecipe(Recipe res) {
		
		Recipe recipe = null;
		
		 try {
			recipe =em.find(Recipe.class, res.getID());
		 }
		catch(Exception ex) {
					//TODO: Replace me with some kind of logging
					System.out.println(this.getClass().getName() + "-- findIngredient(): Error occured: " + ex.getMessage());
					ex.printStackTrace(); 
		}
		
		return recipe;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#deleteRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#deleteRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	public void deleteRecipe(Recipe recipe) {
		if(recipe != null) {
			Recipe res = em.find(Recipe.class, recipe.getID());
			if (res != null) {
				try {
					em.getTransaction().begin();
					em.remove(res);
					em.getTransaction().commit();
				} catch (Exception e) {
					System.out.println(this.getClass().getName() + "-- deleteRecipe(): Error occured: " + e.getMessage());
					e.printStackTrace(); 
				}
			}
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#updateRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	public Recipe updateRecipe(Recipe recipe) {
		Recipe updRecipe = null;
		
		if (recipe != null) {
			try {
				if(!em.getTransaction().isActive()) {
					em.getTransaction().begin();
				}
				//em.persist(housingApartment);
				updRecipe = em.merge(recipe);
				em.getTransaction().commit();
				//em.close();
			}
			catch(Exception ex) {
				//TODO: Replace me with some kind of logging
				System.out.println(this.getClass().getName() + "-- updateRecipe(): Error occured: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
		return updRecipe;
	}
	
	
}
