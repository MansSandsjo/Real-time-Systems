public class Main {
    public static void main(String[] args) {
        final int regulPriority   = 8;
        final int buttonsPriority = 7;
        final int squarePriority  = 6;
        final int opcomPriority   = 5;

        Box box = new Box();

        FirstOrderProcess simulatedProcess = new FirstOrderProcess();

        RegulC4 regul = new RegulC4(regulPriority, box, simulatedProcess);
        OpComC4 opcom = new OpComC4(regul, opcomPriority);
        //GUIOpCom opcom = new GUIOpCom(regul, opcomPriority);
        SquareWave squarewave = new SquareWave(regul, squarePriority);
        Buttons buttons = new Buttons(regul, squarewave, buttonsPriority, box);

        regul.start();
        opcom.start();
        squarewave.start();
        buttons.start();
    }
}
