package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import com.simsetuplab.backend.enumeration.carsetup.TyreType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TyresJSON {
    private TyreType tyreCompound; // 0 -> DRY, 1 -> WET
    private List<Float> tyrePressure; // [ front left, front right, rear left, rear right ]
}
