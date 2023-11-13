// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private final TalonSRX frontLeftMotor;
  private final TalonSRX frontRightMotor;
  private final TalonSRX backLeftMotor;
  private final TalonSRX backRightMotor;

  MotorControllerGroup lefMotorGroup;
  MotorControllerGroup rightMotorGroup;

  private final DifferentialDrive differentialDrive;


  public DriveTrain() {
    frontLeftMotor = new TalonSRX(Constants.FRONT_LEFT_MOTOR);
    backLeftMotor = new TalonSRX(Constants.BACK_LEFT_MOTOR);
    lefMotorGroup = new MotorControllerGroup( (MotorController) frontLeftMotor, (MotorController) backLeftMotor);

    frontRightMotor = new TalonSRX(Constants.FRONT_RIGHT_MOTOR);
    backRightMotor = new TalonSRX(Constants.BACK_RIGHT_MOTOR);
    rightMotorGroup = new MotorControllerGroup( (MotorController)frontRightMotor, (MotorController) backRightMotor);

    differentialDrive = new DifferentialDrive(lefMotorGroup, rightMotorGroup);

  }

  public void arcadeDrive(double xSpeed, double zRotation)
    {
        differentialDrive.arcadeDrive(xSpeed, zRotation);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
