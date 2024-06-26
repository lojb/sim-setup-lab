package com.simsetuplab.backend.model.setupValidator;

import com.simsetuplab.backend.model.setup.setupvalues.Dampers;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "validate_dampers", schema = "public")
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

	@Transient
	List<String> errorList = new ArrayList<>();

	public List<String> validate(Dampers dampers) {
		validateFrontBump(dampers.getFrontLeftBump(), dampers.getFrontRightBump());
		validateFrontFastBump(dampers.getFrontLeftFastBump(), dampers.getFrontRightFastBump());
		validateFrontRebound(dampers.getFrontLeftRebound(), dampers.getFrontRightRebound());
		validateFrontFastRebound(dampers.getFrontLeftFastRebound(), dampers.getFrontRightFastRebound());
		validateRearBump(dampers.getRearLeftBump(), dampers.getRearRightBump());
		validateRearFastBump(dampers.getRearLeftFastBump(), dampers.getRearRightFastBump());
		validateRearRebound(dampers.getRearLeftRebound(), dampers.getRearRightRebound());
		validateRearFastRebound(dampers.getRearLeftFastRebound(), dampers.getRearRightFastRebound());

		return errorList;
	}

	public void validateFrontBump(int frontLeftBump, int frontRightBump) {
		if (!(frontLeftBump >= frontBumpMin && frontLeftBump <= frontBumpMax
				&& frontRightBump >= frontBumpMin && frontRightBump <= frontBumpMax)) {
			errorList.add("front bump");
		}
	}

	public void validateFrontFastBump(int frontLeftFastBump, int frontRightFastBump) {
		if (!(frontLeftFastBump >= frontFastBumpMin && frontLeftFastBump <= frontFastBumpMax
				&& frontRightFastBump >= frontFastBumpMin && frontRightFastBump <= frontFastBumpMax)) {
			errorList.add("front fast bump");
		}
	}

	public void validateFrontRebound(int frontLeftRebound, int frontRightRebound) {
		if (!(frontLeftRebound >= frontReboundMin && frontLeftRebound <= frontReboundMax
				&& frontRightRebound >= frontReboundMin && frontRightRebound <= frontReboundMax)) {
			errorList.add("front rebound");
		}
	}

	public void validateFrontFastRebound(int frontLeftFastRebound, int frontRightFastRebound) {
		if (!(frontLeftFastRebound >= frontFastReboundMin && frontLeftFastRebound <= frontFastReboundMax
				&& frontRightFastRebound >= frontFastReboundMin && frontRightFastRebound <= frontFastReboundMax)) {
			errorList.add("front fast rebound");
		}
	}

	public void validateRearBump(int rearLeftBump, int rearRightBump) {
		if (!(rearLeftBump >= rearBumpMin && rearLeftBump <= rearBumpMax
				&& rearRightBump >= rearBumpMin && rearRightBump <= rearBumpMax)) {
			errorList.add("rear bump");
		}
	}

	public void validateRearFastBump(int rearLeftFastBump, int rearRightFastBump) {
		if (!(rearLeftFastBump >= rearFastBumpMin && rearLeftFastBump <= rearFastBumpMax
				&& rearRightFastBump >= rearFastBumpMin && rearRightFastBump <= rearFastBumpMax)) {
			errorList.add("rear fast bump");
		}
	}

	public void validateRearRebound(int rearLeftRebound, int rearRightRebound) {
		if (!(rearLeftRebound >= rearReboundMin && rearLeftRebound <= rearReboundMax
				&& rearRightRebound >= rearReboundMin && rearRightRebound <= rearReboundMax)) {
			errorList.add("rear rebound");
		}
	}

	public void validateRearFastRebound(int rearLeftFastRebound, int rearRightFastRebound) {
		if (!(rearLeftFastRebound >= rearFastReboundMin && rearLeftFastRebound <= rearFastReboundMax
				&& rearRightFastRebound >= rearFastReboundMin && rearRightFastRebound <= rearFastReboundMax)) {
			errorList.add("rear fast rebound");
		}
	}

}
