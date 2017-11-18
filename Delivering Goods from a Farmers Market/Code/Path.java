
/**
 * The class Path represents an entry in the priority queue
 * for Dijstra's algorithm.
 * 
 * @author Mark Allen Weiss
 */
public class Path implements Comparable<Path>
{
   public UnDirectedGraph.UnDirectedGraphNode dest;
   public double  cost;
   
   public Path(UnDirectedGraph.UnDirectedGraphNode dest, double cost)
   {
       this.dest = dest;
       this.cost = cost;
   }
   
   public int compareTo(Path rhs)
   {
       double otherCost = rhs.cost;
       return cost < otherCost ? - 1 : cost > otherCost ? 1 : 0;
   }
}
