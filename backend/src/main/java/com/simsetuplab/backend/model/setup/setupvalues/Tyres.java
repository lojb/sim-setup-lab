package com.simsetuplab.backend.model.setup.setupvalues;

import com.simsetuplab.backend.model.setup.Setup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "setup_tyres")
public class Tyres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Setup setup;
	private float frontLeftTyrePressure = 25.0f;
	private float frontRightTyrePressure = 25.0f;
	private float rearLeftTyrePressure = 25.0f;
	private float rearRightTyrePressure = 25.0f;
	private float frontCamber;
	private float rearCamber;
	private float frontToe;
	private float rearToe;
	private float caster;
}
