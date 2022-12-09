// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class Controls {
        public static final int DriverControllerPort = 1;
        public static final int OperatorControllerPort = 0;
    }

    public static final class Drive {

        /**
         * The CAN ID of the Left Front drive motor.
         */
        public static final int LF_MOTOR_ID = 1;
        public static final int LF_ENCODER_ID = 0; // TODO: Set this to the correct ID
        /**
         * The CAN ID of the Left Rear drive motor.
         */
        public static final int LR_MOTOR_ID = 2;
        public static final int LR_ENCODER_ID = 1; // TODO: Set this to the correct ID
        /**
         * The CAN ID of the Right Front drive motor.
         */
        public static final int RF_MOTOR_ID = 3;
        public static final int RF_ENCODER_ID = 2; // TODO: Set this to the correct ID
        /**
         * The CAN ID of the Right Rear drive motor.
         */
        public static final int RR_MOTOR_ID = 4;
        public static final int RR_ENCODER_ID = 3; // TODO: Set this to the correct ID

        public static final boolean LEFT_DRIVE_INVERTED = false;
        public static final boolean LEFT_ENCODER_INVERTED = false;

        public static final boolean RIGHT_DRIVE_INVERTED = true;
        public static final boolean RIGHT_ENCODER_INVERTED = true;

        public static final double LOW_SPEED_SCALE_FACTOR = 1;

        public static final long JERK_TIME = 55; // milliseconds

        public enum DifferentialControlScheme {
            ARCADE,
            TANK
        }
    }

    public static final class Climb {
        public static final int CLIMB_MOTOR_PORT = 0; // TODO: Change to correct port

        public static final boolean CLIMB_MOTOR_INVERTED = false;

        public static final double CLIMB_MOTOR_SPEED = .9;
    }

    public static final class EndEffector {
        public static final int INTAKE_MOTOR_PORT = 1; // TODO: Change to correct port
        public static final int RIGHT_SHOOTER_MOTOR_PORT = 13; // TODO: Change to correct port
        public static final int LEFT_SHOOTER_MOTOR_PORT = 15; // TODO: Change to correct port
     
        public static final int RS_MOTOR_ID = 7;   //right shooter motor ID
        public static final int LS_MOTOR_ID = 11;  //left shooter motor ID
     
        public static final double DEFAULT_INTAKE_SPEED = 0.4;
        public static final double DEFAULT_INTAKE_REVERSE_SPEED = -0.4;


        public static final boolean INTAKE_REVERSED = true;

        public static final double DEFAULT_SHOOTER_SPEED = 1.0;
        public static final double DEFAULT_SHOOTER_SLOW_SPEED = 0.2;

        public static final boolean SHOOTER_REVERSED = false;
    }
}