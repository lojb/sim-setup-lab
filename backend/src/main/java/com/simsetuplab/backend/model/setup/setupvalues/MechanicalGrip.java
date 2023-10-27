package com.simsetuplab.backend.model.setup.setupvalues;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "setup_mechanical_grip", schema = "public")
@Getter
public class MechanicalGrip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int frontAntiRollBar;
	private int brakePower = 100;
	private float brakeBias;
	private int steerRatio;

	private int frontLeftWheelRate;
	private int frontRightWheelRate;
	private int rearLeftWheelRate;
	private int rearRightWheelRate;

	private int frontLeftBumpstopRate;
	private int frontRightBumpstopRate;
	private int rearLeftBumpstopRate;
	private int rearRightBumpstopRate;

	private int frontLeftBumpstopRange;
	private int frontRightBumpstopRange;
	private int rearLeftBumpstopRange;
	private int rearRightBumpstopRange;

	private int rearAntiRollBar;
	private int preloadDifferential;
}
