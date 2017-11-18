
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LocationContainerTest.
 *
 * @author Agathe Benichou
 * @version Version 1 - 12/08/2015
 */
public class LocationContainerTest
{
    NeedContainer needContainer;
    LocationContainer locationContainer;
    
    /**
     * Default constructor for test class LocationContainerTest
     */
    public LocationContainerTest()
    {
        needContainer = new NeedContainer();
        locationContainer = new LocationContainer(needContainer);

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        for(int i = 0; i < 5; i ++)
        {
            locationContainer.addLocation("meat", i);
            locationContainer.addLocation("vegetables", i);
            locationContainer.addLocation("fruits", i);
            locationContainer.addLocation("baked goods", i);
            locationContainer.addLocation("beverages", i);
            locationContainer.addLocation("dairy", i);
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
     * A test method that tests that the addLocation method is successfully
     * returning true upon insertion. 
     */
    @Test
    public void addLocationTest()
    {
        for(int i = 0; i < 5; i ++)
        {
            assertTrue(locationContainer.addLocation("meat", i));
            assertTrue(locationContainer.addLocation("vegetables", i));
            assertTrue(locationContainer.addLocation("fruits", i));
            assertTrue(locationContainer.addLocation("baked goods", i));
            assertTrue(locationContainer.addLocation("beverages", i));
            assertTrue(locationContainer.addLocation("dairy", i));
        }
    }

    /**
     * This test method asserts that the getLocationsOfNeed method is returning
     * not null. It returns the Linked List of Integer locations where the
     * warehouses are stored.
     */
    @Test
    public void getLocationsOfNeedTest()
    {
        assertNotNull(locationContainer.getLocationsOfNeed("meat"));
        assertNotNull(locationContainer.getLocationsOfNeed("vegetables"));
        assertNotNull(locationContainer.getLocationsOfNeed("fruits"));
        assertNotNull(locationContainer.getLocationsOfNeed("baked goods"));
        assertNotNull(locationContainer.getLocationsOfNeed("beverages"));
        assertNotNull(locationContainer.getLocationsOfNeed("dairy"));  
    }

    /**
     * This test mathos asserts that the getAmountOfLocationsForNeed method
     * is returning not null and that, for the container in this test class, 
     * the amount of locations is 5
     */
    @Test
    public void getAmountOfLocationsForNeedTest()
    {
        assertNotNull(locationContainer.getAmountOfLocationsForNeed("meat"));
        assertNotNull(locationContainer.getAmountOfLocationsForNeed("vegetables"));
        assertNotNull(locationContainer.getAmountOfLocationsForNeed("fruits"));
        assertNotNull(locationContainer.getAmountOfLocationsForNeed("baked goods"));
        assertNotNull(locationContainer.getAmountOfLocationsForNeed("beverages"));
        assertNotNull(locationContainer.getAmountOfLocationsForNeed("dairy"));
        
        assertSame(locationContainer.getAmountOfLocationsForNeed("meat"), 5);
        assertSame(locationContainer.getAmountOfLocationsForNeed("vegetables"), 5);
        assertSame(locationContainer.getAmountOfLocationsForNeed("fruits"), 5);
        assertSame(locationContainer.getAmountOfLocationsForNeed("baked goods"), 5);
        assertSame(locationContainer.getAmountOfLocationsForNeed("beverages"), 5);
        assertSame(locationContainer.getAmountOfLocationsForNeed("dairy"),5);
    }
}
