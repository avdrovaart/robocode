package avdr;

import robocode.Robot;
import robocode.*;
import robocode.util.Utils;

import java.awt.*;
import java.util.Random;

public class MyFirstBot extends Robot {

    @Override
    public void run() {
        setRadarColor(Color.CYAN);
        while (true) {
            while (getGunHeat() > 0) {
                turnRight(1);
            }
            fireBullet(0.1);
        }
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onScannedRobot(ScannedRobotEvent event) {
        out.println("onScannedRobot");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onHitWall(HitWallEvent event) {
        out.println("onHitWall");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        out.println("onHitByBullet");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onHitRobot(HitRobotEvent event) {
        out.println("onHitRobot");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onRobotDeath(RobotDeathEvent event) {
        out.println("onRobotDeath");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onBulletHit(BulletHitEvent event) {
        out.println("onBulletHit");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onBulletHitBullet(BulletHitBulletEvent event) {
        out.println("onBulletHitBullet");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onBulletMissed(BulletMissedEvent event) {
        out.println("onBulletMissed");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onDeath(DeathEvent event) {
        out.println("onDeath");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onWin(WinEvent event) {
        out.println("onWin");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onRoundEnded(RoundEndedEvent event) {
        out.println("onRoundEnded");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void onBattleEnded(BattleEndedEvent event) {
        out.println("onBattleEnded");
    }

    private double getGunBearing() {
        return Utils.normalRelativeAngleDegrees(getGunHeading() - getHeading());
    }

    private void aimGun(double bearing) {
        double rotate = Utils.normalRelativeAngleDegrees(getHeading() + bearing - getGunHeading());
        turnGunRight(rotate);
    }

    private void aimRadar(double bearing) {
        double rotate = Utils.normalRelativeAngleDegrees(getHeading() + bearing - getRadarHeading());
        turnRadarRight(rotate);
    }

}
