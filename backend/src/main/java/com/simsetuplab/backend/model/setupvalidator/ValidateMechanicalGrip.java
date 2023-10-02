package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.setupvalues.MechanicalGrip;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
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
		validateFrontAntiRollBar(mechanicalGrip.getFrontAntiRollBar());
		validateRearAntiRollBar(mechanicalGrip.getRearAntiRollBar());
		validateBrakeBias(mechanicalGrip.getBrakeBias());
		validateSteerRatio(mechanicalGrip.getSteerRatio());
		validateFrontWheelRate(mechanicalGrip.getFrontLeftWheelRate(), mechanicalGrip.getFrontRightWheelRate());
		validateRearWheelRate(mechanicalGrip.getRearLeftWheelRate(), mechanicalGrip.getRearRightWheelRate());
		validateFrontBumpStopRate(mechanicalGrip.getFrontLeftBumpstopRate(), mechanicalGrip.getFrontRightBumpstopRate());
		validateRearBumpStopRate(mechanicalGrip.getRearLeftBumpstopRate(), mechanicalGrip.getRearRightBumpstopRate());
		validateFrontBumpStopRange(mechanicalGrip.getFrontLeftBumpstopRange(), mechanicalGrip.getFrontRightBumpstopRange());
		validateRearBumpStopRange(mechanicalGrip.getRearLeftBumpstopRange(), mechanicalGrip.getRearRightBumpstopRange());
		validatePreloadDifferential(mechanicalGrip.getPreloadDifferential());

		return true;
	}

	private void validateFrontAntiRollBar(int frontAntiRollBar) {
		if (!(frontAntiRollBar >= frontAntiRollBarMin && frontAntiRollBar <= frontAntiRollBarMax)) {
			throw new ApiRequestException("Invalid front anti roll bar values");
		}
	}

	private void validateRearAntiRollBar(int rearAntiRollBar) {
		if (!(rearAntiRollBar >= rearAntiRollBarMin && rearAntiRollBar <= rearAntiRollBarMax)) {
			throw new ApiRequestException("Invalid rear anti roll bar values");
		}
	}

	private void validateBrakeBias(float brakeBias) {
		if (!(brakeBias >= brakeBiasMin && brakeBias <= brakeBiasMax)) {
			throw new ApiRequestException("Invalid brake bias value");
		}
	}

	private void validateSteerRatio(int steerRatio) {
		if (!(steerRatio >= steerRatioMin && steerRatio <= steerRatioMax)) {
			throw new ApiRequestException("Invalid steer ratio value");
		}
	}

	private void validateFrontWheelRate(int frontLeftWheelRate, int frontRightWheelRate) {
		if (!(frontLeftWheelRate >= frontWheelRateMin && frontLeftWheelRate <= frontWheelRateMax
				&& frontRightWheelRate >= frontWheelRateMin && frontRightWheelRate <= frontWheelRateMax)) {
			throw new ApiRequestException("Invalid front wheelrate value");
		}
	}

	private void validateRearWheelRate(int rearLeftWheelRate, int rearRightWheelRate) {
		if (!(rearLeftWheelRate >= rearWheelRateMin && rearLeftWheelRate <= rearWheelRateMax
				&& rearRightWheelRate >= rearWheelRateMin && rearRightWheelRate <= rearWheelRateMax)) {
			throw new ApiRequestException("Invalid rear wheelrate value");
		}
	}

	private void validateFrontBumpStopRate(int frontLeftBumpStopRate, int frontRightBumpStopRate) {
		if (!(frontLeftBumpStopRate >= frontBumpStopRateMin && frontLeftBumpStopRate <= frontBumpStopRateMax
				&& frontRightBumpStopRate >= frontBumpStopRateMin && frontRightBumpStopRate <= frontBumpStopRateMax)) {
			throw new ApiRequestException("Invalid front bumpstop rate value");
		}
	}

	private void validateRearBumpStopRate(int rearLeftBumpStopRate, int rearRightBumpStopRate) {
		if (!(rearLeftBumpStopRate >= rearBumpStopRateMin && rearLeftBumpStopRate <= rearBumpStopRateMax
				&& rearRightBumpStopRate >= rearBumpStopRateMin && rearRightBumpStopRate <= rearBumpStopRateMax)) {
			throw new ApiRequestException("Invalid rear bumpstop rate value");
		}
	}

	private void validateFrontBumpStopRange(int frontLeftBumpStopRange, int frontRightBumpStopRange) {
		if (!(frontLeftBumpStopRange >= frontBumpStopRangeMin && frontLeftBumpStopRange <= frontBumpStopRangeMax
				&& frontRightBumpStopRange >= frontBumpStopRangeMin && frontRightBumpStopRange <= frontBumpStopRangeMax)) {
			throw new ApiRequestException("Invalid front bumpstop range value");
		}
	}

	private void validateRearBumpStopRange(int frontLeftBumpStopRange, int frontRightBumpStopRange) {
		if (!(frontLeftBumpStopRange >= rearBumpStopRangeMin && frontLeftBumpStopRange <= rearBumpStopRangeMax
				&& frontRightBumpStopRange >= rearBumpStopRangeMin && frontRightBumpStopRange <= rearBumpStopRangeMax)) {
			throw new ApiRequestException("Invalid rear bumpstop range value");
		}
	}

	private void validatePreloadDifferential(int preloadDifferential) {
		if (!(preloadDifferential >= preloadDifferentialMin && preloadDifferential <= preloadDifferentialMax)) {
			throw new ApiRequestException("Invalid preload differential value");
		}
	}
}
