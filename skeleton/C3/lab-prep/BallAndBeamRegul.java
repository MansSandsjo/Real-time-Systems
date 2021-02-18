
import SimEnvironment.*;
// BeamRegul class to be written by you
public class BallAndBeamRegul extends Thread {

	private ReferenceGenerator refGen;
	private PI pi;
    private PID pid;

	private final double UMIN = -10, UMAX = 10;

	// IO interface declarations
	private AnalogSource analogInAngle;
    private AnalogSource analogInPosition;
	private AnalogSink analogOut;
	private AnalogSink analogRef;
	private double u_pid;
	
	public BallAndBeamRegul(ReferenceGenerator refgen, BallAndBeam bb, int priority) {
		// Code to initialize the IO
		this.refGen = refgen;
		pi = new PI("PI");
		pid = new PID("PID");
		analogInPosition = bb.getSource(0);
		analogInAngle = bb.getSource(1);
		analogOut = bb.getSink(0);
		analogRef = bb.getSink(1);
		setPriority(priority);
		u_pid = 0;
		// TODO C3.E3: Write your code here //
	}

	/**
	 * Method limit:
	 *
	 * @param: u (double): The signal to saturate
	 * @return: double: the saturated value
	 */
	private double limit(double u) {
		if (u < UMIN)
			return UMIN;
		else if (u > UMAX)
			return UMAX;
		else
			return u;
	}

	public void run() {
		long t = System.currentTimeMillis();
		while (true) {
			// TODO C3.E3: Write your code here and help variables here //
			double newY = analogInPosition.get();
			double ydeg = analogInAngle.get();
			double ref = refGen.getRef();

			synchronized (pid) {
				// compute control signal
				//pid.calculateOutput(Yref, yNew);
				u_pid = limit(pid.calculateOutput(ref, newY));
				// set output
				//analogOut.set(u);
				//pid.updateState(u);
				//analogOut.set(u_pid);
				
			}
			
			synchronized (pi) {
				// compute control signal
				// pid ska skicka in sitt värde till pi
				//pi.calculateOutput(y, yref);
				double u = limit(pi.calculateOutput(ydeg, u_pid));
				//System.out.println("y degrees " + ydeg + " u_pid " + u_pid + " u limit " + u );
				// set output
				analogOut.set(u);
				pi.updateState(u);
				
			}
			
			// plotter animation
			analogRef.set(ref);

			// TODO C3.E3: Write your code here //
			t = t + pi.getHMillis();
			long duration = t - System.currentTimeMillis();
			if (duration > 0) {
				try {
					
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		// TODO C3.E3: Write code to make run method periodic here //
	}
}
