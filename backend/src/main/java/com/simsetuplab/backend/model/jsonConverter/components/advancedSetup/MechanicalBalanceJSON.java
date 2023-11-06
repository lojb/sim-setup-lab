package com.simsetuplab.backend.model.jsonConverter.components.advancedSetup;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MechanicalBalanceJSON {
    private double aRBFront;
    private double aRBRear;
    private List<Integer> wheelRate;
    private List<Integer> bumpStopRateUp;
    private List<Integer> bumpStopRateDn;
    private List<Integer> bumpStopWindow;
    private int brakeTorque;
    private int brakeBias;
}
