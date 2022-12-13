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
