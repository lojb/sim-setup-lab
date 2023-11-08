package com.simsetuplab.backend.model.jsonConverter.components.advancedSetup;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AeroBalanceJSON {
    private List<Integer> rideHeight; // 1click -> 1 unit [ front, magic number1, rear, magic number2]
    private List<Double> rodLength; // calculated value, can give 0 values
    private int splitter; // 1click -> 1.0mm
    private int rearWing; // 1click -> 1 unit
    private List<Integer> brakeDuct; // [ front, rear ]
}
