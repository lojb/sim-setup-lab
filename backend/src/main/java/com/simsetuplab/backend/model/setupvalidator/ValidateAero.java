package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setup.setupvalues.Aero;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class ValidateAero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private CarType car;
	private int frontRideHeightMin;
	private int frontRideHeightMax;
	private int rearRideHeightMin;
	private int rearRideHeightMax;
	private int splitterMin;
	private int splitterMax;
	private int rearWingMin;
	private int rearWingMax;
	private int frontBrakeDuctsMin;
	private int frontBrakeDuctsMax;
	private int rearBrakeDuctsMin;
	private int rearBrakeDuctsMax;

	public boolean validate(Aero aero) {
		boolean result = true;

		result = result && validateFrontRideHeight(aero.getFrontRideHeight());
		result = result && validateRearRideHeight(aero.getRearRideHeight());
		result = result && validateSplitter(aero.getSplitter());
		result = result && validateRearWing(aero.getRearWing());
		result = result && validateFrontBrakeDucts(aero.getFrontBrakeDucts());
		result = result && validateRearBrakeDucts(aero.getRearBrakeDucts());

		return result;
	}

	private boolean validateFrontRideHeight(int frontRideHeight) {
		return frontRideHeight >= frontRideHeightMin && frontRideHeight <= frontRideHeightMax;
	}

	private boolean validateRearRideHeight(int rearRideHeight) {
		return rearRideHeight >= rearRideHeightMin && rearRideHeight <= rearRideHeightMax;
	}

	private boolean validateSplitter(int splitter) {
		return splitter >= splitterMin && splitter <= splitterMax;
	}

	private boolean validateRearWing(int rearWing) {
		return rearWing >= rearWingMin && rearWing <= rearWingMax;
	}

	private boolean validateFrontBrakeDucts(int frontBrakeDucts) {
		return frontBrakeDucts >= frontBrakeDuctsMin && frontBrakeDucts <= frontBrakeDuctsMax;
	}

	private boolean validateRearBrakeDucts(int rearBrakeDucts) {
		return rearBrakeDucts >= rearBrakeDuctsMin && rearBrakeDucts <= rearBrakeDuctsMax;
	}
}
