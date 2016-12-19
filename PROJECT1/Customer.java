
/**
 * The Customer Class creates a customer with its randomly produced id number and its randomly produced
 * gaussian number
 * 
 * @author Agathe Benichou
 * 
 */

import java.util.Random;
import java.util.ArrayList;

public class Customer
{
   
   /**
    * 
    * customer constructor used in experiment controller class to call the getGaussian method 
    */
   public Customer()
   {
     
   }
   
   /**
    *The Customer constructor with parameters. This constructor is used in the Experiment Controller class to create a 
    *Customer object when the randomly generated arrival time is equal to the current time. 
    *
    *This Constructor is proved that is works by printing out that the Customer has arrived to the market. 
    *
    *@param - randomly produced customer id number
    *@param - the arrival time produced
    *@param - the Array List of needs that each customer is randomly assigned as they enter the market
    */
   public Customer(int iD, int arrivalTime, ArrayList<Object> needs)
   {
     System.out.println("Customer #" + iD + " has arrived to the market at " + arrivalTime + " seconds.");
   }
   
   /**
    * The method that uses the given mean and standard deviation(variance) to randomly
    * produce a number without the range
    * @param the mean of the amount of seconds a customer is produced
    * @param the variance of the amount of seconds a customer is product
    * 
    * @return the random number created
    */
   public Random rand = new Random();
    
   public double getGaussian(double mean, double variance)
   {
     return ((int)(mean + rand.nextGaussian() * (variance)));
   }
}
