package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

//import static org.junit.Assert.assertThrows;
import static org.junit.Assert.*;

public class CoffeeMakerTest {

    private CoffeeMaker cm;
    private Recipe MikeSpecial;
    private Recipe testRecipe;



    @Before
    public void setUp() throws Exception {
        cm = new CoffeeMaker();
        MikeSpecial = new Recipe();
        MikeSpecial.setName("MikeSpecial");
        MikeSpecial.setAmtChocolate("5");
        MikeSpecial.setAmtCoffee("3");
        MikeSpecial.setAmtMilk("4");
        MikeSpecial.setAmtSugar("1");
        MikeSpecial.setPrice("100");

        testRecipe = new Recipe();
        testRecipe.setName("TestRecipe");
        testRecipe.setAmtChocolate("3");
        testRecipe.setAmtCoffee("2");
        testRecipe.setAmtMilk("2");
        testRecipe.setAmtSugar("3");
        testRecipe.setPrice("75");

    }

    @Test
    public void testChange() {
        cm.addRecipe(MikeSpecial);
        int price = 100;
        int amtPaid = 300;
        int change = cm.makeCoffee(0, amtPaid);
        int expected = 300 - price;

        assertEquals(expected, change);
    }

    @Test
    public void testConstructor6() {
        CoffeeMaker testObject = new CoffeeMaker();
        assertNotNull(testObject);
    }

    @Test
    public void testDelete() {
        cm.addRecipe(MikeSpecial);
        String name = cm.deleteRecipe(0);
        assertEquals(name, MikeSpecial.getName());
    }

    @Test
    public void testEdit() {
        cm.addRecipe(MikeSpecial);
        String name = cm.editRecipe(0, testRecipe);
        String expected = cm.getRecipes()[0].getName();
        assertNotEquals(name, expected);
    }

}

