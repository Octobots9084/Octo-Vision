package org.rivierarobotics.subsystems.drive;

public class DriveTrain {
    private final DriveSide left;
    private final DriveSide right;
    
    public DriveTrain(){
        left = new DriveSide(true);
        right = new DriveSide(false);
    }
    public void setPower (double l, double r){
        left.setPower(l);
        right.setPower(r);
    }
    
    public void setArcade(double x, double y){
        double left;
        double right;
        if (y >= 0.0) {
            left = y+x;
            right = y-x;
        } else {
            left = y-x;
            right = y+x;
        }
        setPower(left, right);
    }
}
