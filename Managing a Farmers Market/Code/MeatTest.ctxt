

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MeatTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MeatTest
{
    /**
     * Default constructor for test class MeatTest
     */
    public MeatTest()
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
        Meat<String> instance = new Meat<String>();
        
        instance.MeatQueue.offer("alpha");
        instance.MeatQueue.offer("beta");
        instance.MeatQueue.offer("card");
        
        assertNotNull(instance.MeatQueue);
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
        Meat<String> instance = new Meat<String>();
        
        instance.MeatQueue.offer("alpha");
        instance.MeatQueue.offer("beta");
        instance.MeatQueue.offer("card");
        
        assertNotNull(instance.MeatQueue.size());
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
        Meat<String> instance = new Meat<String>();
        
        instance.MeatQueue.offer("alpha");
        instance.MeatQueue.offer("beta");
        instance.MeatQueue.offer("card");
        
        assertEquals(instance.MeatQueue.size(), 3);
    }
    
    /**
     * asserts that the offer method works
     * makes sure that the first in, alpha, will be the first out
     */
     @Test
    public void testpeekString()
    {
        Meat<String> instance = new Meat<String>();
        
        instance.MeatQueue.offer("alpha");
        instance.MeatQueue.offer("beta");
        instance.MeatQueue.offer("card");
        
        assertEquals(instance.MeatQueue.peek(), "alpha");
  
    }
   
    /**
     * adds string elements to the queue
     * polls out the first string element
     * assert that the queue isnt null from polling out one elemenet
     */
     @Test
    public void testpollnotnullString()
    {
        Meat<String> instance = new Meat<String>();
        
        instance.MeatQueue.offer("alpha");
        instance.MeatQueue.offer("beta");
        instance.MeatQueue.offer("card");
        
        instance.MeatQueue.poll();
        assertNotNull(instance.MeatQueue);
       
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
        Meat<String> instance = new Meat<String>();
        
        instance.MeatQueue.offer("alpha");
        instance.MeatQueue.offer("beta");
        instance.MeatQueue.offer("card");
        
        instance.MeatQueue.poll();
       
         instance.MeatQueue.poll();
    
         instance.MeatQueue.poll();
        assertEquals(instance.MeatQueue.size(), 0);
    }
    
    /**
     * makes sure that the gaussian test is not a null number
     * 
     */
    @Test
    public void testgaussian()
    {
        Meat<String> instance = new Meat<String>();
        
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
        Meat<Integer> instance = new Meat<Integer>();
        
        instance.MeatQueue.offer(5);
        instance.MeatQueue.offer(35);
        instance.MeatQueue.offer(74);
        
        assertNotNull(instance.MeatQueue);
    }
    
    @Test
    public void testsizeInteger()
    {
        Meat<Integer> instance = new Meat<Integer>();
        
        instance.MeatQueue.offer(5);
        instance.MeatQueue.offer(35);
        instance.MeatQueue.offer(74);
        
        assertNotNull(instance.MeatQueue.size());
    }
    
    @Test
    public void testsize2Integer()
    {
        Meat<Integer> instance = new Meat<Integer>();
        
         instance.MeatQueue.offer(5);
        instance.MeatQueue.offer(35);
        instance.MeatQueue.offer(74);
        
        assertEquals(instance.MeatQueue.size(), 3);
    }
    
  
     @Test
    public void testpollnotnullInteger()
    {
        Meat<Integer> instance = new Meat<Integer>();
        
         instance.MeatQueue.offer(5);
        instance.MeatQueue.offer(35);
        instance.MeatQueue.offer(74);;
        
        instance.MeatQueue.poll();
        assertNotNull(instance.MeatQueue);
       
    }
    
     @Test
    public void testpollnullInteger()
    {
        Meat<Integer> instance = new Meat<Integer>();
        
        instance.MeatQueue.offer(5);
        instance.MeatQueue.offer(35);
        instance.MeatQueue.offer(74);
        
        instance.MeatQueue.poll();
       
         instance.MeatQueue.poll();
    
         instance.MeatQueue.poll();
        assertEquals(instance.MeatQueue.size(), 0);
    }
}
