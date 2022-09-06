package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="Auto")
public class Auto extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    private DcMotor getMotor(String motorName) {
        return hardwareMap.get(DcMotor.class, motorName);
    }
}

// Stop the motors
private void motorStop() {
    frontleft.setpower(0);
    frontRight.setpower(0);
    backLeft.setpower(0);
    backRight.setpower(0);
}

// Move all motors forward
private void motorForward(double power) {
    frontleft.setpower(power);
    frontRight.setpower(power);
    backLeft.setpower(power);
    backRight.setpower(power);
}

// Move all motors backward
private void motorBackward(double power) {
    frontleft.setpower(-power);
    frontRight.setpower(-power);
    backLeft.setpower(-power);
    backRight.setpower(-power);
}

// Turn left by setting frontLeft and backLeft backward and frontRight and backRight to forward
private void motorTurnLeft(double power) {
    // * power by 0.8 to ensure slower turns
    frontleft.setpower(-power * 0.8);
    frontRight.setpower(power * 0.8);
    backLeft.setpower(-power * 0.8);
    backRight.setpower(power * 0.8);
}
// Turn right by setting frontleft and backleft forward and frontright and backright to backward
    private void motorTurnRight(double power) {
        // * power by 0.8 to ensure slower turns
        frontLeft.setPower(power * 0.8);
        frontRight.setPower(-power * 0.8);
        backLeft.setPower(power * 0.8);
        backRight.setPower(-power * 0.8);
    }

// Strafe left by setting frontleft and backright to backward and frontright and backleft to forward
    private void motorStrafeLeft(double power) {
        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(-power);
    }
// Strafe right by setting frontleft and backright to forward and frontright and backleft to backward
    private void motorStrafeRight(double power) {
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);
    }
    // This runs the instant you hit "INIT", most methods are still restricted until you hit Play
    @Override
    public void runOpMode() throws InterruptedException {
        // Wait until you hit Play on the Driver Hub
        waitForStart();

        // Define motors
        frontLeft = getMotor("FrontLeft");
        frontRight = getMotor("FrontRight");
        backLeft = getMotor("BackLeft");
        backRight = getMotor("BackRight");

        // Set power for all operations
        final double power = 0.35;

        // Ensure op mode is active in order to avoid breaking FTC rules
        if (opModeIsActive()) {
            // Execute path
            motorStop();
            motorForward(power);
            sleep(3000);
            motorStop();
            motorStrafeRight(power);
            sleep(3000);
            motorStop();
            motorBackward(power);
            sleep(3150);
            motorStop();
            motorTurnRight(power);
            sleep(3000);
            motorStop();
            motorStrafeRight(power);
            sleep(4000);
            motorStop();
        }
    }
}