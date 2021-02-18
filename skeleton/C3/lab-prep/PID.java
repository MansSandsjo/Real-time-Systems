// PID class to be written by you
public class PID {
	// Current PID parameters
	private PIDParametersC4 p;

    private double I = 0; // Integral part of PID
    private double D = 0; // Derivative part of PID
    private double v = 0; // Computed control signal
    private double e = 0; // Error signal
    private double y = 0; // Measurement signal
    private double yOld = 0; // Old measurement signal
    private double ad; // Help variable for Derivative calculation
    private double bd; // Help variable for Derivative calculation
	
	// Constructor
	public PID(String name) {
		//TODO C3.E2: Write your code here //
				p = new PIDParametersC4();
				p.Beta = 1.0;
				p.H = 0.02;
				p.integratorOn = false;
				p.K = -0.01;
				p.Ti = 0.0;
				p.Tr = 10.0;
				p.N = 5;
				p.Td = 4;
				ad = p.Td/(p.Td+p.N*p.H);
				bd = p.K*ad*p.N;
				new PIDGUI(this, p, name);
				setParameters(p);
		    }
			
			// Calculates the control signal v.
			// Called from BnB Regul.
			public synchronized double calculateOutput(double yRef, double newY) {
				e = yRef-newY;
				D = ad*D - (newY - yOld)*bd;
				v = p.K * (p.Beta*yRef - newY) + I + D;
				yOld = newY;
				return v;
		    }
			
			// Updates the controller state.
			// Should use tracking-based anti-windup
			// Called from BeamRegul.
			public synchronized void updateState(double u) {
				//y=u;
				if(p.integratorOn) {
					I = I + (p.K * p.H / p.Ti) * e + (p.H / p.Tr) * (u - v);
					yOld = y;
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
			public synchronized void setParameters(PIDParametersC4 newParameters) {
		        //TODO C3.E2: Write your code here //
				p = (PIDParametersC4) newParameters.clone();
				if(!p.integratorOn) {
					I = 0.0;
				}
		    }
		}

