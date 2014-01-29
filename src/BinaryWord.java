/**
 * Implementation of BinaryWordInterface
 * Fast to implement, but dirty and have really bad performances
 */
public class BinaryWord implements BinaryWordInterface {
    private int    binaryInt;
    private String binaryString;
    private int    size;

    public BinaryWord(int size) {
        this.size = size;
        this.binaryInt = 0;
        this.calculateBinaryString();
    }

    @Override
    public void increment() {
        this.binaryInt += 1;
        this.calculateBinaryString();
    }

    @Override
    public boolean bitAt(int index) {
        return binaryString.charAt(size - index - 1) == '1';
    }

    @Override
    public int bitsAtTrue() {
        int bitsAtTrue = 0;
        for (int i = 0; i < size; i++) {
            bitsAtTrue += binaryString.charAt(i) == '1' ? 1 : 0;
        }
        return bitsAtTrue;
    }

    @Override
    public int toInteger() {
        return binaryInt;
    }

    @Override
    public String toString() {
        return binaryString;
    }

    private void calculateBinaryString() {
        StringBuilder stringBuilder = new StringBuilder();
        binaryString = Integer.toBinaryString(binaryInt);
        for (int i = binaryString.length(); i < size; i++) {
            stringBuilder.append('0');
        }
        stringBuilder.append(binaryString);
        binaryString = stringBuilder.toString();
    }

}
