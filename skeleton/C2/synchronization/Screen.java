/*
 *  class Screen:
 *
 * Printing to a screen
 */

    /*
     * method printPeriod:
     *
     * @param:
     *     p (int): Period to write to screen
     */
     // TODO C2.E4: WRITE FUNCTION printPeriod(int period)//

public class Screen {
	public synchronized void writePeriod(int p) {
		System.out.print(p);
		System.out.print(", ");
	}
}