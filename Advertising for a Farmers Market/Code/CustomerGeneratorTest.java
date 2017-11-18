

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CustomerGeneratorTest.
 *
 * @author  Agathe Benichou
 * @version Version 1 - 11/10/2015
 */
public class CustomerGeneratorTest
{
    
    CustomerGenerator  customer;
    /**
     * Default constructor for test class CustomerGeneratorTest
     */
    public CustomerGeneratorTest()
    {
     customer = new CustomerGenerator();  
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
     * A test the make sure the getcustomer method is returning
     * something
     */
    @Test
    public void custgenertest1()
    {
        assertNotNull(customer.getCustomer());
    }
    
    /**
     * A test that makes sure the ccustomerqueuesize is
     * returning something
     */
    @Test
    public void custgenertest2()
    {
        assertNotNull(customer.CustomerQueueSize());
    }
    
     /**
     * A test that makes sure the retrievecustomer method is
     * returning something
     */
    @Test
    public void custgenertest3()
    {
        assertNotNull(customer.retrieveCustomer());
    }
    
    /**
     * A test that makes sure the customer generator method is
     * returning something
     */
    @Test
    public void custgenertest4()
    {
        assertNotNull(customer.CustomerGenerator());
    }
    
    /**
     * A test that makes no two customer objects are the same
     */
    @Test
    public void custgenertest5()
    {
        assertNotSame(customer.CustomerGenerator(), customer.CustomerGenerator());
    }
    
    /**
     *A test that makes sure ifyou get a customer, it returns the same
     *customer object
     */
    @Test
    public void custgenertest6()
    {
        assertEquals(customer.getCustomer(), customer.getCustomer());
    }
    
    /**
     * A test that makes sure the get customer list method is
     * returning something
     */
    @Test
    public void custgenertest7()
    {
        assertNotNull(customer.getCustList());
    }
    
    /**
     * A test that makes sure the get customer list method is
     * returning the same list
     */
    @Test
    public void custgenertest8()
    {
        assertSame(customer.getCustList(), customer.getCustList());
    }
    
    /**
     * A test that makes sure the customer queue size method is
     * not the same size each time
     */
    @Test
    public void custgenertest9()
    {
        assertNotSame(customer.CustomerQueueSize(), customer.CustomerQueueSize());
    }
    
    /**
     * A test that makes sure the retrievecustomer method is
     * returning something
     */
    @Test
    public void custgenertest10()
    {
        assertNotSame(customer.retrieveCustomer(), customer.retrieveCustomer());
    }
}
