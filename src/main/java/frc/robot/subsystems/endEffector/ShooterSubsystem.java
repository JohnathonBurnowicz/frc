package frc.robot.subsystems.endEffector;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    private CANSparkMax shooterMotor;

    public ShooterSubsystem() {
        shooterMotor = new CANSparkMax(Constants.EndEffector.SHOOTER_MOTOR_PORT,MotorType.kBrushless);
        shooterMotor.setInverted(Constants.EndEffector.SHOOTER_REVERSED);
        //shooterMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void runShooter() {
        shooterMotor.set(Constants.EndEffector.DEFAULT_SHOOTER_SPEED);
    }

    /**
     * Run Shooter at full speed
     */
    public void runShooter(double speed) {
        shooterMotor.set(speed);
    }

    public void runSlowShooter() {
        shooterMotor.set(Constants.EndEffector.DEFAULT_SHOOTER_SLOW_SPEED);
    }

    public void reverseShooter() {
        shooterMotor.set(-Constants.EndEffector.DEFAULT_SHOOTER_SLOW_SPEED);
    }

    /**
     * Stops the shooter motor with brake mode
     */
    public void stopShooter() {
        //shooterMotor.setNeutralMode(NeutralMode.Brake);
        shooterMotor.set(0);
        //shooterMotor.setNeutralMode(NeutralMode.Coast);
    }
}

