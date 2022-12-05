package frc.robot.subsystems.endEffector;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeHeightSubsystem extends SubsystemBase {

    private WPI_TalonSRX intakeHeightMotor;

    public IntakeHeightSubsystem() {
        intakeHeightMotor = new WPI_TalonSRX(5);
        intakeHeightMotor.setInverted(Constants.EndEffector.INTAKE_REVERSED);
        // Intake will not brake stop, it will coast to a stop
        intakeHeightMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void runIntakeHeight(double speed) {
        intakeHeightMotor.setNeutralMode(NeutralMode.Brake);
        intakeHeightMotor.set(speed*4);
    }

    public void runIntakeHeight() {
        intakeHeightMotor.setNeutralMode(NeutralMode.Brake);
        intakeHeightMotor.set(Constants.EndEffector.DEFAULT_INTAKE_SPEED);

    }

    public void reverseIntakeHeight(double speed) {
        intakeHeightMotor.setNeutralMode(NeutralMode.Brake);
        intakeHeightMotor.set(-speed*4);
    }

    /**
     * Stops the intake motor with coast mode
     */
    public void stopIntakeHeight() {
        intakeHeightMotor.setNeutralMode(NeutralMode.Brake);
        intakeHeightMotor.set(0);
    }
}

