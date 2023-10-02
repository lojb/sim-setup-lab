package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.setupvalues.Electronics;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class ValidateElectronics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int tractionControlMin;
	private int tractionControlMax;
	private int absMin;
	private int absMax;
	private int ecuMapMin;
	private int ecuMapMax;
	private int telemetryLapsMin;
	private int telemetryLapsMax;

	public boolean validate(Electronics electronics) {
		validateTractionControl(electronics.getTractionControl());
		validateAbs(electronics.getAbs());
		validateEcuMap(electronics.getEcuMap());
		validateTelemetryLaps(electronics.getTelemetryLaps());

		return true;
	}

	private void validateTractionControl(int tractionControl) {
		if (!(tractionControl >= tractionControlMin && tractionControl <= tractionControlMax)) {
			throw new ApiRequestException("Invalid traction control value");
		}
	}

	private void validateAbs(int abs) {
		if (!(abs >= absMin && abs <= absMax)) {
			throw new ApiRequestException("Invalid ABS value");
		}
	}

	private void validateEcuMap(int ecuMap) {
		if (!(ecuMap >= ecuMapMin && ecuMap <= ecuMapMax)) {
			throw new ApiRequestException("Invalid ECU map value");
		}
	}

	private void validateTelemetryLaps(int telemetryLaps) {
		if (!(telemetryLaps >= telemetryLapsMin && telemetryLaps <= telemetryLapsMax)) {
			throw new ApiRequestException("Invalid telemetry laps value");
		}
	}
}
