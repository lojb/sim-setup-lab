package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setup.setupvalues.Electronics;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ValidateElectronics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType car;
	private int tractionControlMin;
	private int tractionControlMax;
	private int absMin;
	private int absMax;
	private int ecuMapMin;
	private int ecuMapMax;
	private int telemetryLapsMin;
	private int telemetryLapsMax;

	public boolean validate(Electronics electronics) {

		return validatetractionControl(electronics.getTractionControl())
				&& validateAbs(electronics.getAbs())
				&& validateEcuMap(electronics.getEcuMap())
				&& validateTelemetryLaps(electronics.getTelemetryLaps());
	}

	private boolean validatetractionControl(int tractionControl) {
		return tractionControl >= tractionControlMin && tractionControl <= tractionControlMax;
	}

	private boolean validateAbs(int abs) {
		return abs >= absMin && abs <= absMax;
	}

	private boolean validateEcuMap(int ecuMap) {
		return ecuMap >= ecuMapMin && ecuMap <= ecuMapMax;
	}

	private boolean validateTelemetryLaps(int telemetryLaps) {
		return telemetryLaps >= telemetryLapsMin && telemetryLaps <= telemetryLapsMax;
	}
}
