package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.setupvalues.Tyres;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class ValidateTyres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float tyrePressureMin;
	private float tyrePressureMax;
	private float frontCamberMin;
	private float frontCamberMax;
	private float rearCamberMin;
	private float rearCamberMax;
	private float frontToeMin;
	private float frontToeMax;
	private float rearToeMin;
	private float rearToeMax;
	private float casterMin;
	private float casterMax;

	@Transient
	List<String> errorList = new ArrayList<>();

	public List<String> validate(Tyres tyres) {
		validateTyrePressure(tyres.getFrontLeftTyrePressure());
		validateTyrePressure(tyres.getFrontRightTyrePressure());
		validateTyrePressure(tyres.getRearLeftTyrePressure());
		validateTyrePressure(tyres.getRearRightTyrePressure());
		validateFrontCamber(tyres.getFrontLeftCamber(), tyres.getFrontRightCamber());
		validateRearCamber(tyres.getRearLeftCamber(), tyres.getRearRightCamber());
		validateFrontToe(tyres.getFrontLeftToe(), tyres.getFrontRightToe());
		validateRearToe(tyres.getRearLeftToe(), tyres.getRearRightToe());
		validateCaster(tyres.getCasterLeft(), tyres.getCasterRight());

		return errorList;
	}

	private void validateTyrePressure(float tyrePressure) {
		if (!(tyrePressure >= tyrePressureMin && tyrePressure <= tyrePressureMax)) {
			errorList.add("tyre pressure");
		}
	}

	private void validateFrontCamber(float frontLeftCamber, float frontRightCamber) {
		if (!(frontLeftCamber >= frontCamberMin && frontLeftCamber <= frontCamberMax
				&& frontRightCamber >= frontCamberMin && frontRightCamber <= frontCamberMax)) {
			errorList.add("front camber");
		}
	}

	private void validateRearCamber(float rearLeftCamber, float rearRightCamber) {
		if (!(rearLeftCamber >= rearCamberMin && rearLeftCamber <= rearCamberMax
				&& rearRightCamber >= rearCamberMin && rearRightCamber <= rearCamberMax)) {
			errorList.add("rear camber");
		}
	}

	private void validateFrontToe(float frontLeftToe, float frontRightToe) {
		if (!(frontLeftToe >= frontToeMin && frontLeftToe <= frontToeMax
				&& frontRightToe >= frontToeMin && frontRightToe <= frontToeMax)) {
			errorList.add("front toe");
		}
	}

	private void validateRearToe(float rearLeftToe, float rearRightToe) {
		if (!(rearLeftToe >= rearToeMin && rearLeftToe <= rearToeMax
				&& rearRightToe >= rearToeMin && rearRightToe <= rearToeMax)) {
			errorList.add("rear toe");
		}
	}

	private void validateCaster(float casterLeft, float casterRight) {
		if (!(casterLeft >= casterMin && casterLeft <= casterMax
				&& casterRight >= casterMin && casterRight <= casterMax)) {
			errorList.add("caster");
		}
	}
}
