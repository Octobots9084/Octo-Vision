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

package org.octobots.subsystems.drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class DriveSide {
    private final WPI_TalonSRX motor1;
    private final CANSparkMax motor2;
    
    private final CANSparkMax motor3;

    
    public DriveSide (boolean invert){
        if (invert){
            motor1 = new WPI_TalonSRX(1);
            motor2 = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
            motor3 = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
        } else {
            motor1 = new WPI_TalonSRX(3);
            motor2 = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
            motor3 = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);
            
            motor1.setInverted(true);
            motor2.setInverted(true);
            motor3.setInverted(true);
        }
    }

    public void setPower(double pow){
        motor1.set(pow);
        motor2.set(pow);
        motor3.set(pow);
    }
}