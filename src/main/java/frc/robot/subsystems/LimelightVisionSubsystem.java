package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightVisionSubsystem extends SubsystemBase {
    
    private final PhotonCamera camera;

    public LimelightVisionSubsystem()
    {
        camera = new PhotonCamera("gloworm");
        {NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);

        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);}

    }
    public PhotonPipelineResult getResult(){
        PhotonPipelineResult result = camera.getLatestResult();
        return result;
       
     }
     { 
      /* NetworkTable table = NetworkTable.getTable("limelight");
     double targetOffsetAngle_Horizontal = table.getNumber("tx", 0);
     double targetOffsetAngle_Vertical = table.getNumber("ty", 0);
     double targetArea = table.getNumber("ta", 0);
     double targetSkew = table.getNumber("ts", 0);*/
    }
    
}
