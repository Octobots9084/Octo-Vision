/*
 * This file is part of GradleRIO-Redux-example, licensed under the GNU General Public License (GPLv3).
 *
 * Copyright (c) Octobots <https://github.com/Octobots9084>
 * Copyright (c) contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.octobots.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.octobots.subsystems.drive.DriveTrain;
import org.octobots.subsystems.vision.PIVision;

public class Robot extends TimedRobot {
	PIVision vision = new PIVision();
	
	private DriveTrain driveTrain;
	private Joystick joystick1;
	private Joystick joystick2;
	
	@Override
	public void robotInit() {
		super.robotInit();
		
		driveTrain = new DriveTrain();
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		
		SmartDashboard.putBoolean("Target Detected", vision.targetDetected());
		SmartDashboard.putNumber("Target X", vision.getTx());
		SmartDashboard.putNumber("Target Y", vision.getTy());
		SmartDashboard.putNumber("Distance", vision.getDistance());
		SmartDashboard.putNumber("Target in Degrees", vision.getAdjustedTxAndCalc());
	}
	
	@Override
	public void teleopPeriodic(){
        if (joystick1.getRawButton(1)){
//	        setArcade(vision.getTx(), vision.getTy());
	        setArcade(28, 2);
	
        }
		/*else {
            driveTrain.setPower(0.0, 0.0)
        }*/
		double x1 = joystick1.getX();
		double y2 = joystick2.getY();
		//DriveTrain.setPower(x1, y2);
		setArcade(x1, y2);
		
		SmartDashboard.putBoolean("Target Detected", vision.targetDetected());
		SmartDashboard.putNumber("Target X", vision.getTx());
		SmartDashboard.putNumber("Target Y", vision.getTy());
		SmartDashboard.putNumber("Distance", vision.getDistance());
		SmartDashboard.putNumber("Target in Degrees", vision.getAdjustedTxAndCalc());
	}
	private void setArcade(double rotate, double power){
		double max = Math.max(Math.abs(rotate), Math.abs(power));
		double diff = power - rotate;
		double sum = power + rotate;
		double left;
		double right;
		if (power > 0){
			if (rotate > 0){
				left = max;
				right = diff;
			} else {
				left = sum;
				right = max;
			}
		} else {
			if (rotate > 0){
				left = sum;
				right = -max;
			} else {
				left = -max;
				right = diff;
			}
		}
		driveTrain.setPower(left, right);
	}
}
