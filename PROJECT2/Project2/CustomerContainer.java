
/**
 * A class which runs the CustomerGenerator clas
 * and stores all the customers generated into a LinkedList
 * which is called in other methods.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/07/2015
 */

import java.util.LinkedList;

public class CustomerContainer
{
    private CustomerGenerator custGen;
    public LinkedList<Customer> people;
    public LinkedList<Customer> peopleToPull;

    /**
     * The class constructor which generates the customers and
     * stores the customers generated into a List and into
     * a Queue.
     * 
     * The people Queue is used get all the customers and to 
     * measure the size.
     * 
     * the peopletofpull queue is actually pulling out customers from
     * the queue and putting them through the sorting methods in
     * other classes.
     */
    public CustomerContainer()
    {
        custGen = new CustomerGenerator();
        people = new LinkedList<Customer>();
        
        people = custGen.getCustList();
        peopleToPull = custGen.getCustList();
    }
    
    /**
     * A getter method which returns the entire list of
     * Customers Generated.
     * 
     * @return the LinkedList of Customers generated.
     */
    public LinkedList<Customer> getCust()
    {
        return people;
    }
    
    /**
     * A getter method whcih returns the size of the list
     * of the Customers Generated.
     * 
     * @return the number
     */
    public int listAmount()
    {
        return people.size();
    }
    
    /**
     * A getter method which returns the Customer at the front
     * of the Queue when called.
     * 
     * @return Customer
     */
    public Customer pullCustomer()
    {
        return peopleToPull.poll();
    }
        
}
