package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeTest {

	Recipe myRec;
	//instantiate inventory object. default amount for all items is 15
	@Before
	public void setUp() throws Exception {
		 myRec = new Recipe();
	}
	
	//Tests the positive equivalence case for setAmtChocolate
	@Test
	public void testSetAmtChocPos() {
		try{
			myRec.setAmtChocolate("5");
			assertEquals(5,myRec.getAmtChocolate());
		}catch (RecipeException e){
			fail();
		}
	}
	
	//Tests the negative or 0 equivalence case for setAmtChocolate
	@Test
	public void testSetAmtChocNeg() {
		try{
			myRec.setAmtChocolate("-5");
			fail();
		}catch (RecipeException e){

		}
	}
	
	//Tests the non number input case for setAmtChocolate
	@Test
	public void testSetAmtChocNonNum() {
		try{
			myRec.setAmtChocolate("foo");
			fail();
		}catch (RecipeException e){

		}
	}
	
	//Tests the positive equivalence case for setAmtCoffee
	@Test
	public void testSetAmtCoffeePos() {
		try{
			myRec.setAmtCoffee("5");
			assertEquals(5,myRec.getAmtCoffee());
		}catch (RecipeException e){
			fail();
		}
	}

	//Tests the negative or 0 equivalence case for setAmtCoffee
	@Test
	public void testSetAmtCoffeeNeg() {
		try{
			myRec.setAmtMilk("-5");
			fail();
		}catch (RecipeException e){

		}
	}

	//Tests the non number input case for setAmtCoffee
	@Test
	public void testSetAmtCoffeeNonNum() {
		try{
			myRec.setAmtCoffee("foo");
			fail();
		}catch (RecipeException e){

		}
	}
	
	//Tests the positive equivalence case for setAmtMilk
	@Test
	public void testSetAmtMilkPos() {
		try{
			myRec.setAmtMilk("5");
			assertEquals(5,myRec.getAmtMilk());
		}catch (RecipeException e){
			fail();
		}
	}
	
	//Tests the negative or 0 equivalence case for setAmtMilk
	@Test
	public void testSetAmtMilkNeg() {
		try{
			myRec.setAmtMilk("-5");
			fail();
		}catch (RecipeException e){

		}
	}
	
	//Tests the non number input case for setAmtMilk
	@Test
	public void testSetAmtMilkNonNum() {
		try{
			myRec.setAmtMilk("foo");
			fail();
		}catch (RecipeException e){

		}
	}
	
	//Tests the positive equivalence case for setAmtSugar
	@Test
	public void testSetAmtSugarPos() {
		try{
			myRec.setAmtSugar("5");
			assertEquals(5,myRec.getAmtSugar());
		}catch (RecipeException e){
			fail();
		}
	}

	//Tests the negative or 0 equivalence case for setAmtSugar
	@Test
	public void testSetAmtSugarNeg() {
		try{
			myRec.setAmtSugar("-5");
			fail();
		}catch (RecipeException e){

		}
	}

	//Tests the non number input case for setAmtSugar
	@Test
	public void testSetAmtSugarNonNum() {
		try{
			myRec.setAmtSugar("foo");
			fail();
		}catch (RecipeException e){

		}
	}
	
	//Tests the setName function
	@Test
	public void testSetName() {
		myRec.setName("foo");
		assertEquals(myRec.getName(),"foo");
	}
	
	//Tests the positive equivalence case for setPrice
	@Test
	public void testsetPricePos() {
		try{
			myRec.setPrice("5");
			assertEquals(5,myRec.getPrice());
		}catch (RecipeException e){
			fail();
		}
	}

	//Tests the negative or 0 equivalence case for setPrice
	@Test
	public void testsetPriceNeg() {
		try{
			myRec.setPrice("-5");
			fail();
		}catch (RecipeException e){
			assertTrue(true);
		}
	}

	//Tests the non number input case for setPrice
	@Test
	public void testsetPriceNonNum() {
		try{
			myRec.setPrice("foo");
			fail();
		}catch (RecipeException e){
			assertTrue(true);
		}
	}
	
	//Tests toString
	@Test
	public void testtoString() {
		myRec.setName("foo");
		assertEquals(myRec.toString(),"foo");
	}
	
	//Test equals case when both inputs are same object
	public void testEqualsSameObj(){
		Recipe cpyRec = myRec;
		assertTrue(cpyRec.equals(myRec));
	}
	
	//Test equals case when compared object is null
	public void testEqualsNullComparison(){
		assertFalse(myRec.equals(null));
	}
	
	//Test equals case when compared object is of a different class
	public void testEqualsDiffClass(){
		String comp=null;
		assertFalse(myRec.equals(comp));
	}
	
	//Test equals case when both objects have null for name
	public void testEqualsNullName(){
		Recipe cpyRec = new Recipe();
		cpyRec.setName(null);
		myRec.setName(null);
		assertTrue(myRec.equals(cpyRec));
	}
	
	//Test equals case when one object has null name and other is not
	public void testEqualsNullNameOne(){
		Recipe cpyRec = new Recipe();
		cpyRec.setName(null);
		myRec.setName("foo");
		assertFalse(myRec.equals(cpyRec));
	}
	
	//Test equals case when each object has a different name
	public void testEqualsDifferentName(){
		Recipe cpyRec = new Recipe();
		cpyRec.setName("bar");
		myRec.setName("foo");
		assertFalse(myRec.equals(cpyRec));
	}
	
	//Test equals case when one object has the same name
	public void testEqualsNullSameName(){
		Recipe cpyRec = new Recipe();
		cpyRec.setName("foo");
		myRec.setName("foo");
		assertTrue(myRec.equals(cpyRec));
	}
}