
/**
 * The City Class is used to represent city objects.
 * 
 * @author Agathe Benichou
 * @version Version 1 / 11-08-2015
 */
public class City
{
   public String cityName;
   
   /**
    * The City Constructor which takes in the name of the city.
    */
   public City(String cityName)
   {
       this.cityName = cityName;
    }
    
    /**
     *  A getter method for the name of the City;
     *  
     *  @return the String name of the city.
     */
    public String getCityName()
    {
        return cityName;
    }
}
