

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CustomerContainerTest
{
    
    CustomerContainer custContainer;
    
    /**
     * Default constructor for test class CustomerContainerTest
     */
    public CustomerContainerTest()
    {
        custContainer = new CustomerContainer();
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
     * This test method makes sure that the LinkedList in the customer
     * container class are not null 
     */
    @Test
    public void customercontainertest1()
    {
        assertNotNull(custContainer.people);
        assertNotNull(custContainer.peopleToPull);
    }
    
    /**
     * This test method makes sure that the two LinkedList Queues 
     * are pulling the same customer list from the customer generator
     */
     @Test
    public void customercontainertest2()
    {
        assertSame(custContainer.people, custContainer.peopleToPull);
    }
    
    /**
     * A test method that the get cust method is returning something
     */
     @Test
    public void customercontainertest3()
    {
        assertNotNull(custContainer.getCust());
    }
    
    /**
     * A test method that makes sure that the get customer method
     * which returns a list of customer is the same at the people
     * list which is equal to that
     */
      @Test
    public void customercontainertest4()
    {
        assertSame(custContainer.getCust(), custContainer.people);
    }
    
    /**
     * A test method that makes sure that the list amount method
     * is returning something
     */
      @Test
    public void customercontainertest5()
    {
        assertNotNull(custContainer.listAmount());
    }
    
    /**
     * A test method that makes sure that the pull customer
     * method is returnign something
     */
     @Test
    public void customercontainertest7()
    {
        assertNotNull(custContainer.pullCustomer());
    }
 
}
