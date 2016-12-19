import java.util.LinkedList;
import java.lang.NullPointerException;

/**
 * Main class where everything is controlled.
 * The program is set up with loading information from text files to data structures, instructions are
 * parsed and passed through to the CPU where the simulation is done.
 */
public class Main {

    public static void main(String[] args) {
        /**
         * A class that reads in the Binary-Assembly structure and stores it into a hashmap so that
         * the key is the name of the instruction 'add' and the value is the binary equivalent of that
         * instruction which is based on the language created
         */
        BinaryAssemblyStructure binaryAssemblyStructure = new BinaryAssemblyStructure("BinaryAssembly.txt");

        /**
         * Reads in the Registers file and stores it into a hashmap so that the key is the name of a register
         * 'r1' and the value is the binary equivalent of that register which is based off the language created
         *
         * For every register read, it creates a register object for that line of code and stores that into an
         * array of Register objects.
         */
        RegisterControl registerControl = new RegisterControl("Registers.txt");

        /**
         * Creates a selector which has access to the array of register objects in order to choose
         * which register to operate on.
         */
        RegisterControl.Selector selector = registerControl.new Selector();

        /**
         * This class loads in the Machine Code instructions (address 16bitbinaryinstruction) to the main memory
         * of the progra,
         */
        MainMemory mainMemory = new MainMemory("MachineCode.txt");

        /**
         * Creates the program counter as a subclass of the main memory to point to the part of main memory
         * which handles the storage of instructions
         */
        MainMemory.ProgramCounter programCounter = mainMemory.new ProgramCounter();

        /**
         * Creates a stack pointer as a subclass of the main memory to point to the part of main memory which
         * handles the storage of memory
         */
        MainMemory.StackPointer stackPointer = mainMemory.new StackPointer();

        /**
         * Creates an instruction register which receives 16 bit binary instructions from the program counter, parses
         * them and returns the corresponding rtn in english language
         */
        InstructionRegister instructionRegister = new InstructionRegister(programCounter, binaryAssemblyStructure);

        /**
         * Creates an RTN control class which controls all subsequent subclasses of rtn (such as moves, fetches, jumps..)
         * are stored and handled
         */
        RTNControl rtnControl = new RTNControl(instructionRegister.getRtnMap());

        /**
         * This Register C stores the results of the alu to be passed back to the databus
         */
        RegisterC C = new RegisterC("C", "1010");

        /**
         * This handles all CPU operations
         */
        ALU alu = new ALU(C);

        System.out.println();

        /**
         * Creates the CPU simulator which contains all the components needed to complete rtn instructions
         */
        CPU cpu = new CPU(registerControl, selector,C, mainMemory, programCounter,stackPointer, instructionRegister,alu, rtnControl);

    }
}