import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Agathe on 10/27/2016.
 * The 'BinaryAssembly.txt' file stores the binary key that correlates to Y86 assembly instructions. These are loaded into
 * a Hashmap where the key is the string name and the value is its binary reference.
 */
public class BinaryAssemblyStructure {
    HashMap<String, String> binaryAssembly = new HashMap<String, String>();

    /**
     * Loads the information from the textfile into the hashmap where the key is the string name of the instruction and the value
     * is its binary reference.
     * @param textfile
     */
    public BinaryAssemblyStructure(String textfile){
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users/Agathe/CS203Project1/src/"+textfile)))
        {
            String currentLine;
            while ( (currentLine = br.readLine()) != null) {
               String[] instruction = currentLine.split(" ");
                String key = instruction[0];
                String value = instruction[1];
                binaryAssembly.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method finds the instruction name given its binary code.
     * @param binary
     * @return the English name: add, mrmov, ret...
     */
    public String findInstruction(String binary){
        String instruction = "";
        for(String key: binaryAssembly.keySet()){
            String value = binaryAssembly.get(key);
            if(value.equals(binary)){
                instruction = key;
                break;
            }
        }
        return instruction;
    }

    /**
     * This method finds the register given its binary code.
     * @param binary
     * @return the English name: R0, R1, R2...
     */
    public String findRegister(String binary){
        String register = "";
        String[] immediate = {binary.substring(0,1), binary.substring(1,4)};
        for(String key: binaryAssembly.keySet()){
            String value = binaryAssembly.get(key);
            if(value.equals(binary)){
                register = key;
                break;
            } else if(Integer.parseInt(immediate[0]) == 1){
                register = immediate[1];
            }
        }
        return register;
    }
}

