package com.myProjects.myRecipe.application.controler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.myProjects.myRecipe.domain.Ingredient;
import com.myProjects.myRecipe.domain.Recipe;
import com.myProjects.myRecipe.domain.RecipeItem;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class RecipeControlerTest {


	private Recipe testRecipe = new Recipe();
	
	private IngredientControler ingredientC = null;
	private RecipeControler recipeC = null;
	
	private static final int MAX_RECIPE_ITEM_COUNT = 4;
	private static final int MIN_RECIPE_ITEM_COUNT = 2;
	
	@Before
	public void setUp() throws Exception {
		ingredientC = new IngredientControler("MYRECIPE_TEST");
		recipeC  = new RecipeControler("MYRECIPE_TEST");
		this.saveIngredients();
		this.createRecipe();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddRecipe() {
		Recipe savedRecipe = null;
		savedRecipe = recipeC.addRecipe(testRecipe);
		assertNotNull("Was null", savedRecipe);
		
		Recipe actualRecipe = recipeC.findRecipe(savedRecipe);
		assertNotNull("Was null", actualRecipe);
		assertEquals(savedRecipe.getName(), actualRecipe.getName());
		assertEquals(savedRecipe.getRecipeItems().size(), actualRecipe.getRecipeItems().size());
		assertEquals(savedRecipe.getRecipeItems().get(1).getIngredient().getName(), actualRecipe.getRecipeItems().get(1).getIngredient().getName());
		
		
	}

	@Ignore
	public void testFindRecipeByName() {
		fail("Not yet implemented");
	}


	@Test
	public void testGetAllRecipes() {
		Recipe savedRecipe = null;
		savedRecipe = recipeC.addRecipe(testRecipe);
		assertNotNull("Was null", savedRecipe);
		
		List <Recipe> actualRecipes = recipeC.getAllRecipes();
		assertNotNull("Was null", actualRecipes);
		assertEquals(actualRecipes.size(),1);
		for (Recipe actualRecipe: actualRecipes) {
			assertEquals(savedRecipe.getName(), actualRecipe.getName());
			assertEquals(savedRecipe.getRecipeItems().size(), actualRecipe.getRecipeItems().size());
			assertEquals(savedRecipe.getRecipeItems().get(1).getIngredient().getName(), actualRecipe.getRecipeItems().get(1).getIngredient().getName());	
		}
		
	}

	@Test
	public void testRemoveRecipe() {
		Recipe savedRecipe = null;
		savedRecipe = recipeC.addRecipe(testRecipe);
		assertNotNull("Was null", savedRecipe);
		
		Recipe actualRecipe = recipeC.findRecipe(savedRecipe);
		assertNotNull("Was null", actualRecipe);
		
		recipeC.removeRecipe(actualRecipe);
		
		Recipe nullRecipe = recipeC.findRecipe(actualRecipe);
		assertNull(nullRecipe);
		
	}

	@Test
	public void testAddResipeItem() {
		Recipe savedRecipe = null;
		RecipeItem item = this.createRecipeItem();
		
		savedRecipe = recipeC.addRecipe(testRecipe);
		assertNotNull("Was null", savedRecipe);
		
		Recipe actualRecipe = recipeC.findRecipe(savedRecipe);
		assertNotNull("Was null", actualRecipe);
		
		recipeC.AddResipeItem(actualRecipe, item);
		
		//int expectedItemCount = actualRecipe.getRecipeItems().size();
		Recipe currentRecipe = recipeC.findRecipe(actualRecipe);
		
		assertEquals(MAX_RECIPE_ITEM_COUNT, currentRecipe.getRecipeItems().size());
		
		
	}

	@Test
	public void testRemoveResipeItem() {
		Recipe savedRecipe = null;
		 
		savedRecipe = recipeC.addRecipe(testRecipe);
		assertNotNull("Was null", savedRecipe);
		
		Recipe actualRecipe = recipeC.findRecipe(savedRecipe);
		assertNotNull("Was null", actualRecipe);
		
		RecipeItem item = actualRecipe.getRecipeItems().get(0);
		
		recipeC.RemoveResipeItem(actualRecipe, item);
		Recipe currentRecipe = recipeC.findRecipe(actualRecipe);
		
		assertEquals(MIN_RECIPE_ITEM_COUNT, currentRecipe.getRecipeItems().size());
		
	}
	private void createRecipe() {

		List<RecipeItem> items = new ArrayList<RecipeItem>();
		
		List<Ingredient> ingedients = ingredientC.getIngredients();
		
		RecipeItem recipeItem = new RecipeItem();
		recipeItem.setIngredient(ingedients.get(0));
		recipeItem.setQuantity(100);
		recipeItem.setRecipe(testRecipe);
		items.add(recipeItem);
		
		RecipeItem recipeItemTwo = new RecipeItem();
		recipeItemTwo.setIngredient(ingedients.get(1));
		recipeItemTwo.setQuantity(15);
		recipeItemTwo.setRecipe(testRecipe);
		items.add(recipeItemTwo);
		
		RecipeItem recipeItemThree = new RecipeItem();
		recipeItemThree.setIngredient(ingedients.get(2));
		recipeItemThree.setQuantity(20);
		recipeItemThree.setRecipe(testRecipe);
		items.add(recipeItemThree);
		
		testRecipe.setName("Fist rescipe");
		testRecipe.setRecipeItems(items);
		
	}
	private RecipeItem createRecipeItem() {
		Ingredient ing  =new Ingredient();
		RecipeItem item = new RecipeItem();
		
		Ingredient ingredientTwo  = new Ingredient();
		ingredientTwo.setEnergy(417);
		ingredientTwo.setCarbonHydrates(1);
		ingredientTwo.setFat(27);
		ingredientTwo.setProtein(72);
		ingredientTwo.setName("Kinkkusuikale");
		ingredientTwo.setCategory("pöö");
		ingredientTwo.setManufacturer("Atria");
		
		item.setIngredient(ingredientTwo);
		item.setQuantity(250);
		item.setRecipe(testRecipe);
		
		return item;
	}
	private void saveIngredients() {
		List<Ingredient>ings = new ArrayList<Ingredient>();
		ings = this.createListOfIncredients();
		
		for (Ingredient ing:ings) {
			Ingredient savedIng = null;
			savedIng = ingredientC.addIgredient(ing);
			assertNotNull("Was null", savedIng);
		}
	}
	private List<Ingredient> createListOfIncredients() {
		List<Ingredient> ings = new ArrayList<Ingredient>();
		
		Ingredient ingredient  = new Ingredient();
		ingredient.setEnergy(32);
		ingredient.setCarbonHydrates(4.9);
		ingredient.setFat(0.1);
		ingredient.setProtein(3.0);
		ingredient.setName("Rasvaton maito");
		ingredient.setCategory("pöö");
		ingredient.setManufacturer("Valio");
		ings.add(ingredient);

		Ingredient ingredientTwo  = new Ingredient();
		ingredientTwo.setEnergy(382);
		ingredientTwo.setCarbonHydrates(60.0);
		ingredientTwo.setFat(7.2);
		ingredientTwo.setProtein(13.0);
		ingredientTwo.setName("Kaurahiutale");
		ingredientTwo.setCategory("pöö");
		ingredientTwo.setManufacturer("Raisio");
		ings.add(ingredientTwo);
		
		Ingredient ingredientThree  = new Ingredient();
		ingredientThree.setEnergy(92);
		ingredientThree.setCarbonHydrates(2.5);
		ingredientThree.setFat(2.0);
		ingredientThree.setProtein(15.8);
		ingredientThree.setName("Raejuusto");
		ingredientThree.setCategory("pöö");
		ingredientThree.setManufacturer("Valio");
		ings.add(ingredientThree);

		return ings;
		
	}
}
