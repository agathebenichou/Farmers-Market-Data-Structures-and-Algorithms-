
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
    public LinkedList<Need> needs;
    
    /**
     * The NeedContainer constructor instatiates the Need obkecy class
     * and it creates object instances of each need.
     */
    public NeedContainer()
    {
        needs = new LinkedList<Need>();
        needs.add(new Need("fruits"));
        needs.add(new Need("bakedgoods"));
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
