package com.simsetuplab.backend.model.setupValidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setup.Setup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "validate_setup", schema = "public")
public class ValidateSetup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType carType;
	@OneToOne(cascade = CascadeType.ALL)
	private ValidateAero validateAero;
	@OneToOne(cascade = CascadeType.ALL)
	private ValidateDampers validateDampers;
	@OneToOne(cascade = CascadeType.ALL)
	private ValidateElectronics validateElectronics;
	@OneToOne(cascade = CascadeType.ALL)
	private ValidateFuelStrategy validateFuelStrategy;
	@OneToOne(cascade = CascadeType.ALL)
	private ValidateMechanicalGrip validateMechanicalGrip;
	@OneToOne(cascade = CascadeType.ALL)
	private ValidateTyres validateTyres;

	public List<String> validate(Setup setup) {

		List<String> errorList = new ArrayList<>();

		errorList.addAll(validateAero.validate(setup.getAero()));
		errorList.addAll(validateDampers.validate(setup.getDampers()));
		errorList.addAll(validateElectronics.validate(setup.getElectronics()));
		errorList.addAll(validateFuelStrategy.validate(setup.getFuelStrategy()));
		errorList.addAll(validateMechanicalGrip.validate(setup.getMechanicalGrip()));
		errorList.addAll(validateTyres.validate(setup.getTyres()));

		return errorList;
	}
}
