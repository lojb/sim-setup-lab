package com.simsetuplab.backend.model.setup.setupvalues;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "setup_tyres", schema = "public")
@Getter
public class Tyres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float frontLeftTyrePressure = 25.0f;
	private float frontRightTyrePressure = 25.0f;
	private float rearLeftTyrePressure = 25.0f;
	private float rearRightTyrePressure = 25.0f;

	private float frontLeftCamber;
	private float frontRightCamber;
	private float rearLeftCamber;
	private float rearRightCamber;

	private float frontLeftToe;
	private float frontRightToe;
	private float rearLeftToe;
	private float rearRightToe;

	private float casterLeft;
	private float casterRight;
}
