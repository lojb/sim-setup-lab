package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.exception.ApiRequestException;
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
		validateFrontRideHeight(aero.getFrontRideHeight());
		validateRearRideHeight(aero.getRearRideHeight());
		validateSplitter(aero.getSplitter());
		validateRearWing(aero.getRearWing());
		validateFrontBrakeDucts(aero.getFrontBrakeDucts());
		validateRearBrakeDucts(aero.getRearBrakeDucts());

		return true;
	}

	private void validateFrontRideHeight(int frontRideHeight) {
		if (!(frontRideHeight >= frontRideHeightMin && frontRideHeight <= frontRideHeightMax)) {
			throw new ApiRequestException("Invalid front ride height value");
		}
	}

	private void validateRearRideHeight(int rearRideHeight) {
		if (!(rearRideHeight >= rearRideHeightMin && rearRideHeight <= rearRideHeightMax)) {
			throw new ApiRequestException("Invalid rear ride height Value");
		}
	}

	private void validateSplitter(int splitter) {
		if (!(splitter >= splitterMin && splitter <= splitterMax)) {
			throw new ApiRequestException("Invalid splitter value");
		}
	}

	private void validateRearWing(int rearWing) {
		if (!(rearWing >= rearWingMin && rearWing <= rearWingMax)) {
			throw new ApiRequestException("Invalid rear wing value");
		}
	}

	private void validateFrontBrakeDucts(int frontBrakeDucts) {
		if (!(frontBrakeDucts >= frontBrakeDuctsMin && frontBrakeDucts <= frontBrakeDuctsMax)) {
			throw new ApiRequestException("Invalid front brake ducts value");
		}
	}

	private void validateRearBrakeDucts(int rearBrakeDucts) {
		if (!(rearBrakeDucts >= rearBrakeDuctsMin && rearBrakeDucts <= rearBrakeDuctsMax)) {
			throw new ApiRequestException("Invalid rear brake ducts value");
		}
	}
}
