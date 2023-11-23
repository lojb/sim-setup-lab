package com.simsetuplab.backend.model.setup;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.enumeration.carsetup.SetupType;
import com.simsetuplab.backend.enumeration.carsetup.Tracks;
import com.simsetuplab.backend.model.setup.setupvalues.Aero;
import com.simsetuplab.backend.model.setup.setupvalues.Dampers;
import com.simsetuplab.backend.model.setup.setupvalues.Electronics;
import com.simsetuplab.backend.model.setup.setupvalues.FuelStrategy;
import com.simsetuplab.backend.model.setup.setupvalues.MechanicalGrip;
import com.simsetuplab.backend.model.setup.setupvalues.Tyres;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SetupDto {
    private String name;
    private long userId;

    private String carType;
    private String track;
    private String setupType;

    private Aero aero;
    private Dampers dampers;
    private Electronics electronics;
    private FuelStrategy fuelStrategy;
    private MechanicalGrip mechanicalGrip;
    private Tyres tyres;

    public SetupDto(Setup setup) {
        setName(setup.getName());
        setUserId(setup.getUser().getId());

        setCarType(setup.getCarType().toString());
        setTrack(setup.getTrack().toString());
        setSetupType(setup.getSetupType().toString());

        setAero(setup.getAero());
        setDampers(setup.getDampers());
        setElectronics(setup.getElectronics());
        setFuelStrategy(setup.getFuelStrategy());
        setMechanicalGrip(setup.getMechanicalGrip());
        setTyres(setup.getTyres());
    }
}
