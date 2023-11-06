package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TyresJSON {
    private int tyreCompound;
    private List<Integer> tyrePressure;
}
