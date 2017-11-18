
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GaussianTest.
 *
 * @author  Agathe Benichou
 * @version Version 1 - 10/31/2015
 */
public class GaussianTest
{

    Gaussian gaus;
    /**
     * Default constructor for test class GaussianTest
     */
    public GaussianTest()
    {
        gaus = new Gaussian();
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
    public void gaussiantest1()
    {
        double numb = gaus.getGaussian(31, 6);
        assertNotNull(numb);
    }

    @Test
    public void gaussiantest2()
    {
        double numb = gaus.getGaussian(122, 21);
        assertNotNull(numb);
    }
    
    @Test
    public void gaussiantest3()
    {
        int numb2 = (int)gaus.getGaussian(2,1);
        int numb = (int)gaus.getGaussian(32, 1);
        assertNotSame(numb, numb2);
    }
}
