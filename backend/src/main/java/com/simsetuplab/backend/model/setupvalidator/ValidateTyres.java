package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateTyres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType car;
	private float tyrePressureMin = 25.0f;
	private float tyrePressureMax = 25.0f;
	private float frontCamberMin;
	private float frontCamberMax;
	private float rearCamberMin;
	private float rearCamberMax;
	private float frontToeMin;
	private float frontToeMax;
	private float rearToeMin;
	private float rearToeMax;
	private float casterMin;
	private float casterMax;
}
