package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class InventoryTest {
	
	Inventory myInv;

	//instantiate inventory object. default amount for all items is 15
	@Before
	public void setUp() throws Exception {
		 myInv = new Inventory();
	}

	//test both equivalence cases for setCocholate method: 1. amount >= 0     2. amount < 0
	
	//amount >= 0
	@Test
	public void testSetChococolateGreater() {
		int amnt = 5;
		myInv.setChocolate(amnt);
		assertEquals(5, myInv.getChocolate());
	}
	
	//2. amount < 0
	@Test
	public void testSetChococolateLess() {
		int amnt = -1;
		myInv.setChocolate(amnt);
		//assert getChocolate is still 5
		assertEquals(15, myInv.getChocolate());
	}
	
	//test both equivalence cases for setCoffee method: 1. amount >= 0     2. amount < 0
	
	//amount >= 0
	@Test
	public void testSetCoffeeGreater() {
		int amnt = 5;
		myInv.setCoffee(amnt);
		assertEquals(5, myInv.getCoffee());
	}
	
	//amount < 0
	@Test
	public void testSetCoffeeLess() {
		int amnt = -1;
		myInv.setCoffee(amnt);
		//assert getCoffee is still 5
		assertEquals(15, myInv.getCoffee());
	}
	
	//test both equivalence cases for setMilk method: 1. amount >= 0    2. amount < 0
	
	//amount >= 0
	@Test
	public void testSetMilkGreater() {
		int amnt = 5;
		myInv.setMilk(amnt);
		assertEquals(5, myInv.getMilk());
	}
	
	//test amount < 0
	@Test
	public void testSetMilkLess() {	
		int amnt = -1;
		myInv.setMilk(amnt);
		//assert getMilk is still 5
		assertEquals(15, myInv.getMilk());
	}
	
	//test both equivalence cases for setSugar method: 1. amount >= 0    2. amount < 0
	// amount >= 0
	@Test
	public void testSetSugarGreater() {
		int amnt = 5;
		myInv.setSugar(amnt);
		assertEquals(5, myInv.getSugar());
	}
	
	// amount < 0
	@Test
	public void testSetSugarLess() {
		int amnt = -1;
		myInv.setSugar(amnt);
		//assert getSugar is still 5
		assertEquals(15, myInv.getSugar());
	}
	
	//test both equivalence cases for addChocholate method 1. amount >= 0    2. amount < 0
	
	//amount >= 0 
	@Test
	public void testAddChocolateGreater() throws InventoryException  {
		String amnt = "5";
		myInv.addChocolate(amnt);
		//asert getChocolate == defalt amount + amnt
		assertEquals(20, myInv.getChocolate());
	}
		
	//amount < 0 make sure inventory exception is thrown
	@Test
	public void testAddChocolate() throws InventoryException  {
		String amnt = "-1"; 

		try{ 
			myInv.addChocolate(amnt);
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			
		}
		
	}
	
	//test both equivalence cases for addCoffee method 1. amount >= 0    2. amount < 0
	@Test
	public void testAddCoffeeGreater() throws InventoryException  {
		String amnt = "5";
		myInv.addCoffee(amnt);
		//asert getCoffee == defalt amount + amnt
		assertEquals(20, myInv.getCoffee());
	}
		
	//amount < 0 make sure inventory exception is thrown
	@Test
	public void testAddCoffeeLess() throws InventoryException  {
		String amnt = "-1"; 

		try{ 
			myInv.addCoffee(amnt);
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			
		}
		
	}
	
	//test both equivalence cases for addMilk method 1. amount >= 0    2. amount < 0
	@Test
	public void testAddMilkGreater() throws InventoryException  {
		String amnt = "5";
		myInv.addMilk(amnt);
		//asert getMilk == defalt amount + amnt
		assertEquals(20, myInv.getMilk());
	}
	
	//amount < 0 make sure inventory exception is thrown
	@Test
	public void testAddMilkLess() throws InventoryException  {
		String amnt = "-1"; 

		//assert inventory exception is thrown
		try{ 
			myInv.addMilk(amnt);
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			
		}
		
	}
	
	//test both equivalence cases for addSugar method 1. amount >= 0    2. amount < 0
	//Fails because of error found in method: uses a <= sign instead of >= when comparing to input to 0
	@Test
	public void testAddSugarGreater() throws InventoryException  {
		String amnt = "5";
		myInv.addSugar(amnt);
		//asert getSugar == defalt amount + amnt
		assertEquals(20, myInv.getSugar());
	}
	
	//amount < 0 make sure inventory exception is thrown
	//fails again because of error
	@Test
	public void testAddSugarLess() throws InventoryException  {
		String amnt = "-1"; 

		//assert inventory exception is thrown
		try{ 
			myInv.addSugar(amnt);
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			
		}
		
	}
		
	//test 5 equivalence cases for enough ingredients method: enough of everything except 1. chocolate 2. milk 3. coffee 4. sugar
	// 5. chocolate and coffee 6. there is enough of everything
	@Test
	public void testEnoughIngredientsChocolate() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return enough of everything (less than default inventory amnt) except chocolate
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(50);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
	}
	
	@Test
	public void testEnoughIngredientsCoffee() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return enough of everything (less than default inventory amnt) except coffee
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(50);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
		
	}
	
	@Test
	public void testEnoughIngredientsMilk() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return enough of everything (less than default inventory amnt) except milk
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(50);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
	}
	
	@Test
	public void testEnoughIngredientsSugar() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return enough of everything (less than default inventory amnt) except sugar
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(50);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
	}
	
	@Test
	public void testEnoughIngredientsChocAndCoffee() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return enough of everything (less than default inventory amnt) except chocolate
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(50);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(50);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
	}
	
	@Test
	public void testEnoughIngredientsEnoughAll() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return enough of everything (less than default inventory amnt)
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		//assert that enough ingredients returns true
		assertEquals(true, myInv.enoughIngredients(mockRec));
		
	}	
		
	//test useIngredients method for each item by passing in mock recipe that returns one for each item's get amount method
	//and then passes it in as an argument to useIngridients and then asserts that the quantity is correct
	
	@Test
	public void testUseIngredientsChocolate() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return 1 for every item
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		
		myInv.useIngredients(mockRec);
		
		assertEquals(14, myInv.getChocolate());
	}
	
	//This method fails due to an error found in the method: it adds the quantity of coffee in the recipe to the 
	//to the amount of coffee instead of subtracting it.
	@Test
	public void testUseIngredientsCoffee() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return 1 for every item
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		
		myInv.useIngredients(mockRec);
		
		assertEquals(14, myInv.getCoffee());
	}
	
	@Test
	public void testUseIngredientsMilk() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return 1 for every item
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		
		myInv.useIngredients(mockRec);
		
		assertEquals(14, myInv.getMilk());
	}
	
	@Test
	public void testUseIngredientsSugar() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return 1 for every item
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		
		myInv.useIngredients(mockRec);
		
		assertEquals(14, myInv.getSugar());
	}
}
