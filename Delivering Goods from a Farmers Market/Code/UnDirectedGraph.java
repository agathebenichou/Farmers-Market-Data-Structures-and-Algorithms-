
/**
 * UnDirectedGraph class contains the basic graph methods. 
 * The graph is created with a HashMap, per instructions of professor.
 * The class uses a LinkedList to store the edges.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/29/2015
 */

import java.util.*;

public class UnDirectedGraph
{

    /**
     * A Map that stores Integer as its key and UnDirectedGraphNodes as its values
     * With a Node reference number, you can retrieve that Node object.
     */
    public Map <Integer, UnDirectedGraphNode> vertexMap;

    /**
     * Creates an undirected graph that is a Hash Map
     */
    public UnDirectedGraph()
    {
        vertexMap = new HashMap<Integer, UnDirectedGraphNode>();
    }

    /**
     * Adds a node with key k
     * If the map already contains the key k, it returns false
     * Otherwise, put a new entry into the map with key K and create a new
     * UnDirectedGraphNode whose key is K and place that as the value and return true
     * 
     * @param Integer K which is the key to the node
     * 
     * @returns true if the node has been successfully added or false if
     * it has not been successfully added
     */
    public boolean AddNode(Integer k)
    {
        if(vertexMap.containsKey(k))
        {
            return false;
        } else {
            vertexMap.put(k, new UnDirectedGraphNode(k));
            return true;
        }
    }

    /**
     * Adds an edge from the node with key k1 to the node with key k2. 
     * The edge has weight w.
     * If the map does not contain either of the Nodes, return false
     * Otherwise, get the adjancy lists of both nodes and add a new entry to
     * each of their adjancy lists whcih is a new edge that points to where the 
     * edge is connecting to and the weight, return true
     * 
     * @param Two Nodes k1 and k2 which will be connected with this edge and the 
     * weight of their edge w
     * 
     * @returns true if the edge is successfully added or false if the edge has
     * not been successfully added
     */
    public boolean AddEdge(int k1, int k2, double w)
    {
        if(!vertexMap.containsKey(k1) || !vertexMap.containsKey(k2))
        {
            return false;
        } else {
            vertexMap.get(k1).adj.add(new UnDirectedEdge(k2, w));
            vertexMap.get(k2).adj.add(new UnDirectedEdge(k1, w));
            return true;
        }
    }

    /**
     * A method that returns the edge weight between two nodes. 
     * 
     * This method extracts the adjacency list of the start node and stores that into a Linked List. 
     * For every edge in the adjancency list of the start node, get the node that that edge is going to. 
     * Note - The UnDirectedEdge inner class is created with the node the ede is going to and the weight 
     * of the weight. 
     * If the node that the edge is going to matches the node that is the end node, return the weight of that edge.
     * If the nodes do not match up, check the next edge. 
     * 
     * @return The double weight between two Nodes
     * @param The integer references of two Nodes whose edge weight you are looking for.
     */
    public double getEdge(int start, int end)
    {
        double weight = 0.0;
        LinkedList<UnDirectedEdge> adjList = vertexMap.get(start).adj;

        for(UnDirectedEdge edge : adjList)
        {
            int possibleNext = edge.getNextNode();
            if(possibleNext == end)
            {
                weight = edge.getEdgeWeight();
                break;
            }
        }
        
        return weight;
    }
    
    /**
     * Dijkstra's algorithm modified to return an ArrayList of the path and to fit
     * to the vode
     * 
     * Creates a Priority Queue which stores Path objects
     * Retrieves the start and end nodes from the Map and stores them into variables
     * If the start node is not in the map, throw an exception. 
     * Otherwise, clear all the nodes connections
     * Adds a Path object to the priority queue with start node and 0 as the weight because
     * to go from the start node to the start node, that is a cost of 0 since you are already
     * at the node
     * Creates a integer variable which is equal to 0
     * While the priority queue is not empty and the amount of nodes seen is less than the 
     * amount of nodes in the vertex map...
     * The path vrec removes a Path objecy from the priority queue
     * If the removed vrec is the end node then break from the while look and there is only
     * one path between the two nodes
     * If not, the Node that vrec connects to is stored in variable v
     * Only continue within the while loop if v.scratch is not 0
     * Make v.scratch equal to 1 and equal the number of nodes seen by 1
     * For every UnDirectedEdge in vs adjacency list...
     * Make UnDirectedGraphNode w equal to the Node that edge is going to
     * MAke cvw equal to the edge cost 
     * If the distance of w is greater than the distance of v + the cost of the edge
     * then the distance of becomes becomes equal to the distance of v plus cvw and ws
     * previous is v and you add a new Path objecy to the priorirt queue of w and the w distance
     * Break out of the if loop and complete the while loop until all nodes have been seen
     * Stores all the nodes in an array list and then reveres the array list to get the
     * proper sequence 
     * 
     * @param The start node k1 and the end node k2 in whcih you want to find
     * the shorted path between
     * @return The ArrayList that contains the reference to the nodes that form the shortest path
     * @author Dijkstra
     * @version The algorithm in Mark Allen Weiss's book
     */
    public ArrayList<Integer> findShortestPath(int k1, int k2)
    {
        PriorityQueue<Path> pq = new PriorityQueue<Path>();

        UnDirectedGraphNode start = vertexMap.get(k1);
        UnDirectedGraphNode end = vertexMap.get(k2);
        if(start == null)
        {
            throw new NoSuchElementException();
        }

        clearAll();
        pq.add(new Path(start, 0));
        start.dist = 0;

        int nodeSeen = 0;
        while(!pq.isEmpty() && nodeSeen < vertexMap.size())
        {
            Path vrec = pq.remove();
            if (vrec.dest == end) 
            {
                break;
            }
            UnDirectedGraphNode v = vrec.dest;
            if(v.scratch != 0)
            {
                continue;
            }
            v.scratch = 1;
            nodeSeen++;
            for(UnDirectedEdge f : v.adj)
            {
                UnDirectedGraphNode w = vertexMap.get(f.k);
                double cvw = f.e;

                if(cvw<0)
                {
                  throw new NullPointerException();
                }

                if(w.dist > v.dist + cvw )
                { 
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    pq.add(new Path(w, w.dist));
                }
            }
        }

        ArrayList<UnDirectedGraphNode> reverseList = new ArrayList<UnDirectedGraphNode>();
        for (UnDirectedGraphNode u = end; u != start; u = u.prev)
        {
            reverseList.add(u);
        }
        reverseList.add(start);

        ArrayList<Integer> normalList = new ArrayList<Integer>();
        for(int i = reverseList.size()-1; i >= 0; i--)
        {
            normalList.add(reverseList.get(i).getNodeName());
        }
        return normalList;
    }

    /**
     * A method that for every Node in the vertex map, all variables are reset
     */
    public void clearAll()
    {
        for(UnDirectedGraphNode v : vertexMap.values())
        {
            v.reset();
        }
    }

    /**
     * An generic inner class of the class UnDirectedGraph called UnDirectedGraphNode
     */
    class UnDirectedGraphNode
    {
       /**
        * The Integer References name or key of the ndoes
        */
        int k;

        /**
         * The adjacency list of the Node
         */
        LinkedList<UnDirectedEdge> adj;

        /**
         * The double distance between two nodes
         */ 
        double dist;

        /**
         * The previous node
         */
        UnDirectedGraphNode prev;
        
        /**
         * A variable used in Dijkstras algorithm
         */
        int scratch;

        /**
         * The inner class constructor which initializes the integer with the global integer k
         * Initializes the adjacency list of that Node
         * Calls the reset method
         * 
         * @param The integer reference of the Node
         */
        public UnDirectedGraphNode(int k)
        {   
            this.k = k;
            adj = new LinkedList<UnDirectedEdge>();
            reset();
        }

        /**
         * A getter method which returns the name of the Node
         * 
         * @return The integer reference of that node
         */
        public int getNodeName()
        {
            return k;
        }
        
        /**
         * This method is used for Dijkstra's algorithm
         * All connections and edges in the map are cleared so that Dijkstra's algorithm can
         * find the shortest path between all nodes
         */
        public void reset()
        {
            dist = Double.POSITIVE_INFINITY;
            prev = null;
            scratch = 0;
        }
    }

    /**
     * An inner class of UnDirectedGraph called UnDirectedEdge
     */
    class UnDirectedEdge
    {
        /**
         * The integer reference name of the node the edge is going to
         */
        int k;

        /**
         * The double weight of the edge
         */
        double e;
        
        /**
         * The inner class constructor which initializes the reference name of 
         * the node the edge is going to and the weight of the edge
         * 
         * @param The integer reference name of the Node the edge is going to and the double
         * weight of the edge
         */
        public UnDirectedEdge(int k, double e)
        {
            this.k = k;
            this.e = e;
        }

        /**
         * A getter method which returns the name of the Node the edge is going to
         * 
         * @return The integer reference of that node
         */
        public int getNextNode()
        {
            return k;
        }

        /**
         * A getter method which returns the weight of the edge
         */
        public double getEdgeWeight()
        {
            return e;
        }
    }
}
