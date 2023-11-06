package com.simsetuplab.backend.model.jsonConverter.components.advancedSetup;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AeroBalanceJSON {
    private List<Integer> rideHeight;
    private List<Double> rodLength;
    private int splitter;
    private int rearWing;
    private List<Integer> brakeDuct;
}
