

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ExperimentControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExperimentControllerTest
{
    /**
     * Default constructor for test class ExperimentControllerTest
     */
    public ExperimentControllerTest()
    {
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
    public void generaltest()
    {
        ExperimentController experime1 = new ExperimentController();
        experime1.getId();
        experime1.getCustomer();
        experime1.CustomerGenerator();
        experime1.ArrivalTime();
    }
}



