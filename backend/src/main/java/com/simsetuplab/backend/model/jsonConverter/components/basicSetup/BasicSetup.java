package com.simsetuplab.backend.model.jsonConverter.components.basicSetup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "basicsetup_json", schema = "public")
public class BasicSetup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private TyresJSON tyres;
    @OneToOne(cascade = CascadeType.ALL)
    private AlignmentJSON alignment;
    @OneToOne(cascade = CascadeType.ALL)
    private ElectronicsJSON electronics;
    @OneToOne(cascade = CascadeType.ALL)
    private StrategyJSON strategy;
}
