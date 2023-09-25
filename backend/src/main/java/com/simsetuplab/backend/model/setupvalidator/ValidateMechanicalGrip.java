package com.simsetuplab.backend.model.setupvalidator;

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
				&& validateFrontWheelRate(mechanicalGrip.getFrontLeftWheelRate(), mechanicalGrip.getFrontRightWheelRate())
				&& validateRearWheelRate(mechanicalGrip.getRearLeftWheelRate(), mechanicalGrip.getRearRightWheelRate())
				&& validateFrontBumpStopRate(mechanicalGrip.getFrontLeftBumpstopRate(), mechanicalGrip.getFrontRightBumpstopRate())
				&& validateRearBumpStopRate(mechanicalGrip.getRearLeftBumpstopRate(), mechanicalGrip.getRearRightBumpstopRate())
				&& validateFrontBumpStopRange(mechanicalGrip.getFrontLeftBumpstopRange(), mechanicalGrip.getFrontRightBumpstopRange())
				&& validateRearBumpStopRange(mechanicalGrip.getRearLeftBumpstopRange(), mechanicalGrip.getRearRightBumpstopRange())
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

	private boolean validateFrontWheelRate(int frontLeftWheelRate, int frontRightWheelRate) {
		return frontLeftWheelRate >= frontWheelRateMin && frontLeftWheelRate <= frontWheelRateMax
				&& frontRightWheelRate >= frontWheelRateMin && frontRightWheelRate <= frontWheelRateMax;
	}

	private boolean validateRearWheelRate(int rearLeftWheelRate, int rearRightWheelRate) {
		return rearLeftWheelRate >= rearWheelRateMin && rearLeftWheelRate <= rearWheelRateMax
				&& rearRightWheelRate >= rearWheelRateMin && rearRightWheelRate <= rearWheelRateMax;
	}

	private boolean validateFrontBumpStopRate(int frontLeftBumpStopRate, int frontRightBumpStopRate) {
		return frontLeftBumpStopRate >= frontBumpStopRateMin && frontLeftBumpStopRate <= frontBumpStopRateMax
				&& frontRightBumpStopRate >= frontBumpStopRateMin && frontRightBumpStopRate <= frontBumpStopRateMax;
	}

	private boolean validateRearBumpStopRate(int rearLeftBumpStopRate, int rearRightBumpStopRate) {
		return rearLeftBumpStopRate >= rearBumpStopRateMin && rearLeftBumpStopRate <= rearBumpStopRateMax
				&& rearRightBumpStopRate >= rearBumpStopRateMin && rearRightBumpStopRate <= rearBumpStopRateMax;
	}

	private boolean validateFrontBumpStopRange(int frontLeftBumpStopRange, int frontRightBumpStopRange) {
		return frontLeftBumpStopRange >= frontBumpStopRangeMin && frontLeftBumpStopRange <= frontBumpStopRangeMax
				&& frontRightBumpStopRange >= frontBumpStopRangeMin && frontRightBumpStopRange <= frontBumpStopRangeMax;
	}

	private boolean validateRearBumpStopRange(int frontLeftBumpStopRange, int frontRightBumpStopRange) {
		return frontLeftBumpStopRange >= rearBumpStopRangeMin && frontLeftBumpStopRange <= rearBumpStopRangeMax
				&& frontRightBumpStopRange >= rearBumpStopRangeMin && frontRightBumpStopRange <= rearBumpStopRangeMax;
	}

	private boolean validatePreloadDifferential(int preloadDifferential) {
		return preloadDifferential >= preloadDifferentialMin && preloadDifferential <= preloadDifferentialMax;
	}
}
