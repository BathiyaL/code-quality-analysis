package com.moduleA.coffeemaker;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.moduleA.coffeemaker.exceptions.RecipeException;

public class RecipeBookTest {

	/*
	 * Test getRecipes()
	 */
	@Test()
	public void getRecipes_DefaultSize_Rrturn4() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		
		RecipeBook rb= new RecipeBook();
		rb.addRecipe(recipe);
		assertEquals(4, rb.getRecipes().length);
	}
	
	/*
	 * Test addRecipe(Recipe r)
	 */
	@Test()
	public void addRecipe_AddAReceipe_ReturnTrue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		
		RecipeBook rb= new RecipeBook();
		assertEquals(true, rb.addRecipe(recipe));
		//assertEquals("MyRecipe", rb.getRecipes()[0].getName());
	}
	
	@Test()
	public void addRecipe_AddSameReceipe_ReturnFalse() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		
		RecipeBook rb= new RecipeBook();
		rb.addRecipe(recipe);
		assertEquals(false, rb.addRecipe(recipe));
	}
	
	// add recipes more than default value
	@Test()
	public void addRecipe_AddFiveRecipe_ReturnFalse() throws RecipeException{
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		Recipe recipe3 = new Recipe();
		Recipe recipe4 = new Recipe();
		Recipe recipe5 = new Recipe();
		
		RecipeBook rb= new RecipeBook();
		rb.addRecipe(recipe1);
		rb.addRecipe(recipe2);
		rb.addRecipe(recipe3);
		rb.addRecipe(recipe4);
		assertEquals(false, rb.addRecipe(recipe5));
	}
	
	/*
	 * deleteRecipe(int recipeToDelete)
	 */
	@Test()
	public void deleteRecipe_ValidRecipePosition_ReturnRecipeName() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
				
		RecipeBook rb= new RecipeBook();
		rb.addRecipe(recipe);
		
		assertEquals("MyRecipe", rb.deleteRecipe(0));
	}
	
	@Test()
	public void deleteRecipe_InvalideRecipePosition_ReturnNull() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
				
		RecipeBook rb= new RecipeBook();
		rb.addRecipe(recipe);
		
		assertEquals(null, rb.deleteRecipe(1));
	}
	
	/*
	 * Test addRecipe(Recipe r)
	 */
	@Test()
	public void editRecipe_ValidRecipePosition_ReturnEditedRecipeName() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		
		Recipe editedRecipe = new Recipe();
		editedRecipe.setName("MyEditedRecipe");
				
		RecipeBook rb= new RecipeBook();
		rb.addRecipe(recipe);
		
		assertEquals(rb.editRecipe(0,editedRecipe),"MyEditedRecipe");
	}
	
	@Test()
	public void editRecipe_InvalideRecipePosition_ReturnNull() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		
		Recipe editedRecipe = new Recipe();
		editedRecipe.setName("MyEditedRecipe");
				
		RecipeBook rb= new RecipeBook();
		rb.addRecipe(recipe);
		
		assertEquals(rb.editRecipe(1,editedRecipe),null);
	}
}
