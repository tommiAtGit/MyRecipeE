package com.myProjects.myRecipe.application.controler.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.myProjects.myRecipe.application.controler.IngredientControler;
import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.repository.dao.IngredientServiceDAO;
import com.myProjects.myRecipe.repository.dao.impl.IngredientServiceDAOImpl;



public class IngredientControlerImpl implements IngredientControler {
	static Logger log = Logger.getLogger(IngredientControlerImpl.class.getName());
	
	private IngredientServiceDAO ingService = null;
	
	public IngredientControlerImpl(String persistenceUnitName) {
		ingService  = new IngredientServiceDAOImpl(persistenceUnitName);
	}
	/**
	 * Add new ingredient to system
	 * url: /recipe/ingredient/add
	 * @param ing
	 * @return
	 */
	@Override
	public  Ingredient addIgredient(Ingredient ing){
		
		Ingredient ingredient = null;
		if (ing != null){
			try {
				ingredient = ingService.save(ing);
			} catch (Exception e) {
				log.error("Error occured while saving new ingradiet");
				
			}
			log.info("New ingradinet saved: " + ing.getName());
			return ingredient;
		}
		else {
			
			throw new IllegalArgumentException("Ingedient has value of null");
		}
		
	}
	
	/**
	 * Return list of ingredients
	 * @return
	 */

	@Override
	public List<Ingredient> getIngredients(){
		List<Ingredient>ingredientItems = null;
		try {
			ingredientItems = ingService.fetchListOf();
		} catch (Exception e) {
			log.error("Error occured while fetching lit of Ingredient: " + e.getMessage());
					}
		return ingredientItems;
	}
	
	/**
	 * 
	 * @param ingredient
	 * @return
	 */
	@Override
	public Ingredient getIngredient(Ingredient ingredient ){
		Ingredient ing = null;
		
		if (ingredient != null) {
			try {
				ing = ingService.findIngredient(ingredient);
			} catch (Exception e) {
				log.error("Error occured while fetching ingredinet " + e.getMessage());
			}
			return ing;
		}
		else {
			throw new IllegalArgumentException("Error ocured in arguments");
		}
		
	}
	/**
	 * Return list of ingredient sorted by manufacture
	 * @param manufacture
	 * @return
	 */
	@Override
	public List<Ingredient> getIngredientsByManufacture(String manufacture){
		List<Ingredient> mf = null;
		if ((!manufacture.isEmpty()) && (manufacture != null)) {
			try {
				mf = ingService.findByManufacture(manufacture);
			} catch (Exception e) {
				log.error("Error occured while fetching ingredinet by manufacture " + e.getMessage());
			}
			return mf;
		}
		else {
			throw new IllegalArgumentException("Error ocured in arguments");
			
		}
		
	}
	
	/**
	 * Delete selected incredient
	 * @param ing
	 */
	@Override
	public void deleteIncredient(Ingredient ing ){
		if (ing != null) {
			try {
				ingService.removeIngredient(ing);
			} catch (Exception e) {
				log.error("Error occured while deleting ingradient " + e.getMessage());
			
			}
		}
		else {
			throw new IllegalArgumentException("Ingredient was null");
		}
	}
}
