// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.moTor;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;

public class RunFB extends Command {
  /** Creates a new RunFB. */
  public final moTor mT;

  public RunFB(moTor inputSubsystem) {
    mT = inputSubsystem;
    addRequirements(mT);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //mT.driveMotor(0.2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      mT.driveMotor(0.2);
      Timer.delay(1);
      mT.driveMotor(-0.2);
      Timer.delay(1);
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
