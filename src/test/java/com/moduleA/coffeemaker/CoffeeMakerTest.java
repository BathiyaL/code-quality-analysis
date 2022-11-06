package com.moduleA.coffeemaker;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.moduleA.coffeemaker.exceptions.InventoryException;
import com.moduleA.coffeemaker.exceptions.RecipeException;

public class CoffeeMakerTest {

	/*
	 * Test addRecipe()
	 */
	
	// all posible cases of CoffeeMaker.addRecipe are tested under CoffeeMakerTest
	@Test()
	public void addRecipe_ValidRecipe_RrturnTrue(){
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		
		CoffeeMaker cm = new CoffeeMaker();
		assertEquals(cm.addRecipe(recipe), true);
	}
	
	@Test()
	public void deleteRecipe_ValidRecipePosition_RrturnTrue(){
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		
		CoffeeMaker cm = new CoffeeMaker();
		cm.addRecipe(recipe);
		assertEquals(cm.deleteRecipe(0), "MyRecipe");
	}
	
	/*
	 * Test editRecipe(Recipe r)
	 */
	@Test()
	public void editRecipe_ValidRecipePosition_ReturnEditedRecipeName() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		
		Recipe editedRecipe = new Recipe();
		editedRecipe.setName("MyEditedRecipe");
				
		CoffeeMaker cm = new CoffeeMaker();
		cm.addRecipe(recipe);
		
		assertEquals(cm.editRecipe(0,editedRecipe),"MyEditedRecipe");
	}
	
//	@Test()
//	public void addInventory_ValidRecipe_RrturnCheckInventory() throws InventoryException{
//		Recipe recipe = new Recipe();
//		recipe.setName("MyRecipe");
//		
//		CoffeeMaker cm = new CoffeeMaker();
//		cm.addInventory("4","3","2","1");
//		assertEquals(cm.checkInventory(), "");
//	}
}
