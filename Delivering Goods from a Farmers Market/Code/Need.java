
/**
 * The Need Class is used to create Need objects.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/08/2015
 */
public class Need
{
    public String needName;

    /**
     * The Need class constructur which takes in the name of
     * the need.
     * 
     * @param String name of need.
     */
    public Need(String needName)
    {
        this.needName = needName;
    }

    /**
     * A getter method which returns the name of the
     * need. 
     * 
     * @return the String name of the need.
     */
    public String getNeedName()
    {
        return needName;
    }
}
