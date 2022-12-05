package frc.robot.subsystems.drive;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
public class DiffDriveSubsystem extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    public Constants.Drive.DifferentialControlScheme differentialControlScheme = Constants.Drive.DifferentialControlScheme.TANK;
    private final MotorControllerGroup left;
    private final WPI_TalonSRX left1;
    private final WPI_TalonSRX left2;
    private final MotorControllerGroup right;
    private final WPI_VictorSPX right1;
    private final WPI_VictorSPX right2;
    private final DifferentialDrive drive;

    private NeutralMode neutralMode = NeutralMode.Coast;

    public DiffDriveSubsystem() {
        left1 = new WPI_TalonSRX(Constants.Drive.LF_MOTOR_ID);
        left1.setNeutralMode(neutralMode);
        left2 = new WPI_TalonSRX(Constants.Drive.LR_MOTOR_ID);
        left2.setNeutralMode(neutralMode);
        left = new MotorControllerGroup(left1, left2);

        addChild("motorGroup_left", left);

        right1 = new WPI_VictorSPX(Constants.Drive.RF_MOTOR_ID);
        right1.setNeutralMode(neutralMode);
        right2 = new WPI_VictorSPX(Constants.Drive.RR_MOTOR_ID);
        right2.setNeutralMode(neutralMode);
        right = new MotorControllerGroup(right1, right2);
        addChild("motorGroup_right", right);

        // Properly invert motors
        left.setInverted(Constants.Drive.LEFT_DRIVE_INVERTED);
        right.setInverted(Constants.Drive.RIGHT_DRIVE_INVERTED);

        // Instantiate the drive class
        drive = new DifferentialDrive(left, right);
    }

    @Override
    public void setDefaultCommand(Command defaultCommand) {
        super.setDefaultCommand(defaultCommand);
    }

    public void drive(double left, double right) {
        if (differentialControlScheme == Constants.Drive.DifferentialControlScheme.TANK) {
            tankDrive(left, right);
        } else if (differentialControlScheme == Constants.Drive.DifferentialControlScheme.ARCADE) {
            arcadeDrive(left, right);
        }
    }

    public void arcadeDrive(double fwd, double turn) {
        drive.arcadeDrive(fwd, turn);

    }

    public void tankDrive(double left, double right) {
        drive.tankDrive(left, right);

    }

    private void updateNeutralMode() {
        left1.setNeutralMode(neutralMode);
        left2.setNeutralMode(neutralMode);
        right1.setNeutralMode(neutralMode);
        right2.setNeutralMode(neutralMode);
    }

    public void setNeutralMode(NeutralMode neutralMode) {
        this.neutralMode = neutralMode;
        updateNeutralMode();
    }

    public NeutralMode getNeutralMode() {
        return neutralMode;
    }

    public void brakeStop() {
        NeutralMode previousNeutralMode = getNeutralMode();
        setNeutralMode(NeutralMode.Brake);
        drive(0, 0);
        setNeutralMode(previousNeutralMode);
    }

}

