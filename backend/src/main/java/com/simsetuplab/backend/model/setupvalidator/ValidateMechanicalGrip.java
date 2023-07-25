package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateMechanicalGrip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType car;
	private int frontAntiRollBarMin;
	private int frontAntiRollBarMax;
	private int rearAntiRollBarMin;
	private int rearAntiRollBarMax;
	private int brakePower = 100;
	private float brakeBiasMin;
	private float brakeBiasMax;
	private int steerRatioMin;
	private int steerRatioMax;
	private int frontWheelRateMin;
	private int frontWheelRateMax;
	private int rearWheelRateMin;
	private int rearWheelRateMax;
	private int frontBumpStopRateMin;
	private int frontBumpStopRateMax;
	private int rearBumpStopRateMin;
	private int rearBumpStopRateMax;
	private int frontBumpStopRangeMin;
	private int frontBumpStopRangeMax;
	private int rearBumpStopRangeMin;
	private int rearBumpStopRangeMax;
	private int preloadDifferentialMin;
	private int preloadDifferentialMax;
}
