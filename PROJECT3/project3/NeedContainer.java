
/**
 * The Need Container class stores all the possible needs
 * a customer could have from the generated list of needs class.
 * 
 * @author Agathe Benichou
 * @version Version 1 -11/08/2015
 */

import java.util.LinkedList;

public class NeedContainer
{
    /**
     * The container that holds all the possible needs objects.
     */
    public LinkedList<Need> needs;
    
    /**
     * The NeedContainer constructor instatiates the Need object class
     * and it creates object instances of each need.
     */
    public NeedContainer()
    {
        needs = new LinkedList<Need>();
        
        needs.add(new Need("fruits"));
        needs.add(new Need("baked goods"));
        needs.add(new Need("meat"));
        needs.add(new Need("beverages"));
        needs.add(new Need("dairy"));
        needs.add(new Need("vegetables"));
    }
    
    /**
     * This getter method returns the total list of needs
     * 
     * @return LinkedList which stores Need objects a customer could have
     */
    public LinkedList<Need> list()
    {
        return needs;
    }
    
    /**
     * A getter method which returns the Need object that matches up
     * with the parameter. 
     * 
     * @param The String of the good whose Need object you are looking for
     * @return The Need object whose String was input
     */
    public Need getNeedString(String good)
    {
        Need needToReturn = null;
        for(Need needIn : needs)
        { 
            if(needIn.getNeedName() == good)
            {
                needToReturn = needIn;
            }
        }
        return needToReturn;
    }
    
    /**
     * A getter method which returns the Need object that matches up with
     * the parameter
     * 
     * @param The integer of the index whose Need object you want
     * @return The Need object whose integer was input
     */
    public Need getNeedInt(int index)
    {
       return needs.get(index);
    }
    
    /**
     * This getter method returns the size of the total list of needs, 
     * which is always 6.
     * 
     * @return the Integer of list of needs
     */
    public int listSize()
    {
        return needs.size();
    }
}
