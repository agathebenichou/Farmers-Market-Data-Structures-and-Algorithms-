/**
 * The UserInput class is the class that creates an user input command terminal
 * and with the commands the user puts into the terminal, it processes the users
 * command and passes those commands through to the program.
 * 
 * @author Agathe Benichou
 * @version Version 1 / 11-10-2015
 */

import java.util.Scanner;
import java.util.ArrayList;

public class UserInput
{
    private Scanner scanner;
    private InputMethods input;
    public CityContainer citiesTotal;

    /**
     * The constructor which creates the user input terminal, calls other classes
     * and prompts the user if the scanner passes.
     * 
     */
    public UserInput()
    {
        try
        {
            scanner = new Scanner(System.in);
            input = new InputMethods();
            citiesTotal = new CityContainer();

            if(scanner != null)
            {
                askUser();
            }
        } catch(Exception ex)
        {
        }
    }

    /**
     * This method asks the user for their command and passes that command through
     * to another method which will decide what to do with the command.
     */
    private void askUser()
    { 
        System.out.println("What is your command?");

        String command = scanner.nextLine();
        commandPrompt(command);
    }

    /**
     * This method takes in the command that the put into the terminal.
     * 
     * Depending on the command, the method will decide what to do next. 
     * If the command is list, the method will ask for the next city and the next
     * item and pass that city and item through to another method.
     * If the command is findgoods, the method will ask for the next city and
     * pass that city through to another method.
     * If the command is findcities, the method will ask for the next item and pass
     * that item through to another method.
     * If the command is add, the method asks for the name of the city to add and
     * it passes that name to another method. 
     * 
     * If the commands are none of the above, it passes the command to another 
     * method which has what to do with that command.
     */
    private void commandPrompt(String command)
    {   
        if(command.equals("list"))
        {
            String city = " ";
            String item = " ";

            if(scanner.next().equals("city:"))
            {
                city = scanner.next();
            } 

            if(scanner.next().equals("item:"))
            {
                item = scanner.next();
            } 

            if(scanner.nextLine().equals(""))
            {
                commandList(city, item);
            }
        }

        if(command.equals("findgoods"))
        {
            String cityForGoods = scanner.nextLine();  

            if(scanner.nextLine().equals(""))
            {
                commandFindGoods(cityForGoods);
            }
        }

        if(command.equals("findcities"))
        {
            String goodsForCity = scanner.nextLine();
            if(scanner.nextLine().equals(""))
            {
                commandFindCities(goodsForCity);
            }
        }

        if(command.equals("add"))
        {
            String cityToAdd = scanner.nextLine();

            if(scanner.nextLine().equals(""))
            {
                commandAddCity(cityToAdd);
            }
        }

        commandProgramBasic(command);  
    }

    /**
     * This method takes in the commands that the other method did not have.
     * It passes this command through to an array which splits the command if it
     * has another part to it. 
     * 
     * If the command is init, it prompts the inputmethods class to read the file 
     * and pass the information appropriately.
     * If the command is run, it splits up run and the number of runs following it
     * and passes that number though to the input methods class to run the 
     * program however many number of times. 
     * If the command is clear, it prompts the input methods class to clear the 
     * data containers.
     * If the command is exit, it closes the scanner class.
     * 
     * It prompts the user for another input.
     */
    private void commandProgramBasic(String command)
    {
        String[] array = command.split(" ");

        if(array[0].equals("init"))
        {
            System.out.println("The program will now read the file.");
            input.readFile();
        } else if(array[0].equals("run"))
        {
            int runTime = Integer.parseInt(array[1]);
            System.out.println("Please wait while the data is stored.");
            System.out.println("The filled data containers will be printed shortly.");
            input.runProgram(runTime);
        } else if(array[0].equals("clear"))
        {
            System.out.println("The data containers will now be cleared.");
            input.clear();
        } else if(array[0].equals("exit"))
        {
            scanner.close();
        } 

        askUser();
    }

    /**
     * If the user put in the command list, then it passes the city
     * and the item desired to the inputmethod class which will run the method.
     * 
     * This method asks the user for another command.
     */
    private void commandList(String city, String item)
    {
        input.list(city, item);
        
        askUser();
    }

    /**
     * If the user put in the command findgoods, then it passes the city
     * desired to the input method class which will run the method.
     * 
     * This method asks the user for another command.
     */
    private void commandFindGoods(String city)
    {
        input.findgoods(city);

        askUser();
    }

    /**
     * If the user put in the command findcities, then it passes the item
     * desired to the input method class which will run the method.
     * 
     * This method asks the user for another command.
     */
    private void commandFindCities(String item)
    {
        input.findcities(item);

        askUser();
    }

    /**
     * If the user put in the command add, then it takes in the city: city to add
     * format and creates a new city in the city container for when the simulation wil
     * run next.
     * 
     * To show to the user that the city was properly added to the city container, 
     * the city objects in the city container are turned into their string name
     * and stored into a temporaroy array list which prints out all the cities
     * including the new one.
     */
    private void commandAddCity(String city)
    {
        String[] cityArray = city.split(": ");
        String newCityToAdd = cityArray[1];

        citiesTotal.cityContainer.add(new City(newCityToAdd));

        ArrayList<String> newCityList = new ArrayList<String>();
        for(City cities : citiesTotal.cityContainer)
        {
            String newCitiesTotal = cities.getCityName();
            newCityList.add(newCitiesTotal);
        }
        System.out.println(newCityList);

        askUser();
    }
}