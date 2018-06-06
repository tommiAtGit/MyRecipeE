package com.myProjects.myRecipe.application.controler;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myProjects.myRecipe.domain.Ingredient;

public class IngredientControlerTest {

	@Autowired
	private Ingredient ingredient;
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
		fail("Not implemented");
	}
	
	@Test
	public void getIngredients(){
		fail("Not implemented");
	}
	
	@Test
	public void getIngredientTest(){
		fail("Not implemented");
	}
	
	@Test
	public void deleteIncredient(){
		fail("Not implemented");
	}
	
	private void createIcredient() {
		
	}

}
