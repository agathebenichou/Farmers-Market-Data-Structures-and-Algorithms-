
/**
 * Customer class is used to create Customer object 
 * using an iD number and a list of needs the customer
 * has for the Easton Farmers Market.
 * 
 * @author Agathe Benichou
 * @version Version 2 - 10/31/2015
 */

import java.util.ArrayList;

public class Customer
{
    /**
     * Global variables.
     */
    public String iD;
    public ArrayList<Need> ListOfNeeds;
    
    public Customer()
    {
        
    }
    
    /**
     * A Customer constructur that takes in the specific id number
     * of the customer and its specific list of needs.
     * 
     * @param Id number in form of String
     * @param List of needs in form of Array List which stores Strings
     */
    public Customer(String iD, ArrayList<Need> ListOfNeeds)
    {
        this.iD = iD;
        this.ListOfNeeds = ListOfNeeds;
    }
    
    /**
     * A getter method for the Customers iDs. 
     * 
     * @return the specific iD of the customer. 
     */
    public String getId()
    {
        return iD;
    }
    
    /**
     * A getter method for the Customers List Of Needs in String form.
     * 
     * @return the specific List of Needs of the Customer
     */
    public ArrayList<String> getList()
    {
        ArrayList<String> needString = new ArrayList<String>();
        
        for(Need needObj : ListOfNeeds)
        {
            needString.add(needObj.getNeedName());
        }
        
       return needString;
    }
    
    /**
     * A getter method for the size of the Customers List Of Needs.
     * 
     * @return the size of the specific List of Needs of the Customer
     */
    public int getListSize()
    {
        return ListOfNeeds.size();
    }
}
