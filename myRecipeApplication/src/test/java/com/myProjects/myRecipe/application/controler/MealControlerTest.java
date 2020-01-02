package com.myProjects.myRecipe.application.controler;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.myProjects.myRecipe.domain.Meal;

public class MealControlerTest {

	MealControler mealControler = null;
	@Before
	public void setUp() throws Exception {
		mealControler = new MealControler("MYRECIPE_TEST");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveMealNullMeal() {
		
		try {
			mealControler.saveMeal(null);
			fail("There should be exception");
		} catch (Exception Ex) {
			return;
		}
	}
	@Test
	public void testSaveMealEmptyMeal() {
		try {
			mealControler.saveMeal(this.createTestMeal());
			fail("There should be exception");
		} catch (Exception Ex) {
			return;
		}
	}

	@Test
	public void testFetshMelas() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteMeal() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewRecipeToMeal() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveRecipeFromMeal() {
		fail("Not yet implemented");
	}
	
	private Meal createTestMeal() {
		Meal testMeal = new Meal();
		
		
		return testMeal;
	}

}
