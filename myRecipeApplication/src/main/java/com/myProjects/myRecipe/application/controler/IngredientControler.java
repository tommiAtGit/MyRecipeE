package com.myProjects.myRecipe.application.controler;

import java.util.List;

import org.apache.log4j.Logger;

import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.repository.dao.IngredientServiceDAO;
import com.myProjects.myRecipe.repository.dao.impl.IngredientServiceDAOImpl;



public class IngredientControler {
	static Logger log = Logger.getLogger(IngredientControler.class.getName());
	
	private IngredientServiceDAO ingService = null;
	
	public IngredientControler(String persistenceUnitName) {
		ingService  = new IngredientServiceDAOImpl(persistenceUnitName);
	}
	/**
	 * Add new ingredient to system
	 * @param ing
	 * @return
	 */
	public Ingredient addIgredient(Ingredient ing){
		
		Ingredient ingredient = null;
		if (ing != null){
			ingredient = ingService.save(ing);
			log.info("New ingradinet saved: " + ing.getName());
			return ingredient;
		}
		else {
			
			throw new IllegalArgumentException("Ingedient has value of null");
		}
		
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Ingredient> getIngredients(){
		List<Ingredient>ingredientItems = null;
		ingredientItems = ingService.fetchListOf();
		return ingredientItems;
	}
	
	public Ingredient getIngredient(Ingredient ingredient ){
		Ingredient ing = null;
		
		if (ingredient != null) {
			ing = ingService.findIngredient(ingredient);
		}
		
		return ing;
		
	}
	public List<Ingredient> getIngredientsByManufacture(String manufacture){
		List<Ingredient> mf = null;
		if (!manufacture.isEmpty() || manufacture != null) {
			mf = ingService.findByManufacture(manufacture);
		}
		return mf;
	}
	public void deleteIncredient(Ingredient ing ){
		if (ing != null) {
			ingService.removeIngredient(ing);
		}
	}
}
