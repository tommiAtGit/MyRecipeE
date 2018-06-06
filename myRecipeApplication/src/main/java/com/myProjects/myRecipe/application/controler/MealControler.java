package com.myProjects.myRecipe.application.controler;


import java.util.ArrayList;
import java.util.List;

import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.domain.Meal;
import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.domain.RecipeItem;
import com.myProjects.myRecipe.repository.dao.impl.MealServiceDAO;

public class MealControler {

	private Meal myMeal = null;
	private MealServiceDAO service = null;

	public Meal constructMeal(String name, int quatity ){
		myMeal.setName(name);
		myMeal.setQuatity(quatity);
		
		return myMeal;
	}
	public Meal addRecipe(Recipe res){
		if (myMeal == null){
			List<Recipe> recipesForNew = new ArrayList<Recipe>();
			recipesForNew.add(res);
			
		}
		else{
			List <Recipe> recipes =  myMeal.getRecipe();
			recipes.add(res);
			//myMeal.setRecipe(recipes);
		}
		return myMeal;
	}
	
	public Meal saveMeal(Meal meal ){

		Meal savedMeal = null;
		if (meal != null){
			service.save(meal);
			savedMeal = service.getMealWithName(meal);
			return savedMeal;
		}
		else{
			return null;
		}
		
	}
	public void calculateMacros(Meal meal){
		List <Recipe> recipes =  meal.getRecipe();
		List <RecipeItem> recipeItems = recipes.get(0).getRecipeItems();
		
		
		Ingredient ingredient = recipeItems.get(0).getIngredient();
		double incredientQantity = recipeItems.get(0).getQuantity();
		ingredient.getCarbonHydrates();
		
		
	}
}
