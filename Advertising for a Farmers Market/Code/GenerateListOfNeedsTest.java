

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GenerateListOfNeedsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GenerateListOfNeedsTest
{
    /**
     * Default constructor for test class GenerateListOfNeedsTest
     */
    public GenerateListOfNeedsTest()
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
    public void generatetest1()
    {
        GenerateListOfNeeds needs = new GenerateListOfNeeds();
        assertNotNull(needs.GenerateNeeds());
    }
    
     @Test
    public void generatetest2()
    {
        GenerateListOfNeeds needs = new GenerateListOfNeeds();
        assertNotSame(needs.GenerateNeeds(), needs.GenerateNeeds());
    }
}
