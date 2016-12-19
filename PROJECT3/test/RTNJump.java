/**
 * Created by Agathe on 11/5/2016.
 * This class handles the RTN for any jump instruction.
 */
import java.util.LinkedList;

public class RTNJump {
    LinkedList<String> jmpSteps;
    String currentInstruction;

    public RTNJump(){

    }

    /**
     * This method initializes the instruction with its corresponding Linked List of rtn instruction.
     * Since all instructions have the same rtn, they all initialize to the same rtn.
     * @param instruction
     * @param rtnSteps
     */
    public void initialize(String instruction, LinkedList<String> rtnSteps) {

        switch(instruction) {
            case "jmp" :
            case "jl" :
            case "jle" :
            case "jg" :
            case "jge" :
            case "je" :
            case "jne" :
                jmpSteps = new LinkedList<String>();
                this.jmpSteps = rtnSteps;
                break;
        }
    }

    /**
     * This is the main method which is called by the CPU when a jump instrution is found as one of the instructions.
     *
     * It checks to see if certain flags are set for certain jumps and if they are, it will execute the jump.
     * @param instruction
     * @param dataBus
     * @param alu
     * @param memoryAddress
     */
    public void executeJMP(String instruction, CPU.DataBus dataBus,ALU alu, String memoryAddress){
        this.currentInstruction = instruction;
        boolean execute = false;

        switch(instruction) {
            case "jl" :
                if((alu.checkSignFlag())^(alu.checkOverflowFlag())){
                    execute = true;
                } else {
                    execute = false;
                }
                break;

            case "jle" :
                if(((alu.checkSignFlag())^(alu.checkOverflowFlag())|alu.checkZeroFlag())){
                    execute = true;
                } else {
                    execute = false;
                }
                break;

            case "jg" :
                if(!((alu.checkSignFlag())^(alu.checkOverflowFlag()))&!(alu.checkZeroFlag())){
                    execute = true;
                }else {
                    execute = false;
                }
                break;

            case "jge" :
                if(!(alu.checkSignFlag()^alu.checkOverflowFlag())){
                    execute = true;
                } else {
                    execute = false;
                }
                break;

            case "je" :
                if(alu.checkZeroFlag()){
                    execute = true;
                } else {
                    execute = false;
                }
                break;

            case "jne" :
                if(!alu.checkZeroFlag()){
                    execute = true;
                } else {
                    execute = false;
                }
                break;

            case "jmp" :
                execute = true;
                break;
            }

        if(execute) {
            for (int i = 0; i < jmpSteps.size(); i++) {
                String currentStep = jmpSteps.get(i);

                switch (currentStep) {
                    case "pc<-m[ma]":
                        dataBus.redirectPC(memoryAddress);
                        break;
                }
            }
        }
    }

}
