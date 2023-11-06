package com.simsetuplab.backend.model.jsonConverter;

import com.simsetuplab.backend.model.jsonConverter.components.advancedSetup.AdvancedSetup;
import com.simsetuplab.backend.model.jsonConverter.components.basicSetup.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SetupJSON {
    String carName;
    BasicSetup basicSetup;
    AdvancedSetup advancedSetup;
    int trackBopType;
}
