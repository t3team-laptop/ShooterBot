// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmPivot;
import frc.robot.commands.Autos;
import frc.robot.commands.Drive;
import frc.robot.commands.HighSpeedPreset;
import frc.robot.commands.LowSpeedPreset;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain driveTrain = new DriveTrain();
  private final Arm arm = new Arm();
  private final Shooter shooter = new Shooter();

  private final XboxController driver = new XboxController(0);

  /* Controls */
  private final int speedAxis = XboxController.Axis.kLeftY.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;
  
  JoystickButton A, B, X, Y, LB, RB, M1, M2;
  // Commands //
  Drive drive;
  LowSpeedPreset lowSpeedPreset;
  HighSpeedPreset highSpeedPreset;
  ArmPivot armPivot;

  public RobotContainer() {
    highSpeedPreset = new HighSpeedPreset(shooter);
    lowSpeedPreset = new LowSpeedPreset(shooter);

    driveTrain.setDefaultCommand(new Drive(driveTrain, () -> driver.getRawAxis(speedAxis), () -> driver.getRawAxis(rotationAxis)));
    arm.setDefaultCommand(new ArmPivot(arm, 1));

    A = new JoystickButton(driver, 1);
    B = new JoystickButton(driver, 2);
    X = new JoystickButton(driver, 3);
    Y = new JoystickButton(driver, 4);
    LB = new JoystickButton(driver, 5);
    RB = new JoystickButton(driver, 6);
    M1 = new JoystickButton(driver, 7);
    M2 = new JoystickButton(driver, 8);

    // Configure the trigger bindings

    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {

   A.onTrue(lowSpeedPreset);
   Y.onTrue(highSpeedPreset);
   LB.whileTrue(new ArmPivot(arm, 1));
   RB.whileTrue(new ArmPivot(arm, -1));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
}
