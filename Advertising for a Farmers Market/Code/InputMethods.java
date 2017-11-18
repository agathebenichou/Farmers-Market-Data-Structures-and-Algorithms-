
/**
 * Input Method class runs both of my data containers upon
 * user input.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/10/2015
 */
public class InputMethods
{
    /**
     * This class contains the data structure and methods
     * for one of my two data structures. The format of the data
     * structure used in here is:
     * 
     * HashMap<String(City), HashMap<String<Item>, LinkedList<Customers>>>
     * This data structure is called "CICMap"
     * 
     * HashMap<String(Item), HashMap<String<City>, LinkedList<Customers>>>
     * This data structure is called "ICCMap"
     */

    private CityItemCustomers cic;
    private ItemCityCustomers icc;
    private ReadFile file;
  
    /**
     * The method refers to the "init" input command. It will open and run
     * the ReadFile class which reads the cities.txt file and stores the city
     * information in the approrpiate lists.
     */
    public void readFile()
    {
        file = new ReadFile();
        System.out.println("The cities.txt file has been read and stored properly.");
    }
    
    /**
     * This method refers to the "run" input command. It will
     * run the simulation however many number of times the user
     * told it to run the simulation and it stores the data
     * into its appropriate containers.
     */
    public void runProgram(int runTime)
    {
        cic = new CityItemCustomers();
        icc = new ItemCityCustomers();
        
        for(int i = 0; i < runTime ;i ++)
        {
            cic.runSimulation();
            icc.runSimulation();
        }
        System.out.println("The simulation has successfully been run and all data is stored appropriately.");
    }

    /**
     * This method prints out the CIC HashMap.
     */
    public void printData()
    {
       cic.printData();
       icc.printData();
    }

    /**
     * This method refers to the "list" user input command. 
     * With the user input city and item, it will print out the
     * customers in that city who have purchased that item.
     */
    public void list(String city, String item)
    {
        System.out.println("Here are the customers from the city " + city + " who have the item " + item + " on their list." );
        cic.returnList(city, item);
    }

    /**
     * This method refers to the "findgoods" user input command.
     * With the user input city, it will print out the list of 
     * items in that city from most purchased items to least
     * purchased items. 
     * 
     * @param the City whose goods will be ordered.
     */
    public void findgoods(String city)
    {
        System.out.println("Here is the order of goods in " + city + " from most purchased to least purchased.");
        cic.returnGoods(city);
    }

     /**
     * This method refers to the "findcities" user input command.
     * With the user input item, it will print out the list of 
     * cities in whose customers bought the most of those items to bought
     * the least of those items.
     * 
     * @param the Items whose cities will be ordered.
     */
    public void findcities(String item)
    {
        System.out.println("Here is the order of cities whose customers have the most " + item + " to the least " + item);
        icc.returnCities(item);
    }
    
    /**
     * This method refers to the "clear" user input command.
     * It will clear all data in both containers.
     */
    public void clear()
    {
        cic.clear();
        icc.clear();
        System.out.println("The data containers have been cleared.");
    }
}
