package com.myProjects.myRecipe.RecipeWebAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myProjects.myRecipe.application.controler.IngredientControler;
import com.myProjects.myRecipe.domain.Ingredient;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class IncredientAPI {

	@Autowired
	IngredientControler controler;
	
	/**
	 * API interface for adding new ingredient 
	 * url:/recipe/ingredient/add/
	 * @param ing
	 * @return
	 */
	@RequestMapping(value = IngredientRestUriConstants.CREATE_INGREDIENT, method = RequestMethod.POST)
	public @ResponseBody Ingredient addIgredient(@RequestBody Ingredient ing){
		
		
		Ingredient in = controler.addIgredient(ing);
		return in;
	}
	/**
	 * API interface for fetching all ingredients
	 * @return
	 */
	@RequestMapping(value=IngredientRestUriConstants.GET_ALL_INGREDIENTS,method = RequestMethod.GET)
	public @ResponseBody List<Ingredient> getIngredients(){
		
		return controler.getIngredients();
	}
	
	@RequestMapping("/getbymanu")
	public List<Ingredient> getIngredientsByManufacture(String manufacture){
		throw new NotImplementedException();
	}
	@RequestMapping("/delete")
	public void deleteIncredient(Ingredient ing ){
		throw new NotImplementedException();
	}
}
