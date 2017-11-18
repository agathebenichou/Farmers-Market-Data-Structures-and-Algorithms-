

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class NeedTest.
 *
 * @author Agathe Benichou
 * @version Version 1 - 11/08/2015
 */
public class NeedTest
{
    Need need1;
    Need need2;
    
    /**
     * Default constructor for test class NeedTest
     */
    public NeedTest()
    {
        need1 = new Need("makeup");
        need2 = new Need("cheese");
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
     * A test method that makes sure that the get need name method
     * in the need class is not null
     */
    @Test
    public void needtest1()
    {
        assertNotNull(need1.getNeedName());
    }
    
    /**
     * A test method that make susre that the get need name
     * method in the need class is not null
     */
    @Test
    public void needtest2()
    {
        assertNotNull(need2.getNeedName());
    }
    
    /**
     * A test method that makes usre that the get need name method
     * is equal to the name of the need in the parameter
     * upon creation
     */
    @Test
    public void needtest3()
    {
        assertSame(need1.getNeedName(), "makeup");
    }
    
     /**
     * A test method that makes usre that the get need name method
     * is equal to the name of the need in the parameter
     * upon creation
     */
    @Test
    public void needtest4()
    {
        assertSame(need2.getNeedName(), "cheese");
    }
}
