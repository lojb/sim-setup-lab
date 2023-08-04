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
				&& validateFrontCamber(tyres.getFrontCamber())
				&& validateRearCamber(tyres.getRearCamber())
				&& validateFrontToe(tyres.getFrontToe())
				&& validateRearToe(tyres.getRearToe())
				&& validateCaster(tyres.getCaster());
	}

	private boolean validateTyrePressure(float tyrePressure) {
		return tyrePressure >= tyrePressureMin && tyrePressure <= tyrePressureMax;
	}

	private boolean validateFrontCamber(float frontCamber) {
		return frontCamber >= frontCamberMin && frontCamber <= frontCamberMax;
	}

	private boolean validateRearCamber(float rearCamber) {
		return rearCamber >= rearCamberMin && rearCamber <= rearCamberMax;
	}

	private boolean validateFrontToe(float frontToe) {
		return frontToe >= frontToeMin && frontToe <= frontToeMax;
	}

	private boolean validateRearToe(float rearToe) {
		return rearToe >= rearToeMin && rearToe <= rearToeMax;
	}

	private boolean validateCaster(float caster) {
		return caster >= casterMin && caster <= casterMax;
	}
}
