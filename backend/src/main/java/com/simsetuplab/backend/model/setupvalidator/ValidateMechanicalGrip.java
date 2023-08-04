package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setup.setupvalues.MechanicalGrip;

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

	public boolean validate(MechanicalGrip mechanicalGrip) {
		return validateFrontAntiRollBar(mechanicalGrip.getFrontAntiRollBar())
				&& validateRearAntiRollBar(mechanicalGrip.getRearAntiRollBar())
				&& validateBrakeBias(mechanicalGrip.getBrakeBias())
				&& validateSteerRatio(mechanicalGrip.getSteerRatio())
				&& validateFrontWheelRate(mechanicalGrip.getFrontWheelRate())
				&& validateRearWheelRate(mechanicalGrip.getRearWheelRate())
				&& validateFrontBumpStopRate(mechanicalGrip.getFrontBumpstopRate())
				&& validateRearBumpStopRate(mechanicalGrip.getRearBumpstopRate())
				&& validateFrontBumpStopRange(mechanicalGrip.getFrontBumpstopRange())
				&& validateRearBumpStopRange(mechanicalGrip.getRearBumpstopRange())
				&& validatePreloadDifferential(mechanicalGrip.getPreloadDifferential());

	}

	private boolean validateFrontAntiRollBar(int frontAntiRollBar) {
		return frontAntiRollBar >= frontAntiRollBarMin && frontAntiRollBar <= frontAntiRollBarMax;
	}

	private boolean validateRearAntiRollBar(int rearAntiRollBar) {
		return rearAntiRollBar >= rearAntiRollBarMin && rearAntiRollBar <= rearAntiRollBarMax;
	}

	private boolean validateBrakeBias(float brakeBias) {
		return brakeBias >= brakeBiasMin && brakeBias <= brakeBiasMax;
	}

	private boolean validateSteerRatio(int steerRatio) {
		return steerRatio >= steerRatioMin && steerRatio <= steerRatioMax;
	}

	private boolean validateFrontWheelRate(int frontWheelRate) {
		return frontWheelRate >= frontWheelRateMin && frontWheelRate <= frontWheelRateMax;
	}

	private boolean validateRearWheelRate(int rearWheelRate) {
		return rearWheelRate >= rearWheelRateMin && rearWheelRate <= rearWheelRateMax;
	}

	private boolean validateFrontBumpStopRate(int frontBumpStopRate) {
		return frontBumpStopRate >= frontBumpStopRateMin && frontBumpStopRate <= frontBumpStopRateMax;
	}

	private boolean validateRearBumpStopRate(int rearBumpStopRate) {
		return rearBumpStopRate >= rearBumpStopRateMin && rearBumpStopRate <= rearBumpStopRateMax;
	}

	private boolean validateFrontBumpStopRange(int frontBumpStopRange) {
		return frontBumpStopRange >= frontBumpStopRangeMin && frontBumpStopRange <= frontBumpStopRangeMax;
	}

	private boolean validateRearBumpStopRange(int rearBumpStopRange) {
		return rearBumpStopRange >= rearBumpStopRangeMin && rearBumpStopRange <= rearBumpStopRangeMax;
	}

	private boolean validatePreloadDifferential(int preloadDifferential) {
		return preloadDifferential >= preloadDifferentialMin && preloadDifferential <= preloadDifferentialMax;
	}
}
