

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * The test class CityItemCustomersTest.
 *
 * @author Agathe Benichou
 * @version Version 1 - 11/10/2015
 */
public class CityItemCustomersTest
{
    CityItemCustomers CIC;
    
    /**
     * Default constructor for test class CityItemCustomersTest
     */
    public CityItemCustomersTest()
    {
        CIC = new CityItemCustomers();
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
    public void CICReturnListTest1()
    {
        CIC.runSimulation();
        CIC.returnList("Easton","fruits");
    }
    
     @Test
    public void CICReturnListTest2()
    {
        CIC.runSimulation();
        CIC.returnList("Mt Pocono","dairy");
    }
    
     @Test
    public void CICReturnListTest3()
    {
        CIC.runSimulation();
        CIC.returnList("Allentown","bakedgoods");
    }
    
     @Test
    public void CICReturnListTest4()
    {
        CIC.runSimulation();
        CIC.returnList("Bangor","beverages");
    }
    
     @Test
    public void CICReturnListTest5()
    {
        CIC.runSimulation();
        CIC.returnList("Jim Thorpe","meat");
    }
    
     @Test
    public void CICReturnListTest6()
    {
        CIC.runSimulation();
        CIC.returnList("Bethlehem","vegetables");
    }
    
     @Test
    public void CICReturnGoodsTest1()
    {
        CIC.runSimulation();
        CIC.returnGoods("Easton");
    }
  
    @Test
    public void CICReturnGoodsTest2()
    {
        CIC.runSimulation();
        CIC.returnGoods("Mt Pocono");
    }
    
    @Test
    public void CICReturnGoodsTest3()
    {
        CIC.runSimulation();
        CIC.returnGoods("Allentown");
    }
    
    @Test
    public void CICReturnGoodsTest4()
    {
        CIC.runSimulation();
        CIC.returnGoods("Bethlehem");
    }
    
    @Test
    public void CICReturnGoodsTest5()
    {
        CIC.runSimulation();
        CIC.returnGoods("Bangor");
    }
    
    @Test
    public void CICReturnGoodsTest6()
    {
        CIC.runSimulation();
        CIC.returnGoods("Nazareth");
    }
}
