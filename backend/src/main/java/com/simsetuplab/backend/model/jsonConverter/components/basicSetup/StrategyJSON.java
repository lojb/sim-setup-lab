package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StrategyJSON {
    private int fuel;
    private int nPitStops;
    private int tyreSet;
    private int frontBrakePadCompound;
    private int rearBrakePadCompound;
    private List<PitStrategyJSON> pitStrategy;
    private double fuelPerLap;
}
