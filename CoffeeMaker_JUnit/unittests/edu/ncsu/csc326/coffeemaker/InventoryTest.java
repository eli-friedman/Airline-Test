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
	@Test
	public void testSetChococolate() {
		int amnt = 5;
		myInv.setChocolate(amnt);
		assertEquals(5, myInv.getChocolate());
		
		amnt = -1;
		myInv.setChocolate(amnt);
		//assert getChocolate is still 5
		assertEquals(5, myInv.getChocolate());
	}
	
	//test both equivalence cases for setCoffee method: 1. amount >= 0     2. amount < 0
	@Test
	public void testSetCoffee() {
		int amnt = 5;
		myInv.setCoffee(amnt);
		assertEquals(5, myInv.getCoffee());
		
		amnt = -1;
		myInv.setCoffee(amnt);
		//assert getCoffee is still 5
		assertEquals(5, myInv.getCoffee());
	}
	
	//test both equivalence cases for setMilk method: 1. amount >= 0    2. amount < 0
	@Test
	public void testSetMilk() {
		int amnt = 5;
		myInv.setMilk(amnt);
		assertEquals(5, myInv.getMilk());
		
		amnt = -1;
		myInv.setMilk(amnt);
		//assert getMilk is still 5
		assertEquals(5, myInv.getMilk());
	}
	
	//test both equivalence cases for setSugar method: 1. amount >= 0    2. amount < 0
	@Test
	public void testSetSugar() {
		int amnt = 5;
		myInv.setSugar(amnt);
		assertEquals(5, myInv.getSugar());
		
		amnt = -1;
		myInv.setSugar(amnt);
		//assert getSugar is still 5
		assertEquals(5, myInv.getSugar());
	}
	
	//test both equivalence cases for addChocholate method 1. amount >= 0    2. amount < 0
	@Test
	public void testAddChocolate() throws InventoryException  {
		String amnt = "5";
		myInv.addChocolate(amnt);
		//asert getChocolate == defalt amount + amnt
		assertEquals(20, myInv.getChocolate());
		

		amnt = "-1"; 

		//assert inventory exception is thrown
		try{ 
			myInv.addChocolate(amnt);
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			
		}
		
	}
	
	//test both equivalence cases for addCoffee method 1. amount >= 0    2. amount < 0
	@Test
	public void testAddCoffee() throws InventoryException  {
		String amnt = "5";
		myInv.addCoffee(amnt);
		//asert getCoffee == defalt amount + amnt
		assertEquals(20, myInv.getCoffee());
		

		amnt = "-1"; 

		//assert inventory exception is thrown
		try{ 
			myInv.addCoffee(amnt);
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			
		}
		
	}
	
	//test both equivalence cases for addMilk method 1. amount >= 0    2. amount < 0
	@Test
	public void testAddMilk() throws InventoryException  {
		String amnt = "5";
		myInv.addMilk(amnt);
		//asert getMilk == defalt amount + amnt
		assertEquals(20, myInv.getMilk());
		

		amnt = "-1"; 

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
	public void testAddSugar() throws InventoryException  {
		String amnt = "5";
		myInv.addSugar(amnt);
		//asert getSugar == defalt amount + amnt
		assertEquals(20, myInv.getSugar());
		

		amnt = "-1"; 

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
	public void testEnoughIngredients() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return enough of everything (less than default inventory amnt) except chocolate
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(50);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
		
		
		//change stubbed methods so that only amtCoffee returns more than 15
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(49);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
		
		
		//change stubbed methods so that only amtMilk returns more than 15
		Mockito.when(mockRec.getAmtMilk()).thenReturn(40);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
		
		//change stubbed methods so that only amtSugar returns more than 15
		Mockito.when(mockRec.getAmtMilk()).thenReturn(2);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(18);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
		
		//change stubbed methods so that amntChocolate and amtCoffee returns more than 15
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(36);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(49);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(4);
		//assert that enough ingredients returns false
		assertEquals(false, myInv.enoughIngredients(mockRec));
		
		//change stubbed methods so that all amnts return less than 15
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(10);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(6);
		//assert that enough ingredients returns false
		assertEquals(true, myInv.enoughIngredients(mockRec));
	}
	
	//test useIngredients method by passing in mock recipe that returns one for each item's get amount method
	//and then passes it in as an argument to useIngridients and then asserts that each quantity is correct
	//This method fails due to an error found in the method: it adds the quantity of coffee in the recipe to the 
	//to the amount of coffee instead of subtracting it.
	@Test
	public void testUseIngredients() {
		// create a mock recipe
		Recipe mockRec = Mockito.mock(Recipe.class);
		
		//set up getAmnt methods to return 1 for every item
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(1);
		Mockito.when(mockRec.getAmtCoffee()).thenReturn(1);
		Mockito.when(mockRec.getAmtMilk()).thenReturn(1);
		Mockito.when(mockRec.getAmtSugar()).thenReturn(1);
		
		myInv.useIngredients(mockRec);
		
		assertEquals(14, myInv.getChocolate());
		assertEquals(14, myInv.getCoffee());
		assertEquals(14, myInv.getMilk());
		assertEquals(14, myInv.getSugar());
	}
}
