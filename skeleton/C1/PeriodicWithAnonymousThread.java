/*
 *  class PeriodicWithAnonymousThread extends Base:
 *
 * Periodic thread class utilizing an anonymous thread.
 */
public class PeriodicWithAnonymousThread extends Base {

    private int period;
    private Thread t; // Store a thread object
    
    /*
     * Constructor for the class PeriodicWithAnonymousThread
     *
     * @param:
     *     period (int): The period of the periodic thread
     */
    public PeriodicWithAnonymousThread(int period) {
        this.period = period;

        // Create Anonymous class
        // Everything inside this block is part of the new anonymous thread class
        t = new Thread() {
            /*
             * Method run:
             *
             * Anonymous thread class run method
             */
            public void run() {
                try {
                    while (!Thread.interrupted()) {
                        Thread.sleep(period);
                        System.out.print(period + ", ");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /*
     * Method start:
     */
    public void start() {
        t.start(); // Start the anonymous thread.
    }

    public static void main(String[] args) {
        for (String arg : args) {
            new PeriodicWithAnonymousThread(Integer.parseInt(arg)).start();
        }
    }
}
