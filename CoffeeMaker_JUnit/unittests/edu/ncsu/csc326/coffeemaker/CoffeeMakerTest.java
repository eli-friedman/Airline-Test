package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

//most of the methods in CoffeeMaker class just return methods in other classes so tests for 
//them are done in respective classes. There were just a few that needed tested

public class CoffeeMakerTest {
	
	CoffeeMaker myCM;

	@Before
	public void setUp() throws Exception {
		myCM = new CoffeeMaker();
	}
	
	//test add inventory method by adding some units of inventory
	//tested all inventory types together because already tested individual methods in inventory class
	//**Test fails because of error found in Inventory class addSugar method that uses a <= sign instead of >=
	@Test
	public void testAddInventory() throws InventoryException {
		myCM.addInventory("1", "3", "2", "11");
		assertEquals("Coffee: 16\nMilk: 18\nSugar: 17\nChocolate: 26\n", myCM.checkInventory());
	}

	//testing the makeCoffee method which consists of 3 equivalence classes regarding the recipe price and amount paid: 
	//1. where the recipe number is null 2. where the amount paid is greater than or equal to the price of the recipe  3. 
	//where the amount paid is less than the price of the recipe.
	//there are also 2 equivalence classes for when the amount paid is sufficient: 1. the inventory is sufficient 2. the
	//inventory is insufficient. (The default for all amounts in a recipe is 0 and coffeeMaker is instantiated with 15 of everything)
	//also has test for edge case of exact change
	
	//asserting that first equivalence class (recipe is null) returns total amount paid
	@Test
	public void testMakeCoffeeNull() {
	
		int amntPaid = 5;
		
		assertNull(myCM.getRecipes()[0]);
		assertEquals( amntPaid, myCM.makeCoffee(0, amntPaid));
		
	}
	
	//Asserting that second equivalence class (amount paid is more than recipe price) returns the difference between
	//amntPaid and the price
	@Test
	public void testMakeCoffeeGreater() {
		
		Recipe mockRec = new Recipe();
		
		//create the first mock recipe costing 4 and amount of coffee needed 20
		mockRec = Mockito.mock(Recipe.class);
		Mockito.when(mockRec.getPrice()).thenReturn(4);
		
		myCM.addRecipe(mockRec);
		
		int amntPaid = 5;
		
		assertEquals( 1, myCM.makeCoffee(0, amntPaid));
	}
	
	//Asserting that second equivalence class (amount paid is less than recipe price) returns amntPaid
	@Test
	public void testMakeCoffeeLess() {
		
		Recipe mockRec = new Recipe();
		
		//create the second mock recipe costing 5 
		mockRec = Mockito.mock(Recipe.class);
		Mockito.when(mockRec.getPrice()).thenReturn(6);
		
		myCM.addRecipe(mockRec);
		
		int amntPaid = 5;
		
		assertEquals( amntPaid, myCM.makeCoffee(0, amntPaid));
	}
	
	//Testing edge case where amount paid is exactly the recipe price. Should return 0
		@Test
		public void testMakeCoffeeExactChange() {
			
			Recipe mockRec = new Recipe();
			
			//create the second mock recipe costing 5 
			mockRec = Mockito.mock(Recipe.class);
			Mockito.when(mockRec.getPrice()).thenReturn(5);
			
			myCM.addRecipe(mockRec);
			
			int amntPaid = 5;
			
			assertEquals( 0, myCM.makeCoffee(0, amntPaid));
		}
	
	//Asserting that when there is insufficient inventory MakeCoffee returns amntPaid
	@Test
	public void testMakeCoffeeInsufficientInv() {
		
		Recipe mockRec = new Recipe();
		
		//create the second mock recipe costing 5 
		mockRec = Mockito.mock(Recipe.class);
		Mockito.when(mockRec.getPrice()).thenReturn(4);
		Mockito.when(mockRec.getAmtChocolate()).thenReturn(20);
		
		myCM.addRecipe(mockRec);
		
		int amntPaid = 5;
		
		assertEquals( amntPaid, myCM.makeCoffee(0, amntPaid));
	}
}
