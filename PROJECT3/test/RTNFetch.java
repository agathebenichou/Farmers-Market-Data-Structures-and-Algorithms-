/**
 * Created by Agathe on 11/3/2016.
 */

import java.util.LinkedList;

public class RTNFetch {
    public LinkedList<String> fetchSteps;

    public RTNFetch(){

    }

    public void initialize(String instruction, LinkedList<String> rtnSteps){
        fetchSteps = new LinkedList<String>();
        this.fetchSteps = rtnSteps;
    }

    public void executeFetch(CPU.DataBus dataBus, MainMemory mainMemory, MainMemory.ProgramCounter programCounter, InstructionRegister instructionRegister){

        int position=0;

        for(int i = 0; i < fetchSteps.size(); i++){
            String currentStep = fetchSteps.get(i);

            if(currentStep.equals("c<-pc+2")){
                position = dataBus.incrementPC();

            } else if(currentStep.equals("ma<-pc")) {
                dataBus.sendAddressToMA(position);

            } else if(currentStep.equals("pc<-c")) {
                dataBus.updatePC();

            } else if(currentStep.equals("md<-m[ma]")) {

            } else if(currentStep.equals("ir<-md")) {
                instructionRegister.fetchNextInstruction();
            }

        }
    }
}
