package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.enumeration.carsetup.TyreType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateFuelStrategy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType car;
	private int fuelMin = 2;
	private int fuelMax;
	private TyreType tyreTypeMin = TyreType.DRY;
	private int brakesMin = 1;
	private int brakesMax = 4;
	private double fuelPerLap;
}
