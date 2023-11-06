package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PitStrategyJSON {
    private int fuelToAdd;
    private TyresJSON tyres;
    private int tyreSet;
    private int frontBrakePadCompound;
    private int rearBrakePadCompound;
}
