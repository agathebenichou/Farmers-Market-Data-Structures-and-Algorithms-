
/**
 * Class LocationContainer is where the information from locations.txt is going to be stored.
 * This information includes the city where each vendors supply is located.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 12/03/2015
 */

import java.util.HashMap;
import java.util.LinkedList;

public class LocationContainer
{
    /**
     * The data structure which stores the locations of the warehouses of each
     * need.
     */
    public HashMap<String, LinkedList<Integer>> warehouseLocation;
    
    /**
     * The class Contstructor which creates the main data structure
     * 
     * For every item in the NeedsContainer data structure, give that key a new linked list.
     */
    public LocationContainer(NeedContainer needContainer)
    {
        warehouseLocation = new HashMap<String, LinkedList<Integer>>();
       
        for(int i = 0; i < needContainer.listSize() ; i++)
        { 
            warehouseLocation.put(needContainer.getNeedInt(i).getNeedName(), new LinkedList<Integer>());
        }
    }

    /**
     * A method that adds locations to the main data structure
     * Takes the item to search for the key in the hash map and then adds the
     * location to that keys linked list
     * 
     * @param The STring item that is the key and the int City location that will
     * be added to the key
     * @return True if insertion has been successful or false if insertion has failed
     */
    public boolean addLocation(String item, int itemLocation)
    {
        if( warehouseLocation.get(item).add(itemLocation))
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method that returns all the locations in a linked list of an item
     * 
     * @param The good whose linked list of locations you want to return
     */
    public LinkedList<Integer> getLocationsOfNeed(String good)
    {
        return warehouseLocation.get(good);
    }

    /**
     * A method that returns the location of the warehouse for a specific good
     * at a speific location in the linked list
     * 
     * @param The String good of warehouse location you are looking for and the Integer
     * index of the city location
     * @return The warehouse location
     */
    public int getLocationsOfNeedSpecific(String good, int index)
    {
        return warehouseLocation.get(good).get(index);
    }
    
    /**
     * A method that returns the size of the linked list, the amount of warehouse
     * locations a need contains
     * 
     * @param The String good whose amount of locations you want
     * @return The integer size of the Linked List
     */
    public int getAmountOfLocationsForNeed(String good)
    {
        return warehouseLocation.get(good).size();
    }
}
