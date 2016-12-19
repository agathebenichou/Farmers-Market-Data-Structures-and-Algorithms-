

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityTest.
 *
  * @author Agathe Benichou
 * @version Version 1 / 11-08-2015
 */
public class CityTest
{
    City city;
    /**
     * Default constructor for test class CityTest
     */
    public CityTest()
    {
      city = new City("Tel Aviv");
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
    public void citytest1()
    {
        assertNotNull(city);
    }
    
     @Test
    public void citytest2()
    {
        assertNotNull(city.getCityName());
    }
    
     @Test
    public void citytest3()
    {
        assertSame(city.getCityName(), "Tel Aviv");
    }
}
