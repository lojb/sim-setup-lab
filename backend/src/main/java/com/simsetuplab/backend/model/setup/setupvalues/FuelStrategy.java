package com.simsetuplab.backend.model.setup.setupvalues;

import com.simsetuplab.backend.enumeration.carsetup.TyreType;
import com.simsetuplab.backend.model.setup.Setup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "setup_fuel_strategy")
public class FuelStrategy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Setup setup;
	private int fuel = 20;
	private TyreType tyreType;
	private int frontBrakes = 1;
	private int rearBrakes = 1;
	private double fuelPerLap;
}
