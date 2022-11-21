package org.rivierarobotics.vision;

import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.networktables.NetworkTable;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import org.photonvision.targeting.TargetCorner;

import java.util.List;

public class Vision extends PhotonCamera{
    //Variables
    public NetworkTable broadCastedTable;
    private String cameraNickname;

    public Vision(NetworkTable something, String cameraName)
    {
        super(cameraName);
        this.broadCastedTable = something;
        this.cameraNickname = cameraName;
    }

    PhotonCamera camera = new PhotonCamera("photonvision");

}