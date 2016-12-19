
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
    private ReadFile file;
    
    public LinkedList<City> cityContainer;

    public CityContainer()
    {
        file = new ReadFile();  
        
        cityContainer = file.cityContainer;
    }

    /**
     * A getter method which polls the first String element out of the Queue
     * which stores Strings of cities which were read from the file. 
     * 
     * @return the first City in the form of String
     */
    public City getCity()
    {
        return cityContainer.poll();
    }

    public LinkedList<City> totalCityList()
    {
        return cityContainer;
    }

    /**
     * A getter method which returns the size of the Queue which contains
     * all the cities read from the text file. 
     * 
     * @return the first City in the form of String
     */
    public int getCitySize()
    {
        return cityContainer.size();
    }

    /**
     * A method which prints out the Hash Map which contains the cities.
     */
    private void print()
    {
        ArrayList<String> printCityNames = new ArrayList<String>();
        for(City cityIn : cityContainer)
        {
            String cityName = cityIn.getCityName();
            printCityNames.add(cityName);
        }
        System.out.println(printCityNames);
    }
}
