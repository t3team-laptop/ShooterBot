// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */

  private final CANSparkMax leftMotor;
  private final CANSparkMax rightMotor;
  
  public Shooter() {

    this.leftMotor = new CANSparkMax(0, null);
    this.rightMotor = new CANSparkMax(0, null);
    rightMotor.follow(leftMotor, true);

  }

  public void shoot(double velocity){

    leftMotor.set(velocity);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
