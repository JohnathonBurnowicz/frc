package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.drive.DiffDriveSubsystem;

import java.util.Set;

public class AutoDriveCommand implements Command {
    private final DiffDriveSubsystem diffDriveSubsystem;
    private final Set<Subsystem> subsystems;

    private double leftSpeed, rightSpeed;

    public AutoDriveCommand(DiffDriveSubsystem diffDriveSubsystem, double left, double right) {
        this.diffDriveSubsystem = diffDriveSubsystem;
        this.subsystems = Set.of(this.diffDriveSubsystem);

        this.leftSpeed = left;
        this.rightSpeed = right;
    }

    @Override
    public void initialize() {
        this.diffDriveSubsystem.tankDrive(0, 0);
    }

    @Override
    public void execute() {
        this.diffDriveSubsystem.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        this.diffDriveSubsystem.tankDrive(0, 0);
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return this.subsystems;
    }
}
