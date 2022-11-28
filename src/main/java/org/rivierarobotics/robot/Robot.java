/*
 * This file is part of GradleRIO-Redux-example, licensed under the GNU General Public License (GPLv3).
 *
 * Copyright (c) Riviera Robotics <https://github.com/Team5818>
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

package org.rivierarobotics.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.rivierarobotics.subsystems.vision.PIVision;

public class Robot extends TimedRobot {
	PIVision vision = new PIVision();
	
	@Override
	public void robotInit() {
		super.robotInit();
		
		SmartDashboard.putBoolean("Target Detected", vision.targetDetected());
		SmartDashboard.putNumber("Target X", vision.getTx());
		SmartDashboard.putNumber("Target Y", vision.getTy());
		SmartDashboard.putNumber("Distance", vision.getDistance());
		SmartDashboard.putNumber("Target in Degrees", vision.getAdjustedTxAndCalc());
	}
}
