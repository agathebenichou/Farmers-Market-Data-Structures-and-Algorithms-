
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
    public LinkedList<Customer> people;
    private Gaussian nextGaussian;
    public CustomerGenerator customerGenerator;

    /**
     * The class constructor which initalizies the Customer Container
     * data structure and calls the Customer Generator class to 
     * fill the container. Calls the fill Container method.
     */
    public CustomerContainer(CityContainer cityContainer)
    {
        people = new LinkedList<Customer>();
        nextGaussian = new Gaussian();
        customerGenerator = new CustomerGenerator();
        fillContainer(cityContainer);
    }

    /**
     * Method which fills CustomerContainer.
     * Randomly creates a number with a Gaussian distribution given by intructor.
     * For that number of customers, call the customer generator method in the Customer
     * Generator class and fill the CustomerContainer data structure.
     * Do this 10 times to get ~200x10 = 2000 customers to properly fill 
     * all the cities.
     * 
     * @param The CityContainer class which is used in the Customer Generator class.
     */
    public void fillContainer(CityContainer cityContainer)
    {
        for(int j = 0; j < 10;j++)
        {
            int numberOfCustomers = (int)nextGaussian.getGaussian(200, 50);
            for(int i = 0; i < numberOfCustomers; i++)
            {
                Customer customerToAdd = customerGenerator.CustomerGenerator(cityContainer);
                addCustomer(customerToAdd);
            }
        }
    }

    /**
     * An insertion method which adds a Customer object to the Customer
     * Container data structure.
     * 
     * @param The Customer object to add
     * @return True is insertion is successfull and false if insertion
     * is not successful.
     */
    public boolean addCustomer(Customer custom)
    {
        if(people.add(custom))
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A getter method which returns the entire list of
     * Customers Generated.
     * 
     * @return the LinkedList of Customers generated.
     */
    public LinkedList<Customer> getCustList()
    {
        return people;
    }

    /**
     * A getter method whcih returns the size of the list
     * of the Customers Generated.
     * 
     * @return The number of customers generated and that are
     * stored inside the CustomerContainer
     */
    public int getCustListSize()
    {
        return people.size();
    }

    /**
     * This method returns a Customer object at a specified index
     * 
     * @param The integer index whose Customer object you want
     * @return The Customer object that is at the specified index
     */
    public Customer getCustomer(int index)
    {
        return people.get(index);
    }
}
