package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ElectronicsJSON {
    private int tC1; // 1 click -> 1 unit
    private int tC2; // 1 click -> 1 unit
    private int abs; // 1 click -> 1 unit
    private int eCUMap; // 1 click -> 1 unit
    private int fuelMix; // porsche: always 0
    private int telemetryLaps; // 1 click -> 1 lap
}
