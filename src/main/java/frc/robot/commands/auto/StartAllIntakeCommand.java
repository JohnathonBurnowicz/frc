package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.endEffector.IntakeSubsystem;
import frc.robot.subsystems.endEffector.ShooterSubsystem;

import java.util.Set;

public class StartAllIntakeCommand implements Command {
    private final IntakeSubsystem intakeSubsystem;
    private final ShooterSubsystem shooterSubsystem;
    private final Set<Subsystem> subsystems;

    private boolean isFinished = false;

    public StartAllIntakeCommand(IntakeSubsystem intakeSubsystem, ShooterSubsystem shooterSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.shooterSubsystem = shooterSubsystem;
        this.subsystems = Set.of(this.intakeSubsystem, this.shooterSubsystem);
    }


    @Override
    public void execute() {
        intakeSubsystem.runIntake();
        shooterSubsystem.runSlowShooter();
        isFinished = true;
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return isFinished;
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return this.subsystems;
    }
}
