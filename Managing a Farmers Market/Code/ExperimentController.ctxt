
/**
 * This class is the class where all methods are called and where the simulation is run
 * 
 * @author Agathe Benichou
 * @version 10/13/2015
 */

import java.util.Random;
import java.util.ArrayList;

public class ExperimentController extends Market
{

    /**
     * These instances are the open and close time of the market.
     */
    public int openTime = 0;
    public int closeTime = 14400;

    /**
     * These instances are the the ones that keep getting updated while the simulation is run.
     */
    public int currentTime;
    public int iDnumber;
    public int nextArrivalTime;
    public ArrayList<Object> needs;

    /**
     * These instances are how certain objects are created and methods are run.
     */
    Customer customerTime =  new Customer();
    Customer customerObj;
    Market market = new Market();

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
    public ExperimentController()
    {
        System.out.println("Welcome to the Easton Farmers Market!");
        System.out.println();
        System.out.println("Our hours are from 9 am to 11 am.");
        System.out.println();
        System.out.println("Each item in the market costs 1 dollar.");
        System.out.println();
        System.out.println("In this market, there are one of each stall. Each stall has one line and 2 workers.");
        System.out.println();
        System.out.println("The meat stall takes up 14 units, the vegetable stall takes up 17 units,");
        System.out.println(" the dairy stall takes up 10 units, the baked goods stall takes up 12 units ");
        System.out.println(" and the beverage stall takes up 15 units.");
        System.out.println();
        System.out.println("With the workers and the lines, there is a total of 83 units. This does not include the customers online.");
        System.out.println();

        currentTime = openTime;

        while(currentTime < 14400)
        {
            ArrivalTime();
            while(currentTime != nextArrivalTime)
            {   
                currentTime++;
                if(currentTime == nextArrivalTime)
                {
                    if(currentTime < 14400)
                    {
                        int start = currentTime;
                        CustomerGenerator();

                        if(needs.size() > 0)
                        {
                            int newtime1 = market.bakedgoodsqueue(getCustomer(), getId(), needs, currentTime);
                            int newtime2 = market.fruitqueue(getCustomer(), getId(), needs, newtime1);
                            int newtime3 = market.vegetablequeue(getCustomer(), getId(), needs, newtime2);
                            int newtime4 = market.meatqueue(getCustomer(), getId(),needs, newtime3);
                            int newtime5 = market.beveragesqueue(getCustomer(), getId(), needs, newtime4);
                            int newtime6 = market.dairyqueue(getCustomer(), getId(), needs, newtime5);         
                            int end = newtime6;
                            System.out.println("TOTAL TIME FOR CUSTOMER # " + getId() + " AT THE MARKET IS " + (end-start) );
                            System.out.println(end-start);
                            market.nullqueue(getCustomer(), getId(), needs, newtime6);
                            System.out.println();
                        } else {
                            market.nullqueue(getCustomer(), getId(), needs, currentTime); 
                            int end1 = currentTime;
                            System.out.println("TOTAL TIME FOR CUSTOMER # " + getId() + " AT THE MARKET IS " + (end1-start) );
                            
                        }
                    }

                }
            }
        }

        int totalMade = market.getMoney();

        System.out.println("Congratulations!!! The market has made " + totalMade + " dollars today.");
    }

    /**
     * Method that calls the customer class's getGaussian method to randomly produce
     * arrival times for the customers based on the mean and standard deivation
     * the next arrival time of the customer is whatever number produced plus the current time
     * 
     */
    public void ArrivalTime()
    {
        nextArrivalTime = (int)(customerTime.getGaussian(61,31));
        nextArrivalTime += currentTime;
    }

    /**
     * Method that produced random id numbers from 0 to 100 for the customers to keep track of them
     *Generates an array list of needs and assigns a new random ish list to each customer
     *Creates the customer object
     * 
     */
    public void CustomerGenerator()
    {
        iDnumber++;
        needs = market.GenerateNeeds();
        customerObj = new Customer(iDnumber, nextArrivalTime, needs);
        System.out.println("This customer needs " + needs.size() + " items.");
    }

    /**
     * This method return the randomly produced id number of each customer.
     * 
     * @return id number
     */
    public int getId()
    {
        return iDnumber;
    }

    /**
     * This method returns the customer object created in the customergenerator method
     * @return customer object
     * 
     */
    public Object getCustomer()
    {
        return customerObj;
    }
}
