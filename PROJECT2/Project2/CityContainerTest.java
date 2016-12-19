
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
     * A test method that makes sure the queue in the
     * city container class is not null
     */
    @Test
    public void citycontainertest1()
    {
        assertNotNull(cityContainerClass.cityContainer);
    }

    /**
     * A test method that make sure that the size of the 
     * city container queue is equal to the amoutn of cities 
     * in the test file, 10
     */
    @Test
    public void citycontainertest2()
    {
        assertSame(cityContainerClass.cityContainer.size(), 10);
    }

    /**
     * A test method that makes sure that the get city method is r
     * returning something
     */
    @Test
    public void citycontainertest3()
    {
        assertNotNull(cityContainerClass.getCity());
    }

    /**
     * A test method that makes sure that the size of the city contianer
     * is equal to the get size method
     */
    @Test
    public void citycontainertest4()
    {
        assertSame(cityContainerClass.cityContainer.size(), cityContainerClass.getCitySize());
    }
    
    
}
