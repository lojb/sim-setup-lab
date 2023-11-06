package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlignmentJSON {
    private List<Double> camber;
    private List<Double> toe;
    private List<Double> staticCamber;
    private List<Double> toeOutLinear;
    private double casterLF;
    private double casterRF;
    private double steerRatio;
}
