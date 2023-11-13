// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  
  private final TalonSRX LeftMotor_1;
  private final TalonSRX LeftMotor_2;
  private final TalonSRX RightMotor_1;
  private final TalonSRX RightMotor_2;

  private final int upperBound = 100;
  private final int lowerBound = -100;
  
  public Arm() {

    LeftMotor_1 = new TalonSRX(Constants.ARM_LEFT_MOTOR1);
    LeftMotor_2 = new TalonSRX(Constants.ARM_LEFT_MOTOR2);

    RightMotor_1 = new TalonSRX(Constants.ARM_RIGHT_MOTOR1);
    RightMotor_2 = new TalonSRX(Constants.ARM_RIGHT_MOTOR2);

    LeftMotor_2.set(ControlMode.Follower, Constants.ARM_LEFT_MOTOR1);
    RightMotor_2.set(ControlMode.Follower, Constants.ARM_RIGHT_MOTOR1);

    RightMotor_1.set(ControlMode.Follower, Constants.ARM_LEFT_MOTOR1);

    RightMotor_1.setInverted(true);
    LeftMotor_1.setInverted(false); 

    LeftMotor_1.setSelectedSensorPosition(0);

    LeftMotor_1.configForwardSoftLimitThreshold(upperBound); 
    LeftMotor_1.configReverseSoftLimitThreshold(lowerBound);

    LeftMotor_1.configForwardSoftLimitEnable(true);
    LeftMotor_1.configReverseSoftLimitEnable(true);

  }
  public void move(double output){
    LeftMotor_1.set(ControlMode.PercentOutput, output);
  }

  public double getPosition(){
    return LeftMotor_1.getSelectedSensorPosition();
  }

  public void stopMotor(){
      LeftMotor_1.set(ControlMode.Disabled, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
