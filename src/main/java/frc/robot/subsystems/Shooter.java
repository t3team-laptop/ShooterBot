// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */

  private final TalonSRX leftMotor;
  private final TalonSRX rightMotor;
  private double output;

  public Shooter() {

    this.leftMotor = new TalonSRX(Constants.SHOOTER_LEFT_MOTOR);
    this.rightMotor = new TalonSRX(Constants.SHOOTER_RIGHT_MOTOR);

    rightMotor.follow(leftMotor);
    rightMotor.set(ControlMode.Follower, Constants.SHOOTER_LEFT_MOTOR);
    rightMotor.setInverted(true);
    leftMotor.setInverted(false);

    output = 0;

  }

  public void setOutput(double output){

    this.output = output;

  }

  public void shoot(){

    leftMotor.set(ControlMode.PercentOutput, output);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
