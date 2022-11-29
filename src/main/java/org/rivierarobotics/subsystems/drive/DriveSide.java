package org.rivierarobotics.subsystems.drive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSide {
    private final WPI_TalonSRX motor1;
    private final WPI_TalonSRX motor2;

    public DriveSide (boolean invert){
        if (invert){
            motor1 = new WPI_TalonSRX(1);
            motor2 = new WPI_TalonSRX(2);
        } else {
            motor1 = new WPI_TalonSRX(3);
            motor2 = new WPI_TalonSRX(4);
            motor1.setInverted(true);
            motor2.setInverted(true);
        }
    }

    public void setPower(double pow){
        motor1.set(pow);
        motor2.set(pow);
    }
}