
/**
 * The ItemCityCustomer class contains the second data structure that my program is using.
 * 
 * It uses a HashMap whose keys are all the items a customer could have in their list and whose
 * values is another HashMap whose keys are the cities that a customer can be from and whose
 * values are LinkedList of customers.
 * 
 * This data structure will be used for the "findcities" command which takes in an
 * item and returns the cities who most purcahsed that item to the cities who
 * least purchased that item.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/07/2015
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;
import java.util.NavigableMap;
import java.util.Map;
import java.util.List;

public class ItemCityCustomers
{
    /**
     * Calling other classes to use methods and lists stored in those classes.
     */
    private CustomerContainer cust;
    private CityContainer city;
    private NeedContainer listed;

    /**
     * The data structures used in the class.
     */
    private LinkedList<Customer> listOfCustomers;
    private LinkedList<City> cities;
    private LinkedList<Need> item;
    private HashMap<String, HashMap<String, LinkedList<Customer>>> itemCityCustMap;

    /**
     * Global variables that store important values used throughout the code.
     */
    private int numOfCitiesRead;
    private int numOfCustomersGenerated;
    private int custPerCity;

    /**
     * The class constructor.
     * 
     * Instatiates all the classes and data structures.
     * Passes through the list of cities and items from other classes to be stored in a data structure in this class.
     * 
     * Creates the outline of the main data structure used in the class. 
     * For every item available in the items list, make those items each their own keys with values of a new HashMap.
     * For every number of cities in the cityNames list, get that item and make that a key of the new HashMap and the value a LinkedList
     * which stores the customers in that city who have that item in their list.
     */
    public ItemCityCustomers()
    {
        city = new CityContainer();
        listed = new NeedContainer();
        item = new LinkedList<Need>();
        cities = new LinkedList<City>();

        listOfCustomers = new LinkedList<Customer>();
        itemCityCustMap = new HashMap<String, HashMap<String, LinkedList<Customer>>>();

        numOfCitiesRead = city.getCitySize();

        item = listed.list();
        cities = city.totalCityList();

        for(int i = 0; i < item.size() ; i++)
        {
            itemCityCustMap.put(item.get(i).getNeedName(), new HashMap<String, LinkedList<Customer>>());
            for(int j = 0; j < numOfCitiesRead; j++)
            {
                itemCityCustMap.get(item.get(i).getNeedName()).put(cities.get(j).getCityName(), new LinkedList<Customer>());
            }
        }
    }

    /**
     * This method generates the total amount of customers and then it stores the amount of customers generated
     * into a variable. 
     * 
     * It calls the method to sort all the customers that were generated and then it prints out the list with all
     * the customers at the right places.
     */
    public void runSimulation()
    {
        cust = new CustomerContainer();   
        numOfCustomersGenerated = cust.listAmount();
        custPerCity = numOfCustomersGenerated/numOfCitiesRead;   

        sortCustomers();
         System.out.println("size " + itemCityCustMap.size());
        // System.out.println("key set " + itemCityCustMap.keySet());
        //System.out.println("entry set " + itemCityCustMap.entrySet());
        //System.out.println();
    }

    /**
     * This method gets each customer generated in the CustomerTotal class and stores
     * that into a Queue in this class.
     * 
     * For every city there is, it takes a city name out of the list and stores it into a
     * city variable. 
     * For every customer that is supposed to be in that city, it passes through that
     * customer and the city name to the next method.
     */
    private void sortCustomers()
    {
        City city;
        Customer custom = null;

        for(int i = 0; i < numOfCustomersGenerated; i++)
        {
            custom = cust.people.get(i);
            listOfCustomers.offer(custom);
        }

        for(int k = 0; k < numOfCitiesRead;k++)
        {
            city = cities.get(k);
            for(int j = 0; j < custPerCity; j++)
            {
                itemSort(listOfCustomers.poll(), city);
            }
        }
    }

    /**
     * For every item a Customer could have, it gets one item and stores that into a variable.
     * If the Customer contains that need in their list, then it adds the customer to the
     * Linked list of that item in that city.
     * 
     * @param the Customer who needs to be stored in LinkedList based on its needs
     * @param the City of which that customers belongs to
     * 
     */
    private void itemSort(Customer customer, City city)
    {
        Need oneItem;

        for(int k = 0 ; k < listed.listSize(); k++)
        {
            oneItem = item.get(k);
            if(customer.getList().contains(oneItem.getNeedName()))
            {
                itemCityCustMap.get(oneItem.getNeedName()).get(city.getCityName()).add(customer);
            }
        }
    }

    /**
     * A method which prints out the data structure in this class 
     * when called.
     */
    public void printData()
    {
        System.out.println("key set " + itemCityCustMap.keySet());
        System.out.println("entry set " + itemCityCustMap.entrySet());
        System.out.println();
    }

    /**
     * A method which carries out the input command "findcities". 
     * A String of an item is passed into the method. 
     * This method to that item Key in the first hashmap and gets the size of
     * all the linked list in each city and stores the city size and the city name
     * into a TreeMap which sorts the cities customers by which city has purchased
     * the most of that item to the city that has purcahsed the least of that item.
     * 
     * It is printed using a descendingMap iterator which orders the keys by natural
     * order which is numerically.
     * 
     * @param the Item whose cities are being sorted 
     */
    public NavigableMap returnCities(String item)
    {
        City city;
        int sizeOfCity;
        TreeMap<Integer, String> cityTreeMap = new TreeMap<Integer, String>();

        for(int i = 0; i < cities.size(); i++)
        {
            city = cities.get(i);
            sizeOfCity = itemCityCustMap.get(item).get(city.getCityName()).size();
            cityTreeMap.put(sizeOfCity, city.getCityName());
        }

        NavigableMap nmap = cityTreeMap.descendingMap();
        System.out.println(nmap);
        
        return nmap;
    }

    /**
     * This method clears out all the data in both HashMaps and the LinkedLists
     * 
     */
    public void clear()
    {
        itemCityCustMap.clear();
    }
}
