
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

/**
 * The test class CustomerContainerTest.
 *
 * @author  Agathe Benichou
 * @version Version 2 - 12/09/15
 */
public class CustomerContainerTest
{
    CityContainer cityContainer;
    CustomerContainer customerContainer;

    /**
     * Default constructor for test class CustomerContainerTest
     */
    public CustomerContainerTest()
    {
        cityContainer = new CityContainer();
        for(int i = 0; i < 100; i++)
        {
            cityContainer.addCity(new City(i));
        }

        customerContainer = new CustomerContainer(cityContainer); 
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
     * This test method tests that the getCustList method is not returning null
     * and that when the method is called twice, it gives the same data structure
     */
    @Test
    public void getCustListTest()
    {
        assertNotNull(customerContainer.getCustList());
        assertSame(customerContainer.getCustList(), customerContainer.getCustList());
    }

    /**
     * This test method tests that the getCustListSize method is not returning null
     * and that the method is returning the same size that the container in the clas
     * is
     */
    @Test
    public void getCustListSizeTest()
    {
        assertNotNull(customerContainer.getCustListSize());
        assertEquals(customerContainer.getCustListSize(), customerContainer.people.size());
    }

    /**
     * This test method tests the getCustomer method
     * It goes through the customer container and asserts that not null is being
     * returned from the method and then it makes sure that no two customer objects
     * are the same
     */
    @Test
    public void getCustomerTest()
    {
        for(int i = 1; i < customerContainer.getCustListSize();i++)
        {
            assertNotNull(customerContainer.getCustomer(i));
            assertNotSame(customerContainer.getCustomer(i), customerContainer.getCustomer(i-1));
        }
    }
}
