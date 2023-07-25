package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateDampers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType car;
	private int frontBumpMin;
	private int frontBumpMax;
	private int frontFastBumpMin;
	private int frontFastBumpMax;
	private int frontReboundMin;
	private int frontReboundMax;
	private int frontFastReboundMin;
	private int frontFastReboundMax;
	private int rearBumpMin;
	private int rearBumpMax;
	private int rearFastBumpMin;
	private int rearFastBumpMax;
	private int rearReboundMin;
	private int rearReboundMax;
	private int rearFastReboundMin;
	private int rearFastReboundMax;
}
