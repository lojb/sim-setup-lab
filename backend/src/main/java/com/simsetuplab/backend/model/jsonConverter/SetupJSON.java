package com.simsetuplab.backend.model.jsonConverter;

import com.simsetuplab.backend.model.jsonConverter.components.advancedSetup.AdvancedSetup;
import com.simsetuplab.backend.model.jsonConverter.components.basicSetup.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class SetupJSON {
    String carName;
    BasicSetup basicSetup;
    AdvancedSetup advancedSetup;
    int trackBopType;
}
