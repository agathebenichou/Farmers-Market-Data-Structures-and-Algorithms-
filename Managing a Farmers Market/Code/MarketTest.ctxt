

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class MarketTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MarketTest
{
    /**
     * Default constructor for test class MarketTest
     */
    public MarketTest()
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
     * A test that ensures that the getMoney method works and is returning money.
     */
    @Test
    public void getMoneyTest()
    {
        Market market = new Market();
        
        assertNotNull(market.getMoney());
    }
    
    /**
     * A test that makes sure that when the GenerateNeeds method runs, that is
     * returns an array list that is not null
     */
    @Test
    public void generateNeedsTest1()
    {
        Market market = new Market();
        
        assertNotNull(market.GenerateNeeds());
    }
    
    /**
     * A test that makes sure that the GenerateNeeds method is generating and returning an array list.
     * 
     */
    @Test
    public void generateNeedsTest2()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>();
        
        needs = market.GenerateNeeds();
        
        assertNotNull(needs);
    }
    
    /**
     * A test that makes sure that not all the lists of needs are the same.
     */
    @Test
    public void generateNeedsTest3()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>();
        ArrayList<Object> list = new ArrayList<Object>();
        
        needs = market.GenerateNeeds();
        list = market.GenerateNeeds();
        
        assertNotSame(needs, list);
    }
    
    /**
     * A test that makes sure that the bakedgoodsqueue method is running.
     * It also makes sure that it is returning a time;
     */
     @Test
    public void bakedgoodsqueueTest1()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotNull(market.bakedgoodsqueue(cust, iD, needs, currentTime));
        
    }
    
    /**
     * A test that makes sure that the bakedgoodsqueue method is not 
     * generating the same time for every customer.
     */
     @Test
    public void bakedgoodsqueueTest2()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotSame(market.bakedgoodsqueue(cust, iD, needs, currentTime), market.bakedgoodsqueue(cust, iD, needs, currentTime));
        
    }
    
    
     /**
     * A test that makes sure that the fruitqueue method is running.
     * It also makes sure that it is returning a time;
     */
     @Test
    public void fruitqueueTest1()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotNull(market.fruitqueue(cust, iD, needs, currentTime));
        
    }
    
    /**
     * A test that makes sure that the fruitqueue method is not 
     * generating the same time for every customer.
     */
     @Test
    public void fruitqueueTest2()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotSame(market.fruitqueue(cust, iD, needs, currentTime), market.fruitqueue(cust, iD, needs, currentTime));
        
    }
    
     /**
     * A test that makes sure that the vegetablequeue method is running.
     * It also makes sure that it is returning a time;
     */
     @Test
    public void vegetablequeueTest1()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotNull(market.vegetablequeue(cust, iD, needs, currentTime));
        
    }
    
    /**
     * A test that makes sure that the vegetablequeue method is not 
     * generating the same time for every customer.
     */
     @Test
    public void vegetablequeueTest2()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotSame(market.vegetablequeue(cust, iD, needs, currentTime), market.vegetablequeue(cust, iD, needs, currentTime));
        
    }
    
     /**
     * A test that makes sure that the meatqueue method is running.
     * It also makes sure that it is returning a time;
     */
     @Test
    public void meatqueueTest1()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotNull(market.meatqueue(cust, iD, needs, currentTime));
        
    }
    
    /**
     * A test that makes sure that the meatqueue method is not 
     * generating the same time for every customer.
     */
     @Test
    public void meatqueueTest2()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotSame(market.meatqueue(cust, iD, needs, currentTime), market.meatqueue(cust, iD, needs, currentTime));
        
    }
    
    /**
     * A test that makes sure that the beveragesqueue method is running.
     * It also makes sure that it is returning a time;
     */
     @Test
    public void beveragesqueueTest1()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotNull(market.beveragesqueue(cust, iD, needs, currentTime));
        
    }
    
     /**
     * A test that makes sure that the beveragesqueue method is not 
     * generating the same time for every customer.
     */
     @Test
    public void beveragesqueueTest2()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotSame(market.beveragesqueue(cust, iD, needs, currentTime), market.beveragesqueue(cust, iD, needs, currentTime));
        
    }
    
    /**
     * A test that makes sure that the dairyqueue method is running.
     * It also makes sure that it is returning a time;
     */
     @Test
    public void dairyqueueTest1()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotNull(market.dairyqueue(cust, iD, needs, currentTime));
        
    }
    
    /**
     * A test that makes sure that the dairyqueue method is not 
     * generating the same time for every customer.
     */
     @Test
    public void dairyqueueTest2()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        assertNotSame(market.dairyqueue(cust, iD, needs, currentTime), market.dairyqueue(cust, iD, needs, currentTime));
        
    }
    
     /**
     * A test that makes sure that the nullqueue method is running.
     * 
     */
    @Test
    public void nullqueue()
    {
        Market market = new Market();
        ArrayList<Object> needs = new ArrayList<Object>(); 
        needs = market.GenerateNeeds();
        Customer cust = new Customer();
        int iD = 3;
        int currentTime = 0;
        
        market.nullqueue(cust, iD, needs, currentTime);
        
    }
}



