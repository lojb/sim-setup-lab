package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.TyreType;
import com.simsetuplab.backend.model.setup.setupvalues.FuelStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateFuelStrategy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int fuelMin = 2;
	private int fuelMax;
	private TyreType tyreTypeMin = TyreType.DRY;
	private int brakesMin = 1;
	private int brakesMax = 4;
	private double fuelPerLap;

	public boolean validate(FuelStrategy fuelStrategy) {
		return validateFuel(fuelStrategy.getFuel())
				&& validateBrakes(fuelStrategy.getFrontBrakes())
				&& validateBrakes(fuelStrategy.getRearBrakes());
	}

	private boolean validateFuel(int fuel) {
		return fuel >= fuelMin && fuel <= fuelMax;
	}

	private boolean validateBrakes(int brakes) {
		return brakes >= brakesMin && brakes <= brakesMax;
	}
}
