package org.firstinspires.ftc.teamcode.Salsa.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Salsa.Hardware.Motor;
import org.firstinspires.ftc.teamcode.Salsa.Hardware.Robot;
import org.firstinspires.ftc.teamcode.Salsa.Robots.Asteroid;

/**
 * Created by adityamavalankar on 11/15/18.
 */

@TeleOp(name = "Test Actuator")
public class TestActuator extends OpMode {

    Asteroid robot;
    Motor actuator;

    @Override
    public void init() {

        robot.initDrivetrain(hardwareMap);
        actuator.init("actuator", hardwareMap);

    }

    @Override
    public void loop() {

        robot.drive();
        actuatorMove();

    }

    public void actuatorMove() {
        if(gamepad1.dpad_up) {
            actuator.setPower(1);
        }

        else if(gamepad1.dpad_down) {
            actuator.setPower(-1);
        }
        else {
            actuator.setPower(0);
        }
    }
}
