package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeTest {

    private Recipe normalRecipe;
    private Recipe secondNormalRecipe;
    private Recipe emptyNameRecipe;
    private Recipe duplicateNameRecipe;
    private Recipe cloneRecipe;
    private Recipe nullNameRecipe;

    @Before
    public void setUp() throws Exception {
        normalRecipe = new Recipe();
        normalRecipe.setName("Coffee");
        normalRecipe.setAmtChocolate("0");
        normalRecipe.setAmtCoffee("3");
        normalRecipe.setAmtMilk("1");
        normalRecipe.setAmtSugar("5");
        normalRecipe.setPrice("50");

        emptyNameRecipe = new Recipe();
        emptyNameRecipe.setAmtChocolate("2");
        emptyNameRecipe.setAmtCoffee("7");
        emptyNameRecipe.setAmtMilk("5");
        emptyNameRecipe.setAmtSugar("4");
        emptyNameRecipe.setPrice("50");

        duplicateNameRecipe = new Recipe();
        duplicateNameRecipe.setName("Coffee");
        duplicateNameRecipe.setAmtChocolate("2");
        duplicateNameRecipe.setAmtCoffee("7");
        duplicateNameRecipe.setAmtMilk("5");
        duplicateNameRecipe.setAmtSugar("4");
        duplicateNameRecipe.setPrice("50");

        cloneRecipe = new Recipe();
        cloneRecipe.setName("Coffee");
        cloneRecipe.setAmtChocolate("0");
        cloneRecipe.setAmtCoffee("3");
        cloneRecipe.setAmtMilk("1");
        cloneRecipe.setAmtSugar("5");
        cloneRecipe.setPrice("50");

        secondNormalRecipe = new Recipe();
        secondNormalRecipe.setName("Mocha latte");
        secondNormalRecipe.setAmtChocolate("7");
        secondNormalRecipe.setAmtCoffee("4");
        secondNormalRecipe.setAmtMilk("8");
        secondNormalRecipe.setAmtSugar("3");
        secondNormalRecipe.setPrice("25");

        nullNameRecipe = new Recipe();
        nullNameRecipe.setName(null);

    }

    @Test
    public void testCoffeeAmount_Negative(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setAmtCoffee("-3");
        });
    }

    @Test
    public void testCoffeeAmount_isNotInt(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setAmtCoffee("00fg7");
        });
    }

    @Test
    public void testGetAmountSugar(){
        int sugarAmount = normalRecipe.getAmtSugar();
        assertEquals(5, sugarAmount);
    }

    @Test
    public void testGetName(){
        String recipeName = normalRecipe.getName();
        assertEquals("Coffee", recipeName );
    }

    @Test
    public void testSetAmountChocolate_Normal() {
        try {
            normalRecipe.setAmtChocolate("12");
            int newChocolateAmount = normalRecipe.getAmtChocolate();
            assertEquals(12, newChocolateAmount);
        } catch(RecipeException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void nameNotEmpty() {
        assertThrows(RecipeException.class, () -> emptyNameRecipe.setName(""));
    }

    @Test
    public void duplicateNameRecipeIdentified() {
        assertTrue(duplicateNameRecipe.equals(normalRecipe));
    }

    @Test
    public void hashCodeTest() {
        Recipe firstRecipe = new Recipe();
        Recipe secondRecipe = new Recipe();
        assertTrue(firstRecipe.equals(secondRecipe) && secondRecipe.equals(firstRecipe));
        assertEquals(secondRecipe.hashCode(), firstRecipe.hashCode());
    }

    @Test
    public void priceIsDecimalException() {
        assertThrows(RecipeException.class, () -> normalRecipe.setPrice("4.3"));
    }

    //Branch coverage tests for setPrice() method

    @Test
    public void testPrice_isNotInt(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setPrice("00fg7");
        });
    }

    @Test
    public void testSetPrice_Normal() {
        try {
            normalRecipe.setPrice("30");
            int newPrice = normalRecipe.getPrice();
            assertEquals(30, newPrice);
        } catch(RecipeException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
    }

    @Test
    public void testPrice_isNegative(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setPrice("-7");
        });
    }

    // Additional tests for line coverage

    @Test
    public void amtChocolate_isNegative(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setAmtChocolate("-20");
        });
    }

    @Test
    public void testChocolateAmount_isNotInt(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setAmtChocolate("#%&786");
        });
    }

    @Test
    public void testGetAmtCoffee(){
        int recipeAmtCoffee = normalRecipe.getAmtCoffee();
        assertEquals(3, recipeAmtCoffee );
    }

    @Test
    public void testGetAmtMilk(){
        int recipeAmtMilk = normalRecipe.getAmtMilk();
        assertEquals(1, recipeAmtMilk );
    }

    @Test
    public void amtMilk_isNegative(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setAmtMilk("-11");
        });
    }

    @Test
    public void testMilkAmount_isNotInt(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setAmtMilk("0rte43");
        });
    }

    @Test
    public void amtSugar_isNegative(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setAmtSugar("-64");
        });
    }

    @Test
    public void testSugarAmount_isNotInt(){
        assertThrows(RecipeException.class, () -> {
            Recipe wrongRecipe = new Recipe();
            wrongRecipe.setAmtSugar("zx45-5");
        });
    }

    @Test
    public void testToString(){
        String recipeName = normalRecipe.toString();
        assertEquals("Coffee", recipeName );
    }

    @Test
    public void incompatibleClassTest() {
        CoffeeMaker cm = new CoffeeMaker();
        assertFalse(normalRecipe.equals(cm));
    }

    @Test
    public void objectIsNullTest() {
        Recipe nullRecipe = null;
        assertFalse(normalRecipe.equals(nullRecipe));
    }

    @Test
    public void objectNameIsNullTest() {
        secondNormalRecipe.setName(null);
        assertFalse(normalRecipe.equals(secondNormalRecipe));
    }

    @Test
    public void objectsHaveSameMemoryAddress() {
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();
        r1 = r2;
        assertTrue(r1.equals(r2));
    }

    @Test
    public void otherObjectNameIsNullTest() {
        secondNormalRecipe.setName(null);
        assertFalse(secondNormalRecipe.equals(normalRecipe));
    }

    @Test
    public void bothRecipeNamesAreNullTest() {
        secondNormalRecipe.setName(null);
        assertFalse(secondNormalRecipe.equals(nullNameRecipe));
    }
}
