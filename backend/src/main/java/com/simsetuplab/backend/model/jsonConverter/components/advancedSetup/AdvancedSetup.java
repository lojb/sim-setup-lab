package com.simsetuplab.backend.model.jsonConverter.components.advancedSetup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvancedSetup {
    private MechanicalBalanceJSON mechanicalBalance;
    private DampersJSON dampers;
    private AeroBalanceJSON aeroBalance;
    private DrivetrainJSON drivetrain;
}
