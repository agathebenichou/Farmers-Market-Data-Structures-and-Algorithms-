

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FruitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FruitTest
{
    /**
     * Default constructor for test class FruitTest
     */
    public FruitTest()
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
        Fruit<String> instance = new Fruit<String>();
        
        instance.FruitQueue.offer("alpha");
        instance.FruitQueue.offer("beta");
        instance.FruitQueue.offer("card");
        
        assertNotNull(instance.FruitQueue);
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
        Fruit<String> instance = new Fruit<String>();
        
        instance.FruitQueue.offer("alpha");
        instance.FruitQueue.offer("beta");
        instance.FruitQueue.offer("card");
        
        assertNotNull(instance.FruitQueue.size());
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
        Fruit<String> instance = new Fruit<String>();
        
        instance.FruitQueue.offer("alpha");
        instance.FruitQueue.offer("beta");
        instance.FruitQueue.offer("card");
        
        assertEquals(instance.FruitQueue.size(), 3);
    }
    
    /**
     * asserts that the offer method works
     * makes sure that the first in, alpha, will be the first out
     */
     @Test
    public void testpeekString()
    {
        Fruit<String> instance = new Fruit<String>();
        
        instance.FruitQueue.offer("alpha");
        instance.FruitQueue.offer("beta");
        instance.FruitQueue.offer("card");
        
        assertEquals(instance.FruitQueue.peek(), "alpha");
  
    }
   
    /**
     * adds string elements to the queue
     * polls out the first string element
     * assert that the queue isnt null from polling out one elemenet
     */
     @Test
    public void testpollnotnullString()
    {
        Fruit<String> instance = new Fruit<String>();
        
        instance.FruitQueue.offer("alpha");
        instance.FruitQueue.offer("beta");
        instance.FruitQueue.offer("card");
        
        instance.FruitQueue.poll();
        assertNotNull(instance.FruitQueue);
       
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
        Fruit<String> instance = new Fruit<String>();
        
        instance.FruitQueue.offer("alpha");
        instance.FruitQueue.offer("beta");
        instance.FruitQueue.offer("card");
        
        instance.FruitQueue.poll();
       
         instance.FruitQueue.poll();
    
         instance.FruitQueue.poll();
        assertEquals(instance.FruitQueue.size(), 0);
    }
    
    /**
     * makes sure that the gaussian test is not a null number
     * 
     */
    @Test
    public void testgaussian()
    {
        Fruit<String> instance = new Fruit<String>();
        
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
        Fruit<Integer> instance = new Fruit<Integer>();
        
        instance.FruitQueue.offer(5);
        instance.FruitQueue.offer(35);
        instance.FruitQueue.offer(74);
        
        assertNotNull(instance.FruitQueue);
    }
    
    @Test
    public void testsizeInteger()
    {
        Fruit<Integer> instance = new Fruit<Integer>();
        
        instance.FruitQueue.offer(5);
        instance.FruitQueue.offer(35);
        instance.FruitQueue.offer(74);
        
        assertNotNull(instance.FruitQueue.size());
    }
    
    @Test
    public void testsize2Integer()
    {
        Fruit<Integer> instance = new Fruit<Integer>();
        
         instance.FruitQueue.offer(5);
        instance.FruitQueue.offer(35);
        instance.FruitQueue.offer(74);
        
        assertEquals(instance.FruitQueue.size(), 3);
    }
    
  
     @Test
    public void testpollnotnullInteger()
    {
        Fruit<Integer> instance = new Fruit<Integer>();
        
         instance.FruitQueue.offer(5);
        instance.FruitQueue.offer(35);
        instance.FruitQueue.offer(74);;
        
        instance.FruitQueue.poll();
        assertNotNull(instance.FruitQueue);
       
    }
    
     @Test
    public void testpollnullInteger()
    {
        Fruit<Integer> instance = new Fruit<Integer>();
        
        instance.FruitQueue.offer(5);
        instance.FruitQueue.offer(35);
        instance.FruitQueue.offer(74);
        
        instance.FruitQueue.poll();
       
         instance.FruitQueue.poll();
    
         instance.FruitQueue.poll();
        assertEquals(instance.FruitQueue.size(), 0);
    }
}
