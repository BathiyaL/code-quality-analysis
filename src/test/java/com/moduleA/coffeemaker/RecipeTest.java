package com.moduleA.coffeemaker;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.moduleA.coffeemaker.exceptions.RecipeException;

public class RecipeTest {
	private Recipe recipe1;
	
//	@BeforeClass
//	public void setUp() throws RecipeException {
//		recipe1 = new Recipe();
//		recipe1.setName("Coffee");
//		recipe1.setAmtChocolate("2");
//		recipe1.setAmtCoffee("3");
//		recipe1.setAmtMilk("1");
//		recipe1.setAmtSugar("1");
//		recipe1.setPrice("50");
//	}
	
	/*
	 * Test setAmtChocolate()
	 */
	@Test(expectedExceptions = RecipeException.class)
	public void setAmtChocolate_NonNumeric_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("abc");		
	}
	
	@Test(expectedExceptions = RecipeException.class)
	public void setAmtChocolate_NegativeInteger_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();	
		recipe.setAmtChocolate("-2");		
	}
	
	@Test()
	public void setAmtChocolate_PositiveInteger_getAmtChocolateReturnValue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("2");
		assertEquals(2, recipe.getAmtChocolate());
	}
	
	@Test()
	public void setAmtChocolate_zero_getAmtChocolateReturnValueZero() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setAmtChocolate("0");
		assertEquals(0, recipe.getAmtChocolate());
	}
	
	/*
	 * Test setAmtCoffee()
	 */
	@Test(expectedExceptions = RecipeException.class)
	public void setAmtCoffee_NonNumeric_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtCoffee("two");		
	}
	
	@Test(expectedExceptions = RecipeException.class)
	public void setAmtCoffee_NegativeInteger_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();	
		recipe.setAmtCoffee("-5");		
	}
	
	@Test()
	public void setAmtCoffee_PositiveInteger_getAmtChocolateReturnValue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setAmtCoffee("100");
		assertEquals(100, recipe.getAmtCoffee());
	}
	
	@Test()
	public void setAmtCoffee_zero_getAmtChocolateReturnValueZero() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setAmtCoffee("0");
		assertEquals(0, recipe.getAmtCoffee());
	}
	
	/*
	 * Test setAmtMilk()
	 */
	@Test(expectedExceptions = RecipeException.class)
	public void setAmtMilk_NonNumeric_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtMilk("two");		
	}
	
	@Test(expectedExceptions = RecipeException.class)
	public void setAmtMilk_NegativeInteger_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();	
		recipe.setAmtMilk("-5");		
	}
	
	@Test()
	public void setAmtMilk_PositiveInteger_getAmtChocolateReturnValue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setAmtMilk("100");
		assertEquals(100, recipe.getAmtMilk());
	}
	
	@Test()
	public void setAmtMilk_zero_getAmtChocolateReturnValueZero() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setAmtMilk("0");
		assertEquals(0, recipe.getAmtMilk());
	}
	
	/*
	 * Test setAmtSugar()
	 */
	@Test(expectedExceptions = RecipeException.class)
	public void setAmtSugar_NonNumeric_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setAmtSugar("two");		
	}
	
	@Test(expectedExceptions = RecipeException.class)
	public void setAmtSugar_NegativeInteger_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();	
		recipe.setAmtSugar("-5");		
	}
	
	@Test()
	public void setAmtSugar_PositiveInteger_getAmtChocolateReturnValue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setAmtSugar("100");
		assertEquals(100, recipe.getAmtSugar());
	}
	
	@Test()
	public void setAmtSugar_zero_getAmtChocolateReturnValueZero() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setAmtSugar("0");
		assertEquals(0, recipe.getAmtSugar());
	}
	
	/*
	 * Test setPrice()
	 */
	@Test(expectedExceptions = RecipeException.class)
	public void setPrice_NonNumeric_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();
		recipe.setPrice("two");		
	}
	
	@Test(expectedExceptions = RecipeException.class)
	public void setPrice_NegativeInteger_RecipeException() throws RecipeException {
		Recipe recipe = new Recipe();	
		recipe.setPrice("-5");		
	}
	
	@Test()
	public void setPrice_PositiveInteger_getAmtChocolateReturnValue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setPrice("100");
		assertEquals(100, recipe.getPrice());
	}
	
	@Test()
	public void setPrice_zero_getAmtChocolateReturnValueZero() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setPrice("0");
		assertEquals(0, recipe.getPrice());
	}
	
	/*
	 * Test setName()
	 */
	@Test()
	public void setName_ValidName_getNameReturnValue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		assertEquals("MyRecipe", recipe.getName());
	}
	
	@Test()
	public void setName_Null_getNameReturnEmpty() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName(null);
		assertEquals("", recipe.getName());
	}
	
	/*
	 * Test setName()
	 */
	@Test()
	public void toString_ValidName_getNameReturnValue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		assertEquals("MyRecipe", recipe.toString());
	}
	
	/*
	 * Test setName()
	 */
	@Test()
	public void hashCode_WithValidName_ReturnHashValue() throws RecipeException{
		Recipe recipe = new Recipe();
		recipe.setName("MyRecipe");
		assertEquals(-784874855, recipe.hashCode());
	}
	
	// we cannot set null value to name, since it assign empty string "" from the constructor
	// hence we cannot check all branches of hasCode()

	/*
	 * Test setName()
	 */
	@Test()
	public void equals_WithOtherRecipeObj_ReturnTrue() throws RecipeException{
		Recipe recipe1 = new Recipe();
		Recipe recipe = new Recipe();
		assertEquals(true, recipe.equals(recipe1));
	}
	
	// else if (!name.equals(other.name))
	@Test()
	public void equals_WithOtherRecipeWithdifferentName_ReturnTrue() throws RecipeException{
		Recipe recipe1 = new Recipe();
		recipe1.setName("Rcipe_A");
		Recipe recipe = new Recipe();
		recipe.setName("Rcipe_B");
		assertEquals(false, recipe.equals(recipe1));
	}
	
	@Test()
	public void equals_WithSameRecipeObj_ReturnTrue() throws RecipeException{
		Recipe recipe = new Recipe();
		assertEquals(true, recipe.equals(recipe));
	}
	
	@Test()
	public void equals_WithNullObj_ReturnTrue() throws RecipeException{
		Recipe recipe = new Recipe();
		assertEquals(false, recipe.equals(null));
	}
	
	@Test()
	public void equals_WithDifferentObj_ReturnFalse() throws RecipeException{
		Recipe recipe = new Recipe();		
		Object obj = new Object();
		assertEquals(false, recipe.equals(obj));
	}
}
