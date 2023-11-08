package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BasicSetup {
    private TyresJSON tyres;
    private AlignmentJSON alignment;
    private ElectronicsJSON electronics;
    private StrategyJSON strategy;
}
