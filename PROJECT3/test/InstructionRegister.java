import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;


/**
 * Created by Agathe on 10/27/2016.
 * The Instruction Register accepts the binary instruction sent by the program counter, parses it and sends it to the CPU
 * to be processed and simulates it.
 */
public class InstructionRegister extends Register {
    String instruction;
    MainMemory.ProgramCounter programCounter;
    BinaryAssemblyStructure binaryAssemblyStructure;
    HashMap<String, LinkedList<String>> rtnMap = new HashMap<String, LinkedList<String>>();

    /**
     * The constructor takes in the Program Counter and the Binary Assembly Structure. The instruction is sent by
     * the program counter and parsed using the data structure in the binary assembly struvture.
     * @param programCounter
     * @param binaryAssemblyStructure
     */
    public InstructionRegister(MainMemory.ProgramCounter programCounter, BinaryAssemblyStructure binaryAssemblyStructure){
        this.programCounter = programCounter;
        this.binaryAssemblyStructure = binaryAssemblyStructure;
        readInRTN("RTN.txt");
    }

    /**
     * Increments the program counter to point to the next instruction and assigns this.instruction to be
     * the next instruction stored in main memory at the address the program counter points to.
     */
    public void fetchNextInstruction(){
        programCounter.incrementPointer();
        this.instruction = programCounter.sendInstruction();
    }

    /**
     * This long method parses the binary instruction. It looks at the first 8 bits to see what the instruciton is:add, rmmov, irmov...
     * and depending on that instruction, parses the next 8 bits (source and destination operands) different.
     * @return the Y86 instruction in the format 'add R1 R2'
     */
    public String parseInstruction(){
        String[] instructionAll = {this.instruction.substring(0, 8), this.instruction.substring(8, 12), this.instruction.substring(12, 16)};
        String assemblyInstruction = binaryAssemblyStructure.findInstruction(instructionAll[0]);

        if(assemblyInstruction.equals("rmmov")){
            String assemblySource = binaryAssemblyStructure.findRegister(instructionAll[1]);
            String assemblyDestination = binaryAssemblyStructure.findRegister(instructionAll[2]);

            int memoryAddress = Integer.parseInt(assemblyDestination);
            // store to memory
            instruction = assemblyInstruction + " " + assemblySource + " (" + memoryAddress + ") ";

        } else if(assemblyInstruction.equals("mrmov")){
            String assemblySource = binaryAssemblyStructure.findRegister(instructionAll[1]);
            String assemblyDestination = binaryAssemblyStructure.findRegister(instructionAll[2]);

            int memoryAddress = Integer.parseInt(assemblySource);
            // fetch from memory
            instruction = assemblyInstruction + " (" + memoryAddress + ") " + assemblyDestination;

        } else if(assemblyInstruction.equals("irmov")){
            String assemblySource = binaryAssemblyStructure.findRegister(instructionAll[1]);
            String assemblyDestination = binaryAssemblyStructure.findRegister(instructionAll[2]);

            String immediate = assemblySource;
            int immediateValue = Integer.parseInt(immediate);

            instruction = assemblyInstruction + " " + immediateValue + " " + assemblyDestination;

        } else if(assemblyInstruction.equals("rrmov")) {
            String assemblySource = binaryAssemblyStructure.findRegister(instructionAll[1]);
            String assemblyDestination = binaryAssemblyStructure.findRegister(instructionAll[2]);

            instruction = assemblyInstruction + " " + assemblySource + " " + assemblyDestination;

        } else if(assemblyInstruction.equals("jmp")||assemblyInstruction.equals("jle")||assemblyInstruction.equals("jl")||assemblyInstruction.equals("je")||assemblyInstruction.equals("jne")||assemblyInstruction.equals("jge")||assemblyInstruction.equals("jg")){
            String binaryLabel1 = instructionAll[1];
            int decimalLabel1 = Integer.parseInt(binaryLabel1, 2);
            String hexLabel1 = Integer.toHexString(decimalLabel1);

            String binaryLabel2 = instructionAll[2];
            int decimalLabel2 = Integer.parseInt(binaryLabel2, 2);
            String hexLabel2 = Integer.toHexString(decimalLabel2);

            instruction = assemblyInstruction + " " + hexLabel1 + hexLabel2;

        } else if(assemblyInstruction.equals("add")||assemblyInstruction.equals("sub")||assemblyInstruction.equals("and")||assemblyInstruction.equals("xor")){
            String assemblySource = binaryAssemblyStructure.findRegister(instructionAll[1]);
            String assemblyDestination = binaryAssemblyStructure.findRegister(instructionAll[2]);

            instruction = assemblyInstruction + " " + assemblySource + " " + assemblyDestination;
        }

        return instruction;
    }

    /**
     * This method parses the RTN file and stores it into a hashmap which looks like {add [.. .. ..], mrmov [.. .. ..]}
     * @param textFile
     */
    public void readInRTN(String textFile){
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users/Agathe/CS203Project1/src/"+textFile)))
        {
            String currentLine;
            while ( (currentLine = br.readLine()) != null) {
                String[] rtn = currentLine.split(" ");
                LinkedList<String> rtnSteps = new LinkedList<String>();
                for(int i = 1; i < rtn.length; i++){
                    rtnSteps.add(rtn[i]);
                }
                rtnMap.put(rtn[0], rtnSteps);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns the Linked List of RTN instructions for a single Y86 assembly incstruction.
     * @return
     */
    public LinkedList<String> getRTNForInstruction(){
        String[] label = this.instruction.split(" ");
        LinkedList<String> instructionArray = rtnMap.get(label[0]);
        return instructionArray;
    }

    public HashMap<String, LinkedList<String>> getRtnMap(){
        return rtnMap;
    }

}
