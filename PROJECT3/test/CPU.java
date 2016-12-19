/**
 * Created by Agathe on 10/30/2016.
 * This class runs simulation of the program. It controls all the parts of the CPU.
 */

import java.util.LinkedList;

public class CPU {
    String currentInstruction = "";
    RegisterControl registerControl;
    RegisterControl.Selector selector;
    DataBus dataBus;
    RTNControl rtnControl;
    MainMemory mainMemory;
    MainMemory.ProgramCounter programCounter;
    MainMemory.StackPointer stackPointer;
    RegisterC C;
    ALU alu;

    /**
     * The CPU is composed of many components.
     * @param registerControl
     * @param selector
     * @param mainMemory
     * @param programCounter
     * @param instructionRegister
     * @param alu
     * @param rtnControl
     */
    public CPU(RegisterControl registerControl, RegisterControl.Selector selector,RegisterC C, MainMemory mainMemory, MainMemory.ProgramCounter programCounter, MainMemory.StackPointer stackPointer, InstructionRegister instructionRegister, ALU alu, RTNControl rtnControl){

        this.dataBus = new DataBus();
        this.registerControl = registerControl;
        this.selector = selector;
        this.rtnControl = rtnControl;
        this.mainMemory = mainMemory;
        this.C = C;
        this.programCounter = programCounter;
        this.stackPointer = stackPointer;
        this.alu = alu;

        /**
         * While the program counter is still running on memory allocated to the instructions, execute a fetch and then
         * process the instruction.
         */
        while(programCounter.checkAvailableMemory()){
            rtnControl.rtnFetch.executeFetch(dataBus, mainMemory, programCounter, instructionRegister);
            this.currentInstruction = instructionRegister.parseInstruction();
            System.out.println("Current Instruction: " + currentInstruction);
            processInstruction(this.currentInstruction);

            System.out.println("-------------------");
        }
    }

    /**
     * This method takes an instruction such as 'add R0 R1', parses it and depending on the instruction name, identifies the
     * following parameters and sends it to the appropriate RTN classes to be dealt with there.
     * @param currentInstruction
     */
    public void processInstruction(String currentInstruction){
        String[] instructionSplit = currentInstruction.split(" ");
        String instructionName = instructionSplit[0];
        String registerDestination ="";
        String memoryAddress = "";
        String registerSource;

        switch(instructionName) {
            case "irmov" :
                String immediateValue = instructionSplit[1];
                registerDestination = instructionSplit[2];
                System.out.println("Executing IRMOV......");
                rtnControl.rtnrmov.executeIRMOV(dataBus, immediateValue, registerDestination);
                break;

            case "add" :
            case "sub" :
            case "xor" :
            case "and" :
                registerSource = instructionSplit[1];
                registerDestination = instructionSplit[2];
                System.out.println("Executing " + instructionName.toUpperCase() + "......");
                rtnControl.rtnOperations.executeOperation(instructionName, dataBus,C,
                        registerSource, registerDestination);
                break;

            case "mrmov" :
                memoryAddress = instructionSplit[1];
                registerDestination = instructionSplit[2];
                System.out.println("Executing MRMOV.....");
                rtnControl.rtnmmov.executeMRMOV(dataBus, mainMemory,stackPointer, memoryAddress, registerDestination);
                break;

            case "jmp" :
            case "jl" :
            case "jle" :
            case "jg" :
            case "jge" :
            case "jn" :
            case "jne" :
                memoryAddress = instructionSplit[1];
                System.out.println("Executing " + instructionName.toUpperCase() + "......");
                rtnControl.rtnJump.executeJMP(instructionName, dataBus,alu, memoryAddress);
                break;

            case "rmmov" :
                registerSource = instructionSplit[1];
                memoryAddress = instructionSplit[2];
                System.out.println("Executing RMMOV......");
                rtnControl.rtnmmov.executeRMMOV(dataBus, mainMemory,stackPointer, registerSource, memoryAddress);
                break;

            case "rrmov" :
                registerSource = instructionSplit[1];
                registerDestination = instructionSplit[2];
                System.out.println("Executing RRMOV....");
                rtnControl.rtnrmov.executeRRMOV(dataBus, registerSource, registerDestination);
                break;

            case "push" :
                registerSource = instructionSplit[1];
                System.out.println("Executing PUSH......");
                rtnControl.rtnStack.executePUSH(dataBus, stackPointer,C, registerSource);
                break;

            case "pop" :
                registerSource = instructionSplit[1];
                System.out.println("Executing POP......");
                rtnControl.rtnStack.executePOP(dataBus, stackPointer,C, registerSource);
                break;

            case "call" :
            case "ret" :
            case "halt" :
                rtnControl.rtnStack.executeOther();
                break;

        }
    }

    /**
     * The databus the most important part of the CPU, it links together all the parts. It retrieves information from certain parts
     * to send to other parts in order to complete the rtn.
     */
    public class DataBus {
        public boolean available;

        /**
         * Constructor that sets the bus as available.
         */
        public DataBus(){
            available = true;
        }

        /**
         * @return true or false depending on if databus is available or not.
         */
        public boolean isAvailable(){
            return available;
        }

        /**
         * Sets boolean variable to true to indicate that the databus is available.
         */
        public void makeAvailable(){
            available = true;
        }

        /**
         * Sets boolean variable to false to indicate that the databus is unavailable.
         */
        public void makeUnavailable(){
            available = false;
        }

        /**
         * Takes an integer value and stores it to a selected register.
         * Uses the selector to find the correct register object and inserts the value into that register.
         * @param value
         * @param registerName
         */
        public void sendValueToRegister(int value, String registerName){
            makeUnavailable();
            Register reg = selector.findRegister(registerName);
            reg.insert(value);
            makeAvailable();
        }

        /**
         * Takes the value from a source register and stores it as the value of a destination value, both
         * of which are indicated in the parameter.
         * @param sourceRegister
         * @param destinationRegister
         */
        public void moveRegisterValues(String sourceRegister, String destinationRegister){
            makeUnavailable();
            Register sourceReg = selector.findRegister(sourceRegister);
            Register destinationReg = selector.findRegister(destinationRegister);

            int data = sourceReg.getData();
            sourceReg.clearRegister();
            destinationReg.insert(data);

            makeAvailable();
        }

        /**
         * Sends an address to the stack pointer (so that whatever data is stored at the memory
         * address can be fetched)
         * @param address
         */
        public void sendAddressToMA(int address){
            makeUnavailable();
            stackPointer.update(address);
            makeAvailable();
        }

        /**
         * Retrieves the value of the indicated register.
         * @param registerName
         * @return
         */
        public int getValueFromRegister(String registerName){
            makeUnavailable();
            Register reg = selector.findRegister(registerName);
            int data = reg.getData();
            makeAvailable();
            return data;
        }

        /**
         * Takes the data that is currently being stored at a register and stores that in memory
         * to where the stack pointr is pointing to.
         * @param memoryData
         * @param registerData
         */
        public void updateMemoryDataWithRegister(String memoryData, String registerData){
            memoryData = registerData;
            stackPointer.storeData(memoryData);
        }

        /**
         * Takes the current position of the program counter, sends it to register 2, increments it
         * so that the next time the program counter wants to access memory, it will have the correct
         * location.
         * @return
         */
        public int incrementPC(){
            int currentPCposition = programCounter.returnCurrentAddress();
            C.insert(currentPCposition);
            System.out.println();
            currentPCposition = currentPCposition + 2;
            return currentPCposition;
        }

        /**
         * Sends the address that the program counter is currently pointing to the
         * stack pointer
         * @param currentPCposition
         */
        public void sendPcToMA(int currentPCposition){
            makeUnavailable();
            stackPointer.update(currentPCposition);
            makeUnavailable();
        }

        public void updatePC(){
        }

        /**
         * Takes two integers to send to the alu to perform an operation
         * @param instruction
         * @param sourceValue
         * @param destinationValue
         */
        public void sendToALU(String instruction, int sourceValue, int destinationValue){
            makeUnavailable();

            switch(instruction) {
                case "add" :
                    alu.add(sourceValue, destinationValue);
                    break;
                case "and" :
                    alu.and(sourceValue, destinationValue);
                    break;
                case "sub" :
                    alu.sub(sourceValue, destinationValue);
                    break;
                case "xor" :
                    alu.xor(sourceValue, destinationValue);
                    break;
            }

            makeAvailable();
        }

        /**
         * Sends in a register name, sends to the selector to choose a register object
         * and clears that register object
         * @param registerName
         */
        public void clearSelectRegister(String registerName){
            makeUnavailable();
            Register reg = selector.findRegister(registerName);
            reg.clearRegister();
            makeAvailable();
        }

        /**
         * Takes the memory address to redirect the program counter to
         * @param memoryAddress
         */
        public void redirectPC(String memoryAddress){
            makeUnavailable();
            int memAddress = Integer.parseInt(memoryAddress);
            programCounter.redirectPointer(memAddress);
            makeAvailable();
        }

        /**
         * Update the data of the register C with the stack pointer
         * @param stackPointer
         */
        public void updateC(int stackPointer){
            makeUnavailable();
            C.insert(stackPointer);
            makeAvailable();
        }

    }
}
