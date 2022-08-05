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
public class DemoTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;


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
	public void demoTest() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");
		assertEquals(true, false);
	}
	

}
