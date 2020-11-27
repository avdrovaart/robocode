package avdr;

import robocode.Robot;
import robocode.*;
import robocode.util.Utils;

import java.awt.*;
import java.util.Random;

public class RandomDriveAndShoot extends Robot {
    private Random random = new Random();

    @Override
    public void run() {
        setAllColors(Color.CYAN);
        while (true) {
            ahead(50 + (random.nextDouble() * 500));
            double angle = Math.max(45.0, (random.nextDouble() * 180));
            angle = random.nextBoolean() ? angle : -angle;
            turnRight(angle);
        }
    }

    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        out.println("onScannedRobot");
        out.println("Distance: " + event.getDistance());
        if (getGunHeat() == 0) {
            if (Utils.isNear(event.getVelocity(), 0) || event.getDistance() < 200) {
                fire(3);
            }
        } else if (getGunHeat() < 0.2 && event.getDistance() > 200) {
            ahead(event.getDistance() - 150);
        }
    }

    @Override
    public void onHitWall(HitWallEvent event) {
        out.println("onHitWall");
        moveAway(event.getBearing());
    }

    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        out.println("onHitByBullet");
        turnRight(event.getBearing());
    }

    @Override
    public void onHitRobot(HitRobotEvent event) {
        out.println("onHitRobot");
        if (-5 < event.getBearing() && event.getBearing() < 5 && getGunHeat() == 0) {
            fire(3);
        } else if (getGunHeat() <= 0.2) {
            turnRight(event.getBearing());
            fire(3);
        } else if (event.getBearing() > -90 && event.getBearing() < 90) {
            moveAway(event.getBearing());
        }
    }

    private void moveAway(double bearing) {
        back(50);
        double angle = Math.max(90.0, (random.nextDouble() * 180));
        angle = bearing < 0 ? angle : -angle;
        turnRight(angle);
        ahead(50 + (random.nextDouble() * 500));
    }

}
