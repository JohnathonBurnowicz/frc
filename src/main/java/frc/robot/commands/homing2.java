package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.PhotonVisionSubsystem;
import frc.robot.Constants;
import frc.robot.subsystems.drive.DiffDriveSubsystem;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import org.photonvision.*;
import org.photonvision.targeting.PhotonTrackedTarget;

import java.util.Set;

public class homing2 implements Command {
    private final DiffDriveSubsystem diffDriveSubsystem;
    private final PhotonVisionSubsystem photonVisionSubsystem;
    private final Set<Subsystem> subsystems;


    public homing2(DiffDriveSubsystem diffDriveSubsystem, PhotonVisionSubsystem photonVisionSubsystem) {
        this.diffDriveSubsystem = diffDriveSubsystem;
        this.photonVisionSubsystem = photonVisionSubsystem;
        this.subsystems = Set.of(this.diffDriveSubsystem,photonVisionSubsystem);
    }

    /**
     * The initial subroutine of a command.  Called once when the command is initially scheduled.
     */
    @Override
    public void initialize() {
        Shuffleboard.getTab("PID").add("D", 1).withWidget(BuiltInWidgets.kNumberSlider); // specify the widget here.getEntry();
    }

    /**
     * The main body of a command.  Called repeatedly while the command is scheduled.
     * (That is, it is called repeatedly until {@link #isFinished()}) returns true.)
     */
    double aP = 0.03;
    double aI = 0.05;
    double aD = 0;
    PIDController anglePID = new PIDController(aP, aI, aD);

    double dP = 0;
    double dI = 0;
    double dD = 0;
    PIDController distancePID = new PIDController(dP, dI, dD);


    /*
    double P=0.05;
    double I =0.03;
    double D = 0;

    double integral, prev_error, setpoint =0;
    double error =0;
    double derivative =0;
    double rcw =0;
    */
    @Override
    public void execute() {

        var result = photonVisionSubsystem.getResult();
        if (result.hasTargets()){
            PhotonTrackedTarget target = result.getBestTarget();
            double distance = PhotonUtils.calculateDistanceToTargetMeters(0.7,0.8,0,result.getBestTarget().getPitch()*0.01745329);

            /*error = setpoint - target.getYaw();
            integral +=(error*0.02);
            derivative = (error-prev_error)/0.02;
            rcw = P*error + I*integral + D*derivative;
            */
            diffDriveSubsystem.arcadeDrive(distancePID.calculate(distance,2), anglePID.calculate(target.getYaw(),0));
            //prev_error=error;
        }
    }

    /**
     * <p>
     * Returns whether this command has finished. Once a command finishes -- indicated by
     * this method returning true -- the scheduler will call its {@link #end(boolean)} method.
     * </p><p>
     * Returning false will result in the command never ending automatically. It may still be
     * cancelled manually or interrupted by another command. Hard coding this command to always
     * return true will result in the command executing once and finishing immediately. It is
     * recommended to use * {@link edu.wpi.first.wpilibj2.command.InstantCommand InstantCommand}
     * for such an operation.
     * </p>
     *
     * @return whether this command has finished.
     */
    @Override
    public boolean isFinished() {
        return false;
    }

    /**
     * The action to take when the command ends. Called when either the command
     * finishes normally -- that is it is called when {@link #isFinished()} returns
     * true -- or when  it is interrupted/canceled. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the command.
     *
     * @param interrupted whether the command was interrupted/canceled
     */
    @Override
    public void end(boolean interrupted) {
        diffDriveSubsystem.brakeStop();
    }

    /**
     * <p>
     * Specifies the set of subsystems used by this command.  Two commands cannot use the same
     * subsystem at the same time.  If the command is scheduled as interruptible and another
     * command is scheduled that shares a requirement, the command will be interrupted.  Else,
     * the command will not be scheduled. If no subsystems are required, return an empty set.
     * </p><p>
     * Note: it is recommended that user implementations contain the requirements as a field,
     * and return that field here, rather than allocating a new set every time this is called.
     * </p>
     *
     * @return the set of subsystems that are required
     */
    @Override
    public Set<Subsystem> getRequirements() {
        return this.subsystems;
    }
}
