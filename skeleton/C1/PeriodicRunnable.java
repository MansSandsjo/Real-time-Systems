/*
 *  class PeriodicRunnable extends Base implements Runnable:
 *
 * Same class as periodic but using the runnable interface rather than extending thread
 */
public class PeriodicRunnable extends Base implements Runnable {  //TODO C1.E16: Consider why we implement Runnable. //

    private int period;
    
    /*
     * Constructor for the class PeriodicRunnable
     *
     * @param:
     *     period (int): TO WRITE
     */
    public PeriodicRunnable(int period) {

        //TODO C1.E16: Write your initialization code here //

    }

    /*
     * Method run:
     */
    public void run() {

        //TODO C1.E20: Write code that prints thread priority //
        System.out.println("Period " + period + " => Priority " + "????????");

        //TODO C1.E22: Write code that increases thread priority //

        //TODO C1.E16: Same functionality as the Periodic class //

    }

    public static void main(String[] args) {
        //TODO C1.E16: Same functionality as the Periodic class //
    }
}
