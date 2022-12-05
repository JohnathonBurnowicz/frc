package frc.robot.commands;

import java.io.Console;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Helpers;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drive.DiffDriveSubsystem;
public class DriveCommand extends CommandBase {
    private final DiffDriveSubsystem diffDriveSubsystem;

    public DriveCommand(DiffDriveSubsystem diffDriveSubsystem) {
        this.diffDriveSubsystem = diffDriveSubsystem;
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(this.diffDriveSubsystem);

    }

    @Override
    public void initialize() {
        diffDriveSubsystem.setNeutralMode(NeutralMode.Brake);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        RobotContainer robot = RobotContainer.getInstance();
        double fwdRaw = Helpers.setDeadZone(robot.getDriverJoystick().getLeftY(), 0.03 ), turnRaw = Helpers.setDeadZone(robot.getDriverJoystick().getRightX(),0.03);
        double fwd = robot.getDriverJoystick().getLeftBumperPressed() ? fwdRaw * Constants.Drive.LOW_SPEED_SCALE_FACTOR : fwdRaw;
        double turn = robot.getDriverJoystick().getLeftBumperPressed() ? turnRaw * Constants.Drive.LOW_SPEED_SCALE_FACTOR : turnRaw;
        if (robot.getDriverJoystick().getLeftBumper()){
            fwd*=0.5;
            turn*=0.5;
        }
        System.out.print(fwd);
        diffDriveSubsystem.arcadeDrive(fwd, -turn);
        // System.out.println("Slow: " + robot.getDriverJoystick().getLeftBumperPressed());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        diffDriveSubsystem.drive(0.0, 0.0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
