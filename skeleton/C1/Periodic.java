/*
 *  class Periodic extends Thread:
 *
 * Periodically executing class
 */
public class Periodic extends Thread { // TODO C1.E6

    private int period;
    
    /*
     * Constructor for the class Periodic
     *
     * @param:
     *     period (int): the period of the periodically executing object
     */
    public Periodic(int period) { 
        
        //TODO C1.E9: Write your code here //

    }

    /*
     * Method run:
     *
     * Run the thread
     */
    public void run() {

        //TODO C1.E19: Write code that prints thread priority //
        System.out.println("Period " + period + " => Priority " + "????????");

        //TODO C1.E21: Write code that increases thread priority //

        //TODO C1.E10: Write code that's supposed to execute when thread starts //
        //TODO C1.E11: Write code such that the periodic thread executes periodically //

        System.out.println("Thread stopped.");
    }

    /*
     * Main method
     */
    public static void main(String[] args) { // TODO C1.E8

        //TODO C1.E9: Create a Periodic object //
        //TODO C1.E12: Create more Periodic objects //
        //TODO C1.E13: Make program read input arguments //
        //TODO C1.E14: How many threads are involved? Which? //

    }
}
