
/**
 * The City Class is used to represent city objects.
 * 
 * @author Agathe Benichou
 * @version Version 1 / 11-08-2015
 */
public class City
{
   public int cityReference;
   
   /**
    * The City Constructor which takes in the Integer reference of the city.
    */
   public City(int cityReference)
   {
       this.cityReference = cityReference;
    }
    
    /**
     *  A getter method for the name of the City;
     *  
     *  @return the Integer name of the city.
     */
    public Integer getCityReference()
    {
        return cityReference;
    }
}
