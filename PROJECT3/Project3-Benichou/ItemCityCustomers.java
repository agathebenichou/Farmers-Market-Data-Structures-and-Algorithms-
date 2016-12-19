
/**
 * The ItemCityCustomer class contains the some of the data structures that my Find Shortest Tour is using.
 * 
 * The first HashMap, called itemCityMap stores Strings of allthe items customers can have on their life at its
 * keys and the values are LinkedList of integers whihc stores the cities that have customers who have that item
 * on their list. 
 * 
 * The second HashMap, called cityCustMap stores Integers of all the cities in the CityContainer as keys and 
 * the values are LinkedLists of Customers in those cities
 * 
 * @author Agathe Benichou
 * @version Version 2 - 12/05/2015
 */

import java.util.HashMap;
import java.util.LinkedList;

public class ItemCityCustomers
{
    /**
     * The data structures used in the class.
     */
    public HashMap<String, LinkedList<Integer>> itemCityMap;
    public HashMap<Integer, LinkedList<Customer>> cityCustMap;
    private int numOfCustomersGenerated;

    /**
     * The class constructor.
     * 
     * Instatiates all the classes and data structures.
     * Passes through the list of cities and items from other classes to be stored in a data structure in this class.
     * 
     * Creates the outline of the main data structures used in the class. 
     * The first one, called itemCityMap, is a HashMap where the key is the name of each need and the value of each are linked lists
     * that contain the cities where customers who have that need on their list live
     * 
     * The second map, called itemCustMap, is a HashMap where the key are the integer of the cities and the value of each are linked lists
     * that contain the the customers who live in that city
     * 
     */
    public ItemCityCustomers(CustomerContainer customerContainer, CityContainer cityContainer, NeedContainer needContainer)
    {
        itemCityMap = new HashMap<String, LinkedList<Integer>>();
        cityCustMap = new HashMap<Integer, LinkedList<Customer>>();

        for(int i = 0; i < needContainer.listSize() ; i++)
        {
            itemCityMap.put(needContainer.getNeedInt(i).getNeedName(), new LinkedList<Integer>());
        }

        for(int k = 0; k < cityContainer.getContainerSize(); k++)
        {
            cityCustMap.put(cityContainer.getCity(k).getCityReference(), new LinkedList<Customer>());
        }

        runSimulation1(cityContainer, customerContainer, needContainer);

    }

    /**
     * This method generates the total amount of customers and then it stores the amount of customers generated
     * into a variable. 
     * 
     * It calls the method to sort all the customers that were generated and then it prints out the list with all
     * the customers at the right places.
     */
    public void runSimulation1(CityContainer cityContainer, CustomerContainer customerContainer, NeedContainer needContainer)
    {
        numOfCustomersGenerated = customerContainer.getCustListSize();
        System.out.println("number of customers " + numOfCustomersGenerated);
        Need oneItem;
        Customer custom = null;

        for(int i = 0; i < numOfCustomersGenerated; i++)
        {
            custom = customerContainer.getCustomer(i);
            int city = custom.getCity();
            cityCustMap.get(city).add(custom);
            for(int j = 0 ; j < needContainer.listSize(); j++)
            {
                oneItem = needContainer.getNeedInt(j);
                if(custom.getList().contains(oneItem.getNeedName()))
                {
                    if(itemCityMap.get(oneItem.getNeedName()).contains(custom.getCity()))
                    {

                    } else {
                        itemCityMap.get(oneItem.getNeedName()).add(custom.getCity());
                    }
                }
            }
        }
    }
    
    /**
     * This method returns the LinkedList of Integers which stores the City object keys for a need. Each
     * need has their own Linked List of Integers. 
     * 
     * @param The String need whose LinkedList of cities where customers who have that need are
     * @return The LinkedList of Integer City where Customer objects are who have that need.
     */
    public LinkedList<Integer> getCitiesWithNeed(String need)
    {
        return itemCityMap.get(need);
    }
    
    /**
     * This method returns the size of the Linked List of cities for a good.
     * 
     * @param The String need whose size of the LinkedList of cities you want
     * @return The amount of cities who have customers with that given good
     */
    public int getCitiesSizeWithNeed(String need)
    {
        return itemCityMap.get(need).size();
    }
    
    /**
     * This method returns an Integer that represents a city that contains a Customer with
     * the specified need. 
     * 
     * @param The STring need whose cities you want to look at and the index of the LinkedList you want
     * @return The city reference integer of the city who has a customer with the need and is at the index
     */
    public int getCityWithNeedAndIndex(String good, int index)
    {
        return itemCityMap.get(good).get(index);
    }
    
    /**
     * This method returns the LinkedList of Customers in a specified city. 
     * 
     * @param The city reference number whose linked list of customer objects you want
     * @return The LinkedList of Customer objects in that specified city
     */
    public LinkedList<Customer> getCustomersWithCity(int city)
    {
        return cityCustMap.get(city);
    }
    
    /**
     * This method returns the amount of customers in a city.
     * 
     * @param The Integer city reference of the City whose amount of customers you want
     * @return The amount of customers that are in a City
     */
    public int getCustomerSizeWithCity(int city)
    {
        return cityCustMap.get(city).size();
    }
    
    /**
     * This method returns a Customer object in a specified city in a specified index of the LinkedList
     * 
     * @param The city refeence number of the city and the index of the customer in the Linked List
     * @return The customer object in that city at that reference number
     */
    public Customer getCustomerWithCityAndIndex(int city, int index)
    {
        return cityCustMap.get(city).get(index);
    }
}
