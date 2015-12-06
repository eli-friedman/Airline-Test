package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CoffeeMakerTest {
	
	CoffeeMaker myCM = new CoffeeMaker();

	@Before
	public void setUp() throws Exception {
		Recipe [] mockRecArray = new Recipe[4];
	//	mockRecArray[0] = null;
		mockRecArray[0] = Mockito.mock(Recipe.class);
		Mockito.when(mockRecArray[0].getPrice()).thenReturn(4);
		mockRecArray[1] = Mockito.mock(Recipe.class);
		Mockito.when(mockRecArray[1].getPrice()).thenReturn(5);
		mockRecArray[2] = Mockito.mock(Recipe.class);
		Mockito.when(mockRecArray[2].getPrice()).thenReturn(6);
		
		myCM.addRecipe(mockRecArray[0]);
		myCM.addRecipe(mockRecArray[1]);
		myCM.addRecipe(mockRecArray[2]);
	}

	@Test
	public void testMakeCoffee() {
		
		int amntPaid = 5;
		assertEquals( amntPaid, myCM.makeCoffee(3, amntPaid));
		assertEquals( 1, myCM.makeCoffee(0, amntPaid));
		assertEquals( 0, myCM.makeCoffee(1, amntPaid));
		assertEquals( amntPaid, myCM.makeCoffee(2, amntPaid));
		
	}
	
	//test add sugar method**************************

}
