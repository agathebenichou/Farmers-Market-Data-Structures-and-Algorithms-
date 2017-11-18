
/**
 * This abstract queue class contains all the queue methods 
 * necessary/
 * 
 * @author Agathe Benichou
 * @version 10/13/15
 */

import java.util.Queue;
import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Random;

public class Meat<E> extends AbstractQueue<E> implements Queue<E>
{
    /**
     * This creates a Queue of type E (It can be any type, the type Object is used in the project.)
     * 
     */
    public Queue<E> MeatQueue;
    
    /**
     * The Constructor that instantiates the Queue with a Linked List of Type E, Object in this project. 
     */
    public Meat()
    {
        MeatQueue = new LinkedList<E>();
    }
    
      /**
     * Creates a random number that is used in the GetGaussian method.
     */
     public Random rand = new Random();
    
     /**
    * A method that calculates a random number based on a mean and a variance. 
    * 
    * @param The mean of the data.
    * @param The variance of the data. 
    * 
    * @return The random number that is generated and casted by an int from the method.
    */
   public double getGaussian(double mean, double variance)
   {
     return ((int)(mean + rand.nextGaussian() * (variance)));
   }
    
     /**
    * A method that returns the size of the Queue at any instance. 
    * 
    * @return The size of the array
    */
    public int size()
  {
      
      return MeatQueue.size();
   };
  
   /**
    * A method that iterators through the Queue
    * 
    * @return the iterated list of type E
    */
  public Iterator<E> iterator(){
      
      Iterator<E> printer =  MeatQueue.iterator();
      
      return printer;
    };
  
    /**
     * A method that returns (peeks) BUT DOES NOT REMOVE the first item in the Queue.
     * 
     * @return The first element of the queue.
     */
  public E peek(){
      return MeatQueue.peek();
    };
  
    /**
     * A method that returns and removes the first item in the Queue.
     * 
     * @return The first element of the queue.
     */
  public E poll(){
      return MeatQueue.poll();
    };
  
     /**
   * A method that inserts an Element of AnyType to the back of the Queue.
   * 
   * @returns True or false depending on if the element was able to be inserted into the Queue. 
   */
  public boolean offer(E e){
      
      return MeatQueue.offer(e);
    };
}