/**
 * Created by Agathe on 11/6/2016.
 *
 * This class pertains to the RTN instructions relating to the stack so push, pop, halt, call, ret.
 */

import java.util.LinkedList;

public class RTNStack {
    LinkedList<String> popSteps;
    LinkedList<String> pushSteps;

    public RTNStack() {

    }

    /**
     * This method initializes the instruction with its corresponding Linked List of rtn instruction.
     * Since all instructions have the same rtn, they all initialize to the same rtn.
     * @param instruction
     * @param rtnSteps
     */
    public void initialize(String instruction, LinkedList<String> rtnSteps){
        switch(instruction) {
            case "pop" :
                popSteps = new LinkedList<String>();
                this.popSteps = rtnSteps;
                break;
            case "push" :
                pushSteps = new LinkedList<String>();
                this.pushSteps = rtnSteps;
                break;
            case "ret" :
            case "halt" :
            case "call" :
                break;
        }
    }

    /**
     * This method takes in the necessary parts of the CPU and performs the pop instruction
     * @param dataBus
     * @param stackPointer
     * @param C
     * @param registerName
     */
    public void executePOP(CPU.DataBus dataBus, MainMemory.StackPointer stackPointer, RegisterC C,  String registerName){
        int memoryAddress=0;
        String memoryData="";
        int memoryDataI=0;

        for(int i = 0; i < popSteps.size(); i++){
            String currentStep = popSteps.get(i);

            switch(currentStep) {

                case "ma<-rsp" :
                    memoryAddress = stackPointer.returnSP();
                    dataBus.sendAddressToMA(memoryAddress);
                    break;

                case "md<-m[ma]" :
                    memoryData = stackPointer.fetchData();
                    break;

                case "r[ra]<-md" :
                    if(dataBus.isAvailable()) {
                        memoryDataI = Integer.parseInt(memoryData);
                        dataBus.sendValueToRegister(memoryDataI, registerName);
                    }
                    break;

                case "c<-rsp+8" :
                    memoryAddress = stackPointer.returnSP();
                    memoryAddress = memoryAddress + 8;
                    dataBus.updateC(memoryAddress);
                    break;

                case "rsp<-c" :
                    stackPointer.update(C.getData());
                    break;
            }
        }
    }

    /**
     * this method takes in the necessary parts of the cpu to perform the push instruction
     * @param dataBus
     * @param stackPointer
     * @param C
     * @param registerName
     */
    public void executePUSH(CPU.DataBus dataBus, MainMemory.StackPointer stackPointer,RegisterC C, String registerName){
        int memoryAddress=0;
        String memoryData= "";

        for(int i = 0; i < pushSteps.size(); i++){
            String currentStep = pushSteps.get(i);

            switch(currentStep) {

                case "ma<-rsp" :
                    memoryAddress = stackPointer.returnSP();
                    dataBus.sendAddressToMA(memoryAddress);
                    break;

                case "c<-rsp-8" :
                    memoryAddress = stackPointer.returnSP();
                    memoryAddress = memoryAddress - 8;
                    dataBus.updateC(memoryAddress);
                    break;

                case "md<-m[ma]" :
                    memoryData = stackPointer.fetchData();
                    break;

                case "rsp<-c" :
                    stackPointer.update(C.getData());
                    break;
            }
        }
    }

    /**
     * I was unable to fulfill the halt, call and ret instructions.
     */
    public void executeOther(){
        System.out.println("Unable to execute this instruction.");
    }
}
