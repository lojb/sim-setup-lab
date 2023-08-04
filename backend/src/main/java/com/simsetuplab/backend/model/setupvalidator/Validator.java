package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setup.Setup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Validator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType carType;
	@OneToOne
	private ValidateAero validateAero;
	@OneToOne
	private ValidateDampers validateDampers;
	@OneToOne
	private ValidateElectronics validateElectronics;
	@OneToOne
	private ValidateFuelStrategy validateFuelStrategy;
	@OneToOne
	private ValidateMechanicalGrip validateMechanicalGrip;
	@OneToOne
	private ValidateTyres validateTyres;

	public boolean validate(Setup setup) {
		return validateAero.validate(setup.getAero())
				&& validateDampers.validate(setup.getDampers())
				&& validateElectronics.validate(setup.getElectronics())
				&& validateFuelStrategy.validate(setup.getFuelStrategy())
				&& validateMechanicalGrip.validate(setup.getMechanicalGrip())
				&& validateTyres.validate(setup.getTyres());
	}
}
