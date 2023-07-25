package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateAero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType car;
	private int frontRideHeightMin;
	private int frontRideHeightMax;
	private int rearRideHeightMin;
	private int rearRideHeightMax;
	private int splitterMin;
	private int splitterMax;
	private int rearWingMin;
	private int rearWingMax;
	private int frontBrakeDuctsMin;
	private int frontBrakeDuctsMax;
	private int rearBrakeDuctsMin;
	private int rearBrakeDuctsMax;
}
