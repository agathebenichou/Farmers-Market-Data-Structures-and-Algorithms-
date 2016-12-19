
/**
 * Class GraphGenerator takes the information from the citymap.txt file read in the ReadFile class and 
 * uses the methods in the UnDirectedGraph to create a graph.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 12/03/2015
 */
public class GraphGeneratorContainer
{
  /**
   * Calls the class which contains the methods to create a graph
   */
  public UnDirectedGraph graph;
   
   public GraphGeneratorContainer()
   {
       graph = new UnDirectedGraph();
   }
   
   /**
    * Method which creates a graph using methods from UnDirectedGraph class
    * 
    * @param The starting city, the ending city and the weight inbetween the cities.
    */
   public void createGraph(int startingCity, int endingCity, double weight)
   { 
       graph.AddNode(startingCity);
       graph.AddNode(endingCity);
       graph.AddEdge(startingCity, endingCity, weight);
   }
   
}
