
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class CustomerTest.
 * 
 * @author Agathe Benichou
 * @version Version 2 - 10/31/2015
 */
public class CustomerTest
{
    /**
     * Classes called to create Customer object
     */
     GenerateListOfNeeds list;
     Customer cust;
     
     /**
      * Objects and Lists used to create Customer object
      */
     City city;
     ArrayList<Need> listneeds;

    /**
     * Default constructor for test class CustomerTest
     */
    public CustomerTest()
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
         list = new GenerateListOfNeeds();
         listneeds = new ArrayList<Need>();
         listneeds = list.GenerateNeeds();
         city = new City(2);
         cust = new Customer("32", listneeds, city);
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
     * A test method which creates a new Customer object with an id and the GenerateNeeds() method
     * from GenerateListOfNeeds class and asserts that the Customer object is not null and that is
     * has been created.
     */
    @Test
    public void assertCustomerObjectNotNullTest()
    {
       setUp();
       assertNotNull(cust);
    }

    /**
     * A test method which creates a new Customer object and the GenerateNeeds() method from the
     * GenerateListOfNeeds class and asserts that the getId() method from the Customer class matches
     * up with the id number of the customer.
     */
    @Test
    public void assertGetIdMethodTest()
    {
        assertEquals(cust.getId(), "32");
    }

    /**
     * A test method which creates a new Customer object and the GenerateNeeds() method from the
     * GenerateListOfNeeds class and asserts that the getListSize() method from the Customer class matches
     * up with the size of the List of Needs of the customer.
     */
    @Test
    public void assertGetListSizeMethodTest()
    {
        assertEquals(cust.getListSize(), listneeds.size());
    }

    /**
     * This test method converts the generated list of needs from need
     * objects to strings. It makes sure that the lists are equal in String 
     * form and it tests that the getlist method is properly returning the list
     */
    @Test
    public void assertGetListMethodTest()
    {
        ArrayList<String> needsInString = new ArrayList<String>();

        for(Need needs : listneeds)
        {
            needsInString.add(needs.getNeedName());
        }

        assertEquals(cust.getList(), needsInString);
    }

    /**
     * This test method tests that the getCity() method is returning something
     * Makes sure that the city number assigned to the customer is the 
     * same city that the getCity method is returning
     */
    @Test
    public void assertGetCityMethodTest()
    {
         assertNotNull(cust.getCity());
         assertSame(cust.getCity(), city.getCityReference());
    }

}
