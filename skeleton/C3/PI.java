// PI class to be written by you
public class PI {
	// Current PI parameters
	private PIParametersC4 p;

    private double I = 0; // Integral part of controller
    private double e = 0; // Error signal
    private double v = 0; // Output from controller
	
	// Constructor
	public PI(String name) {
        //TODO C3.E2: Write your code here //
		PIParametersC4 p = new PIParametersC4();
		p.Beta = 1.0;
		p.H = 0.02;
		p.integratorOn = false;
		p.K = 10.0; ///////////////7
		p.Ti = 0;
		p.Tr = 10.0;
		new PIGUI(this, p, name);
		setParameters(p);
		
    }
	
	// Calculates the control signal v.
	// Called from BeamRegul.
	public synchronized double calculateOutput(double y, double yref) {
		e = yref-y;
		v = p.K * (p.Beta*yref - y) + I;
		return v;
    }
	
	// Updates the controller state.
	// Should use tracking-based anti-windup
	// Called from BeamRegul.
	public synchronized void updateState(double u) {
		if(p.integratorOn) {
			I = I + (p.K * p.H / p.Ti) * e + (p.H / p.Tr) * (u - v);
		}
		else
			I = 0.0;
	}
	
	// Returns the sampling interval expressed as a long.
	// Note: Explicit type casting needed
	public synchronized long getHMillis() {
        //TODO C3.E2: Write your code here //
		long hmillis = (long)(p.H*1000.0);
        return hmillis;
    }
	
	// Sets the PIParameters.
	// Called from PIGUI.
	// Must clone newParameters.
	public synchronized void setParameters(PIParametersC4 newParameters) {
        //TODO C3.E2: Write your code here //
		p = (PIParametersC4) newParameters.clone();
		if(!p.integratorOn) {
			I = 0.0;
		}
    }
}
