package com.myProjects.myRecipe.repository.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.repository.dao.DaoBase;
import com.myProjects.myRecipe.repository.dao.RecipeServiceDAO;

public class RecipeServiceDAOImpl extends DaoBase implements RecipeServiceDAO {

	static Logger log = Logger.getLogger(RecipeServiceDAOImpl.class.getName());
	
	public RecipeServiceDAOImpl(String persistenceUnit) {
		super(persistenceUnit);
		
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#saveRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	public Recipe saveRecipe(Recipe recipe) throws Exception {
		
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
				log.error("Error occured while saving resipe:" + ex.getMessage());
				throw ex;
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
	public List<Recipe> listOf() throws Exception {
		List<Recipe> recipeList = null; 
		Query q  = em.createQuery("from Recipe");
		 try {
			 recipeList = (List<Recipe>) q.getResultList();
		 }
		catch(Exception ex) {
			log.error("Error occured while fetching list of recipes" + ex.getMessage());
			throw ex;
		}
		return recipeList;
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#findRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	public Recipe findRecipe(Recipe res) throws Exception {
		
		Recipe recipe = null;
		
		 try {
			recipe =em.find(Recipe.class, res.getID());
		 }
		catch(Exception ex) {
			log.error("Error occured while finding resipe:" + ex.getMessage());
			throw ex;
		}
		
		return recipe;
	}
	

	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#deleteRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	public void deleteRecipe(Recipe recipe) throws Exception {
		if(recipe != null) {
			Recipe res = em.find(Recipe.class, recipe.getID());
			if (res != null) {
				try {
					em.getTransaction().begin();
					em.remove(res);
					em.getTransaction().commit();
				} catch (Exception ex) {
					log.error("Error occured while finding resipe:" + ex.getMessage());
					throw ex; 
				}
			}
			
		}
	}
	
	/* (non-Javadoc)
	 * @see com.myProjects.myRecipe.repository.dao.impl.RecipeServiceDAO#updateRecipe(com.myProjects.myRecipe.domain.Recipe)
	 */
	public Recipe updateRecipe(Recipe recipe) throws Exception {
		Recipe updRecipe = null;
		
		if (recipe != null) {
			try {
				if(!em.getTransaction().isActive()) {
					em.getTransaction().begin();
				}
				updRecipe = em.merge(recipe);
				em.getTransaction().commit();
				
			}
			catch(Exception ex) {
				log.error("Error occured while updateing recipe:" + ex.getMessage());
				throw ex;
			}
		}
		return updRecipe;
	}
	public Recipe findRecipeByName(String argument) throws Exception {
		Recipe fndRecipe = null;
		try {
			Query q  = em.createQuery("select arg from Recipe r where r.name = :argument");
			q.setParameter("name", argument);
			fndRecipe = (Recipe) q.getResultList();
		}
		catch(Exception ex) {
			log.error("Error occured while updateing recipe:" + ex.getMessage());
			throw ex;
		}
		return fndRecipe;
	}
	
	
}
