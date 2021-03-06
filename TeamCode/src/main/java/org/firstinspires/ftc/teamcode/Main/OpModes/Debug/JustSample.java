package org.firstinspires.ftc.teamcode.Main.OpModes.Debug;

import com.disnodeteam.dogecv.detectors.roverrukus.SamplingOrderDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Main.OpModes.ExtendedLinearOpMode;
import org.firstinspires.ftc.teamcode.Main.Vision.CameraCropAngle;

@Autonomous(name = "Just Sample")
public class JustSample extends ExtendedLinearOpMode {

    @Override
    public void runOpMode() {

        // initiate
        setHardwareMap(hardwareMap);
        robot.setHardwareMap(hardwareMap);
        robot.initDrivetrain();
        robot.initColorSensors();
        robot.liftSlides = hardwareMap.dcMotor.get(constants.LIFT_SLIDES_NAME);
        robot.initVision(CameraCropAngle.LEFT);
        robot.enableVision();
        // Telemetry confirms successful initialization. It's delayed to let everything load
        sleep(3000);
        telemetry.addLine("Initialization done ... Ready to start!");
        telemetry.update();

        waitForStart();
        resetEncoderAngle();

        //save sampling order of minerals to this variable
        SamplingOrderDetector.GoldLocation goldLocation = robot.getSamplingOrder();
        sleep(400);

        telemetry.addData("Current Orientation is", robot.getSamplingOrder());
        telemetry.update();

        switch (robot.getSamplingOrder()) {

            case LEFT:

                telemetry.addLine("LEFT GOLD.");
                telemetry.update();
                encoderTurn(0.5, -90);
                encoderDriveIN(20, 20, 0.5, 5);
                break;

            case CENTER:

                telemetry.addLine("CENTER GOLD.");
                telemetry.update();
                encoderDriveIN(4, 4, 0.5, 5);
                encoderTurn(0.5, -90);
                encoderDriveIN(20, 20, 0.5, 5);
                break;

            case RIGHT:

                telemetry.addLine("RIGHT GOLD");
                telemetry.update();
                encoderDriveIN(11, 11, 0.5, 5);
                encoderTurn(0.5, -90);
                encoderDriveIN(20, 20, 0.5, 5);
                break;

            case UNKNOWN:

                telemetry.addLine("Hah too bad for you, the robot can't find ANYTHING.");
                telemetry.update();
                encoderDriveIN(4, 4, 0.5, 5);
                encoderTurn(0.5, -90);
                encoderDriveIN(20, 20, 0.5, 5);
                break;

        }

        robot.disableVision();

        encoderDriveINNew(-12, -12, 0.25, 4);

        encoderTurn(0.25, -180);
    }
}
