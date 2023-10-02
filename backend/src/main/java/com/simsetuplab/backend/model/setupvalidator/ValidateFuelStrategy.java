package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.TyreType;
import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.setupvalues.FuelStrategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class ValidateFuelStrategy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int fuelMin = 2;
	private int fuelMax;
	private TyreType tyreType = TyreType.DRY;
	private int brakesMin = 1;
	private int brakesMax = 4;
	private double fuelPerLap = 0;

	public boolean validate(FuelStrategy fuelStrategy) {
		validateFuel(fuelStrategy.getFuel());
		validateBrakes(fuelStrategy.getFrontBrakes());
		validateBrakes(fuelStrategy.getRearBrakes());

		return true;
	}

	private void validateFuel(int fuel) {
		if (!(fuel >= fuelMin && fuel <= fuelMax)) {
			throw new ApiRequestException("Invalid fuel value");
		}
	}

	private void validateBrakes(int brakes) {
		if (!(brakes >= brakesMin && brakes <= brakesMax)) {
			throw new ApiRequestException("Invalid brakes values");
		}
	}
}
