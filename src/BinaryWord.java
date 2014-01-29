public class BinaryWord {
    private int binaryInt;
    private String binaryString;
    private int size;

    public BinaryWord(int size) {
        this.size = size;
        this.binaryInt = 0;
        this.calculateBinaryString();
    }

    public void add(int i) {
        this.binaryInt += i;
        this.calculateBinaryString();
    }

    public boolean bitAt(int index) {
        return binaryString.charAt(size-index-1) == '1';
    }

    public int bitsAtTrue() {
        int bitsAtTrue = 0;
        for(int i = 0; i < size; i++) {
            bitsAtTrue += binaryString.charAt(i) == '1' ? 1 : 0;
        }
        return  bitsAtTrue;
    }

    public int toInteger() {
        return binaryInt;
    }

    public String toString() {
        return binaryString;
    }

    private void calculateBinaryString() {
        StringBuilder stringBuilder = new StringBuilder();
        binaryString = Integer.toBinaryString(binaryInt);
        for(int i = binaryString.length(); i < size; i++) {
            stringBuilder.append('0');
        }
        stringBuilder.append(binaryString);
        binaryString = stringBuilder.toString();
    }

}
