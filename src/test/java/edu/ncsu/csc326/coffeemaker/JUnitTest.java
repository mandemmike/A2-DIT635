package edu.ncsu.csc326.coffeemaker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ExampleTest.class,
        RecipeTest.class,
        InventoryTest.class,
        CoffeeMakerTest.class
})

public class JUnitTest {
    // This class remains empty, it is used only as a holder for the above annotations
}