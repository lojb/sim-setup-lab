package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.model.setup.setupvalues.Electronics;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "validate_electronics", schema = "public")
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

	@Transient
	List<String> errorList = new ArrayList<>();

	public List<String> validate(Electronics electronics) {
		validateTractionControl(electronics.getTractionControl());
		validateAbs(electronics.getAbs());
		validateEcuMap(electronics.getEcuMap());
		validateTelemetryLaps(electronics.getTelemetryLaps());

		return errorList;
	}

	private void validateTractionControl(int tractionControl) {
		if (!(tractionControl >= tractionControlMin && tractionControl <= tractionControlMax)) {
			errorList.add("traction control");
		}
	}

	private void validateAbs(int abs) {
		if (!(abs >= absMin && abs <= absMax)) {
			errorList.add("ABS");
		}
	}

	private void validateEcuMap(int ecuMap) {
		if (!(ecuMap >= ecuMapMin && ecuMap <= ecuMapMax)) {
			errorList.add("ECU map");
		}
	}

	private void validateTelemetryLaps(int telemetryLaps) {
		if (!(telemetryLaps >= telemetryLapsMin && telemetryLaps <= telemetryLapsMax)) {
			errorList.add("telemetry laps");
		}
	}
}
