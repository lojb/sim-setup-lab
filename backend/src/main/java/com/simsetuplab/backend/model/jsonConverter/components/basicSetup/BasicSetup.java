package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicSetup {
    private TyresJSON tyres;
    private AlignmentJSON alignment;
    private ElectronicsJSON electronics;
    private StrategyJSON strategy;
}
