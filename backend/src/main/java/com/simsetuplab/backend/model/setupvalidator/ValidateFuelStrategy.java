package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.TyreType;
import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.setupvalues.FuelStrategy;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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

	@Transient
	List<String> errorList = new ArrayList<>();

	public List<String> validate(FuelStrategy fuelStrategy) {
		validateFuel(fuelStrategy.getFuel());
		validateBrakes(fuelStrategy.getFrontBrakes());
		validateBrakes(fuelStrategy.getRearBrakes());

		return errorList;
	}

	private void validateFuel(int fuel) {
		if (!(fuel >= fuelMin && fuel <= fuelMax)) {
			errorList.add("fuel value");
		}
	}

	private void validateBrakes(int brakes) {
		if (!(brakes >= brakesMin && brakes <= brakesMax)) {
			errorList.add("brakes values");
		}
	}
}
