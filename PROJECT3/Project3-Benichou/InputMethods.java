
/**
 * Input Method class runs my program upon
 * user input.
 * 
 * @author Agathe Benichou
 * @version Version 1 - 11/10/2015
 */
public class InputMethods
{
    private ItemCityCustomers icc;
    private ReadFile file;
    private CustomerContainer customerContainer;
    private NeedContainer needContainer;
    private CityContainer cityContainer;
    private GraphGeneratorContainer graphGenerator;
    private ProfitPerUnitContainer profitContainer;
    private LocationContainer warehouseContainer;
    private FindShortestTour findShortestTour;

    public static double costPerDistanceUnit = 0.0;
    
    /**
     * The class constructor that takes in the cost per distance unit of traversing one weight of an edge.
     */
    public InputMethods(double costPerDistanceUnit)
    {
        this.costPerDistanceUnit = costPerDistanceUnit; 
    }
    
    /**
     * Creates an instance of the class the passes through the the args that is the cost per distance unit.
     * Runs the method that runs the methods that run the program.
     * 
     * Please put a cost per distance unit inside the brackets in quotations.
     * The cost per distance unit should be a double such as 1.00 or 2.41. 
     * The correct format should be {"1.23"}. Press okay and program will run.
     */
    public static void main(String[] args)
    {
        InputMethods input = new InputMethods(Double.parseDouble(args[0]));
        input.run();
    }

    /**
     * This method runs the methods that runs the entire simulation
     */
    public void run()
    {
        long start = System.currentTimeMillis();
        readFile();
        runProgram(costPerDistanceUnit);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * The method refers to the "init" input command. It will open and run
     * the ReadFile class which reads the cities.txt file and stores the city
     * information in the approrpiate lists and creates the graph.
     */
    public void readFile()
    {
        needContainer = new NeedContainer();
        cityContainer = new CityContainer();
        graphGenerator = new GraphGeneratorContainer();
        profitContainer = new ProfitPerUnitContainer();
        warehouseContainer = new LocationContainer(needContainer);

        file = new ReadFile(cityContainer, graphGenerator, profitContainer, warehouseContainer);
        System.out.println("The .txt files has been read and stored properly.");
    }

    /**
     * This method refers to the "run" input command. 
     */
    public void runProgram(double costPerDistanceUnit)
    {
        customerContainer = new CustomerContainer(cityContainer);
        icc = new ItemCityCustomers(customerContainer, cityContainer,needContainer);
        System.out.println("Item City Container " + icc.itemCityMap);
        System.out.println("City Customer Container " + icc.cityCustMap);
        System.out.println();

        findShortestTour = new FindShortestTour(costPerDistanceUnit,needContainer, icc, graphGenerator, profitContainer, warehouseContainer);
    }
}
