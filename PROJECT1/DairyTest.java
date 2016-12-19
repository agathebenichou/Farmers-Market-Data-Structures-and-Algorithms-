

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DairyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DairyTest
{
    /**
     * Default constructor for test class DairyTest
     */
    public DairyTest()
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
        Dairy<String> instance = new Dairy<String>();
        
        instance.DairyQueue.offer("alpha");
        instance.DairyQueue.offer("beta");
        instance.DairyQueue.offer("card");
        
        assertNotNull(instance.DairyQueue);
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
        Dairy<String> instance = new Dairy<String>();
        
        instance.DairyQueue.offer("alpha");
        instance.DairyQueue.offer("beta");
        instance.DairyQueue.offer("card");
        
        assertNotNull(instance.DairyQueue.size());
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
        Dairy<String> instance = new Dairy<String>();
        
        instance.DairyQueue.offer("alpha");
        instance.DairyQueue.offer("beta");
        instance.DairyQueue.offer("card");
        
        assertEquals(instance.DairyQueue.size(), 3);
    }
    
    /**
     * asserts that the offer method works
     * makes sure that the first in, alpha, will be the first out
     */
     @Test
    public void testpeekString()
    {
        Dairy<String> instance = new Dairy<String>();
        
        instance.DairyQueue.offer("alpha");
        instance.DairyQueue.offer("beta");
        instance.DairyQueue.offer("card");
        
        assertEquals(instance.DairyQueue.peek(), "alpha");
  
    }
   
    /**
     * adds string elements to the queue
     * polls out the first string element
     * assert that the queue isnt null from polling out one elemenet
     */
     @Test
    public void testpollnotnullString()
    {
        Dairy<String> instance = new Dairy<String>();
        
        instance.DairyQueue.offer("alpha");
        instance.DairyQueue.offer("beta");
        instance.DairyQueue.offer("card");
        
        instance.DairyQueue.poll();
        assertNotNull(instance.DairyQueue);
       
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
        Dairy<String> instance = new Dairy<String>();
        
        instance.DairyQueue.offer("alpha");
        instance.DairyQueue.offer("beta");
        instance.DairyQueue.offer("card");
        
        instance.DairyQueue.poll();
       
         instance.DairyQueue.poll();
    
         instance.DairyQueue.poll();
        assertEquals(instance.DairyQueue.size(), 0);
    }
    
    /**
     * makes sure that the gaussian test is not a null number
     * 
     */
    @Test
    public void testgaussian()
    {
        Dairy<String> instance = new Dairy<String>();
        
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
        Dairy<Integer> instance = new Dairy<Integer>();
        
        instance.DairyQueue.offer(5);
        instance.DairyQueue.offer(35);
        instance.DairyQueue.offer(74);
        
        assertNotNull(instance.DairyQueue);
    }
    
    @Test
    public void testsizeInteger()
    {
        Dairy<Integer> instance = new Dairy<Integer>();
        
        instance.DairyQueue.offer(5);
        instance.DairyQueue.offer(35);
        instance.DairyQueue.offer(74);
        
        assertNotNull(instance.DairyQueue.size());
    }
    
    @Test
    public void testsize2Integer()
    {
        Dairy<Integer> instance = new Dairy<Integer>();
        
         instance.DairyQueue.offer(5);
        instance.DairyQueue.offer(35);
        instance.DairyQueue.offer(74);
        
        assertEquals(instance.DairyQueue.size(), 3);
    }
    
  
     @Test
    public void testpollnotnullInteger()
    {
        Dairy<Integer> instance = new Dairy<Integer>();
        
         instance.DairyQueue.offer(5);
        instance.DairyQueue.offer(35);
        instance.DairyQueue.offer(74);;
        
        instance.DairyQueue.poll();
        assertNotNull(instance.DairyQueue);
       
    }
    
     @Test
    public void testpollnullInteger()
    {
        Dairy<Integer> instance = new Dairy<Integer>();
        
        instance.DairyQueue.offer(5);
        instance.DairyQueue.offer(35);
        instance.DairyQueue.offer(74);
        
        instance.DairyQueue.poll();
       
         instance.DairyQueue.poll();
    
         instance.DairyQueue.poll();
        assertEquals(instance.DairyQueue.size(), 0);
    }
}
