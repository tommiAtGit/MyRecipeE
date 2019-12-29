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


public class IngredientControlerTest {

	private IngredientControler ingredientC = null;
	@Before
	public void setUp() throws Exception {
		ingredientC = new IngredientControler("MYRECIPE_TEST");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void  addIgredientTest(){
		Ingredient actualIng = null;
		Ingredient savedIng = null;
	
		try {
			savedIng = ingredientC.addIgredient(this.createIngredient());
		} catch (Exception e) {
			
		}
		assertNotNull("Was null", savedIng);
		savedIng.setId(1);
		actualIng = ingredientC.getIngredient(savedIng);
		assertEquals(savedIng.getName(), actualIng.getName());
		assertEquals(savedIng.getManufacturer(), actualIng.getManufacturer());
	}
	
	@Test
	public void getIngredients(){
		List <Ingredient> actualIngs = null;
		List <Ingredient> ings = this.createListOfIncredients();
		for (Ingredient ing:ings) {
			Ingredient savedIng = null;
			savedIng = ingredientC.addIgredient(ing);
			assertNotNull("Was null", savedIng);
		}
		
		actualIngs = ingredientC.getIngredients();
		assertNotNull("The list was null", actualIngs);
		assertEquals(actualIngs.size(),3);
		assertEquals(actualIngs.get(0).getName(), ings.get(0).getName());
		assertEquals(actualIngs.get(0).getManufacturer(), ings.get(0).getManufacturer());
		assertEquals(actualIngs.get(1).getName(), ings.get(1).getName());
		assertEquals(actualIngs.get(1).getManufacturer(), ings.get(1).getManufacturer());
		
		Ingredient testI = null;
		try {
			testI = ingredientC.getIngredient(actualIngs.get(1));
		} catch (Exception e) {
			fail("Exception occured");
		}
		assertNotNull("Was null", testI);
		
	}
	@Test
	public void getIngredientsNullArgument() {
		Ingredient testI = null;
		try {
			testI = ingredientC.getIngredient(null);
			fail("Exception occured");
		} catch (Exception e) {
			assertNull("Should be null", testI);
		}
	}
	
	@Test
	public void deleteIncredient(){
		List <Ingredient> actualIngs = null;
		List <Ingredient> ings = this.createListOfIncredients();
		for (Ingredient ing:ings) {
			Ingredient savedIng = null;
			savedIng = ingredientC.addIgredient(ing);
			assertNotNull("Was null", savedIng);
		}
		
		actualIngs = ingredientC.getIngredients();
		assertNotNull("The list was null", actualIngs);
		assertEquals(actualIngs.size(),3);
		assertEquals(actualIngs.get(0).getName(), ings.get(0).getName());
		assertEquals(actualIngs.get(0).getManufacturer(), ings.get(0).getManufacturer());
		assertEquals(actualIngs.get(1).getName(), ings.get(1).getName());
		assertEquals(actualIngs.get(1).getManufacturer(), ings.get(1).getManufacturer());
		
		try {
			ingredientC.deleteIncredient(actualIngs.get(1));
		} catch (Exception e) {
			fail("Exception occured");
		}
		Ingredient testI = ingredientC.getIngredient(actualIngs.get(1));
		assertNull("Was Not null", testI);
	}
	@Test
	public void deleteIncredientNullArgument() {
		Ingredient ing = null;
		try {
			ingredientC.deleteIncredient(ing);
			fail();
		}
		catch(Exception Ex) {
			return;
		}
	}
	@Ignore
	//@Test
	public void getIngredientsByManufactureTest() {
		List <Ingredient> actualIngs = null;
		List<Ingredient>manufacLst = null;
		
		//Create and save ingredients
		List <Ingredient> ings = this.createListOfIncredients();
		for (Ingredient ing:ings) {
			Ingredient savedIng = null;
			savedIng = ingredientC.addIgredient(ing);
			assertNotNull("Some error occured while saving ingredient. Was null", savedIng);
		}
		
		actualIngs = ingredientC.getIngredients();
		assertNotNull("The list was null", actualIngs);
		assertEquals(actualIngs.size(),3);
		
		manufacLst = ingredientC.getIngredientsByManufacture("Valio");
		assertEquals(manufacLst.size(),2);
		
	}
	
	
	private Ingredient createIngredient() {
		Ingredient ingredient  = new Ingredient();
		ingredient.setEnergy(32);
		ingredient.setCarbonHydrates(4.9);
		ingredient.setFat(0.1);
		ingredient.setProtein(3.0);
		ingredient.setName("Rasvaton maito");
		ingredient.setCategory("pöö");
		ingredient.setManufacturer("Valio");
		
		return ingredient;
		
		
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
