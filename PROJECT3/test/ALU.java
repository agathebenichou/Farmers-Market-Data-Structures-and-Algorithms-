/**
 * Created by Agathe on 10/27/2016.
 * The ALU is where the arithmetic of CPU happens. Any sort of operation must pass through the ALU and the result is sent to a register called C.
 * Upon any operation, the ALU must check if the result signals any flags.
 */
public class ALU {
    /**
     * A and B are the variables passed through the ALU for an operation to be performed on.
     * C is the result and binaryResult is the binary equivalent of that result.
     */
    private int A;
    private int B;
    private int C;
    private String binaryResult;

    /**
     * These are the 3 flags that come with the ALU.
     * SF is sign flag which is set equal to the most-significant bit of the result, which is the
     * sign bit of a signed integer. (0 indicates a positive value and 1 indicates a negative value.)
     *
     * OF is an overflow flag is set if the integer result is too large a positive number or too small a negative number (excluding the sign-bit)
     * to fit in the destination operand; cleared otherwise. This flag indicates an overflow condition for signed-integer (two’s complement) arithmetic.
     *
     * ZF is a zero flag which is set if the result is zero; cleared otherwise.
     */
    private boolean SF;
    private boolean OF;
    private boolean ZF;

    /**
     * This is the register that stores any calculation done by the ALU. The databus must fetch the result from this register.
     */
    public RegisterC regC;

    /**
     * Constructor
     * Passes through the Register C, sets all flags to false and results to 0/empty.
     */
    public ALU(RegisterC regC){
        this.regC = regC;
        this.SF = false;
        this.OF = false;
        this.ZF = false;
        this.binaryResult = "";
        this.C = 0;
    }

    /**
     * The addition command of the ALU. It checks to see if the length of the binary equivalent of result is greater
     * than the max length that registers can store, then checks to see if the highest bit is 1/0 and finally checks
     * to see if the result is 0 or not. It sends the result of the alu (C) to the register C.
     * @param A
     * @param B
     *
     */
    public void add(int A, int B){
        this.A = A;
        this.B = B;
        this.C = this.A + this.B;
        this.binaryResult = Integer.toBinaryString(C);
        System.out.println("In binary " + this.binaryResult);
        overflowCheck(this.binaryResult);
        signCheck(this.C);
        zeroCheck(this.C);

        regC.insert(C);
    }

    /**
     * The subtraction command of the ALU. It checks to see if the length of the binary equivalent of result is greater
     * than the max length that registers can store, then checks to see if the highest bit is 1/0 and finally checks
     * to see if the result is 0 or not. It sends the result of the alu (C) to the register C.
     *
     * @param A
     * @param B
     */
    public void sub(int A, int B){
        this.A = A;
        this.B = B;
        this.C = this.A - this.B;
        this.binaryResult = Integer.toBinaryString(C);
        System.out.println("In binary " + this.binaryResult);
        overflowCheck(this.binaryResult);
        signCheck(this.C);
        zeroCheck(this.C);

        regC.insert(C);
    }

    /**
     * The exclusive OR command of the ALU. It checks to see if the length of the binary equivalent of result is greater
     * than the max length that registers can store, then checks to see if the highest bit is 1/0 and finally checks
     * to see if the result is 0 or not. It sends the result of the alu (C) to the register C.
     *
     * @param A
     * @param B
     */
    public void xor(int A, int B){
        this.A = A;
        this.B = B;
        this.C = this.A ^ this.B;
        this.binaryResult = Integer.toBinaryString(C);
        System.out.println("In binary " + this.binaryResult);
        overflowCheck(this.binaryResult);
        signCheck(this.C);
        zeroCheck(this.C);

        regC.insert(C);
    }

    /**
     * The and command of the ALU. It checks to see if the length of the binary equivalent of result is greater
     * than the max length that registers can store, then checks to see if the highest bit is 1/0 and finally checks
     * to see if the result is 0 or not. It sends the result of the alu (C) to the register C.
     *
     * @param A
     * @param B
     */
    public void and(int A, int B){
        this.A = A;
        this.B = B;
        C=this.A & this.B;
        this.binaryResult = Integer.toBinaryString(C);
        System.out.println("In binary " + this.binaryResult);
        overflowCheck(this.binaryResult);
        signCheck(this.C);
        zeroCheck(this.C);

        regC.insert(C);
    }

    /**
     * Takes in the binary result of any calculation, checks to see if its length is greater than 16 (bits) and
     * changes the boolean value of the overflow flag based off of that.
     * @param binary
     */
    public void overflowCheck(String binary){
        if(binary.length() > 16) {
            this.OF = true;
        } else {
            this.OF = false;
        }
    }

    /**
     * Takes in the integer result of any calculation, checks to see if it is 0 and changes the boolean value
     * of the zero flag based off of that.
     * @param result
     */
    public void zeroCheck(int result){
        if(result == 0){
            this.ZF = true;
        } else {
            this.ZF = false;
        }
    }

    /**
     * Takes in the integer result of any calculation, checks to see if its highest bit (leftmost bit) is 1,
     * if it is then it changes the boolean value of the sign flag based off of that.
     * @param result
     */
    public void signCheck(int result){
        int signBit = Integer.highestOneBit(result);

        if(signBit == 1){
            this.SF = true;
        } else {
            this.SF = false;
        }
    }

    /**
     * @return The boolean value of sign flag.
     */
    public boolean checkSignFlag(){
        return this.SF;
    }

    /**
     * @return The boolean value of zero flag.
     */
    public boolean checkZeroFlag(){
        return this.ZF;
    }

    /**
     * @return The booealn value of the overflow flag.
     */
    public boolean checkOverflowFlag(){
        return this.OF;
    }

}
