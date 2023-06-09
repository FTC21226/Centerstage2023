package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="RobotTest: Mecanum Wheels", group="TeleOp")

public class MecanumWheels extends LinearOpMode {
        private DcMotor frontLeftDrive = null;
        private DcMotor frontRightDrive = null;
        private DcMotor backLeftDrive = null;
        private DcMotor backRightDrive = null;

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("blmotor"); //0
        DcMotor motorBackRight = hardwareMap.dcMotor.get("brmotor"); //1
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("flmotor"); //2
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("frmotor"); //3

        waitForStart();

        /*
        Update performed
        motorFrontRight.setPower(0.5);
         */

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x * 0.5;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);
        }
    }
}
