

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Queue;
import java.util.LinkedList;

/**
 * The test class BakedGoodsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BakedGoodsTest
{
    /**
     * Default constructor for test class BakedGoodsTest
     */
    public BakedGoodsTest()
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
     * methods to test the baked goods class with a string 
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
        BakedGoods<String> instance = new BakedGoods<String>();
        
        instance.BakedGoodsQueue.offer("alpha");
        instance.BakedGoodsQueue.offer("beta");
        instance.BakedGoodsQueue.offer("card");
        
        assertNotNull(instance.BakedGoodsQueue);
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
        BakedGoods<String> instance = new BakedGoods<String>();
        
        instance.BakedGoodsQueue.offer("alpha");
        instance.BakedGoodsQueue.offer("beta");
        instance.BakedGoodsQueue.offer("card");
        
        assertNotNull(instance.BakedGoodsQueue.size());
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
        BakedGoods<String> instance = new BakedGoods<String>();
        
        instance.BakedGoodsQueue.offer("alpha");
        instance.BakedGoodsQueue.offer("beta");
        instance.BakedGoodsQueue.offer("card");
        
        assertEquals(instance.BakedGoodsQueue.size(), 3);
    }
    
    /**
     * asserts that the offer method works
     * makes sure that the first in, alpha, will be the first out
     */
     @Test
    public void testpeekString()
    {
        BakedGoods<String> instance = new BakedGoods<String>();
        
        instance.BakedGoodsQueue.offer("alpha");
        instance.BakedGoodsQueue.offer("beta");
        instance.BakedGoodsQueue.offer("card");
        
        assertEquals(instance.BakedGoodsQueue.peek(), "alpha");
  
    }
   
    /**
     * adds string elements to the queue
     * polls out the first string element
     * assert that the queue isnt null from polling out one elemenet
     */
     @Test
    public void testpollnotnullString()
    {
        BakedGoods<String> instance = new BakedGoods<String>();
        
        instance.BakedGoodsQueue.offer("alpha");
        instance.BakedGoodsQueue.offer("beta");
        instance.BakedGoodsQueue.offer("card");
        
        instance.BakedGoodsQueue.poll();
        assertNotNull(instance.BakedGoodsQueue);
       
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
        BakedGoods<String> instance = new BakedGoods<String>();
        
        instance.BakedGoodsQueue.offer("alpha");
        instance.BakedGoodsQueue.offer("beta");
        instance.BakedGoodsQueue.offer("card");
        
        instance.BakedGoodsQueue.poll();
       
         instance.BakedGoodsQueue.poll();
    
         instance.BakedGoodsQueue.poll();
        assertEquals(instance.BakedGoodsQueue.size(), 0);
    }
    
    /**
     * makes sure that the gaussian test is not a null number
     * 
     */
    @Test
    public void testgaussian()
    {
        BakedGoods<String> instance = new BakedGoods<String>();
        
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
        BakedGoods<Integer> instance = new BakedGoods<Integer>();
        
        instance.BakedGoodsQueue.offer(5);
        instance.BakedGoodsQueue.offer(35);
        instance.BakedGoodsQueue.offer(74);
        
        assertNotNull(instance.BakedGoodsQueue);
    }
    
    @Test
    public void testsizeInteger()
    {
        BakedGoods<Integer> instance = new BakedGoods<Integer>();
        
        instance.BakedGoodsQueue.offer(5);
        instance.BakedGoodsQueue.offer(35);
        instance.BakedGoodsQueue.offer(74);
        
        assertNotNull(instance.BakedGoodsQueue.size());
    }
    
    @Test
    public void testsize2Integer()
    {
        BakedGoods<Integer> instance = new BakedGoods<Integer>();
        
         instance.BakedGoodsQueue.offer(5);
        instance.BakedGoodsQueue.offer(35);
        instance.BakedGoodsQueue.offer(74);
        
        assertEquals(instance.BakedGoodsQueue.size(), 3);
    }
    
  
     @Test
    public void testpollnotnullInteger()
    {
        BakedGoods<Integer> instance = new BakedGoods<Integer>();
        
         instance.BakedGoodsQueue.offer(5);
        instance.BakedGoodsQueue.offer(35);
        instance.BakedGoodsQueue.offer(74);;
        
        instance.BakedGoodsQueue.poll();
        assertNotNull(instance.BakedGoodsQueue);
       
    }
    
     @Test
    public void testpollnullInteger()
    {
        BakedGoods<Integer> instance = new BakedGoods<Integer>();
        
        instance.BakedGoodsQueue.offer(5);
        instance.BakedGoodsQueue.offer(35);
        instance.BakedGoodsQueue.offer(74);
        
        instance.BakedGoodsQueue.poll();
       
         instance.BakedGoodsQueue.poll();
    
         instance.BakedGoodsQueue.poll();
        assertEquals(instance.BakedGoodsQueue.size(), 0);
    }

}
