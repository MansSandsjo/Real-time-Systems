import javax.swing.*;

public class MainC4 {
	public static void main(String[] argv) {
		RegulC4 regul = new RegulC4();
		final OpComC4 opcom = new OpComC4(); //Must be declared final since it is used in an inner class
		
		regul.setOpCom(opcom);
		opcom.setRegul(regul);
		
		Runnable initializeGUI = new Runnable() {
		    public void run() {
		      opcom.initializeGUI();
		      opcom.start();
		    }
		};
		try {
		  SwingUtilities.invokeAndWait(initializeGUI);
		    } catch (Exception x) {
		  return;
		}
		regul.start();
	}
}
