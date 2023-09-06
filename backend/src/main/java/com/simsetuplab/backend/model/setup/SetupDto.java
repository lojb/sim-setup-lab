package com.simsetuplab.backend.model.setup;

import com.simsetuplab.backend.model.setup.setupvalues.Aero;
import com.simsetuplab.backend.model.setup.setupvalues.Dampers;
import com.simsetuplab.backend.model.setup.setupvalues.Electronics;
import com.simsetuplab.backend.model.setup.setupvalues.FuelStrategy;
import com.simsetuplab.backend.model.setup.setupvalues.MechanicalGrip;
import com.simsetuplab.backend.model.setup.setupvalues.Tyres;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetupDto {
	private String name;
	private long userId;
	private String carType;
	private String track;
	private Aero aero;
	private Dampers dampers;
	private Electronics electronics;
	private FuelStrategy fuelStrategy;
	private MechanicalGrip mechanicalGrip;
	private Tyres tyres;
}
