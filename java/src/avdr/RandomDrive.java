package avdr;

import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;

import java.awt.*;
import java.util.Random;

public class RandomDrive extends Robot {
    private Random random = new Random();

    @Override
    public void run() {
        setAllColors(Color.WHITE);
        while (true) {
            ahead(50 + (random.nextDouble() * 500));
            double angle = 45.0 + (random.nextDouble() * 135);
            angle = random.nextBoolean() ? angle : -angle;
            turnRight(angle);
        }
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        out.println("onHitWall");
        moveAway(event.getBearing());
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        out.println("onHitRobot");
        if (event.getBearing() > -90 && event.getBearing() < 90) {
            moveAway(event.getBearing());
        }
    }

    private void moveAway(double bearing) {
        back(50);
        double angle = 90.0 + (random.nextDouble() * 90);
        angle = bearing < 0 ? angle : -angle;
        turnRight(angle);
        ahead(50 + (random.nextDouble() * 500));
    }
}
