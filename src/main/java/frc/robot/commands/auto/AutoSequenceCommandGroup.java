package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.drive.DiffDriveSubsystem;
import frc.robot.subsystems.endEffector.IntakeSubsystem;
import frc.robot.subsystems.endEffector.ShooterSubsystem;

public class AutoSequenceCommandGroup extends SequentialCommandGroup {
    public AutoSequenceCommandGroup(DiffDriveSubsystem drive, IntakeSubsystem intake, ShooterSubsystem shooter) {
        // TODO: Add command to drop intake when thats a thing
        super(
                new StartAllIntakeCommand(intake, shooter),
                new AutoDriveCommand(drive, 0.5, 0.5).withTimeout(5),
                new StopAllIntakeCommand(intake, shooter)
        );

    }
}