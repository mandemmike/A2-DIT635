package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InventoryTest {

    private Inventory inventory;
    private Recipe testRecipe;

    @Before
    public void setUp() throws Exception {
        inventory = new Inventory();

        testRecipe = new Recipe();
        testRecipe.setName("Test Recipe");
        testRecipe.setAmtChocolate("10");
        testRecipe.setAmtCoffee("10");
        testRecipe.setAmtMilk("10");
        testRecipe.setAmtSugar("10");
        testRecipe.setPrice("50");
    }

    @Test
    public void testGetChocolate() {

        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testSetChocolate(){
        inventory.setChocolate(5);
        assertEquals(5, inventory.getChocolate());
    }

    @Test
    public void testAddChocolate() {
        try {
            inventory.addChocolate("10");
            assertEquals(25, inventory.getChocolate());
        } catch (InventoryException e){
            fail("An error occurred while adding chocolate\n");
        }
    }

    @Test
    public void testAddChocolateNegative(){
        try{
            inventory.addChocolate("-5");
            fail("Negative number was added, InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    @Test
    public void testAddChocolate_emptyString(){
        try{
            inventory.addChocolate("");
            fail("No number, InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    //coffee
    @Test
    public void testGetCoffee() {
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    public void testSetCoffee(){
        inventory.setCoffee(5);
        assertEquals(5, inventory.getCoffee());
    }

    @Test
    public void testAddCoffee() {
        try {
            inventory.addCoffee("10");
            assertEquals(25, inventory.getCoffee());
        } catch (InventoryException e){
            fail("An error occurred while adding coffee\n");
        }
    }

    @Test
    public void testAddCoffeeNegative() {
        try{
            inventory.addCoffee("-5");
            fail("Negative number was added, InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    @Test
    public void testAddCoffee_emptyString(){
        try{
            inventory.addCoffee("");
            fail("No number, InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    //milk
    @Test
    public void testGetMilk() {
        assertEquals(15, inventory.getMilk());
    }

    @Test
    public void testSetMilk(){
        inventory.setMilk(5);
        assertEquals(5, inventory.getMilk());
    }

    @Test
    public void testAddMilk() {
        try {
            inventory.addMilk("10");
            assertEquals(25, inventory.getMilk());
        } catch (InventoryException e){
            fail("An error occurred while adding milk\n");
        }
    }

    @Test
    public void testAddMilkNegative() {
        try{
            inventory.addMilk("-10");
            fail("Negative number was added, InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    @Test
    public void testAddMilk_emptyString(){
        try{
            inventory.addMilk("");
            fail("No number, InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    //sugar
    @Test
    public void testGetSugar() {
        assertEquals(15, inventory.getSugar());
    }

    @Test
    public void testSetSugar(){
        inventory.setSugar(5);
        assertEquals(5, inventory.getSugar());
    }

    @Test
    public void testAddSugar() {
        try {
            inventory.addSugar("10");
            assertEquals(25, inventory.getSugar());
        } catch (InventoryException e){
            fail("An error occurred while adding sugar\n");
        }
    }

    @Test
    public void testAddSugarNegative() {
        try{
            inventory.addSugar("-5");
            fail("Negative number was added, InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    @Test
    public void testAddSugar_emptyString(){
        try{
            inventory.addSugar("");
            fail("No number, InventoryException should be thrown");
        }catch (InventoryException e){
            // Success
        }
    }

    @Test
    public void testEnoughIngredients() {
        assertTrue(inventory.enoughIngredients(testRecipe));
    }

    @Test
    public void testEnoughIngredientsFailCoffee() throws Exception{
        testRecipe.setAmtCoffee("20");
        assertFalse(inventory.enoughIngredients(testRecipe));
    }

    @Test
    public void testEnoughIngredientsFailChocolate() throws Exception{
        testRecipe.setAmtChocolate("25");
        assertFalse(inventory.enoughIngredients(testRecipe));
    }

    @Test
    public void testEnoughIngredientsFailMilk() throws Exception{
        testRecipe.setAmtMilk("25");
        assertFalse(inventory.useIngredients(testRecipe));
    }

    @Test
    public void testEnoughIngredientsFailSugar() throws Exception{
        testRecipe.setAmtSugar("25");
        assertFalse(inventory.useIngredients(testRecipe));
    }

    @Test
    public void testUseIngredients() {
        inventory.useIngredients(testRecipe);
        assertEquals(5, inventory.getCoffee());
        assertEquals(5, inventory.getMilk());
        assertEquals(5, inventory.getSugar());
        assertEquals(5, inventory.getChocolate());
    }



    @Test
    public void testToString() {
        assertEquals("Coffee: 15\n" +
                "Milk: 15\n" +
                "Sugar: 15\n" +
                "Chocolate: 15\n", inventory.toString());
    }
}