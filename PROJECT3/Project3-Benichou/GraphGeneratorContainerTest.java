import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GraphGeneratorContainerTest.
 *
 * @author Agathe Benichou
 * @version Version 1 / 12/08/2015
 */
public class GraphGeneratorContainerTest
{
    GraphGeneratorContainer graphGenerator;

    /**
     * Default constructor for test class GraphGeneratorContainerTest
     */
    public GraphGeneratorContainerTest()
    {
        graphGenerator = new GraphGeneratorContainer();
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
     * This test method creates a graph and asserts that the graph
     * is not null
     *
     */
    @Test
    public void test()
    {
        for(int i = 1; i < 11; i++ )
        {
            for(int j = 2; j < 12; j++)
            {
                for(double k = 1.0; k < 11.0; k++)
                {
                    graphGenerator.createGraph(i, j, k);
                }
            }
        }
        
        assertNotNull(graphGenerator.graph.vertexMap);
    }
}

