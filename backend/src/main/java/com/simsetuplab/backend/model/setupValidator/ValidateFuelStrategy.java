package com.simsetuplab.backend.model.setupValidator;

import com.simsetuplab.backend.enumeration.carsetup.TyreType;
import com.simsetuplab.backend.model.setup.setupvalues.FuelStrategy;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "validate_fuel_strategy", schema = "public")
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

	public void validateFuel(int fuel) {
		if (!(fuel >= fuelMin && fuel <= fuelMax)) {
			errorList.add("fuel value");
		}
	}

	public void validateBrakes(int brakes) {
		if (!(brakes >= brakesMin && brakes <= brakesMax)) {
			errorList.add("brakes values");
		}
	}
}
