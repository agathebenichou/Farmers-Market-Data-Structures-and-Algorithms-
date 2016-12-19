
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;

/**
 * The test class CustomerGeneratorTest.
 *
 * @author  Agathe Benichou
 * @version Version 1 - 11/10/2015
 */
public class CustomerGeneratorTest
{
    /**
     * Default constructor for test class CustomerGeneratorTest
     * 

     */
    public CustomerGeneratorTest()
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

    /**
     * Creates an instance of CityContainer and fills the container with
     * cities. Creates an instance of CustomerGenerator and calls the genertor
     * method in the class. 
     * Asserts that Customers are being created.
     * Asserts that no two Customers objects are the same.
     */
    @Test
    public void customerGeneratorNotNullTest()
    {
        CityContainer city = new CityContainer();
        for(int i = 0; i < 100; i++)
        {
            city.addCity(new City(i));
        }

        CustomerGenerator custGenerator = new CustomerGenerator();
        assertNotNull(custGenerator.CustomerGenerator(city));
        assertNotSame(custGenerator.CustomerGenerator(city), custGenerator.CustomerGenerator(city));
    }
}
