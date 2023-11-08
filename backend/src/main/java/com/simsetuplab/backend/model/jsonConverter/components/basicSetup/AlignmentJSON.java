package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AlignmentJSON {
    private List<Double> camber; // 1 click -> 0.1° [ front left, front right, rear left, rear right ]
    private List<Double> toe; // 1 click -> 0.01°  [ front left, front right, rear left, rear right ]
    private List<Double> staticCamber; //calculated values
    private List<Double> toeOutLinear; //calculated values
    private double casterLF; // 1 click -> 0.2° except 7.7° + 1 click = 7.8°
    private double casterRF; // 1 click -> 0.2° except 7.7° + 1 click = 7.8°
    private double steerRatio; // 1 click -> 1.0°
}
