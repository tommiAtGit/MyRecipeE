package com.myProjects.myRecipe.application.controler;

import java.util.List;

import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.repository.dao.IngredientServiceDAO;
import com.myProjects.myRecipe.repository.dao.impl.IngredientServiceDAOImpl;



public class IngredientControler {

	private String persistenceUnitName = null;
	private IngredientServiceDAO ingService = null;
	
	public IngredientControler(String persistenceUnitName) {
		this.persistenceUnitName = persistenceUnitName;
		ingService  = new IngredientServiceDAOImpl(this.persistenceUnitName);
	}
	
	public Ingredient addIgredient(Ingredient ing){
		
		Ingredient ingredient = null;
		if (ing != null){
			ingredient = ingService.save(ing);
		}
		return ingredient;
	}
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
	public void deleteIncredient(Ingredient ing ){
		if (ing != null) {
			ingService.removeIngredient(ing);
		}
		
		
		
	}
}
