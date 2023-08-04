package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
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

	public boolean validate(Dampers dampers) {
		return validateFrontBump(dampers.getFrontBump())
				&& validateFrontFastBump(dampers.getFrontFastBump())
				&& validateFrontRebound(dampers.getFrontRebound())
				&& validateFrontFastRebound(dampers.getFrontFastRebound())
				&& validateRearBump(dampers.getRearBump())
				&& validateRearFastBump(dampers.getRearFastBump())
				&& validateRearRebound(dampers.getRearRebound())
				&& validateRearFastRebound(dampers.getRearFastRebound());
	}

	private boolean validateFrontBump(int frontBump) {
		return frontBump >= frontBumpMin && frontBump <= frontBumpMax;
	}

	private boolean validateFrontFastBump(int frontFastBump) {
		return frontFastBump >= frontFastBumpMin && frontFastBump <= frontFastBumpMax;
	}

	private boolean validateFrontRebound(int frontRebound) {
		return frontRebound >= frontReboundMin && frontRebound <= frontReboundMax;
	}

	private boolean validateFrontFastRebound(int frontFastRebound) {
		return frontFastRebound >= frontFastReboundMin && frontFastRebound <= frontFastReboundMax;
	}

	private boolean validateRearBump(int rearBump) {
		return rearBump >= rearBumpMin && rearBump <= rearBumpMax;
	}

	private boolean validateRearFastBump(int rearFastBump) {
		return rearFastBump >= rearFastBumpMin && rearFastBump <= rearFastBumpMax;
	}

	private boolean validateRearRebound(int rearRebound) {
		return rearRebound >= rearReboundMin && rearRebound <= rearReboundMax;
	}

	private boolean validateRearFastRebound(int rearFastRebound) {
		return rearFastRebound >= rearFastReboundMin && rearFastRebound <= rearFastReboundMax;
	}

}
