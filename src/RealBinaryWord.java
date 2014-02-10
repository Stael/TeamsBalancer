/***************************************************************************
 * Project file:    TeamsBalancer - TeamsBalancer - RealBinaryWord.java    *
 * Full Class name: RealBinaryWord                                         *
 *                                                                         *
 *                Copyright (c) 2014 Ribesg - www.ribesg.fr                *
 *   This file is under GPLv3 -> http://www.gnu.org/licenses/gpl-3.0.txt   *
 *    Please contact me at ribesg[at]yahoo.fr if you improve this file!    *
 ***************************************************************************/

public class RealBinaryWord implements BinaryWordInterface {

	private static final int  SIZE_1 = Long.SIZE - 1;
	private              long bits   = 0;

	/**
	 * Increment the binary word by 1
	 */
	@Override
	public void increment() {
		bits++;
	}

	/**
	 * Return the bit at a given position
	 *
	 * @param index of the bit we want
	 *
	 * @return a boolean who symbolize the status of the bit at the given index
	 */
	@Override
	public boolean bitAt(final int index) {
		return ((bits << (SIZE_1 - index)) >>> SIZE_1) == 1;
	}

	/**
	 * Return the number of bit who are set to 1
	 *
	 * @return the number of bit set to 1
	 */
	@Override
	public int bitsAtTrue() {
		return Long.bitCount(bits);
	}

	/**
	 * Return the binary word as an integer
	 *
	 * @return the binary word converted to an integer
	 */
	@Override
	public int toInteger() {
		return (int) bits;
	}
}
