package avdr;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

import java.awt.*;

public class CirkelDriver extends AdvancedRobot {
    @Override
    public void run() {
        setAllColors(Color.PINK);
        while (true) {
            setTurnRight(360);
            setAhead(100);
            execute();
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        fire(3);
    }
}
