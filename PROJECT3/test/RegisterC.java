/**
 * Created by Agathe on 11/7/2016.
 *
 * The Register C is what contains the result of the ALU operation
 */
public class RegisterC extends Register {
    String registerName;
    String binaryName;
    int data=0;
    String binaryData="";

    public RegisterC(String registerName, String binaryName){
        this.registerName = registerName;
        this.binaryName = binaryName;
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

    /**
     *
     * @return the binary equivalent of the integer
     */
    public String getBinaryData() {
        return binaryData;
    }

}
