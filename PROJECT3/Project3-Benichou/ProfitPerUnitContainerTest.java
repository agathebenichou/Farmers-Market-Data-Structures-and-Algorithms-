
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProfitPerUnitContainerTest.
 *
 * @author  Agathe Benichou
 * @version Version 1 - 12/09/2015
 */
public class ProfitPerUnitContainerTest
{
    ProfitPerUnitContainer profitContainer;

    /**
     * Default constructor for test class ProfitPerUnitContainerTest
     */
    public ProfitPerUnitContainerTest()
    {
        profitContainer = new ProfitPerUnitContainer();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        profitContainer.addProfit("meat", 20);
        profitContainer.addProfit("vegetables", 10);
        profitContainer.addProfit("fruits", 15);
        profitContainer.addProfit("dairy", 7);
        profitContainer.addProfit("beverages", 5);
        profitContainer.addProfit("baked goods", 3);  
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
     * A test method that asserts that the goods and their profits 
     * are properly being inserted and returning true and is not returning null.
     */
    @Test
    public void addProfitTest()
    {
        assertNotNull(profitContainer.addProfit("meat", 20));
        assertNotNull(profitContainer.addProfit("vegetables", 10));
        assertNotNull(profitContainer.addProfit("fruits", 15));
        assertNotNull(profitContainer.addProfit("dairy", 7));
        assertNotNull(profitContainer.addProfit("beverages", 5));
        assertNotNull(profitContainer.addProfit("baked goods", 3));
        
        assertTrue(profitContainer.addProfit("meat", 20));
        assertTrue(profitContainer.addProfit("vegetables", 10));
        assertTrue(profitContainer.addProfit("fruits", 15));
        assertTrue(profitContainer.addProfit("dairy", 7));
        assertTrue(profitContainer.addProfit("beverages", 5));
        assertTrue(profitContainer.addProfit("baked goods", 3));
    }
    
    /**
     * A test method that makes sure that the getProfit method is 
     * returning the correct profit and is not returning null.
     */
    @Test
    public void getProfitTest()
    {
        assertNotNull(profitContainer.getProfit("meat"));
        assertNotNull(profitContainer.getProfit("vegetables"));
        assertNotNull(profitContainer.getProfit("fruits"));
        assertNotNull(profitContainer.getProfit("dairy"));
        assertNotNull(profitContainer.getProfit("beverages"));
        assertNotNull(profitContainer.getProfit("baked goods"));
        
        assertSame(profitContainer.getProfit("meat"), 20);
        assertSame(profitContainer.getProfit("vegetables"), 10);
        assertSame(profitContainer.getProfit("fruits"), 15);
        assertSame(profitContainer.getProfit("dairy"), 7);
        assertSame(profitContainer.getProfit("beverages"), 5);
        assertSame(profitContainer.getProfit("baked goods"), 3);
    }
}
