package com.simsetuplab.backend.model.setupvalidator;

import com.simsetuplab.backend.model.setup.setupvalues.Aero;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

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

	@Transient
	List<String> errorList = new ArrayList<>();

	public List<String> validate(Aero aero) {
		validateFrontRideHeight(aero.getFrontRideHeight());
		validateRearRideHeight(aero.getRearRideHeight());
		validateSplitter(aero.getSplitter());
		validateRearWing(aero.getRearWing());
		validateFrontBrakeDucts(aero.getFrontBrakeDucts());
		validateRearBrakeDucts(aero.getRearBrakeDucts());

		return errorList;
	}

	private void validateFrontRideHeight(int frontRideHeight) {
		if (!(frontRideHeight >= frontRideHeightMin && frontRideHeight <= frontRideHeightMax)) {
			errorList.add("front ride height");
		}
	}

	private void validateRearRideHeight(int rearRideHeight) {
		if (!(rearRideHeight >= rearRideHeightMin && rearRideHeight <= rearRideHeightMax)) {
			errorList.add("rear ride height");
		}
	}

	private void validateSplitter(int splitter) {
		if (!(splitter >= splitterMin && splitter <= splitterMax)) {
			errorList.add("splitter");
		}
	}

	private void validateRearWing(int rearWing) {
		if (!(rearWing >= rearWingMin && rearWing <= rearWingMax)) {
			errorList.add("rear wing");
		}
	}

	private void validateFrontBrakeDucts(int frontBrakeDucts) {
		if (!(frontBrakeDucts >= frontBrakeDuctsMin && frontBrakeDucts <= frontBrakeDuctsMax)) {
			errorList.add("front brake ducts");
		}
	}

	private void validateRearBrakeDucts(int rearBrakeDucts) {
		if (!(rearBrakeDucts >= rearBrakeDuctsMin && rearBrakeDucts <= rearBrakeDuctsMax)) {
			errorList.add("rear brake ducts");
		}
	}
}
