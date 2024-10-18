// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.moTor;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunJS extends Command {
  /** Creates a new RunFB. */
  public final moTor mT;

  private final CommandXboxController JSm_driverController;

  

  public RunJS(moTor inputSubsystem, CommandXboxController inputController) {
    mT = inputSubsystem;
    addRequirements(mT);

    JSm_driverController = inputController;
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //mT.driveMotor(0.2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

      double JSValue =  JSm_driverController.getRawAxis(0);
      if (Math.abs(JSValue) < 0.085) {
        JSValue = 0;
      }
      SmartDashboard.putNumber("speed",JSValue);
      mT.driveMotor(JSValue);
    }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
    mT.driveMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
