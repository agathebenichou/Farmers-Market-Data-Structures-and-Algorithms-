/**
 * Class ProfitPerUnitContainer is where the information from the goods.txt file will be stored.
 * This information is how much the vender profits (sells) his goods for. This might determine
 * if it is worth delivering a good to a customer if the good is cheap and the customer is far. 
 * 
 * @author Agathe Benichou
 * @version Version 1 - 12/03/2015
 */

import java.util.HashMap;

public class ProfitPerUnitContainer
{
    /**
     * The data structure used to store the profits of each need.
     * The key is the need and the value is the profit of that need.
     */
    public HashMap<String, Integer> goodsProfitMap;

    /**
     * The class constructor which initializes the data structure
     */
    public ProfitPerUnitContainer()
    {
        goodsProfitMap = new HashMap<String, Integer>();
    }

    /**
     * This method adds goods and their profits to the data structure.
     * 
     * @param The good and the profit that you are adding to the data structure
     * @return True upon successful insertion
     */
    public boolean addProfit(String good, int profit)
    {
        goodsProfitMap.put(good, profit);
        return true;
    }

    /**
     * This method returns the profit of the good specified
     * 
     * @param The good whose profit you want
     * @return The profit of the good specified
     */
    public int getProfit(String good)
    {
        return goodsProfitMap.get(good);
    }
}
