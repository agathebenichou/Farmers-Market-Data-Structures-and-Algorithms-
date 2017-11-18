

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemCityCustomersTest.
 *
 * @author  Agathe Benichou
 * @version Version 1 - 11/14/2015
 */
public class ItemCityCustomersTest
{
    ItemCityCustomers ICC;
    /**
     * Default constructor for test class ItemCityCustomersTest
     */
    public ItemCityCustomersTest()
    {
        ICC = new ItemCityCustomers();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void ICCtest1()
    {
        ICC.runSimulation();
        assertNotNull(ICC.returnCities("fruits"));
    }
   
    @Test
    public void ICCtest2()
    {
        ICC.runSimulation();
        assertNotNull(ICC.returnCities("vegetables"));
    }
    
    @Test
    public void ICCtest3()
    {
        ICC.runSimulation();
        assertNotNull(ICC.returnCities("bakedgoods"));
    }
    
    @Test
    public void ICCtest4()
    {
        ICC.runSimulation();
        assertNotNull(ICC.returnCities("meat"));
    }
    
    @Test
    public void ICCtest5()
    {
        ICC.runSimulation();
        assertNotNull(ICC.returnCities("dairy"));
    }
    
    @Test
    public void ICCtest6()
    {
        ICC.runSimulation();
        assertNotNull(ICC.returnCities("beverages"));
    }
}
