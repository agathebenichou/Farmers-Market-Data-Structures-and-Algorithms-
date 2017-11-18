
/**
 * Write a description of class GenerateListOfNeeds here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.Random;

public class GenerateListOfNeeds
{

    public ArrayList<Need> ListOfNeeds;
    private Need dairy;
    private Need meat;
    private Need vegetables;
    private Need fruits;
    private Need beverages;
    private Need bakedgoods;
    Gaussian gaus = new Gaussian();

    public GenerateListOfNeeds()
    {
        dairy = new Need("dairy");   
        meat = new Need("meat");  
        vegetables = new Need("vegetables");  
        fruits = new Need("fruits");  
        beverages = new Need("beverages");  
        bakedgoods = new Need("baked goods");  
    }

    /**
     * This method generates a list of needs, in the form of an array list, for each customer.
     * The generation depends on the mean and standard deviation of each need.
     * Some needs, like vegetables, meat, and dairy, are more desired and will be in more lists.
     * Other needs, like baked goods, fruit, meat and beverages, are less desired and will be in less lists.
     * The list generated can have 0 elements or can have 6 elements, depending on the probability.
     * 
     * The method creates an ArrayList that contains Objects. It goes through each stall type and generates a random number for each stall type depending
     * on the mean and standard deviation numbers given in class. This generated random number must be between certain intervals, depending on the stall type
     * in order for that stall type item to be added to the list of needs.
     * 
     * The math works like so: If the stall types have a high demand, like vegetables, meat and dairy, then the range of numbers within the if/else is greater than the range
     * of numbers for stall types have less demand. I tested each individual if/else for each stall type so that out of 10 times it was tested, a need was added to the 
     * Array List only 4/10 times for baked goods because 37% of customers want a baked goods. I did the same with each other stall type.
     * 
     * @return an ArrayList with Object elements that is the list of needs for one customer
     */
    public ArrayList<Need> GenerateNeeds()
    {
        ListOfNeeds = new ArrayList<Need>();

        int bakedGoodsPercent = (int)(gaus.getGaussian(37, 17));
        if(bakedGoodsPercent >= 30 && bakedGoodsPercent <= 44)
        {
            ListOfNeeds.add(bakedgoods);
        }

        int fruitPercent = (int)(gaus.getGaussian(47, 13));
        if(fruitPercent >= 37 && fruitPercent <= 55)
        {
            ListOfNeeds.add(fruits);
        } 

        int vegPercent = (int)(gaus.getGaussian(71, 29));
        if(vegPercent >= 25 && vegPercent <= 100)
        {
            ListOfNeeds.add(vegetables);
        } 

        int meatPercent = (int)(gaus.getGaussian(53, 13));
        if(meatPercent >= 43 && meatPercent <= 60)
        {
            ListOfNeeds.add(meat);
        } 

        int bevPercent = (int)(gaus.getGaussian(43, 11));
        if(bevPercent >= 38 && bevPercent <= 42)
        {
            ListOfNeeds.add(beverages);
        } 

        int dairyPercent = (int)(gaus.getGaussian(59, 19));
        if(dairyPercent >= 45 && dairyPercent <= 73)
        {
            ListOfNeeds.add(dairy);
        } 

        return ListOfNeeds;
    }
}
