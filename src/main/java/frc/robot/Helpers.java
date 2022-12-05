package frc.robot;

public class Helpers {

    /**
     * Set deadzone for axis values
     * @param value value from joystick
     * @param deadzone deadzone for value
     * @return value of joystick after applying deadzone
     */
    public static double setDeadZone(double value, double deadzone) {
        // If motor is below the deadzone, don't run any motors
        if (Math.abs(value) < deadzone) {
            return 0;
        }
        return value;
    }
}
