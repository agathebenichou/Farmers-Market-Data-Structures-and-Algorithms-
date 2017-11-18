
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Scanner;

/**
 * The test class ReadFileTest.
 *
  * @author  Agathe Benichou
 * @version Version 1 - 11/10/2015
 */
public class ReadFileTest
{

    ReadFile read;

    /**
     * Default constructor for test class ReadFileTest
     */
    public ReadFileTest()
    {
        read = new ReadFile();
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
    public void readfiletest1()
    {
        assertNotNull(read.cityContainer);
    }
    
     @Test
    public void readfiletest2()
    {
        assertEquals(read.cityContainer.size(), 10);
    }
}
