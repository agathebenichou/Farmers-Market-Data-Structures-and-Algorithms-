
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemCityCustomersTest.
 *
 * @author  Agathe Benichou
 * @version Version 1 - 11/14/2015
 */
public class ItemCityCustomersTest
{
    NeedContainer needContainer;
    CityContainer cityContainer;
    CustomerContainer customerContainer;
    ItemCityCustomers ICC;

    /**
     * Default constructor for test class ItemCityCustomersTest
     */
    public ItemCityCustomersTest()
    {
        needContainer = new NeedContainer();
        cityContainer = new CityContainer();
        for(int i = 0; i< 100;i++)
        {
            cityContainer.addCity(new City(i));
        }
        customerContainer = new CustomerContainer(cityContainer);

        ICC = new ItemCityCustomers(customerContainer, cityContainer, needContainer);
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
     * This test method asserts that the getCitiesWithNeed method is
     * not returning null. It is possible that two needs have the 
     * same cities of customers who have those items so it is not true
     * that they have to be the same or not the same.
     */
    @Test
    public void getCitiesWithNeedTest()
    {
        assertNotNull(ICC.getCitiesWithNeed("meat"));
        assertNotNull(ICC.getCitiesWithNeed("vegetables"));
        assertNotNull(ICC.getCitiesWithNeed("fruits"));
        assertNotNull(ICC.getCitiesWithNeed("dairy"));
        assertNotNull(ICC.getCitiesWithNeed("baked goods"));
        assertNotNull(ICC.getCitiesWithNeed("beverages"));
    }

    /**
     * This test method asserts that the getCitiesSizeWithNeed method is
     * not returning null. It is possible that two needs have the 
     * same cities of customers who have those items so it is not true
     * that they have to be the same or not the same.
     */
    @Test
    public void getCitiesSizeWithNeedTest()
    {
        assertNotNull(ICC.getCitiesSizeWithNeed("meat"));
        assertNotNull(ICC.getCitiesSizeWithNeed("vegetables"));
        assertNotNull(ICC.getCitiesSizeWithNeed("fruits"));
        assertNotNull(ICC.getCitiesSizeWithNeed("dairy"));
        assertNotNull(ICC.getCitiesSizeWithNeed("baked goods"));
        assertNotNull(ICC.getCitiesSizeWithNeed("beverages"));

        assertSame(ICC.getCitiesSizeWithNeed("meat"), ICC.getCitiesSizeWithNeed("meat"));
        assertSame(ICC.getCitiesSizeWithNeed("vegetables"), ICC.getCitiesSizeWithNeed("vegetables"));
        assertSame(ICC.getCitiesSizeWithNeed("fruits"), ICC.getCitiesSizeWithNeed("fruits"));
        assertSame(ICC.getCitiesSizeWithNeed("dairy"), ICC.getCitiesSizeWithNeed("dairy"));
        assertSame(ICC.getCitiesSizeWithNeed("baked goods"), ICC.getCitiesSizeWithNeed("baked goods"));
        assertSame(ICC.getCitiesSizeWithNeed("beverages"), ICC.getCitiesSizeWithNeed("beverages"));
    }

    /**
     * This test method asserts that the getCityWithNeedAndIndex method is not returning null
     * and it asserts that there is the same customer object 
     */
    @Test
    public void getCityWithNeedAndIndexTest()
    {
        assertNotNull(ICC.getCityWithNeedAndIndex("meat", 3));
        assertNotNull(ICC.getCityWithNeedAndIndex("vegetables", 3));
        assertNotNull(ICC.getCityWithNeedAndIndex("fruits", 3));
        assertNotNull(ICC.getCityWithNeedAndIndex("dairy", 3));
        assertNotNull(ICC.getCityWithNeedAndIndex("baked goods", 3));
        assertNotNull(ICC.getCityWithNeedAndIndex("beverages", 3));

        assertSame(ICC.getCityWithNeedAndIndex("meat", 3), ICC.getCityWithNeedAndIndex("meat", 3));
        assertSame(ICC.getCityWithNeedAndIndex("vegetables", 3), ICC.getCityWithNeedAndIndex("vegetables", 3));
        assertSame(ICC.getCityWithNeedAndIndex("fruits", 3), ICC.getCityWithNeedAndIndex("fruits", 3));
        assertSame(ICC.getCityWithNeedAndIndex("dairy", 3), ICC.getCityWithNeedAndIndex("dairy", 3));
        assertSame(ICC.getCityWithNeedAndIndex("baked goods", 3), ICC.getCityWithNeedAndIndex("baked goods", 3));
        assertSame(ICC.getCityWithNeedAndIndex("beverages", 3), ICC.getCityWithNeedAndIndex("beverages", 3));
    }
    
    /**
     * This test method asserts that the getCitiesWithCity method is
     * not returning null. It is possible that two needs have the 
     * same cities of customers who have those items so it is not true
     * that they have to be the same or not the same.
     */
    @Test
    public void getCustomersWithCityTest()
    {
        assertNotNull(ICC.getCustomersWithCity(2));
        assertNotNull(ICC.getCustomersWithCity(5));
        assertNotNull(ICC.getCustomersWithCity(47));
        assertNotNull(ICC.getCustomersWithCity(38));
        assertNotNull(ICC.getCustomersWithCity(56));
        assertNotNull(ICC.getCustomersWithCity(63));
    }
    
     /**
     * This test method asserts that the getCitiesSizeWithNeed method is
     * not returning null. It is possible that two needs have the 
     * same cities of customers who have those items so it is not true
     * that they have to be the same or not the same.
     */
    @Test
    public void getCustomerSizeWithCityTest()
    {
        assertNotNull(ICC.getCustomerSizeWithCity(2));
        assertNotNull(ICC.getCustomerSizeWithCity(5));
        assertNotNull(ICC.getCustomerSizeWithCity(47));
        assertNotNull(ICC.getCustomerSizeWithCity(23));
        assertNotNull(ICC.getCustomerSizeWithCity(93));
        assertNotNull(ICC.getCustomerSizeWithCity(74));

        assertSame(ICC.getCustomerSizeWithCity(2), ICC.getCustomerSizeWithCity(2));     
        assertSame(ICC.getCustomerSizeWithCity(5), ICC.getCustomerSizeWithCity(5));
        assertSame(ICC.getCustomerSizeWithCity(23), ICC.getCustomerSizeWithCity(23));
        assertSame(ICC.getCustomerSizeWithCity(45), ICC.getCustomerSizeWithCity(45));
        assertSame(ICC.getCustomerSizeWithCity(67), ICC.getCustomerSizeWithCity(67));
        assertSame(ICC.getCustomerSizeWithCity(75), ICC.getCustomerSizeWithCity(75));
    }

     /**
     * This test method asserts that the getCityWithNeedAndIndex method is not returning null
     * and it asserts that there is the same customer object 
     */
    @Test
    public void getCustomerWithCityAndIndexTest()
    {
        assertNotNull(ICC.getCustomerWithCityAndIndex(4, 3));
        assertNotNull(ICC.getCustomerWithCityAndIndex(6, 3));
        assertNotNull(ICC.getCustomerWithCityAndIndex(34, 3));
        assertNotNull(ICC.getCustomerWithCityAndIndex(54, 3));
        assertNotNull(ICC.getCustomerWithCityAndIndex(63, 3));
        assertNotNull(ICC.getCustomerWithCityAndIndex(73, 3));

        assertSame(ICC.getCustomerWithCityAndIndex(4, 3), ICC.getCustomerWithCityAndIndex(4, 3));
        assertSame(ICC.getCustomerWithCityAndIndex(23, 3), ICC.getCustomerWithCityAndIndex(23, 3));
        assertSame(ICC.getCustomerWithCityAndIndex(34, 3), ICC.getCustomerWithCityAndIndex(34, 3));
        assertSame(ICC.getCustomerWithCityAndIndex(45, 3), ICC.getCustomerWithCityAndIndex(45, 3));
        assertSame(ICC.getCustomerWithCityAndIndex(56, 3), ICC.getCustomerWithCityAndIndex(56, 3));
        assertSame(ICC.getCustomerWithCityAndIndex(64, 3), ICC.getCustomerWithCityAndIndex(64, 3));
    }
}
