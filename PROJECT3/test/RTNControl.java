import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Agathe on 11/2/2016.
 */
public class RTNControl {
    public RTNRMOV rtnrmov;
    public RTNMMOV rtnmmov;
    public RTNFetch rtnFetch;
    public RTNOperations rtnOperations;
    public RTNJump rtnJump;
    public RTNStack rtnStack;

    public RTNControl(HashMap<String, LinkedList<String>> rtnMap){
        rtnrmov = new RTNRMOV();
        rtnmmov = new RTNMMOV();
        rtnFetch = new RTNFetch();
        rtnOperations = new RTNOperations();
        rtnJump = new RTNJump();
        rtnStack = new RTNStack();

        for(String key: rtnMap.keySet()){

            switch(key) {

                case "irmov" :
                case "rrmov" :
                    rtnrmov.initialize(key, rtnMap.get(key));
                    break;

                case "mrmov" :
                case "rmmov" :
                    rtnmmov.initialize(key, rtnMap.get(key));
                    break;

                case "fetch" :
                    rtnFetch.initialize(key, rtnMap.get(key));
                    break;

                case "add" :
                case "sub" :
                case "xor" :
                case "and" :
                    rtnOperations.initialize(key, rtnMap.get(key));
                    break;

                case "jmp" :
                case "jl" :
                case "jle" :
                case "jg" :
                case "jge" :
                case "je" :
                case "jne" :
                    rtnJump.initialize(key, rtnMap.get(key));
                    break;

                case "push" :
                case "pop" :
                case "halt" :
                case "call" :
                case "ret" :
                    rtnStack.initialize(key, rtnMap.get(key));
                    break;
            }

        }
    }

}
