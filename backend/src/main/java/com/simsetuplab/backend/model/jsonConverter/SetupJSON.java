package com.simsetuplab.backend.model.jsonConverter;

import com.simsetuplab.backend.model.jsonConverter.components.advancedSetup.AdvancedSetup;
import com.simsetuplab.backend.model.jsonConverter.components.basicSetup.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "setup_json", schema = "public")
public class SetupJSON {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String carName;
    @OneToOne(cascade = CascadeType.ALL)
    BasicSetup basicSetup;
    @OneToOne(cascade = CascadeType.ALL)
    AdvancedSetup advancedSetup;
    int trackBopType;
}
