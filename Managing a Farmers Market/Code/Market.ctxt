
/**
 * The market class simulates the eastons farmers market.
 * 
 * @author Agathe Benichou
 * @version 10/13/2015
 */

import java.util.ArrayList;
import java.util.Queue;

public class Market
{
    /**
     * These instances are the queues for each stall.
     */
    BakedGoods<Object> bakedGoodsQueue = new BakedGoods<Object>();
    Fruit<Object> fruitQueue           = new Fruit<Object>();
    Vegetable<Object> vegetableQueue   = new Vegetable<Object>();
    Meat<Object> meatQueue             = new Meat<Object>();
    Beverages<Object> beveragesQueue   = new Beverages<Object>();
    Dairy<Object> dairyQueue           = new Dairy<Object>();

    /**
     * These isntances are the needs that each customer will need.
     * THERE ARE TWO ITEMS PER STALL. So each customer can have either product.
     */
    ObjectNeeds bakedgoods             = new ObjectNeeds();
    ObjectNeeds fruit                  = new ObjectNeeds();
    ObjectNeeds vegetable              = new ObjectNeeds();
    ObjectNeeds meat                   = new ObjectNeeds();
    ObjectNeeds beverages              = new ObjectNeeds();
    ObjectNeeds dairy                  = new ObjectNeeds();
    ObjectNeeds bakedgoods2             = new ObjectNeeds();
    ObjectNeeds fruit2                  = new ObjectNeeds();
    ObjectNeeds vegetable2              = new ObjectNeeds();
    ObjectNeeds meat2                   = new ObjectNeeds();
    ObjectNeeds beverages2              = new ObjectNeeds();
    ObjectNeeds dairy2                  = new ObjectNeeds();

    /**
     * A global variable that counts how much money the market has made throughout the 4 hours it is open. 
     */
    int money;

    /**
     * A method that returns the money made in the market throughout the 4 hours it was open.
     * 
     * @return The amount of money made.
     */
    public int getMoney()
    {
        return money;
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
    public ArrayList<Object> GenerateNeeds()
    {
        ArrayList<Object> ListOfNeeds = new ArrayList<Object>();
        int bakedGoodsPercent = (int)(bakedGoodsQueue.getGaussian(37, 17));
        if(bakedGoodsPercent >= 28 && bakedGoodsPercent <= 35)
        {
            ListOfNeeds.add(bakedgoods);
        } else if(bakedGoodsPercent >= 35 && bakedGoodsPercent <= 44)
        {
            ListOfNeeds.add(bakedgoods2);
        }

        int fruitPercent = (int)(fruitQueue.getGaussian(47, 13));
        if(fruitPercent >= 37 && fruitPercent <= 44)
        {
            ListOfNeeds.add(fruit);
        } else if(fruitPercent >= 44 && fruitPercent <= 55)
        {
            ListOfNeeds.add(fruit2);
        }

        int vegPercent = (int)(vegetableQueue.getGaussian(71, 29));
        if(vegPercent >= 40 && vegPercent <= 65)
        {
            ListOfNeeds.add(vegetable);
        } else if(vegPercent >= 65 && vegPercent <= 93)
        {
            ListOfNeeds.add(vegetable2);
        }

        int meatPercent = (int)(meatQueue.getGaussian(53, 13));
        if(meatPercent >= 43 && meatPercent <= 51)
        {
            ListOfNeeds.add(meat);
        } else if(meatPercent >= 51 && meatPercent <= 60)
        {
            ListOfNeeds.add(meat2);
        }

        int bevPercent = (int)(beveragesQueue.getGaussian(43, 11));
        if(bevPercent >= 38 && bevPercent <= 42)
        {
            ListOfNeeds.add(beverages);
        } else if(bevPercent >= 42 && bevPercent <= 47)
        {
            ListOfNeeds.add(beverages2);
        }

        int dairyPercent = (int)(dairyQueue.getGaussian(59, 19));
        if(dairyPercent >= 45 && dairyPercent <= 62)
        {
            ListOfNeeds.add(dairy);
        } else if(dairyPercent >= 62 && dairyPercent <= 73)
        {
            ListOfNeeds.add(dairy2);
        }

        return ListOfNeeds;
    }

    /**
     * This method is for the baked goods queue. 
     * It starts by generating a waiting time for each customer to stay on the queue using the Gaussian method based on a mean amount of time and standard deviation given 
     * in class. It adds this time to the current time, and that added time is the time that the customers will receive their item, be removed from the queue and move on
     * to their next item in the next queue if they have one. 
     * It checks to see if that stall type item is in the customers queue, if it is then the method checks to make sure that market has not closed. If the market has not
     * closed, then it adds the customer to the queue for that item. The method waits until the current time increments and when the wait time has reached the current time, 
     * that is when the customer is removed from the queue. Those needs are removed from their lists and the money made in the market is incremented.
     * 
     * @param The Customer object that will be placed on the queue.
     * @param The id of the Customer.
     * @param The Array List of needs the customer has.
     * @param The current time.
     * 
     * @return The new time based on how long the customer has waited in line.
     * 
     */
    public int bakedgoodsqueue(Object customer, int iD, ArrayList<Object> needs, int currentTime)
    {
        int bakedgoodstime = (int)(bakedGoodsQueue.getGaussian(29, 13));
        bakedgoodstime += currentTime;
        if((needs.contains(bakedgoods)) || (needs.contains(bakedgoods2)))
        {
            if(currentTime >= 14400)
            {
                System.out.println("Customer # " + iD + " is unable to get a baked good because the market is closed.");
            } else {
                bakedGoodsQueue.add(customer);
                System.out.println("Customer # " + iD + " has been added to the baked goods queue at " + currentTime);
                while(bakedgoodstime != currentTime)
                {
                    currentTime++;
                    if(currentTime >= 14400)
                    {
                        System.out.println("Customer # " + iD + " was unable to get a baked goods because the market has closed.");
                        break;
                    } else if(bakedgoodstime == currentTime)
                    {
                        bakedGoodsQueue.poll();
                        money++;
                        needs.remove(bakedgoods);
                        needs.remove(bakedgoods2);
                        System.out.println("Customer # " + iD + " has left the baked goods queue at " + currentTime);
                    }
                }
            } 
        }

        return bakedgoodstime;
    }

    /**
     * This method is for the fruit queue. 
     * It starts by generating a waiting time for each customer to stay on the queue using the Gaussian method based on a mean amount of time and standard deviation given 
     * in class. It adds this time to the current time, and that added time is the time that the customers will receive their item, be removed from the queue and move on
     * to their next item in the next queue if they have one. 
     * It checks to see if that stall type item is in the customers queue, if it is then the method checks to make sure that market has not closed. If the market has not
     * closed, then it adds the customer to the queue for that item. The method waits until the current time increments and when the wait time has reached the current time, 
     * that is when the customer is removed from the queue. Those needs are removed from their lists and the money made in the market is incremented.
     * 
     * @param The Customer object that will be placed on the queue.
     * @param The id of the Customer.
     * @param The Array List of needs the customer has.
     * @param The current time.
     * 
     * @return The new time based on how long the customer has waited in line.
     * 
     */
    public int fruitqueue(Object customer, int iD, ArrayList<Object> needs, int currentTime)
    {
        int fruittime = (int)(fruitQueue.getGaussian(83, 31));
        fruittime += currentTime;
        if((needs.contains(fruit)) || (needs.contains(fruit2)))
        {
            if(currentTime >= 14400)
            {
               System.out.println("Customer # " + iD + " will now leave the market.");
            } else {
                fruitQueue.add(customer);
                System.out.println("Customer # " + iD + " has been added to the fruit queue at " + currentTime);    
                while(fruittime != currentTime)
                {
                    currentTime++;
                    if(currentTime >= 14400)
                    {
                        System.out.println("Customer # 346 " + iD + " was unable to get a fruit because the market has closed.");
                        break;
                    } else if(fruittime == currentTime)
                    {
                        fruitQueue.poll();
                        money++;
                        needs.remove(fruit);
                        needs.remove(fruit2);
                        System.out.println("Customer # " + iD + " has left the fruit queue at " + currentTime);
                    }
                }
            }
        } 
        return fruittime;
    }

    /**
     * This method is for the vegetable queue. 
     * It starts by generating a waiting time for each customer to stay on the queue using the Gaussian method based on a mean amount of time and standard deviation given 
     * in class. It adds this time to the current time, and that added time is the time that the customers will receive their item, be removed from the queue and move on
     * to their next item in the next queue if they have one. 
     * It checks to see if that stall type item is in the customers queue, if it is then the method checks to make sure that market has not closed. If the market has not
     * closed, then it adds the customer to the queue for that item. The method waits until the current time increments and when the wait time has reached the current time, 
     * that is when the customer is removed from the queue. Those needs are removed from their lists and the money made in the market is incremented.
     * 
     * @param The Customer object that will be placed on the queue.
     * @param The id of the Customer.
     * @param The Array List of needs the customer has.
     * @param The current time.
     * 
     * @return The new time based on how long the customer has waited in line.
     * 
     */
    public int vegetablequeue(Object customer, int iD, ArrayList<Object> needs, int currentTime)
    {
        int vegetabletime = (int)(vegetableQueue.getGaussian(119, 29));
        vegetabletime += currentTime;
        if((needs.contains(vegetable)) || (needs.contains(vegetable2)))
        {
            if(currentTime >= 14400)
            {
                System.out.println("Customer # " + iD + " will now leave the market.");
            } else {
                vegetableQueue.add(customer);
                System.out.println("Customer # " + iD + " has been added to the vegetable queue at " + currentTime);
                while(vegetabletime != currentTime)
                {
                    currentTime++;
                    if(currentTime >= 14400)
                    {
                        System.out.println("Customer # " + iD + " was unable to get a vegetable because the market has closed.");
                        break;
                    }else if(vegetabletime == currentTime)
                    {
                        vegetableQueue.poll();
                        money++;
                        needs.remove(vegetable);
                        needs.remove(vegetable2);
                        System.out.println("Customer # " + iD + " has left the vegetable queue at " + currentTime);
                    }
                }
            } 
        }
        return vegetabletime;
    }

    /**
     * This method is for the meat queue. 
     * It starts by generating a waiting time for each customer to stay on the queue using the Gaussian method based on a mean amount of time and standard deviation given 
     * in class. It adds this time to the current time, and that added time is the time that the customers will receive their item, be removed from the queue and move on
     * to their next item in the next queue if they have one. 
     * It checks to see if that stall type item is in the customers queue, if it is then the method checks to make sure that market has not closed. If the market has not
     * closed, then it adds the customer to the queue for that item. The method waits until the current time increments and when the wait time has reached the current time, 
     * that is when the customer is removed from the queue. Those needs are removed from their lists and the money made in the market is incremented.
     * 
     * @param The Customer object that will be placed on the queue.
     * @param The id of the Customer.
     * @param The Array List of needs the customer has.
     * @param The current time.
     * 
     * @return The new time based on how long the customer has waited in line.
     * 
     */
    public int meatqueue(Object customer, int iD, ArrayList<Object> needs, int currentTime)
    {
        int meattime = (int)(meatQueue.getGaussian(101, 41));
        meattime += currentTime;
        if((needs.contains(meat)) || (needs.contains(meat2)))
        {
            if(currentTime >= 14400)
            {
                System.out.println("Customer # " + iD + " will now leave the market.");
            } else {
                meatQueue.add(customer);
                System.out.println("Customer # " + iD + " has been added to the meat queue at " + currentTime);
                while(meattime != currentTime)
                {
                    currentTime++;
                    if(currentTime >= 14400)
                    {
                        System.out.println("Customer # " + iD + " was unable to get a vegetable because the market has closed.");
                        break;
                    } else if(meattime == currentTime)
                    {
                        meatQueue.poll();
                        money++;
                        needs.remove(meat);
                        needs.remove(meat2);
                        System.out.println("Customer # " + iD + " has left the meat queue at " + currentTime);
                    }
                }
            } 
        }
        return meattime;
    }

    /**
     * This method is for the beverages queue. 
     * It starts by generating a waiting time for each customer to stay on the queue using the Gaussian method based on a mean amount of time and standard deviation given 
     * in class. It adds this time to the current time, and that added time is the time that the customers will receive their item, be removed from the queue and move on
     * to their next item in the next queue if they have one. 
     * It checks to see if that stall type item is in the customers queue, if it is then the method checks to make sure that market has not closed. If the market has not
     * closed, then it adds the customer to the queue for that item. The method waits until the current time increments and when the wait time has reached the current time, 
     * that is when the customer is removed from the queue. Those needs are removed from their lists and the money made in the market is incremented.
     * 
     * @param The Customer object that will be placed on the queue.
     * @param The id of the Customer.
     * @param The Array List of needs the customer has.
     * @param The current time.
     * 
     * @return The new time based on how long the customer has waited in line.
     * 
     */
    public int beveragesqueue(Object customer, int iD, ArrayList<Object> needs, int currentTime)
    {
        int beveragestime = (int)(beveragesQueue.getGaussian(19, 7));
        beveragestime += currentTime;
        if((needs.contains(beverages)) || (needs.contains(beverages2)))
        {
            if(currentTime >= 14400)
            {
                System.out.println("Customer # " + iD + " will now leave the market.");
            } else {
                beveragesQueue.add(customer);
                System.out.println("Customer # " + iD + " has been added to the beverages queue at " + currentTime);

                while(beveragestime != currentTime)
                {
                    currentTime++;
                    if(currentTime >= 14400)
                    {
                        System.out.println("Customer # " + iD + " was unable to get a beverage because the market has closed.");
                        break;
                    } else if(beveragestime == currentTime)
                    {
                        beveragesQueue.poll();
                        money++;
                        needs.remove(beverages);
                        needs.remove(beverages2);
                        System.out.println("Customer # " + iD + " has left the beverages queue at " + currentTime);
                    }
                }
            } 
        }
        return beveragestime;
    }

    /**
     * This method is for the dairy queue. 
     * It starts by generating a waiting time for each customer to stay on the queue using the Gaussian method based on a mean amount of time and standard deviation given 
     * in class. It adds this time to the current time, and that added time is the time that the customers will receive their item, be removed from the queue and move on
     * to their next item in the next queue if they have one. 
     * It checks to see if that stall type item is in the customers queue, if it is then the method checks to make sure that market has not closed. If the market has not
     * closed, then it adds the customer to the queue for that item. The method waits until the current time increments and when the wait time has reached the current time, 
     * that is when the customer is removed from the queue. Those needs are removed from their lists and the money made in the market is incremented.
     * 
     * @param The Customer object that will be placed on the queue.
     * @param The id of the Customer.
     * @param The Array List of needs the customer has.
     * @param The current time.
     * 
     * @return The new time based on how long the customer has waited in line.
     * 
     */
    public int dairyqueue(Object customer, int iD, ArrayList<Object> needs, int currentTime)
    {
        int dairytime = (int)( dairyQueue.getGaussian(59, 23));
        dairytime += currentTime;
        if((needs.contains(dairy)) || (needs.contains(dairy2)))
        { 
            if(currentTime >= 14400)
            {
                System.out.println("Customer # " + iD + " will now leave the market.");
            } else {        
                dairyQueue.add(customer);
                System.out.println("Customer # " + iD + " has been added to the dairy queue at " + currentTime);
                while(dairytime != currentTime)
                {
                    currentTime++;
                    if(currentTime >= 14400)
                    {
                        System.out.println("Customer # " + iD + " was unable to get dairy because the market has closed.");
                        break;
                    } else if(dairytime == currentTime)
                    {
                        dairyQueue.poll();
                        money++;
                        needs.remove(dairy);
                        needs.remove(dairy2);
                        System.out.println("Customer # " + iD + " has left the dairy queueat " + currentTime);
                    }
                }
            }
        }
        return dairytime;
    }

    /**
     * This method is for when the list of needs is empty. When the customer has no more needs, the customer leaves the market.
     * 
     * @param The Customer object that will be placed on the queue.
     * @param The id of the Customer.
     * @param The Array List of needs the customer has.
     * 
     */
    public void nullqueue(Object customer, int iD, ArrayList<Object> needs, int currentTime)
    {
       System.out.println("Customer # " + iD + " has no more needs and is now leaving the market at  " + currentTime);
    }
}
