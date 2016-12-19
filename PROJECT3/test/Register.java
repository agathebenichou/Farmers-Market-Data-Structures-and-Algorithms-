/**
 * Created by Agathe on 10/26/2016.
 * This imitates the registers as data structures. It has a register name R0 and a binary name 0000 along with a boolean
 * value about whether it is available for storage and its global variable which stores the registers data.
 */
public class Register {
    String registerName;
    String binaryName;
    int data=0;
    String binaryData="";

    public Register(){
    }

    /**
     * This constructor initiates all registers with both their names and makes their availability
     * to true.
     * @param registerName
     * @param binaryName
     */
    public Register(String registerName, String binaryName){
        this.binaryName = binaryName;
        this.registerName = registerName;
    }

    /**
     * This method clears the registers
     */
    public void clearRegister(){
        binaryData = "";
        data=0;
        System.out.println("Register " + registerName + " is now empty.");
    }

    /**
     * Inserts a new piece of data to the register.
     * @param data
     */
    public void insert(int data){
        this.data = data;
        binaryData = Integer.toBinaryString(data);
        System.out.println("Register " + registerName + " now has a value of " + data + "(" + binaryData +")");
    }

    /**
     *
     * @return the data the register stores
     */
    public int getData(){
        return this.data;
    }

    public String getBinaryData() {
        return binaryData;
    }

}

