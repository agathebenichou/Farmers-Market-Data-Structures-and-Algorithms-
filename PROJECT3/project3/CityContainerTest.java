
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityContainerTest
{
    CityContainer cityContainerClass;
    /**
     * Default constructor for test class CityContainerTest
     */
    public CityContainerTest()
    {
        cityContainerClass = new CityContainer();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
         for(int i = 0; i < 100; i ++)
        {
            cityContainerClass.addCity(new City(i));
        }   
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

    /**
     * A test method that asserts that all cities are being added
     */
    @Test
    public void addCityTest()
    {
        for(int i = 0; i < 100; i ++)
        {
            assertTrue(cityContainerClass.addCity(new City(i)));
        }
    }

    /**
     * A test method that tests that the totalCityList method is not returning
     * null after cities have been added and that the getcontainersize
     * method is returning the size of the number of cities that have been
     * added
     */
    @Test
    public void cityContainerTest()
    {
        assertNotNull(cityContainerClass.totalCityList());
        assertEquals(cityContainerClass.getContainerSize(), 100);
    }

    /**
     * A test method that tests the getCity method to see that it does not return
     * a null object, that two objects at two indexs are not the same and that two objects
     * at the same index are the same 
     */
    @Test
    public void getCityIntTest()
    {
        assertNotNull(cityContainerClass.getCity(1));
        assertNotSame(cityContainerClass.getCity(1), cityContainerClass.getCity(2));
        assertSame(cityContainerClass.getCity(1),cityContainerClass.getCity(1));
    }
    
   /**
    * A test method that tests that the randomlyassigncitymethod is not returning null
    * when cities have been added to the container and the method tries to assign
    * a city
    */
    @Test
    public void randomlyAssignCityTest()
    {
        assertNotNull(cityContainerClass.randomlyAssignCity());
    }
}
