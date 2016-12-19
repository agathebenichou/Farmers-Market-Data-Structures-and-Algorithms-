import java.util.LinkedList;
import java.lang.String;

/**
 * Created by Agathe on 11/2/2016.
 */
public class RTNMMOV {
    public LinkedList<String> rmmovSteps;
    public LinkedList<String> mrmovSteps;

    public RTNMMOV(){

    }

    /**
     * This method initializes the instruction with its corresponding Linked List of rtn instruction.
     * Since all instructions have the same rtn, they all initialize to the same rtn.
     * @param instruction
     * @param rtnSteps
     */
    public void initialize(String instruction, LinkedList<String> rtnSteps){

        if(instruction.equals("rmmov")){
            rmmovSteps = new LinkedList<String>();
            this.rmmovSteps = rtnSteps;

        } else if (instruction.equals("mrmov")){
            mrmovSteps = new LinkedList<String>();
            this.mrmovSteps = rtnSteps;
        }
    }

    /**
     * This method takes in the necessary components to fulfill the mrmov insruction
     * @param dataBus
     * @param mainMemory
     * @param stackPointer
     * @param memoryAddress
     * @param destinationRegister
     */
    public void executeMRMOV(CPU.DataBus dataBus,MainMemory mainMemory, MainMemory.StackPointer stackPointer, String memoryAddress, String destinationRegister){

        int memoryAddressInt = Integer.parseInt(memoryAddress.substring(1,3));
        //System.out.println(memoryAddressInt);
        int data=0;
        String dataString = "";
        //System.out.println(mrmovSteps);
        for(int i = 0; i < mrmovSteps.size(); i++){
            String currentStep = mrmovSteps.get(i);
            System.out.println("Current Step is: " + currentStep);

            if(currentStep.equals("ma<-r[ra]")){
                if(dataBus.isAvailable()){
                    dataBus.sendAddressToMA(memoryAddressInt);
                }
            } else if(currentStep.equals("md<-m[ma]")){
                dataString = stackPointer.fetchData();

            } else if(currentStep.equals("r[rb]<-md")){
                if(dataBus.isAvailable()) {
                    data = Integer.parseInt(dataString);
                    dataBus.sendValueToRegister(data, destinationRegister);
                }
            }
        }
    }

    /**
     * This method takes in the necessary cpu components to fulfill the rmmov intruction
     * @param dataBus
     * @param mainMemory
     * @param stackPointer
     * @param registerSource
     * @param memoryAddress
     */
    public void executeRMMOV(CPU.DataBus dataBus, MainMemory mainMemory,MainMemory.StackPointer stackPointer, String registerSource, String memoryAddress){
        int memoryAddressInt = Integer.parseInt(memoryAddress.substring(1,3));
        //System.out.println(memoryAddressInt);
        String memorydata="";
        int registerData=0;
        String registerDataString="";
        int dataInt;

        for(int i = 0; i <rmmovSteps.size(); i++){
            String currentStep = rmmovSteps.get(i);
            System.out.println("Current Step is : " + currentStep);

            if(currentStep.equals("ma<-r[rb]")){
                if(dataBus.isAvailable()){
                    dataBus.sendAddressToMA(memoryAddressInt);
                }
            } else if(currentStep.equals("md<-m[ma]")){
                memorydata = stackPointer.fetchData();

            } else if(currentStep.equals("md<-r[ra]")){
                if(dataBus.isAvailable()) {
                    registerData = dataBus.getValueFromRegister(registerSource);
                    registerDataString = Integer.toString(registerData);
                    dataBus.updateMemoryDataWithRegister(memorydata, registerDataString);
                }
            }
        }
    }

}
