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
import com.simsetuplab.backend.model.user.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@Table(name = "setup", schema = "public")
public class Setup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private CarType carType;
    private Tracks track;
    private SetupType setupType;

    @OneToOne(cascade = CascadeType.ALL)
    private Aero aero;
    @OneToOne(cascade = CascadeType.ALL)
    private Dampers dampers;
    @OneToOne(cascade = CascadeType.ALL)
    private Electronics electronics;
    @OneToOne(cascade = CascadeType.ALL)
    private FuelStrategy fuelStrategy;
    @OneToOne(cascade = CascadeType.ALL)
    private MechanicalGrip mechanicalGrip;
    @OneToOne(cascade = CascadeType.ALL)
    private Tyres tyres;

    public Setup(SetupDto setupDto) {
        setName(setupDto.getName());

        setCarType(CarType.valueOf(setupDto.getCarType()));
        setTrack(Tracks.valueOf(setupDto.getTrack()));
        setSetupType(SetupType.valueOf(setupDto.getSetupType()));

        setAero(setupDto.getAero());
        setDampers(setupDto.getDampers());
        setElectronics(setupDto.getElectronics());
        setFuelStrategy(setupDto.getFuelStrategy());
        setMechanicalGrip(setupDto.getMechanicalGrip());
        setTyres(setupDto.getTyres());
    }

    public Setup() {

    }
}
