package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RecipeBookTest {
	RecipeBook myBook; 
	@Before
	public void setUp() throws Exception {
		 myBook = new RecipeBook();
	}
	
	//tests addRecipe() in the case the recipeBook has space to add the recipe
	//and that the recipe does not already exist
	@Test
	public void testAddEmpty() {
		Recipe mockRec = Mockito.mock(Recipe.class);
		//the only method that is checked when a recipe is added is its name
		Mockito.when(mockRec.getName()).thenReturn("foo");
		assertTrue(myBook.addRecipe(mockRec));
	}
	
	//tests addRecipe() in the case the recipeBook already contains the recipe
	public void testAddExists() {
		Recipe mockRec = Mockito.mock(Recipe.class);
		//the only method that is checked when a recipe is added is its name
		Mockito.when(mockRec.getName()).thenReturn("foo");
		myBook.addRecipe(mockRec);
		assertFalse(myBook.addRecipe(mockRec));
	}
	
	//testS addRecipe() in the case the recipeBook is full
	@Test
	public void testAddFull() {
		//creating a bunch of recipe mocks to be added to the book
		Recipe mockRec = Mockito.mock(Recipe.class);
		Recipe mockRec1 = Mockito.mock(Recipe.class);
		Recipe mockRec2 = Mockito.mock(Recipe.class);
		Recipe mockRec3 = Mockito.mock(Recipe.class);
		Recipe mockRec4 = Mockito.mock(Recipe.class);
		Mockito.when(mockRec.getName()).thenReturn("foo");
		Mockito.when(mockRec1.getName()).thenReturn("bar");
		Mockito.when(mockRec2.getName()).thenReturn("foobar");
		Mockito.when(mockRec3.getName()).thenReturn("baz");
		Mockito.when(mockRec4.getName()).thenReturn("error");
		//add all of the recipes to the recipe book
		myBook.addRecipe(mockRec);
		myBook.addRecipe(mockRec1);
		myBook.addRecipe(mockRec2);
		myBook.addRecipe(mockRec3);
		//should return false because recipe book can only hold 4 recipes
		assertFalse(myBook.addRecipe(mockRec4)); 
	}
	
	//tests the deleteRecipe() in the case that a recipe exists at the specified location
	@Test
	public void testDeleteExists() {
		Recipe mockRec = Mockito.mock(Recipe.class);
		Mockito.when(mockRec.getName()).thenReturn("foo");
		myBook.addRecipe(mockRec);
		assertEquals(myBook.deleteRecipe(0),"foo");
	}
	
	//tests the deleteRecipe() in the case that a recipe does not exist 
	//at the specified location
	@Test
	public void testDeleteNoExistence() {
		Recipe mockRec = Mockito.mock(Recipe.class);
		Mockito.when(mockRec.getName()).thenReturn("foo");
		myBook.addRecipe(mockRec);
		assertNull(myBook.deleteRecipe(1));
	}
	
	//tests the editRecipe() in the case that a recipe exists at the specified location
	@Test
	public void testEditExists() {
		Recipe mockRec = Mockito.mock(Recipe.class);
		Mockito.when(mockRec.getName()).thenReturn("foo");
		Recipe mockRec1 = Mockito.mock(Recipe.class);
		Mockito.when(mockRec1.getName()).thenReturn("bar");
		myBook.addRecipe(mockRec);
		assertEquals(myBook.editRecipe(0,mockRec1),"foo");
	}
	
	//tests the editRecipe() in the case that a recipe does not exist 
	//at the specified location
	@Test
	public void testEditNoExistence() {
		Recipe mockRec = Mockito.mock(Recipe.class);
		Mockito.when(mockRec.getName()).thenReturn("foo");
		Recipe mockRec1 = Mockito.mock(Recipe.class);
		Mockito.when(mockRec1.getName()).thenReturn("bar");
		myBook.addRecipe(mockRec);
		assertNull(myBook.editRecipe(1,mockRec1));
	}
}
