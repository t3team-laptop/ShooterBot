// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private final Talon frontLeftMotor;
  private final Talon frontRightMotor;
  private final CANSparkMax backLeftMotor;
  private final CANSparkMax backRightMotor;
  MotorControllerGroup lefMotorGroup;
  MotorControllerGroup rightMotorGroup;
  private final DifferentialDrive differentialDrive;


  public DriveTrain() {
    frontLeftMotor = new TalonSRX(Constants.FRONT_LEFT_MOTOR);
    backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR, MotorType.kBrushless);
    lefMotorGroup = new MotorControllerGroup(frontLeftMotor, backLeftMotor);

    frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR, MotorType.kBrushless);
    rightMotorGroup = new MotorControllerGroup(frontRightMotor, backRightMotor);

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
