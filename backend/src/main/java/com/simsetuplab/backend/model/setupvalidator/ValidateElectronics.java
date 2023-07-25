package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateElectronics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType car;
	private int tractionControlMin;
	private int tractionControlMax;
	private int absMin;
	private int absMax;
	private int ecuMapMin;
	private int ecuMapMax;
	private int telemetryLapsMin;
	private int telemetryLapsMax;
}
