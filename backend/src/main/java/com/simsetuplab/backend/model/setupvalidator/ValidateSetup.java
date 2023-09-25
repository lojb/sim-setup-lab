package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setup.Setup;

import jakarta.persistence.CascadeType;
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

	public boolean validate(Setup setup) {
		return validateAero.validate(setup.getAero())
				&& validateDampers.validate(setup.getDampers())
				&& validateElectronics.validate(setup.getElectronics())
				&& validateFuelStrategy.validate(setup.getFuelStrategy())
				&& validateMechanicalGrip.validate(setup.getMechanicalGrip())
				&& validateTyres.validate(setup.getTyres());
	}
}
