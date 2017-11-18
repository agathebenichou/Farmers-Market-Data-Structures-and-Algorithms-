

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;

/**
 * The test class NeedContainerTest.
 *
 * @author Agathe Benichou
 * @version Version 1 -11/08/2015
 */
public class NeedContainerTest
{
    NeedContainer needsContainer;
     LinkedList<Need> needsList;
    
    /**
     * Default constructor for test class NeedContainerTest
     */
    public NeedContainerTest()
    {
        needsContainer = new NeedContainer();
        
        needsList = new LinkedList<Need>();
        needsList.add(new Need("fruits"));
        needsList.add(new Need("bakedgoods"));
        needsList.add(new Need("meat"));
        needsList.add(new Need("beverages"));
        needsList.add(new Need("dairy"));
        needsList.add(new Need("vegetables"));
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
     * This test method makes sure that the list of needs is
     * not null
     */
    @Test
    public void needcontainertest1()
    {
        assertNotNull(needsContainer.list());
    }
    
    /**
     * This test method make sure that the list size
     * method is not null
     */
     @Test
    public void needcontainertest2()
    {
        assertNotNull(needsContainer.listSize());
    }
    
    /**
     * This method make sure that the list size
     * is equal to 6 because there are 6 needs
     */
     @Test
    public void needcontainertest3()
    {
        assertSame(needsContainer.listSize(), 6);
    }
   
}
