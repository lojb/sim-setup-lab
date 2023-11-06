package com.simsetuplab.backend.model.setupValidator;

import com.simsetuplab.backend.model.setup.setupvalues.MechanicalGrip;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "validate_mechanical_grip", schema = "public")
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

	@Transient
	List<String> errorList = new ArrayList<>();

	public List<String> validate(MechanicalGrip mechanicalGrip) {
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

		return errorList;
	}

	private void validateFrontAntiRollBar(int frontAntiRollBar) {
		if (!(frontAntiRollBar >= frontAntiRollBarMin && frontAntiRollBar <= frontAntiRollBarMax)) {
			errorList.add("front anti roll bar");
		}
	}

	private void validateRearAntiRollBar(int rearAntiRollBar) {
		if (!(rearAntiRollBar >= rearAntiRollBarMin && rearAntiRollBar <= rearAntiRollBarMax)) {
			errorList.add("rear anti roll bar");
		}
	}

	private void validateBrakeBias(float brakeBias) {
		if (!(brakeBias >= brakeBiasMin && brakeBias <= brakeBiasMax)) {
			errorList.add("brake bias");
		}
	}

	private void validateSteerRatio(int steerRatio) {
		if (!(steerRatio >= steerRatioMin && steerRatio <= steerRatioMax)) {
			errorList.add("steer ratio");
		}
	}

	private void validateFrontWheelRate(int frontLeftWheelRate, int frontRightWheelRate) {
		if (!(frontLeftWheelRate >= frontWheelRateMin && frontLeftWheelRate <= frontWheelRateMax
				&& frontRightWheelRate >= frontWheelRateMin && frontRightWheelRate <= frontWheelRateMax)) {
			errorList.add("front wheel rate");
		}
	}

	private void validateRearWheelRate(int rearLeftWheelRate, int rearRightWheelRate) {
		if (!(rearLeftWheelRate >= rearWheelRateMin && rearLeftWheelRate <= rearWheelRateMax
				&& rearRightWheelRate >= rearWheelRateMin && rearRightWheelRate <= rearWheelRateMax)) {
			errorList.add("rear wheel rate");
		}
	}

	private void validateFrontBumpStopRate(int frontLeftBumpStopRate, int frontRightBumpStopRate) {
		if (!(frontLeftBumpStopRate >= frontBumpStopRateMin && frontLeftBumpStopRate <= frontBumpStopRateMax
				&& frontRightBumpStopRate >= frontBumpStopRateMin && frontRightBumpStopRate <= frontBumpStopRateMax)) {
			errorList.add("front bumpstop rate");
		}
	}

	private void validateRearBumpStopRate(int rearLeftBumpStopRate, int rearRightBumpStopRate) {
		if (!(rearLeftBumpStopRate >= rearBumpStopRateMin && rearLeftBumpStopRate <= rearBumpStopRateMax
				&& rearRightBumpStopRate >= rearBumpStopRateMin && rearRightBumpStopRate <= rearBumpStopRateMax)) {
			errorList.add("rear bumpstop rate");
		}
	}

	private void validateFrontBumpStopRange(int frontLeftBumpStopRange, int frontRightBumpStopRange) {
		if (!(frontLeftBumpStopRange >= frontBumpStopRangeMin && frontLeftBumpStopRange <= frontBumpStopRangeMax
				&& frontRightBumpStopRange >= frontBumpStopRangeMin && frontRightBumpStopRange <= frontBumpStopRangeMax)) {
			errorList.add("front bumpstop range");
		}
	}

	private void validateRearBumpStopRange(int frontLeftBumpStopRange, int frontRightBumpStopRange) {
		if (!(frontLeftBumpStopRange >= rearBumpStopRangeMin && frontLeftBumpStopRange <= rearBumpStopRangeMax
				&& frontRightBumpStopRange >= rearBumpStopRangeMin && frontRightBumpStopRange <= rearBumpStopRangeMax)) {
			errorList.add("rear bumpstop range");
		}
	}

	private void validatePreloadDifferential(int preloadDifferential) {
		if (!(preloadDifferential >= preloadDifferentialMin && preloadDifferential <= preloadDifferentialMax)) {
			errorList.add("preload differential");
		}
	}
}
