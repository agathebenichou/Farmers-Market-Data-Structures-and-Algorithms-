
/**
 * A class used to calculate the Gaussian numbers using the mean and the variance of a data set.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/10/2015
 */

import java.util.*;

public class Gaussian
{
    /**
     * Creates a random number that is used in the GetGaussian method.
     */
    private Random rand  = new Random();
    
    /**
     * A method that calculates a random number based on a mean and a variance. 
     * 
     * @param The mean of the data.
     * @param The variance of the data. 
     * 
     * @return The random number that is generated and casted by an int from the method.
     */
    public double getGaussian(double mean, double variance)
    {
        return ((int)(mean + rand.nextGaussian() * (variance)));
    }
}
