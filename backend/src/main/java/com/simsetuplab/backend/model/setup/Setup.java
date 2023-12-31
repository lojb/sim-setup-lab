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
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    public Setup convertDtoToSetup(SetupDto setupDto, User user) {
        return Setup.builder()
                .id(setupDto.getId())
                .name(setupDto.getName())
                .user(user)
                .carType(CarType.valueOf(setupDto.getCarType()))
                .track(Tracks.valueOf(setupDto.getTrack()))
                .setupType(SetupType.valueOf(setupDto.getSetupType()))
                .aero(setupDto.getAero())
                .dampers(setupDto.getDampers())
                .electronics(setupDto.getElectronics())
                .fuelStrategy(setupDto.getFuelStrategy())
                .mechanicalGrip(setupDto.getMechanicalGrip())
                .tyres(setupDto.getTyres())
                .build();
    }

    public SetupDto convertSetupToDto() {
        return SetupDto.builder()
                .id(this.getId())
                .name(this.getName())
                .userId(this.getUser().getId())
                .carType(this.getCarType().toString())
                .track(this.getTrack().toString())
                .setupType(this.getSetupType().toString())
                .aero(this.getAero())
                .dampers(this.getDampers())
                .electronics(this.getElectronics())
                .fuelStrategy(this.getFuelStrategy())
                .mechanicalGrip(this.getMechanicalGrip())
                .tyres(this.getTyres())
                .build();
    }
}
