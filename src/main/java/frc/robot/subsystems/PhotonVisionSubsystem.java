package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PhotonVisionSubsystem extends SubsystemBase {
    
    private final PhotonCamera camera;

    public PhotonVisionSubsystem(){
        camera = new PhotonCamera("gloworm");

    }
    public PhotonPipelineResult getResult(){
        PhotonPipelineResult result = camera.getLatestResult();
        return result;

    }
    
}
