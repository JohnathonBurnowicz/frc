package frc.robot.subsystems.climber;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {
    private final WPI_TalonSRX climbMotor;

    public ClimberSubsystem() {
        climbMotor = new WPI_TalonSRX(Constants.Climb.CLIMB_MOTOR_PORT);
        climbMotor.setInverted(Constants.Climb.CLIMB_MOTOR_INVERTED);
        climbMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void climbUp() {
        climbMotor.set(Constants.Climb.CLIMB_MOTOR_SPEED);
    }

    public void climbDown() {
        climbMotor.set(-Constants.Climb.CLIMB_MOTOR_SPEED);
    }

    public void stopClimb() {
        climbMotor.set(0);
    }
}

