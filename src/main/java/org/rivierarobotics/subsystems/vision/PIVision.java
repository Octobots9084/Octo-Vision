package org.rivierarobotics.subsystems.vision;

import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.List;

public class PIVision extends SubsystemBase {
	public static boolean targetExists;
	public static double[] targetData; // This will hold yaw,pitch,area,and skew respectively in that order
	public static List corners;
	private PhotonCamera camera;
	private PhotonPipelineResult result;
	private PhotonTrackedTarget target;

	private static final double LL_ANGLE = 30; // deg
	private static final double ROBOT_HEIGHT = 1.092; // m;
	private static final double GOAL_HEIGHT = 2.6416; // m
	private static final double LL_OFFSET = 0.2286;
	private static final double TARGET_X = 8.22;
	private static final double TARGET_Y = 4.11;

	public PIVision() {
		camera = new PhotonCamera("Microsoft_LifeCam_HD_3000");
	}

	public boolean targetDetected() {
		return targetExists;
	}

	public double getTx() {
		return targetDetected() ? targetData[0] : 0;
	}

	public double getTy() {
		return targetDetected() ? targetData[1] : 0;
	}

	public double getDistance() {
		return PhotonUtils.calculateDistanceToTargetMeters(ROBOT_HEIGHT, GOAL_HEIGHT, Math.toRadians(LL_ANGLE),
				Math.toRadians(getTy()));
	}

	public double getAdjustedDistance(double dist, double tx) {
		return Math
				.sqrt(Math.pow(dist, 2) + Math.pow(LL_OFFSET, 2) - 2 * dist * LL_OFFSET * Math.cos(Math.toRadians(90 + tx)));
	}

	/** returns new T in Degrees. */
	public double getAdjustedTxAndCalc() {
		// Angle from limelight to goal, in degrees
		var tx = getTx();
		// Original distance, from limelight to goal
		var dist = getDistance();
		// Adjusted distance, from offset shooter to goal
		var adj = getAdjustedDistance(dist, tx);
		// Angle math to solve for offset side to new tx
		var txp = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(90.0 + tx)) / adj * dist)));
		// Final math and decision-making
		var cutoff = Math.asin(LL_OFFSET / dist);
		return tx > cutoff ? 90 - txp : txp - 90;
	}

	@Override
	public void periodic() {
		result = camera.getLatestResult();
		targetExists = result.hasTargets();
		target = result.getBestTarget();
		targetData = new double[] { target.getYaw(), target.getPitch(), target.getArea(), target.getSkew() };
		corners = target.getCorners();
	}

}
