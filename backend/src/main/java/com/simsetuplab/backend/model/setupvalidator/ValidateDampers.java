package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.setupvalues.Dampers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class ValidateDampers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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

	public boolean validate(Dampers dampers) {
		validateFrontBump(dampers.getFrontLeftBump(), dampers.getFrontRightBump());
		validateFrontFastBump(dampers.getFrontLeftFastBump(), dampers.getFrontRightFastBump());
		validateFrontRebound(dampers.getFrontLeftRebound(), dampers.getFrontRightRebound());
		validateFrontFastRebound(dampers.getFrontLeftFastRebound(), dampers.getFrontRightFastRebound());
		validateRearBump(dampers.getRearLeftBump(), dampers.getRearRightBump());
		validateRearFastBump(dampers.getRearLeftFastBump(), dampers.getRearRightFastBump());
		validateRearRebound(dampers.getRearLeftRebound(), dampers.getRearRightRebound());
		validateRearFastRebound(dampers.getRearLeftFastRebound(), dampers.getRearRightFastRebound());

		return true;
	}

	private void validateFrontBump(int frontLeftBump, int frontRightBump) {
		if (!(frontLeftBump >= frontBumpMin && frontLeftBump <= frontBumpMax
				&& frontRightBump >= frontBumpMin && frontRightBump <= frontBumpMax)) {
			throw new ApiRequestException("Invalid front bump values");
		}
	}

	private void validateFrontFastBump(int frontLeftFastBump, int frontRightFastBump) {
		if (!(frontLeftFastBump >= frontFastBumpMin && frontLeftFastBump <= frontFastBumpMax
				&& frontRightFastBump >= frontFastBumpMin && frontRightFastBump <= frontFastBumpMax)) {
			throw new ApiRequestException("Invalid front fast bump values");
		}
	}

	private void validateFrontRebound(int frontLeftRebound, int frontRightRebound) {
		if (!(frontLeftRebound >= frontReboundMin && frontLeftRebound <= frontReboundMax
				&& frontRightRebound >= frontReboundMin && frontRightRebound <= frontReboundMax)) {
			throw new ApiRequestException("Invalid front rebound values");
		}
	}

	private void validateFrontFastRebound(int frontLeftFastRebound, int frontRightFastRebound) {
		if (!(frontLeftFastRebound >= frontFastReboundMin && frontLeftFastRebound <= frontFastReboundMax
				&& frontRightFastRebound >= frontFastReboundMin && frontRightFastRebound <= frontFastReboundMax)) {
			throw new ApiRequestException("Invalid front fast rebound values");
		}
	}

	private void validateRearBump(int rearLeftBump, int rearRightBump) {
		if (!(rearLeftBump >= rearBumpMin && rearLeftBump <= rearBumpMax
				&& rearRightBump >= rearBumpMin && rearRightBump <= rearBumpMax)) {
			throw new ApiRequestException("Invalid rear bump values");
		}
	}

	private void validateRearFastBump(int rearLeftFastBump, int rearRightFastBump) {
		if (!(rearLeftFastBump >= rearFastBumpMin && rearLeftFastBump <= rearFastBumpMax
				&& rearRightFastBump >= rearFastBumpMin && rearRightFastBump <= rearFastBumpMax)) {
			throw new ApiRequestException("Invalid rear fast bump values");
		}
	}

	private void validateRearRebound(int rearLeftRebound, int rearRightRebound) {
		if (!(rearLeftRebound >= rearReboundMin && rearLeftRebound <= rearReboundMax
				&& rearRightRebound >= rearReboundMin && rearRightRebound <= rearReboundMax)) {
			throw new ApiRequestException("Invalid rear rebound values");
		}
	}

	private void validateRearFastRebound(int rearLeftFastRebound, int rearRightFastRebound) {
		if (!(rearLeftFastRebound >= rearFastReboundMin && rearLeftFastRebound <= rearFastReboundMax
				&& rearRightFastRebound >= rearFastReboundMin && rearRightFastRebound <= rearFastReboundMax)) {
			throw new ApiRequestException("Invalid rear fast rebound values");
		}
	}

}
