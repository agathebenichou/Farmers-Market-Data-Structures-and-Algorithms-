
/**
 * Class ReadFile reads the three .txt files and stores the information appropriately.
 * 
 * @author Agathe Benichou
 * @version 
 */

import java.io.*;
import java.util.*;
import java.util.InputMismatchException;
import java.lang.String;

public class ReadFile
{
    /**
     * The Constructor which calls all the methods in the class.
     * First it initiaizes the TreeSet data structure using the Team Objects to be 
     * stored and inside and it sorts is using the TeamComparator ckass.
     * 
     * It calls the openFile method and stores the Scanner retrieved into the Scanner
     * open variable.
     * 
     * It parses the Scanner using the parseFile method.
     */
    public ReadFile(CityContainer city, GraphGeneratorContainer graphGenerator, ProfitPerUnitContainer profitContainer, LocationContainer warehouseContainer) 
    {
        try
        {
            Scanner openCityMap = openFile("citymap.TXT");
            parseFileCityMap(openCityMap, city, graphGenerator);

            Scanner openGoods = openFile("goods.TXT");
            parseFileGoods(openGoods, profitContainer);

            Scanner openLocations = openFile("locations.TXT");
            parseFileLocations(openLocations, warehouseContainer);
        } catch(Exception e)
        {
            System.out.println("Your file could not be passed.");
        }
    }

    /**
     * This method takes in the name of the File to be opened using a scanner and 
     * outputs the Scanner object.
     * 
     * @param the String name of the file
     * @return the Scanner object if successful
     * @return null if unsuccessful.
     */
    private Scanner openFile(String file) 
    {
        try
        {
            Scanner input = new Scanner(new File(file));
            return input;
        } catch(Exception e)
        {
            System.out.println("Your file has not been scanned.");
            return null;
        }
    }

    /**
     * A method which reads the citymap.txt file and stores and information appropriately
     * While the txt file has a next, the first String is the starting city and the second String is
     * the ending city and the next value is the weight ofthe edge between those
     * cities
     * Stores the information into variables and creates the graph using the GraphGenerator class
     * 
     * @param the Scanner object
     */
    private void parseFileCityMap(Scanner all, CityContainer city, GraphGeneratorContainer graphGenerator)
    {
        try
        {
            while(all.hasNext())
            {
                String startingCity = all.next();
                int startingCityInteger = Integer.parseInt(startingCity);
                all.next();
                String endingCity = all.next();
                int endingCityInteger = Integer.parseInt(endingCity);
                String edgeWeightString = all.next();
                double edgeWeightInt = Integer.parseInt(edgeWeightString);
                
                city.cityContainer.add(new City(startingCityInteger));
                city.cityContainer.add(new City(endingCityInteger));
               
                graphGenerator.createGraph(startingCityInteger, endingCityInteger, edgeWeightInt);
            }
            System.out.println("The graph of cities is " + graphGenerator.graph.vertexMap);
        } catch (Exception e)
        {
        }
    }

    /**
     * A method which reads the goods.txt file and stores the information appropriately.
     * While the txt file has a next, the first String is the name of the need and the second string
     * is the amount of profit per unit for that need.
     * Stores that information into variables and stores it into the ProfitPerUnitContainer class
     * 
     * @param the Scanner object
     */
    private void parseFileGoods(Scanner all, ProfitPerUnitContainer profitContainer)
    {
        try
        {
            while(all.hasNext())
            {
                String item = all.next();
                if(item.equals("baked"))
                {
                    String nextPart = all.next();
                    item = item + " " + nextPart;
                }
                all.next();
                String profitOfItem = all.next();
                int profitOnly = Integer.parseInt(profitOfItem);

                profitContainer.addProfit(item, profitOnly);
            }
            System.out.println("The profit container is " + profitContainer.goodsProfitMap);
        } catch (Exception e)
        {
        }
    }

    /**
     * A method which reads the locations.txt file and stores the information appropriately
     * While the txt file has a next, the first String is the name of the need
     * and the second string is the city location of the need
     * Stores the information into variables and stores the variables into the locationscontainer class
     * 
     * @param the Scanner object
     */
    private void parseFileLocations(Scanner all, LocationContainer warehouseContainer)
    {
        try
        {
            while(all.hasNext())
            {
                String item = all.next();
                if(item.equals("baked"))
                {
                    String nextPart = all.next();
                    item = item + " " + nextPart;
                }
                String itemLocationString = all.next();
                int itemLocationInt = Integer.parseInt(itemLocationString);
                
                warehouseContainer.addLocation(item, itemLocationInt);
            }
            System.out.println("The warehouse container is " + warehouseContainer.warehouseLocation);
        } catch (Exception e)
        {
        }
    }
}
