
/**
 * ReadFile is a class that reads the cities from a text file and stores 
 * them into a Queue.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 10/31/2015
 */

import java.io.*;
import java.util.*;
import java.util.InputMismatchException;
import java.lang.String;

public class ReadFile
{

    private City newCity;
    public LinkedList<City> cityContainer;
   
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
    public ReadFile() 
    {
        try
        {
            cityContainer = new LinkedList<City>();
           
            Scanner open = openFile("cities.TXT");
            parseFile(open);
      
        } catch(Exception e)
        {
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
            //System.out.println("The file has been scanned.");

            return input;
        } catch(Exception e)
        {
            System.out.println("Your file has not been scanned.");
            return null;
        }
    }

    /**
     * A method which reads the city names from each line, passes that name into
     * a the city clas to create a city objecy of that name and add that city
     * object to the city container queue
     * @param the Scanner object
     */
    private void parseFile(Scanner all)
    {
        try
        {
            while(all.hasNextLine())
            {
                String cityName = all.nextLine(); 
                all.nextLine();

                newCity = new City(cityName);
                cityContainer.add(newCity);
            }
        } catch (Exception e)
        {
        }
    }
}
