//TODO C2.E5: Write your code here //

public class WrongWithSemaphore extends Thread {

    private volatile int ti = 0; 
    //TODO C2.E5: Write your code here //

    public void run() { 
        //TODO C2.E5: give and take semaphore //
        int e;
        int u;
        int loops = 0;

        setPriority(4);

        try {
            e = 10;
            while (!Thread.interrupted()) {
                if (ti != 0) {
                    u = e / ti; 
                } else {
                    u = 0;
                }
                loops++;
            }
        } catch (Exception ex) {
            System.out.println("Terminated after " + loops + " iterations with " + ex);
            System.exit(1);
        }
    }

    //TODO C2.E5: give and take semaphore //
    public void setTi(int ti) { 
        this.ti = ti;
    }

    public static void main(String[] args) {
        WrongWithSemaphore w1 = new WrongWithSemaphore();
        w1.start();
        int i = 0;
        try {
            while (!Thread.interrupted()) {
                w1.setTi(0); 
                Thread.sleep(1);
                w1.setTi(2);
                Thread.sleep(1);
                i++;
                if (i > 100) {
                    System.out.println("Main thread is alive");
                    i = 0;
                }
            }
        } catch (InterruptedException e) {
            // Requested to stop
        }
        System.out.println("Thread stopped.");
    }
}
