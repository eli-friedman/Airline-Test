package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class CoffeeMakerTest {
	
	CoffeeMaker myCM;

	@Before
	public void setUp() throws Exception {
		myCM = new CoffeeMaker();
	}
	
	//test add inventory method by adding some units of inventory
	//**Test fails because of error found in Inventory class addSugar method that uses a <= sign instead of >=
	@Test
	public void testAddInventory() throws InventoryException {
		myCM.addInventory("1", "3", "2", "11");
		assertEquals("Coffee: 16\nMilk: 18\nSugar: 17\nChocolate: 26\n", myCM.checkInventory());
	}

	//testing the makeCoffee method which consists of 3 equivalence classes regarding the recipe price and amount paid: 
	//1. where the recipe number is null 2. where the price of the recipe is less than or equal to the amount paid 3. 
	//where the price of the recipe is more than the amount paid
	//there are also 2 equivalence classes for when the amount paid is sufficient: 1. the inventory is sufficient 2. the
	//inventory is insufficient. (The default for all amounts in a recipe is 0 and coffeeMaker is instantiated with 15 of everything)
	@Test
	public void testMakeCoffee() {
		
		Recipe [] mockRecArray = new Recipe[3];
		
		//create the first mock recipe costing 4 and amount of coffee needed 20
		mockRecArray[0] = Mockito.mock(Recipe.class);
		Mockito.when(mockRecArray[0].getPrice()).thenReturn(4);
		Mockito.when(mockRecArray[0].getAmtCoffee()).thenReturn(20);
		
		//create the second mock recipe costing 5 
		mockRecArray[1] = Mockito.mock(Recipe.class);
		Mockito.when(mockRecArray[1].getPrice()).thenReturn(5);
		
		//create the third mock recipe costing 6
		mockRecArray[2] = Mockito.mock(Recipe.class);
		Mockito.when(mockRecArray[2].getPrice()).thenReturn(6);
		
		// add recipes to coffeeMaker
		myCM.addRecipe(mockRecArray[0]);
		myCM.addRecipe(mockRecArray[1]);
		myCM.addRecipe(mockRecArray[2]);
		
		int amntPaid = 5;
		
		//asserting that first equivalence class (recipe is null) returns total amount paid
		assertEquals( amntPaid, myCM.makeCoffee(3, amntPaid));
		
		//Asserting that second equivalence class (amount paid is more than recipe price) but the 
		//the recipe uses more coffee(20 units) than default(15 units) should return total amount paid
		assertEquals( amntPaid, myCM.makeCoffee(0, amntPaid));
		
		//Asserting that second equivalence class (amount paid is more than recipe price) but the 
		//the recipe uses less(0 units) than default(15 units) should return total amntPaid - price.
		assertEquals( 0, myCM.makeCoffee(1, amntPaid));
		
		//Asserting that third equivalence class (amount paid is less than recipe price) returns total amntPaid
		assertEquals( amntPaid, myCM.makeCoffee(2, amntPaid));
		
	}

}
