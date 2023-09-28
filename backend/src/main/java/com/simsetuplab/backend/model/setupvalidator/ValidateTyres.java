package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.setupvalues.Tyres;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateTyres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float tyrePressureMin = 25.0f;
	private float tyrePressureMax = 25.0f;
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

	public boolean validate(Tyres tyres) {
		validateTyrePressure(tyres.getFrontLeftTyrePressure());
		validateTyrePressure(tyres.getFrontRightTyrePressure());
		validateTyrePressure(tyres.getRearLeftTyrePressure());
		validateTyrePressure(tyres.getRearRightTyrePressure());
		validateFrontCamber(tyres.getFrontLeftCamber(), tyres.getFrontRightCamber());
		validateRearCamber(tyres.getRearLeftCamber(), tyres.getRearRightCamber());
		validateFrontToe(tyres.getFrontLeftToe(), tyres.getFrontRightToe());
		validateRearToe(tyres.getRearLeftToe(), tyres.getRearRightToe());
		validateCaster(tyres.getCasterLeft(), tyres.getCasterRight());

		return true;
	}

	private void validateTyrePressure(float tyrePressure) {
		if (!(tyrePressure >= tyrePressureMin && tyrePressure <= tyrePressureMax)) {
			throw new ApiRequestException("Invalid tyre pressure values");
		}
	}

	private void validateFrontCamber(float frontLeftCamber, float frontRightCamber) {
		if (!(frontLeftCamber >= frontCamberMin && frontLeftCamber <= frontCamberMax
				&& frontRightCamber >= frontCamberMin && frontRightCamber <= frontCamberMax)) {
			throw new ApiRequestException("Invalid front camber values");
		}
	}

	private void validateRearCamber(float rearLeftCamber, float rearRightCamber) {
		if (!(rearLeftCamber >= rearCamberMin && rearLeftCamber <= rearCamberMax
				&& rearRightCamber >= rearCamberMin && rearRightCamber <= rearCamberMax)) {
			throw new ApiRequestException("Invalid rear camber values");
		}
	}

	private void validateFrontToe(float frontLeftToe, float frontRightToe) {
		if (!(frontLeftToe >= frontToeMin && frontLeftToe <= frontToeMax
				&& frontRightToe >= frontToeMin && frontRightToe <= frontToeMax)) {
			throw new ApiRequestException("Invalid front toe values");
		}
	}

	private void validateRearToe(float rearLeftToe, float rearRightToe) {
		if (!(rearLeftToe >= rearToeMin && rearLeftToe <= rearToeMax
				&& rearRightToe >= rearToeMin && rearRightToe <= rearToeMax)) {
			throw new ApiRequestException("Invalid rear toe values");
		}
	}

	private void validateCaster(float casterLeft, float casterRight) {
		if (!(casterLeft >= casterMin && casterLeft <= casterMax
				&& casterRight >= casterMin && casterRight <= casterMax)) {
			throw new ApiRequestException("Invalid caster values");
		}
	}
}
