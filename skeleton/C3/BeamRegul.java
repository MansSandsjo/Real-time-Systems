import SimEnvironment.*;

// BeamRegul class to be written by you
public class BeamRegul extends Thread {

	private ReferenceGenerator refGen;
	private PI controller;

	private final double UMIN = -10, UMAX = 10;

	// IO interface declarations
	private AnalogSource analogIn;
	private AnalogSink analogOut;
	private AnalogSink analogRef;

	public BeamRegul(ReferenceGenerator refgen, Beam beam, int priority) {
		// Code to initialize the IO
		this.refGen = refgen;
		controller = new PI("PI");
		analogIn = beam.getSource(0);
		analogOut = beam.getSink(0);
		analogRef = beam.getSink(1);
		setPriority(priority);
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
			double y = analogIn.get();
			double ref = refGen.getRef();

			synchronized (controller) {
				// compute control signal
				double u = limit(controller.calculateOutput(y, ref));
				// set output
				analogOut.set(u);

				controller.updateState(u);
			}
			// plotter animation
			analogRef.set(ref);

			// TODO C3.E3: Write your code here //
			t = t + controller.getHMillis();
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
