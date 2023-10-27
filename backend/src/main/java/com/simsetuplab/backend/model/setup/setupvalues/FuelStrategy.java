package com.simsetuplab.backend.model.setup.setupvalues;

import com.simsetuplab.backend.enumeration.carsetup.TyreType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "setup_fuel_strategy", schema = "public")
@Getter
public class FuelStrategy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int fuel = 20;
	private TyreType tyreType = TyreType.DRY;
	private int frontBrakes = 1;
	private int rearBrakes = 1;
	private double fuelPerLap;
}
