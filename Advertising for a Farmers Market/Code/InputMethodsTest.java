

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InputMethodsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InputMethodsTest
{
    InputMethods inputmethods;
    
    /**
     * Default constructor for test class InputMethodsTest
     */
    public InputMethodsTest()
    {
        inputmethods = new InputMethods();
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
    public void readFileTest()
    {
        inputmethods.readFile();
    }
    
    @Test
    public void runProgramTest()
    {
        inputmethods.runProgram(2);
    }
    
}
