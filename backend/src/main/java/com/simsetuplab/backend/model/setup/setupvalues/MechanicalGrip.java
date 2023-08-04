package com.simsetuplab.backend.model.setup.setupvalues;

import com.simsetuplab.backend.model.setup.Setup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "setup_mechanical_grip")
@Getter
public class MechanicalGrip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Setup setup;
	private int frontAntiRollBar;
	private int rearAntiRollBar;
	private int brakePower = 100;
	private float brakeBias;
	private int steerRatio;
	private int frontWheelRate;
	private int rearWheelRate;
	private int frontBumpstopRate;
	private int rearBumpstopRate;
	private int frontBumpstopRange;
	private int rearBumpstopRange;
	private int preloadDifferential;
}
