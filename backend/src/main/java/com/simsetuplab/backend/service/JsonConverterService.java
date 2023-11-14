package com.simsetuplab.backend.service;

import com.simsetuplab.backend.model.jsonConverter.SetupJSON;
import com.simsetuplab.backend.model.jsonConverter.components.basicSetup.BasicSetup;
import com.simsetuplab.backend.model.jsonConverter.components.basicSetup.TyresJSON;
import com.simsetuplab.backend.model.setup.Setup;
import com.simsetuplab.backend.model.setup.setupvalues.FuelStrategy;
import com.simsetuplab.backend.model.setup.setupvalues.Tyres;
import com.simsetuplab.backend.repository.SetupRepository;
import com.simsetuplab.backend.repository.ValidateSetupRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class JsonConverterService {
    private final SetupRepository setupRepository;

    private final ValidateSetupRepository validateSetupRepository;

    public JsonConverterService(SetupRepository setupRepository, ValidateSetupRepository validateSetupRepository) {
        this.setupRepository = setupRepository;
        this.validateSetupRepository = validateSetupRepository;
    }

    public SetupJSON convertSetupToJSON(Setup setup) {
        return null;
    }

    private BasicSetup convertIntoBasicSetup(Setup setup) {
        return BasicSetup.builder()
                .tyres(convertToTyresJSON(setup.getTyres(), setup.getFuelStrategy()))
                .build();
    }

    private TyresJSON convertToTyresJSON(Tyres tyres, FuelStrategy fuelStrategy) {
        return TyresJSON.builder()
                .tyreCompound(fuelStrategy.getTyreType())
                .tyrePressure(Arrays.asList(tyres.getFrontLeftTyrePressure(), tyres.getFrontRightTyrePressure(), tyres.getRearLeftTyrePressure(), tyres.getRearRightTyrePressure()))
                .build();
    }


}
