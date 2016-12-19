import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Agathe on 10/27/2016.
 * Main Memory is an array which stores the program code in the form of machine instructions and the normal program memory.
 * Addresses 0 to 9 is for the instructions, Addresses 10 to 20 is for the main memory storage.
 */
public class MainMemory {
    private String[] programMemory = new String[20];
   // public int memoryAddressPointer;
   // public String memoryData;

    /**
     * Loads the machine code instructions into the specified address from the file and instantiates the program counter.
     * @param textFile
     */
    public MainMemory(String textFile){
        loadInstructions(textFile);
        ProgramCounter pc = new ProgramCounter();
        programMemory[10] = "3";
    }


    /**
     * Loads in the machine code to the memory.
     * @param textFile
     */
    private void loadInstructions(String textFile){
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users/Agathe/CS203Project1/src/"+textFile)))
        {
            String currentLine;
            while ( (currentLine = br.readLine()) != null) {
                String[] machineCode = currentLine.split(" ");
                String addressStringHex = machineCode[0];
                String[] addressString = addressStringHex.split("x");
                int address = Integer.parseInt(addressString[1]);
                String instruction = machineCode[1];
                String[] instructionAll = {instruction.substring(0, 8), instruction.substring(8, 16)};
                String instructionType = instructionAll[0];
                String instructionSourceDestination = instructionAll[1];

                programMemory[address] = instructionType;
                programMemory[address+1] = instructionSourceDestination;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
        for(int i = 0; i < programMemory.length; i++){
            System.out.println("Address:" + i + " Instruction:" + programMemory[i]);
        }
         **/
    }

    /**
     * Inner class to Main Memory. Program Counter points at the instruction set stored in main memory, grabs the
     * 16 bit instruction stored there and sends it to the Instruction Register.
     */
    public class ProgramCounter extends Register{
        private int address;
        private String data;

        /**
         * The program counter always initially points to address 0 and the data is the instruction stored there.
         */
        public ProgramCounter(){
            address = 0;
            data = fetchInstruction(address);
        }

        /**
         * If the program counter is pointing to an address between 0 and 9, fetch the first 8 bits, increment, fetch
         * the next 8 bits and increment it again.
         */
        public void incrementPointer(){
            if(checkAvailableMemory()){
                data = fetchInstruction(address);
                address++;
                data += fetchInstruction(address);
                address++;
            }
        }

        /**
         * Fetches the instruction from the main memory given the address.
         * @param address
         * @return the instruction stored at that address.
         */
        public String fetchInstruction(int address){
            if((address >= 0)&&(address <= 9)){
                String instruction = programMemory[address];
                return instruction;
            } else {
                return null;
            }
        }

        /**
         * Redirects the program counter to point to a new address in the main memory.
         * @param address
         */
        public void redirectPointer(int address){
            this.address=address;
            System.out.println("Program Counter has been redirected to memory address " + this.address);
        }

        /**
         * Sends the instruction that the program counter is pointing.
         * @return 16 bit instruction
         */
        public String sendInstruction(){
            return data;
        }

        /**
         *
         * @return true or false depending on if the program counter is pointing
         * to the main memory range where the instructions are stored.
         */
        public boolean checkAvailableMemory(){
            if(address < 10){
                return true;
            } else {
                return false;
            }
        }

        /**
         *
         * @return the current address that the program counter is pointing to
         */
        public int returnCurrentAddress(){
            return address;
        }
    }

    /**
     * The stack pointer is a small register that stores the address of the last program request in the stack.
     */
    public class StackPointer extends Register{
        public int currentAddress;
        public String data;
        public String binaryData;


        public StackPointer() {
            currentAddress = 10;
            data = fetchData();
        }

        public void update(int address){
            if((address >= 10) && (address <= 20)) {
                this.currentAddress = address;
                System.out.println("Updated MA to " + this.currentAddress);
            }
        }

        public int returnSP(){
            return this.currentAddress;
        }

        /**
         * Fetches the data from the main memory given the address.
         * @param address
         * @return the data stored at that address.
         */
        public String fetchData(){
            String data = programMemory[this.currentAddress];
            System.out.println("Pulled " + data + " from address " + this.currentAddress + " in main memory.");
            return data;
        }

        /**
         * Takes the given address and stores the given address to it.
         * @param address
         * @param data
         * @return true if the address is in correct domain for main memory
         */
        public void storeData(String data){
            //String dataString = Integer.toString(data);
            programMemory[this.currentAddress] = data;
            System.out.println(data + " has been stored at memory location " + this.currentAddress);
        }

    }

}
