package com.simsetuplab.backend.model.setupvalidator;

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
		return validateFrontBump(dampers.getFrontLeftBump(), dampers.getFrontRightBump())
				&& validateFrontFastBump(dampers.getFrontLeftFastBump(), dampers.getFrontRightFastBump())
				&& validateFrontRebound(dampers.getFrontLeftRebound(), dampers.getFrontRightRebound())
				&& validateFrontFastRebound(dampers.getFrontLeftFastRebound(), dampers.getFrontRightFastRebound())
				&& validateRearBump(dampers.getRearLeftBump(), dampers.getRearRightBump())
				&& validateRearFastBump(dampers.getRearLeftFastBump(), dampers.getRearRightFastBump())
				&& validateRearRebound(dampers.getRearLeftRebound(), dampers.getRearRightRebound())
				&& validateRearFastRebound(dampers.getRearLeftFastRebound(), dampers.getRearRightFastRebound());
	}

	private boolean validateFrontBump(int frontLeftBump, int frontRightBump) {
		return frontLeftBump >= frontBumpMin && frontLeftBump <= frontBumpMax
				&& frontRightBump >= frontBumpMin && frontRightBump <= frontBumpMax;
	}

	private boolean validateFrontFastBump(int frontLeftFastBump, int frontRightFastBump) {
		return frontLeftFastBump >= frontFastBumpMin && frontLeftFastBump <= frontFastBumpMax
				&& frontRightFastBump >= frontFastBumpMin && frontRightFastBump <= frontFastBumpMax;
	}

	private boolean validateFrontRebound(int frontLeftRebound, int frontRightRebound) {
		return frontLeftRebound >= frontReboundMin && frontLeftRebound <= frontReboundMax
				&& frontRightRebound >= frontReboundMin && frontRightRebound <= frontReboundMax;
	}

	private boolean validateFrontFastRebound(int frontLeftFastRebound, int frontRightFastRebound) {
		return frontLeftFastRebound >= frontFastReboundMin && frontLeftFastRebound <= frontFastReboundMax
				&& frontRightFastRebound >= frontFastReboundMin && frontRightFastRebound <= frontFastReboundMax;
	}

	private boolean validateRearBump(int rearLeftBump, int rearRightBump) {
		return rearLeftBump >= rearBumpMin && rearLeftBump <= rearBumpMax
				&& rearRightBump >= rearBumpMin && rearRightBump <= rearBumpMax;
	}

	private boolean validateRearFastBump(int rearLeftFastBump, int rearRightFastBump) {
		return rearLeftFastBump >= rearFastBumpMin && rearLeftFastBump <= rearFastBumpMax
				&& rearRightFastBump >= rearFastBumpMin && rearRightFastBump <= rearFastBumpMax;
	}

	private boolean validateRearRebound(int rearLeftRebound, int rearRightRebound) {
		return rearLeftRebound >= rearReboundMin && rearLeftRebound <= rearReboundMax
				&& rearRightRebound >= rearReboundMin && rearRightRebound <= rearReboundMax;
	}

	private boolean validateRearFastRebound(int rearLeftFastRebound, int rearRightFastRebound) {
		return rearLeftFastRebound >= rearFastReboundMin && rearLeftFastRebound <= rearFastReboundMax
				&& rearRightFastRebound >= rearFastReboundMin && rearRightFastRebound <= rearFastReboundMax;
	}

}
