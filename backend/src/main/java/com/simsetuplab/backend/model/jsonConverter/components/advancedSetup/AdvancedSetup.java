package com.simsetuplab.backend.model.jsonConverter.components.advancedSetup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "basicsetup_json", schema = "public")
public class AdvancedSetup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private MechanicalBalanceJSON mechanicalBalance;
    @OneToOne(cascade = CascadeType.ALL)
    private DampersJSON dampers;
    @OneToOne(cascade = CascadeType.ALL)
    private AeroBalanceJSON aeroBalance;
    @OneToOne(cascade = CascadeType.ALL)
    private DrivetrainJSON drivetrain;
}
