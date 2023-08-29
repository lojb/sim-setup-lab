package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
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
	private CarType car;
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
		return validateTyrePressure(tyres.getFrontLeftTyrePressure())
				&& validateTyrePressure(tyres.getFrontRightTyrePressure())
				&& validateTyrePressure(tyres.getRearLeftTyrePressure())
				&& validateTyrePressure(tyres.getRearRightTyrePressure())
				&& validateFrontCamber(tyres.getFrontLeftCamber(), tyres.getFrontRightCamber())
				&& validateRearCamber(tyres.getRearLeftCamber(), tyres.getRearRightCamber())
				&& validateFrontToe(tyres.getFrontLeftToe(), tyres.getFrontRightToe())
				&& validateRearToe(tyres.getRearLeftToe(), tyres.getRearRightToe())
				&& validateCaster(tyres.getCaster());
	}

	private boolean validateTyrePressure(float tyrePressure) {
		return tyrePressure >= tyrePressureMin && tyrePressure <= tyrePressureMax;
	}

	private boolean validateFrontCamber(float frontLeftCamber, float frontRightCamber) {
		return frontLeftCamber >= frontCamberMin && frontLeftCamber <= frontCamberMax
				&& frontRightCamber >= frontCamberMin && frontRightCamber <= frontCamberMax;
	}

	private boolean validateRearCamber(float rearLeftCamber, float rearRightCamber) {
		return rearLeftCamber >= rearCamberMin && rearLeftCamber <= rearCamberMax
				&& rearRightCamber >= rearCamberMin && rearRightCamber <= rearCamberMax;
	}

	private boolean validateFrontToe(float frontLeftToe, float frontRightToe) {
		return frontLeftToe >= frontToeMin && frontLeftToe <= frontToeMax
				&& frontRightToe >= frontToeMin && frontRightToe <= frontToeMax;
	}

	private boolean validateRearToe(float rearLeftToe, float rearRightToe) {
		return rearLeftToe >= rearToeMin && rearLeftToe <= rearToeMax
				&& rearRightToe >= rearToeMin && rearRightToe <= rearToeMax;
	}

	private boolean validateCaster(float caster) {
		return caster >= casterMin && caster <= casterMax;
	}
}
