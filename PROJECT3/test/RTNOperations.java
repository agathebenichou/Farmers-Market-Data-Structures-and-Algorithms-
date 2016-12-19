/**
 * Created by Agathe on 11/4/2016.
 */

import java.util.LinkedList;
public class RTNOperations {
    LinkedList<String> addSteps;
    LinkedList<String> subSteps;
    LinkedList<String> xorSteps;
    LinkedList<String> andSteps;
    String currentInstruction;


    public RTNOperations(){

    }

    /**
     * This method initializes the instruction with its corresponding Linked List of rtn instruction.
     * Since all instructions have the same rtn, they all initialize to the same rtn.
     * @param instruction
     * @param rtnSteps
     */
    public void initialize(String instruction, LinkedList<String> rtnSteps){

        switch(instruction) {

            case "and" :
                andSteps = new LinkedList<String>();
                this.andSteps = rtnSteps;
                break;

            case "add" :
                addSteps = new LinkedList<String>();
                this.addSteps = rtnSteps;
                break;

            case "xor" :
                xorSteps = new LinkedList<String>();
                this.xorSteps = rtnSteps;
                break;
            case "sub" :
                subSteps = new LinkedList<String>();
                this.subSteps = rtnSteps;
                break;

        }

    }

    /**
     * based off of the chosen instruction, chooses a linked list of rtn steps for that instruction
     * takes in part needed to fulfill the operations
     * @param instruction
     * @param dataBus
     * @param C
     * @param sourceRegister
     * @param desinationRegier
     */
    public void executeOperation(String instruction, CPU.DataBus dataBus, RegisterC C, String sourceRegister, String desinationRegier){
        int sourceValue=0;
        int destinationValue=0;
        this.currentInstruction = instruction;
        LinkedList<String> operationList = chooseOperation(this.currentInstruction);

        for(int i = 0; i < operationList.size(); i++){
            String currentStep = operationList.get(i);

            switch(currentStep){

                case "a<-r[ra]":
                    sourceValue = dataBus.getValueFromRegister(sourceRegister);
                    dataBus.clearSelectRegister(sourceRegister);
                    break;

                case "b<-r[rb]" :
                    destinationValue = dataBus.getValueFromRegister(desinationRegier);
                    break;

                case "c<-a+b" :
                case "c<-a|b" :
                case "c<-a^b" :
                case "c<-a&b" :
                    dataBus.sendToALU(currentInstruction, sourceValue, destinationValue);
                    break;

                case "r[rb]<-c" :
                    dataBus.sendValueToRegister(C.getData(), desinationRegier);
                    break;
            }
        }
    }

    /**
     * given an instruction, returns the linked list of rtn instructions
     * @param currentInstruction
     * @return
     */
    public LinkedList<String> chooseOperation(String currentInstruction){
        LinkedList<String> operationList = new LinkedList<String>();

        switch(currentInstruction) {

            case "add" :
                operationList = addSteps;
                break;

            case "sub" :
                operationList = subSteps;
                break;

            case "xor" :
                operationList = xorSteps;
                break;

            case "and" :
                operationList = andSteps;
                break;
        }
        return operationList;
    }

}
