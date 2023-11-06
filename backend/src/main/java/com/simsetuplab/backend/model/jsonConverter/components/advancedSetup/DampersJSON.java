package com.simsetuplab.backend.model.jsonConverter.components.advancedSetup;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DampersJSON {
    private List<Integer> bumpSlow;
    private List<Integer> bumpFast;
    private List<Integer> reboundSlow;
    private List<Integer> reboundFast;
}
