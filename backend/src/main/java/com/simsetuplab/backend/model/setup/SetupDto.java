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

    public SetupDto convertSetupToDto(Setup setup) {
        return SetupDto.builder()
                .name(setup.getName())
                .userId(setup.getUser().getId())
                .carType(setup.getCarType().toString())
                .track(setup.getTrack().toString())
                .setupType(setup.getSetupType().toString())
                .aero(setup.getAero())
                .dampers(setup.getDampers())
                .electronics(setup.getElectronics())
                .fuelStrategy(setup.getFuelStrategy())
                .mechanicalGrip(setup.getMechanicalGrip())
                .tyres(setup.getTyres())
                .build();
    }
}
