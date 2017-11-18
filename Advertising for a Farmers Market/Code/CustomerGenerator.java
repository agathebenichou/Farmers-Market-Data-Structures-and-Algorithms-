
/**
 * Write a description of class CustomerGenerator here.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CustomerGenerator
{

    /**
     * These instances are the open and close time of the market.
     */
    private int openTime = 0;
    private int closeTime = 14400;

    /**
     * These instances are the the ones that keep getting updated while the simulation is run.
     */
    private int currentTime;
    public int iDnumber;
    private int nextArrivalTime;
    public ArrayList<Need> needs;
    public LinkedList<Customer> customers;

    /**
     * These instances are how certain objects are created and methods are run.
     */
    GenerateListOfNeeds listofneeds = new GenerateListOfNeeds();
    Gaussian gaus = new Gaussian();
    Customer customerObj;

    /**
     * The method where everything is run.
     * The initial currentTime is the time the market opens, 0 seconds.
     * While the current time is less than 14400 seconds, or 4 hours, :
     * the current time increments by one, the arrival time generator is called
     * which creates an arrivla time and based on that time, the customers are produced.
     * The produced customers with their list of needs are put through several queue methods
     * to decide which queues they need to get one dpeending n their needs.
     * 
     */
    public CustomerGenerator()
    {
        currentTime = openTime;
        customers = new LinkedList<Customer>();
        
        while(currentTime < 14400)
        {
            ArrivalTime();
            if(currentTime != nextArrivalTime)
            {
                currentTime++;
            }  else
            if(currentTime == nextArrivalTime){
                int start = currentTime;
                Customer customer = CustomerGenerator();   
                customers.add(customer);
            }
        }
       // printCustomerQueue();
    }

    /**
     * Method that calls the customer class's getGaussian method to randomly produce
     * arrival times for the customers based on the mean and standard deivation
     * the next arrival time of the customer is whatever number produced plus the current time
     * 
     */
    private void ArrivalTime()
    {
        nextArrivalTime = (int)(gaus.getGaussian(31,31));
        nextArrivalTime += currentTime;
    }

    /**
     * Method that produced random id numbers from 0 to 100 for the customers to keep track of them
     *Generates an array list of needs and assigns a new random ish list to each customer
     *Creates the customer object
     * 
     */
    public Customer CustomerGenerator()
    {
        iDnumber++;
        String iDNumberString = Integer.toString(iDnumber);
        needs = listofneeds.GenerateNeeds();
        customerObj = new Customer(Integer.toString(iDnumber), needs);
        return customerObj;
    }

    /**
     * This method returns the customer object created in the customergenerator method
     * 
     * @return customer object
     */
    public Object getCustomer()
    {
        System.out.println(customerObj);
        return customerObj;
    }

    /**
     * prints out the length of the Customer Queue
     */
    private void printCustomerQueue()
    {
        System.out.println("There are " + customers.size() + " customers that have been produced in this run.");
    }

    public LinkedList<Customer> getCustList()
    {
        return customers;
    }

    /**
     * This method returns the size of the Customer Queue. 
     * 
     * @return the size of the Customer Queue in the form is int
     */
    public int CustomerQueueSize()
    {
        return customers.size();
    }

    /**
     * This method polls the the first customer out of the Customer 
     * queue
     * 
     * @return the first Customer object of the queue
     */
    public Customer retrieveCustomer()
    {
        return customers.poll();
    }
}
