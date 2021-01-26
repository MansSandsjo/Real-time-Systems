public class StarvationNativeTest {
    public static void main(String[] args) {
        Thread t_low = new LowPrioThread();
        t_low.start();

        int nbrHIThreads = 1;
        for (int i = 0; i < nbrHIThreads; i++) {
            Thread t_high = new HighPrioThread();
            t_high.start();
        }
    }

    private static class LowPrioThread extends LinuxRTThread {
        public void run() {
            setPrio(7);
            System.out.println("Low priority thread started.");
            try {
                while (!Thread.interrupted()) {
                    System.out.println("Low priority thread executing");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                // Requested to stop
            }
            System.out.println("Thread stopped.");
        }
    }

    private static class HighPrioThread extends Thread {

        private double sum;

        public void run() {
            setPrio(8);
            System.out.println("High priority thread started.");
            while (!Thread.interrupted()) {
                sum = sum + Math.random();
            }
            System.out.println("Thread stopped.");
        }
    }
}
