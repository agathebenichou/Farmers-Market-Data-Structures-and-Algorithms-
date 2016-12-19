
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class UnDirectedGraphTest.
 *
 * @author Agathe Benichou
 * @version Version 1 - 12/01/2015
 */
public class UnDirectedGraphTest
{

    /**
     * Default constructor for test class UnDirectedGraphTest
     */
    public UnDirectedGraphTest()
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
     * Makes sure that Graph is not null and it has been initialized.
     */
    @Test
    public void graphNotNullTest()
    {
        UnDirectedGraph graph = new UnDirectedGraph();
        assertNotNull(graph.vertexMap);
    }

    /**
     * Creates a new graph
     * Adds a Node to the graph 
     * Asserts that the Add Node method is returning true and it properly inserting Nodes
     */
    @Test
    public void addNodeTrue()
    {
        UnDirectedGraph graph = new UnDirectedGraph();
        assertEquals(graph.AddNode(1), true);
    }

    /**
     * Creates a new graph
     * Adds 10 nodes starting with Node 1 to Node 10
     * Asserts that all of these nodes are being added to the graph and it is returning true
     * Asserts that the graph is not null
     */
    @Test
    public void addManyNodesTrue()
    {
        UnDirectedGraph graph = new UnDirectedGraph();
        for(int i = 1; i < 11; i++)
        {
            assertEquals(graph.AddNode(i), true);
        }
        assertNotNull(graph.vertexMap);
    }

    /**
     * Creates a new graph
     * Adds a Node to the graph called Node 1
     * Adds the same Node to the graph
     * Asserts false when you try to add a node that is already there
     */
    @Test
    public void addNodeThatIsAlreadyThereFalse()
    {
        UnDirectedGraph graph = new UnDirectedGraph();
        graph.AddNode(1);
        assertEquals(graph.AddNode(1), false);
    }

    /**
     * Creates a new graph
     * Adds 10 nodes to the graph
     * Asserts that the add edge method is returning true given two nodes and a weight
     */
    @Test
    public void addEdgeTrue()
    {
        UnDirectedGraph graph = new UnDirectedGraph();
        for(int i = 1; i < 11; i++)
        {
            graph.AddNode(i);
        }

        assertEquals(graph.AddEdge(1, 2, 3.0), true);
    }

    /**
     * Creates a new graph
     * Adds 10 nodes to the new graph
     * Makes sure that all those edges have been properly added and the add edge method is 
     * returning true
     * Creates a LinkedList which stores edges which will act as a Nodes adjacency list
     * Retrieves Node 1s adjacency list
     * Prints out Node 1s adjacency list
     */
    @Test
    public void addManyEdgeTrue()
    {
        UnDirectedGraph graph = new UnDirectedGraph();
        for(int i = 1; i < 11; i++)
        {
            graph.AddNode(i);
        }

        assertEquals(graph.AddEdge(1, 2, 3.0), true);
        assertEquals(graph.AddEdge(2, 3, 2.0), true);
        assertEquals(graph.AddEdge(3, 4, 5.0), true);
        assertEquals(graph.AddEdge(4, 5, 1.0), true);
        assertEquals(graph.AddEdge(5, 6, 8.0), true);
        assertEquals(graph.AddEdge(6, 7, 4.0), true);
        assertEquals(graph.AddEdge(7, 8, 2.0), true);
        assertEquals(graph.AddEdge(8, 9, 0.0), true);
        assertEquals(graph.AddEdge(9, 10, 5.0), true);
        assertEquals(graph.AddEdge(10, 1, 3.0), true);

        LinkedList<UnDirectedGraph.UnDirectedEdge> list = new LinkedList<UnDirectedGraph.UnDirectedEdge>();
        list = graph.vertexMap.get(1).adj;

    }

    /**
     * Creates a new graph
     * Adds 10 nodes
     * Adds 10 edges for those 10 nodes to connect to each other
     * Creates a Linked List which stores Edges and will act as a Nodes adjancy list
     * Makes the list equal t the adjancy list in node 1
     * Asserts that Node 1 has two adjancies
     * Asserts that the two adjancies in Node 1 are 2 and 10
     */
    @Test
    public void edgesAreCorrectTrue()
    {
        UnDirectedGraph graph = new UnDirectedGraph();
        for(int i = 1; i < 11; i++)
        {
            graph.AddNode(i);
        }

        graph.AddEdge(1, 2, 3.0);
        graph.AddEdge(2, 3, 2.0);
        graph.AddEdge(3, 4, 5.0);
        graph.AddEdge(4, 5, 1.0);
        graph.AddEdge(5, 6, 8.0);
        graph.AddEdge(6, 7, 4.0);
        graph.AddEdge(7, 8, 2.0);
        graph.AddEdge(8, 9, 0.0);
        graph.AddEdge(9, 10, 5.0);
        graph.AddEdge(10, 1, 3.0);

        LinkedList<UnDirectedGraph.UnDirectedEdge> list = new LinkedList<UnDirectedGraph.UnDirectedEdge>();
        list = graph.vertexMap.get(1).adj;
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getNextNode(), 2);
        assertEquals(list.get(1).getNextNode(), 10);
    }

    /**
     * Creates a new graph
     * Add two nodes, node 1 and node 2, to the graph
     * Add an edge connecting those two ndoes
     * Tests the getNodeName method 
     * Asserts that the Nodes have the correct Names using the getNodeName method
     * Creates a Linked List which stores Edges and will act as a Nodes adjancy list
     * Makes the list equal t the adjancy list in node 1
     * Tests the getEdgeName method
     * Tests the getEdgeWeight method
     * Asserts that Node 1 only goes to 2
     * Asserts that the Edge between 1 and 2 has a weight of 3.0
     */
    @Test
    public void testGetterMethodsEdgeNode()
    {
        UnDirectedGraph graph = new UnDirectedGraph();

        graph.AddNode(1);
        graph.AddNode(2);

        graph.AddEdge(1, 2, 3.0);

        assertEquals(graph.vertexMap.get(1).getNodeName(), 1);
        assertEquals(graph.vertexMap.get(2).getNodeName(), 2);

        LinkedList<UnDirectedGraph.UnDirectedEdge> list = new LinkedList<UnDirectedGraph.UnDirectedEdge>();
        list = graph.vertexMap.get(1).adj;
        assertEquals(list.get(0).getNextNode(), 2);
    }
    
    /**
     * Creates a graph
     * Adds two Nodes
     * Adds an edge
     * Gets shortest path
     * Asserts that the shortest path method is returning something
     * Asserts that the size is equal to 2
     * 
     */
    @Test
    public void dijkstrasAlgorithmTest1()
    {
        UnDirectedGraph graph = new UnDirectedGraph();

        graph.AddNode(1);
        graph.AddNode(2);

        graph.AddEdge(1, 2, 3.0);

        ArrayList<Integer> path = graph.findShortestPath(1, 2);
        assertNotNull(path);
        assertEquals(path.size(), 2);
    }
    
    /**
     * Creates a new graph
     * Adds 5 nodes
     * Adds Edges
     * Asserts that the shortest path from 1 to 4 is through 1, 2, 4 instead of going straight 1 to 4
     */
     @Test
    public void dijkstrasAlgorithmTest2()
    {
        UnDirectedGraph graph = new UnDirectedGraph();

        graph.AddNode(1); 
        graph.AddNode(2); 
        graph.AddNode(3); 
        graph.AddNode(4); 
        graph.AddNode(5); 

        graph.AddEdge(1, 3, 5.0);
        graph.AddEdge(1, 4, 6.0);
        graph.AddEdge(1, 2, 3.0);
        graph.AddEdge(2, 4, 2.0);
        graph.AddEdge(3, 4, 2.0);
        graph.AddEdge(3, 5, 6.0);
        graph.AddEdge(4, 5, 5.0);
        graph.AddEdge(5, 1, 2.0);

        ArrayList<Integer> path = graph.findShortestPath(1, 4);
        assertEquals(path.size(), 3);
        assertSame(path.get(0), 1);
        assertSame(path.get(1), 2);
        assertSame(path.get(2), 4);
    }
    
     /**
     * 
     */
     @Test
    public void getEdgeTest()
    {
        UnDirectedGraph graph = new UnDirectedGraph();

        graph.AddNode(1); 
        graph.AddNode(2); 
        graph.AddNode(3); 
        graph.AddNode(4); 
        graph.AddNode(5); 

        graph.AddEdge(1, 3, 5.0);
        graph.AddEdge(1, 4, 6.0);
        graph.AddEdge(1, 2, 3.0);
        graph.AddEdge(2, 4, 2.0);
        graph.AddEdge(3, 4, 2.0);
        graph.AddEdge(3, 5, 6.0);
        graph.AddEdge(4, 5, 5.0);
        graph.AddEdge(5, 1, 2.0);

        assertEquals(graph.getEdge(1, 3), 5.0, 0);
        assertEquals(graph.getEdge(1, 4), 6.0, 0);
        assertEquals(graph.getEdge(1, 2), 3.0, 0);
        assertEquals(graph.getEdge(2, 4), 2.0, 0);
        assertEquals(graph.getEdge(3, 4), 2.0, 0);
        assertEquals(graph.getEdge(3, 5), 6.0, 0);
        assertEquals(graph.getEdge(4, 5), 5.0, 0);
        assertEquals(graph.getEdge(5, 1), 2.0, 0);
    }
}
