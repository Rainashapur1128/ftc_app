package org.firstinspires.ftc.teamcode.Main.OpModes.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Main.OpModes.ExtendedLinearOpMode;

@Autonomous(name = "Test Encoder Drive")
public class testEncoderDrive extends ExtendedLinearOpMode {

    @Override
    public void runOpMode() {

        setHardwareMap(hardwareMap);
        robot.setHardwareMap(hardwareMap);
        robot.initDrivetrain();
        robot.initColorSensors();
        robot.liftSlides = hardwareMap.dcMotor.get(constants.LIFT_SLIDES_NAME);
        robot.initVision();
        robot.enableVision();
        // Telemetry confirms successful initialization
        telemetry.addLine("Initialization done ... Ready to start!");
        telemetry.update();

        waitForStart();
        resetEncoderAngle();

        encoderDriveINdividual(robot.leftBack, 5, 0.6, 4);
        sleep(10000);
        encoderDriveINdividual(robot.leftFront, 5, 0.6, 4);
        sleep(10000);
        encoderDriveINdividual(robot.rightBack, 5, 0.6, 4);
        sleep(10000);
        encoderDriveINdividual(robot.rightFront, 5, 0.6, 4);
        sleep(500);

        // encoderDriveIN(5, 5, 1, 10);
    }

}
