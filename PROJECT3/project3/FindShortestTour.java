/**
 * Class FindShortestTour is the class that creates my Shortest Tour Algorithm and prints out the profit and cost the vendor has make.
 * 
 * The Shortest Tour Algorithm uses Dijkstra's Algorithm to calculate the shortest path between two nodes. It starts at one of the warehouses of a certain
 * need and it calculates the shortest path to the next City who has a Customer who has that need in it. It goes through all the cities until there are no more cities that have
 * not been visitied and that have a Customer in it with that need. After that, it calculates the shortest path back to the warehouse. It returns a full
 * array list of the shortest tour from the warehouse to all the cities who contain a customer with that need and back to the warehouse. 
 * 
 * @author Agathe Benichou
 * @version Version 1 -12/09/2015
 */

import java.util.LinkedList;
import java.util.ArrayList;

public class FindShortestTour
{
    private double costPerDistanceUnit = 0.0;

    /**
     * The Class Constructor that takes in all the Containers it needs to run.
     */
    public FindShortestTour(double costPerDistanceUnit, NeedContainer needContainer, ItemCityCustomers icc, GraphGeneratorContainer graphGenerator, ProfitPerUnitContainer profitContainer, LocationContainer warehouseContainer)
    {
        this.costPerDistanceUnit = costPerDistanceUnit;

        for(int i = 0; i < needContainer.listSize(); i ++)
        {
            String good = needContainer.getNeedInt(i).getNeedName();
            ArrayList<Integer> shortestTour = shortestTourAlgorithm(good, profitContainer, icc, graphGenerator, warehouseContainer);
            results(good, shortestTour, profitContainer, icc, graphGenerator);
            System.out.println();
        }
    }

    /**
     * The algorithm that calculates the shortest tour algorithm for a given need. 
     * 
     * Gets a location of the warehouse for the specified good. Gets the amount of cities that customers are in with the specified good.
     * Finds the shortest path between the warehouse and the first city in the city container and stores that into a global arraylist.
     * Gets the city going to and the city coming from and keeps placing that into the shortest path algorithm until
     * there are no more cities left in the city list. Creates a local array list to store the shortest paths into.
     * Calculates if it is worth going to a city using a profitCalculator method and if it is, calculate the shortest path between those nodes
     * and stores that path into the local array list. Adds that local array list to the global one on every run. GEts the last
     * city in the list and calculates the shortest path between the last city back to the warehouse. 
     * 
     * @param The String whose shortest path you want to find, the ProfitPerUnitContainer, the ItemCityCustomers container, the GraphGeneratorContainer, the 
     * LocationContainer
     * @return The ArrayList that shows the shortest path from the warehouse to all the cities(nodes) with customers inside it with that need and back to the warehouse.
     */
    public ArrayList<Integer> shortestTourAlgorithm(String good, ProfitPerUnitContainer profitContainer, ItemCityCustomers icc, GraphGeneratorContainer graphGenerator, LocationContainer warehouseContainer)
    {
        int warehouse = warehouseContainer.getLocationsOfNeedSpecific(good, 0);
        int cityListSize = icc.getCitiesSizeWithNeed(good);

        ArrayList<Integer> nodesListFinal = graphGenerator.graph.findShortestPath(warehouse, icc.getCityWithNeedAndIndex(good,0));

        for(int i = 1; i < cityListSize; i++)
        {
            int cityGoingTo = icc.getCityWithNeedAndIndex(good, i);
            int cityComingFrom = icc.getCityWithNeedAndIndex(good, i-1);

            ArrayList<Integer> nodesListToAdd = new ArrayList<Integer>();
            if(profitCostCalculator(good, cityComingFrom, cityGoingTo, profitContainer, icc, graphGenerator))
            {
                nodesListToAdd = graphGenerator.graph.findShortestPath(cityComingFrom, cityGoingTo);
            }
            nodesListFinal.addAll(nodesListToAdd);
        }

        int lastCityInList = icc.getCityWithNeedAndIndex(good, cityListSize-1);
        ArrayList<Integer> backToWarehouse = graphGenerator.graph.findShortestPath(lastCityInList, warehouse);
        nodesListFinal.addAll(backToWarehouse);

        System.out.println("The shortest tour for the " + good + " vendor coming from warehouse " + warehouse + " is " + nodesListFinal);
        return nodesListFinal;
    }

    /**
     * This method calculates the results for the vendor, how much they made and how much they lost on the path. IT depends greatly on
     * the cost per distance unit.
     * 
     * GEts the profit fot the good. For every customer in all the cities that have customers who have that good, add up all those customers.
     * Calculate the total profit the vendor has made by multiplying the profit per unit with the number of customers te vendor
     * delivered to.
     * Calculates the cost of delivering to the city by getting the edge weights from all nodes in the shortest path and
     * multiplying that by the cost per diatance unit.
     * 
     * @param The string good whose shortest path you are calculating, the shortest tour found, the ProfitPErUnitCotnainer, the ItemCityCustomers class, the GraphGeneratorConainer class
     */
    public void results(String good, ArrayList<Integer> shortestTour, ProfitPerUnitContainer profitContainer, ItemCityCustomers icc, GraphGeneratorContainer graphGenerator)
    {
        int totalCustomersWithGood = 0;
        int profitPerUnit = profitContainer.getProfit(good);

        for(int i = 0; i < icc.getCitiesSizeWithNeed(good); i++)
        {
            int cityWithCustomers = icc.getCityWithNeedAndIndex(good, i);
            for(Customer custom : icc.getCustomersWithCity(cityWithCustomers))
            {
                if(custom.getList().contains(good))
                {
                    totalCustomersWithGood++;
                }
            }
        }

        int totalProfit = profitPerUnit*totalCustomersWithGood;
        System.out.println("The " + good + " vendor has made " + totalProfit + " delivering today.");

        double weight = 0.0; 

        for(int j = 1; j < shortestTour.size(); j++)
        {
            int cityGoingTo = shortestTour.get(j);
            int cityComingFrom = shortestTour.get(j-1);
            double weighted = graphGenerator.graph.getEdge(cityComingFrom, cityGoingTo);
            weight += weighted;
        }

        double totalCost = weight*costPerDistanceUnit;
        System.out.println("With a cost per distance unit of " + costPerDistanceUnit + "......");
        System.out.println("The " + good + " vendor has spent " + totalCost + " delivering today");

        System.out.println("The " + good + " vendor has made a profit of " + (totalProfit-totalCost) + " delivering today.");     
    }

    /**
     * This method calculates the cost of going to a city and compares that to the amount of money the vendor will make
     * at that city and makes a decision of whether the vendor should tranverse there or not.
     * 
     * For every customer in a city, if that customers list contains the good the vendor is calculating, increment counter.
     * Calculates the profit, and the cost and compares the two.
     * 
     * @param The String good, the city you are going to, the city you are coming from, the ProfitPerUnitContainer, the ItemCityCustomers container and the GraphGeneratorContainer 
     * @return True if the profit is greater than the cost and false if the profit is less than the cost.
     */
    public boolean profitCostCalculator(String good, int cityComingFrom, int cityGoingTo, ProfitPerUnitContainer profitContainer, ItemCityCustomers icc, GraphGeneratorContainer graphGenerator)
    {
        int profitPerUnit = profitContainer.getProfit(good);
        int numberOfCustomersWithGoodInCity = 0;

        for(Customer custom : icc.getCustomersWithCity(cityGoingTo))
        {
            if(custom.getList().contains(good))
            {
                numberOfCustomersWithGoodInCity++;
            }
        }

        int totalProfit = profitPerUnit*numberOfCustomersWithGoodInCity;
        double weight = graphGenerator.graph.getEdge(cityComingFrom, cityGoingTo);
        double totalCost = costPerDistanceUnit*weight;

        if(totalProfit > totalCost)
        {
            return true;
        } else {
            return false;
        }
    }
}
