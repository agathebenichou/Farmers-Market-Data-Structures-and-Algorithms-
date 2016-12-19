/**
 * Created by Agathe on 11/2/2016.
 */

import java.util.LinkedList;

public class RTNRMOV {
    private LinkedList<String> irmovSteps;
    private LinkedList<String> rrmovSteps;

    public RTNRMOV(){
    }

    /**
     * This method initializes the instruction with its corresponding Linked List of rtn instruction.
     * Since all instructions have the same rtn, they all initialize to the same rtn.
     * @param instruction
     * @param rtnSteps
     */
    public void initialize(String instruction, LinkedList<String> rtnSteps){

        if(instruction.equals("irmov")){
            irmovSteps = new LinkedList<String>();
            this.irmovSteps = rtnSteps;

        } else if(instruction.equals("rrmov")){
            rrmovSteps = new LinkedList<String>();
            this.rrmovSteps = rtnSteps;

        }

    }

    // communicate with data bus to move the immediate value to the register control
    // send immediate through selector to store in register
    public void executeIRMOV(CPU.DataBus dataBus, String immediateString, String destinationRegister){
        int immediate = Integer.parseInt(immediateString);

        for(int i = 0; i < irmovSteps.size(); i++){
            String currentStep = irmovSteps.get(i);
            System.out.println("Current Step is: " + currentStep);

            if(currentStep.equals("r[ra]<-#")){
                if(dataBus.isAvailable()){
                    System.out.println("Data bus available...");
                    dataBus.sendValueToRegister(immediate, destinationRegister);
                }
            }
        }
    }

    /**
     * takes in the necessary components of the cpu to perform the rrmov instruction
     * @param dataBus
     * @param sourceRegister
     * @param destinationRegister
     */
    public void executeRRMOV(CPU.DataBus dataBus, String sourceRegister, String destinationRegister){
        for(int i = 0; i < rrmovSteps.size(); i++){
            String currentStep = rrmovSteps.get(i);
            System.out.println("Current Step is: " + currentStep);

            if(currentStep.equals("r[rb]<-r[ra]")){
                if(dataBus.isAvailable()){
                    System.out.println("Data bus available....");
                    dataBus.moveRegisterValues(sourceRegister, destinationRegister);
                }
            }
        }
    }
}
