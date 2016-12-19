
/**
 * The CityContainer class stores the cities read in the
 * file from the read file class.
 * 
 * @author Agathe Benichou
 * @version  Version 1 = 11/10/2015
 */

import java.util.LinkedList;
import java.util.ArrayList;

public class CityContainer
{
    /**
     * The data structure used to to store the City objects
     */
    public LinkedList<City> cityContainer;

    /**
     * The class constructor
     */
    public CityContainer()
    {
        cityContainer = new LinkedList<City>();
    }
    
    /**
     * A method that adds City objects to the city container and 
     * returns true upon successful insertion or false if insertion
     * was unsuccessful
     * 
     * @param The City object to insert into the city container
     * @return True or false depending on the success of the insertion
     */
    public boolean addCity(City city)
    {
        if(cityContainer.add(city))
        {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * A method which returns the City object given a certain index
     * 
     * @param The integer index of the city object you want to get
     * @return The City object at that given index
     */
    public City getCity(int index)
    {
        return cityContainer.get(index);
    }
    
    /**
     * A method that returns the CityContainer data structure 
     * which is a LinkedList that stores City objects
     * 
     * @return The CityContainer data sturcutre, a LinkedList
     */
    public LinkedList<City> totalCityList()
    {
        return cityContainer;
    }

    /**
     * A method that returns the size of the CityContainer data structure
     * 
     * @return The Integer Size of the data structure
     */
    public int getContainerSize()
    {
        return cityContainer.size();
    }
    
    /**
     * A method that randomly returns City objects in the City
     * Container by generating a random number from 1 to the size of the 
     * CityContainer and then getting the City that is at the index
     * of the randomly generated number
     * 
     * @return The City object that has been randomly chosen
     */
    public City randomlyAssignCity()
   {
       int cityReferenceNumber = (int)(Math.random()*(getContainerSize() - 1)) + 1;
       City randomCity = cityContainer.get(cityReferenceNumber);
       
       return randomCity;
   }
}
