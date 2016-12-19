

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VegetableTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VegetableTest
{
    /**
     * Default constructor for test class VegetableTest
     */
    public VegetableTest()
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
        Vegetable<String> instance = new Vegetable<String>();
        
        instance.VegetableQueue.offer("alpha");
        instance.VegetableQueue.offer("beta");
        instance.VegetableQueue.offer("card");
        
        assertNotNull(instance.VegetableQueue);
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
        Vegetable<String> instance = new Vegetable<String>();
        
        instance.VegetableQueue.offer("alpha");
        instance.VegetableQueue.offer("beta");
        instance.VegetableQueue.offer("card");
        
        assertNotNull(instance.VegetableQueue.size());
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
        Vegetable<String> instance = new Vegetable<String>();
        
        instance.VegetableQueue.offer("alpha");
        instance.VegetableQueue.offer("beta");
        instance.VegetableQueue.offer("card");
        
        assertEquals(instance.VegetableQueue.size(), 3);
    }
    
    /**
     * asserts that the offer method works
     * makes sure that the first in, alpha, will be the first out
     */
     @Test
    public void testpeekString()
    {
        Vegetable<String> instance = new Vegetable<String>();
        
        instance.VegetableQueue.offer("alpha");
        instance.VegetableQueue.offer("beta");
        instance.VegetableQueue.offer("card");
        
        assertEquals(instance.VegetableQueue.peek(), "alpha");
  
    }
   
    /**
     * adds string elements to the queue
     * polls out the first string element
     * assert that the queue isnt null from polling out one elemenet
     */
     @Test
    public void testpollnotnullString()
    {
        Vegetable<String> instance = new Vegetable<String>();
        
        instance.VegetableQueue.offer("alpha");
        instance.VegetableQueue.offer("beta");
        instance.VegetableQueue.offer("card");
        
        instance.VegetableQueue.poll();
        assertNotNull(instance.VegetableQueue);
       
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
        Vegetable<String> instance = new Vegetable<String>();
        
        instance.VegetableQueue.offer("alpha");
        instance.VegetableQueue.offer("beta");
        instance.VegetableQueue.offer("card");
        
        instance.VegetableQueue.poll();
       
         instance.VegetableQueue.poll();
    
         instance.VegetableQueue.poll();
        assertEquals(instance.VegetableQueue.size(), 0);
    }
    
    /**
     * makes sure that the gaussian test is not a null number
     * 
     */
    @Test
    public void testgaussian()
    {
        Vegetable<String> instance = new Vegetable<String>();
        
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
        Vegetable<Integer> instance = new Vegetable<Integer>();
        
        instance.VegetableQueue.offer(5);
        instance.VegetableQueue.offer(35);
        instance.VegetableQueue.offer(74);
        
        assertNotNull(instance.VegetableQueue);
    }
    
    @Test
    public void testsizeInteger()
    {
        Vegetable<Integer> instance = new Vegetable<Integer>();
        
        instance.VegetableQueue.offer(5);
        instance.VegetableQueue.offer(35);
        instance.VegetableQueue.offer(74);
        
        assertNotNull(instance.VegetableQueue.size());
    }
    
    @Test
    public void testsize2Integer()
    {
        Vegetable<Integer> instance = new Vegetable<Integer>();
        
         instance.VegetableQueue.offer(5);
        instance.VegetableQueue.offer(35);
        instance.VegetableQueue.offer(74);
        
        assertEquals(instance.VegetableQueue.size(), 3);
    }
    
  
     @Test
    public void testpollnotnullInteger()
    {
        Vegetable<Integer> instance = new Vegetable<Integer>();
        
         instance.VegetableQueue.offer(5);
        instance.VegetableQueue.offer(35);
        instance.VegetableQueue.offer(74);;
        
        instance.VegetableQueue.poll();
        assertNotNull(instance.VegetableQueue);
       
    }
    
     @Test
    public void testpollnullInteger()
    {
        Vegetable<Integer> instance = new Vegetable<Integer>();
        
        instance.VegetableQueue.offer(5);
        instance.VegetableQueue.offer(35);
        instance.VegetableQueue.offer(74);
        
        instance.VegetableQueue.poll();
       
         instance.VegetableQueue.poll();
    
         instance.VegetableQueue.poll();
        assertEquals(instance.VegetableQueue.size(), 0);
    }
}
