package com.moduleA.coffeemaker;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.moduleA.coffeemaker.exceptions.InventoryException;
import com.moduleA.coffeemaker.exceptions.RecipeException;

/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 */
public class CoffeeMakerTest2 {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@BeforeClass
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");
	}
	
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");		
	}
	
	@Test
	public void testAddInventoryWithPostiveValues() throws InventoryException {
		coffeeMaker.addInventory("4","7","3","9");		
	}
	
	
	@Test
	public void testAddInventoryWithZeroValues() throws InventoryException {
		coffeeMaker.addInventory("0","0","0","0");		
	}
	
	@Test(expectedExceptions = InventoryException.class)
	public void testAddInventoryWithNagativeValues() throws InventoryException {
		coffeeMaker.addInventory("0","0","-1","0");		
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantities (i.e., a negative 
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expectedExceptions = InventoryException.class)
	public void testAddInventoryException() throws InventoryException {
		coffeeMaker.addInventory("4", "-1", "asdf", "3");
	}
	
	// there is an issue on assertion
	@Test
	public void testCheckInventory() throws InventoryException {		
		String expectedInventory = "Coffee: 15" + "\n";
		expectedInventory +=  "Milk: 15" + "\n";
		expectedInventory +=  "Sugar: 15" + "\n";
		expectedInventory +=  "Chocolate: 15" + "\n";   	
		assertEquals(expectedInventory, coffeeMaker.checkInventory());
	}
	
	@Test
	public void testCheckInventoryAfterMakeCoffee() {
		coffeeMaker.addRecipe(recipe1);		
		String expectedInventory = "Coffee: 12" + "\n";
		expectedInventory +=  "Milk: 14" + "\n";
		expectedInventory +=  "Sugar: 14" + "\n";
		expectedInventory +=  "Chocolate: 15" + "\n"; 		
		coffeeMaker.makeCoffee(0, 75);		
		assertEquals(expectedInventory, coffeeMaker.checkInventory());
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffee() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}
	
	// if cannot make will return user's money
	@Test
	public void testMakeCoffeeWhenPayLess() {
		coffeeMaker.addRecipe(recipe3);
		assertEquals(75, coffeeMaker.makeCoffee(0, 75));
	}
	
	// if cannot make will return user's money
	@Test
	public void testMakeCoffeeWithNagativeRecipeValue() {
		coffeeMaker.addRecipe(recipe3);
		assertEquals(75, coffeeMaker.makeCoffee(-1, 75));
	}
	
	// if cannot make will return user's money
	@Test
	public void testMakeCoffeeWithOutOfRecipeValue() {
		coffeeMaker.addRecipe(recipe3);
		assertEquals(75, coffeeMaker.makeCoffee(5, 75));
	}
	
	@Test
	public void testEditRecipe() throws RecipeException {
		
		coffeeMaker.addRecipe(recipe1);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
		
		Recipe recipe5 = new Recipe();
		recipe5 = recipe1;
		recipe5.setPrice("70");
		recipe5.setName("NESCAFÉ");

		assertEquals("NESCAFÉ", coffeeMaker.editRecipe(0,recipe5));
	}
	
	@Test
	public void testDeleteRecipe(){		
		coffeeMaker.addRecipe(recipe1);
		assertEquals("Coffee",coffeeMaker.deleteRecipe(0));
	}
		
	@Test
	public void testAddRecipe() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals("Coffee", coffeeMaker.getRecipes()[0].getName());
	}
	
	@Test
	public void testGetRecipes() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals("Coffee", coffeeMaker.getRecipes()[0].getName());
	}
	

}
