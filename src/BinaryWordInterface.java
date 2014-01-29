/**
 * Interface to manipulate a binary word needed for the BruteBalancer
 */
public interface BinaryWordInterface {

    /**
     * Increment the binary word by 1
     */
    public void increment();

    /**
     * Return the bit at a given position
     *
     * @param index of the bit we want
     * @return a boolean who symbolize the status of the bit at the given index
     */
    public boolean bitAt(int index);

    /**
     * Return the number of bit who are set to 1
     *
     * @return the number of bit set to 1
     */
    public int bitsAtTrue();

    /**
     * Return the binary word as an integer
     *
     * @return the binary word converted to an integer
     */
    public int toInteger();
}
