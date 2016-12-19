import com.sun.org.apache.xpath.internal.operations.Mult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.lang.NullPointerException;

/**
 * Created by Agathe on 10/27/2016.
 *
 * Used to store the correlation between 4 bit binary values and register names in registerStack
 * Stores the register objects in an array R0-R7
 */
public class RegisterControl {
    public HashMap<String, String> registerStack = new HashMap<String, String>();
    public Register[]  registerObjects = new Register[8];
    public Register selectedRegister;

    /**
     * This constructor reads in the register file which contains string and binary names and stores it to a
     * data structure and then creates register objects based on those values.
     * @param textfile
     */
    public RegisterControl(String textfile){
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users/Agathe/CS203Project1/src/"+textfile)))
        {
            String currentLine;
            int counter = 0;
            while ( (currentLine = br.readLine()) != null) {
                String[] register = currentLine.split(" ");
                String key = register[0];
                String value = register[1];
                registerStack.put(key, value);

                Register newReg = new Register(key, value);
                registerObjects[counter] = newReg;
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Values must go though the selector before a register object is chosen.
     *
     */
    public class Selector{
        public Selector(){

        }

        /**
         * Takes in a binary name referring to a register, finds its english name R0 equivalent
         * and search for that registers object in the object array
         * @param regName
         * @return the register object
         */
        public Register findRegister(String regName) {
            for(int i = 0; i < registerObjects.length; i++){
                if(regName.equals(registerObjects[i].registerName)){
                    selectedRegister =  registerObjects[i];
                    break;
                }
            }
            System.out.println("Found register " + selectedRegister.registerName + " which stores " + selectedRegister.getData() + "(" + selectedRegister.getBinaryData() + ")");
            return selectedRegister;
        }
    }
}
