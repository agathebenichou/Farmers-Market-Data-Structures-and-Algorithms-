
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
    public void assertsNeedsContainerListNotNullTest()
    {
        assertNotNull(needsContainer.list());
    }

    /**
     * This test method make sure that the list size
     * method is not null
     */
    @Test
    public void assertListSizeNotNullTest()
    {
        assertNotNull(needsContainer.listSize());
    }

    /**
     * This method make sure that the list size
     * is equal to 6 because there are 6 needs
     */
    @Test
    public void assertListSizeIsCorrectTest()
    {
        assertSame(needsContainer.listSize(), 6);
    }

    /**
     * This test method makes sure that the list() method which
     * returns the needs container is returning the correct container
     */
    @Test
    public void assertTwoListsAreTheSameTest()
    {
        assertEquals(needsContainer.list(), needsContainer.needs);
    }
    
    /**
     * This test method makes sure that the GetNeed method is returning
     * not returning null. Asserts that the same string input is returning
     * the same object.
     */
    @Test
    public void getNeedStringIsReturningTest()
    {
        assertNotNull(needsContainer.getNeedString("meat"));
        assertSame(needsContainer.getNeedString("meat"), needsContainer.getNeedString("meat"));
        assertNotSame(needsContainer.getNeedString("fruits"), needsContainer.getNeedString("vegetables"));
    }
    
     /**
     * This test method makes sure that the GetNeed method is returning
     * not returning null. Asserts that the same integer input is returning
     * the same object.
     */
    @Test
    public void getNeedIntIsReturningTest()
    {
        assertNotNull(needsContainer.getNeedInt(1));
        assertSame(needsContainer.getNeedInt(1), needsContainer.getNeedInt(1));
        assertNotSame(needsContainer.getNeedInt(1), needsContainer.getNeedInt(3));
    }
}
