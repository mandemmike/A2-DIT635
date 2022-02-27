package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.assertThrows;
import static org.junit.Assert.*;

public class RecipeBookTest {

    private RecipeBook testRecipeBook;
    private Recipe testRecipe;
    private CoffeeMaker cm;



    @Before
    public void setUp() throws Exception {
        testRecipeBook = new RecipeBook();
        cm = new CoffeeMaker();
        testRecipe = new Recipe();
        testRecipe.setName("TestRecipe");
        testRecipe.setAmtChocolate("3");
        testRecipe.setAmtCoffee("2");
        testRecipe.setAmtMilk("2");
        testRecipe.setAmtSugar("3");
        testRecipe.setPrice("75");
    }

    @Test
    public void testConstructor() {
        Recipe[] test = testRecipeBook.getRecipes();
        assertEquals(test.length, 4);
    }

    @Test
    public void testAddRecipeNull() {
        Recipe test = null;
        boolean expected = false;
        boolean actual = testRecipeBook.addRecipe(test);
        assertEquals(expected, actual);

    }

    @Test
    public void testAddRecipe() {
        boolean expected = true;
        boolean actual = testRecipeBook.addRecipe(testRecipe);
        assertEquals(expected, actual);

    }


    @Test
    public void testDeleteRecipe() {
        testRecipeBook.addRecipe(testRecipe);
        String expected = testRecipe.getName();
        String actual = testRecipeBook.deleteRecipe(0);
        assertEquals(expected, actual);

    }

    @Test
    public void testDeleteRecipeNull() {
        String expected = null;
        String actual = testRecipeBook.deleteRecipe(0);
        assertEquals(expected, actual);

    }

    @Test
    public void testEdit() {
        testRecipeBook.addRecipe(testRecipe);
        String name = testRecipeBook.editRecipe(0, testRecipe);
        String expected = testRecipeBook.getRecipes()[0].getName();
        assertNotEquals(name, expected);
    }

}
