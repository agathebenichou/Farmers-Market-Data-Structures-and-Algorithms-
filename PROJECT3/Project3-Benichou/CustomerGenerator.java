
/**
 * The CustomerGenerator class generates Customers that will be assigned
 * a list of needs, an ID number and a city. These customers are the customer
 * that need their goods delivered.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/03/2015
 */

import java.util.ArrayList;

public class CustomerGenerator
{
    /**
     * These instances are the the ones that keep getting updated while the simulation is run.
     */
    public int iDnumber;

    /**
     * These instances are how certain objects are created and methods are run.
     */
    GenerateListOfNeeds listofneeds;
    Customer customerObj;

    /**
     * Class constructor.
     */
    public CustomerGenerator()
    {
        listofneeds = new GenerateListOfNeeds();
    }
    
    /**
     * Method that produced random id numbers from 0 to 100 for the customers to keep track of them
     * Generates an array list of needs and assigns a new random ish list to each customer
     * Creates the customer object
     * 
     * @param The CityContainer class that has the list of cities
     * @return A Customer object.
     */
    public Customer CustomerGenerator(CityContainer city)
    {
        iDnumber++;
        String iDNumberString = Integer.toString(iDnumber);
        ArrayList<Need> needs = listofneeds.GenerateNeeds();
        City cityInside = city.randomlyAssignCity();
        customerObj = new Customer(Integer.toString(iDnumber), needs, cityInside);

        return customerObj;
    }
}
