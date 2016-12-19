
/**
 * The CityItemCustomers class is where one of my data structures is
 * implemented.
 * 
 * This Data Structure is a HashMap whose key is the City and whose
 * values are another HashMap whose key is the Item and whose values
 * are LinkedList which store the Customer objects.
 * 
 * This data structure will be used for the "list" command which returns all the
 * Customers who bought a certain item within a city. It also be used for the
 * "finditems" command which returns the most purcahsed to least purchased
 * items within a city. 
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/3/2015
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeMap;
import java.util.NavigableMap;
import java.util.Map;
import java.util.TreeSet;

public class CityItemCustomers
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
    private HashMap<String, HashMap<String, LinkedList<Customer>>> cityItemCustMap;

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
     * For every number of cities in the cityNames list, make those cities each their own keys with values of a new HashMap.
     * For every item a customer could have, get that item and make that a key of the
     * new HashMap and the value a LinkedList
     * which stores the customers in that city who have that item in their list.
     */
    public CityItemCustomers()
    {
        city = new CityContainer();
        listed = new NeedContainer();
        item = new LinkedList<Need>();
        cities = new LinkedList<City>();
        listOfCustomers = new LinkedList<Customer>();
        cityItemCustMap = new HashMap<String, HashMap<String, LinkedList<Customer>>>();

        numOfCitiesRead = city.getCitySize();

        item = listed.list();
        cities = city.totalCityList();

        for(int i = 0; i < numOfCitiesRead; i++)
        {
            cityItemCustMap.put(cities.get(i).getCityName(), new HashMap<String, LinkedList<Customer>>());
            for(int j = 0; j < item.size(); j++)
            {
                cityItemCustMap.get(cities.get(i).getCityName()).put(item.get(j).getNeedName(), new LinkedList<Customer>());
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
        System.out.println("size " + cityItemCustMap.size());
       /// System.out.println("key set " + cityItemCustMap.keySet());
       // System.out.println("entry set " + cityItemCustMap.entrySet());
       // System.out.println();
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

        for(int i = 0; i < numOfCustomersGenerated;i++)
        {
            custom = cust.people.get(i);
            listOfCustomers.offer(custom);
        }

        for(int j = 0; j < numOfCitiesRead; j++)
        {
            city = cities.get(j);
            for(int k = 0; k < custPerCity; k++)
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

        for(int i = 0; i < listed.listSize(); i++)
        {
            oneItem = item.get(i);
            if(customer.getList().contains(oneItem.getNeedName()))
            {
                cityItemCustMap.get(city.getCityName()).get(oneItem.getNeedName()).add(customer);
            }
        }
    }

    /**
     * A method which prints out the data structure in this class 
     * when called.
     */
    public void printData()
    {
        System.out.println("key set " + cityItemCustMap.keySet());
        System.out.println("entry set " + cityItemCustMap.entrySet());
        System.out.println();
    }

    /**
     * This method print the LinkedList of Customers within a city
     * who have an item in their list.
     * 
     * @param The city desired
     * @param the item desired
     * 
     */
    public LinkedList<String> returnList(String city, String item)
    {
        LinkedList<Customer> custObj =  cityItemCustMap.get(city).get(item);
        System.out.println("Getting customers");
        LinkedList<String> custId = new LinkedList<String>();

        for(Customer custs : custObj)
        {
            String total = "Customer # " + custs.getId();

            custId.add(total);
        }

        System.out.println(custId);
        return custId;
    }

    /**
     * This method is used for the "findgoods" command from the input command. 
     * 
     * The size of each LinkedList in that city is found, and that integer is stored into 
     * a TreeMap with its correspondin good. The key is the name of the item and the value
     * is the size of the LinkedList for thatite, or the amount of customers in that city
     * who purchased that item.
     * 
     * The TreeMap is printed out using Navigable Map, which prints out the keys with the 
     * largest values first and the keys with the smalllest values last. 
     */
    public NavigableMap returnGoods(String city)
    {
        Need totalItems;
        int sizeOfItemList;
        TreeMap<Integer, String> itemTreeMap = new TreeMap<Integer, String>();
        for(int i = 0; i < item.size(); i++)
        {
            totalItems = item.get(i);
            sizeOfItemList = cityItemCustMap.get(city).get(totalItems.getNeedName()).size();
            itemTreeMap.put(sizeOfItemList, totalItems.getNeedName());
        }
     
        NavigableMap nmap = itemTreeMap.descendingMap();
        System.out.println(nmap);
        return nmap;
    }

    /**
     * This method clears out all the data in both HashMaps and the LinkedLists
     * 
     */
    public void clear()
    {
        cityItemCustMap.clear();
    }
}

