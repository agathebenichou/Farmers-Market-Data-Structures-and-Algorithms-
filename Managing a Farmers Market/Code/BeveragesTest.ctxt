

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BeveragesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BeveragesTest
{
    /**
     * Default constructor for test class BeveragesTest
     */
    public BeveragesTest()
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
     * methods to test the fruit class with a string 
     * 
     */
    
    
    /**
     *
     *makes sure that the offer() method is properly adding strings to the queue
     * asserts that the queue isnt null
     */
    @Test
    public void testofferString()
    {
        Beverages<String> instance = new Beverages<String>();
        
        instance.BeveragesQueue.offer("alpha");
        instance.BeveragesQueue.offer("beta");
        instance.BeveragesQueue.offer("card");
        
        assertNotNull(instance.BeveragesQueue);
    }
    
    /**
     *
     *makes sure that the offer() method is working
     *ensures that the size() method is returning the correct amount of elements
     * asserts that the queue isnt null
     */
    @Test
    public void testsizeString()
    {
        Beverages<String> instance = new Beverages<String>();
        
        instance.BeveragesQueue.offer("alpha");
        instance.BeveragesQueue.offer("beta");
        instance.BeveragesQueue.offer("card");
        
        assertNotNull(instance.BeveragesQueue.size());
    }
    
    /**
     *
     * uses the offer() method to add string elements
     * asserts that the queue is the correct size
     * 
     */
    @Test
    public void testsize2String()
    {
        Beverages<String> instance = new Beverages<String>();
        
        instance.BeveragesQueue.offer("alpha");
        instance.BeveragesQueue.offer("beta");
        instance.BeveragesQueue.offer("card");
        
        assertEquals(instance.BeveragesQueue.size(), 3);
    }
    
    /**
     * asserts that the offer method works
     * makes sure that the first in, alpha, will be the first out
     */
     @Test
    public void testpeekString()
    {
        Beverages<String> instance = new Beverages<String>();
        
        instance.BeveragesQueue.offer("alpha");
        instance.BeveragesQueue.offer("beta");
        instance.BeveragesQueue.offer("card");
        
        assertEquals(instance.BeveragesQueue.peek(), "alpha");
  
    }
   
    /**
     * adds string elements to the queue
     * polls out the first string element
     * assert that the queue isnt null from polling out one elemenet
     */
     @Test
    public void testpollnotnullString()
    {
        Beverages<String> instance = new Beverages<String>();
        
        instance.BeveragesQueue.offer("alpha");
        instance.BeveragesQueue.offer("beta");
        instance.BeveragesQueue.offer("card");
        
        instance.BeveragesQueue.poll();
        assertNotNull(instance.BeveragesQueue);
       
    }
    
    /**
     * adds 3 strings elements to the queue
     * polls out 3 string element from the queueu
     * asserts that the size of the queue is now 0
     * 
     */
     @Test
    public void testpollnullString()
    {
        Beverages<String> instance = new Beverages<String>();
        
        instance.BeveragesQueue.offer("alpha");
        instance.BeveragesQueue.offer("beta");
        instance.BeveragesQueue.offer("card");
        
        instance.BeveragesQueue.poll();
       
         instance.BeveragesQueue.poll();
    
         instance.BeveragesQueue.poll();
        assertEquals(instance.BeveragesQueue.size(), 0);
    }
    
    /**
     * makes sure that the gaussian test is not a null number
     * 
     */
    @Test
    public void testgaussian()
    {
        Beverages<String> instance = new Beverages<String>();
        
        assertNotNull(instance.getGaussian(10,5));
        
    }
    
    /**
     * 
     * ALL THE SAME UNIT TEST METHODS AS ABOVE, EXCEPT WITH INTEGER
     * 
     */
    
    @Test
    public void testofferInteger()
    {
        Beverages<Integer> instance = new Beverages<Integer>();
        
        instance.BeveragesQueue.offer(5);
        instance.BeveragesQueue.offer(35);
        instance.BeveragesQueue.offer(74);
        
        assertNotNull(instance.BeveragesQueue);
    }
    
    @Test
    public void testsizeInteger()
    {
        Beverages<Integer> instance = new Beverages<Integer>();
        
        instance.BeveragesQueue.offer(5);
        instance.BeveragesQueue.offer(35);
        instance.BeveragesQueue.offer(74);
        
        assertNotNull(instance.BeveragesQueue.size());
    }
    
    @Test
    public void testsize2Integer()
    {
        Beverages<Integer> instance = new Beverages<Integer>();
        
         instance.BeveragesQueue.offer(5);
        instance.BeveragesQueue.offer(35);
        instance.BeveragesQueue.offer(74);
        
        assertEquals(instance.BeveragesQueue.size(), 3);
    }
    
  
     @Test
    public void testpollnotnullInteger()
    {
        Beverages<Integer> instance = new Beverages<Integer>();
        
         instance.BeveragesQueue.offer(5);
        instance.BeveragesQueue.offer(35);
        instance.BeveragesQueue.offer(74);;
        
        instance.BeveragesQueue.poll();
        assertNotNull(instance.BeveragesQueue);
       
    }
    
     @Test
    public void testpollnullInteger()
    {
        Beverages<Integer> instance = new Beverages<Integer>();
        
        instance.BeveragesQueue.offer(5);
        instance.BeveragesQueue.offer(35);
        instance.BeveragesQueue.offer(74);
        
        instance.BeveragesQueue.poll();
       
         instance.BeveragesQueue.poll();
    
         instance.BeveragesQueue.poll();
        assertEquals(instance.BeveragesQueue.size(), 0);
    }
}
