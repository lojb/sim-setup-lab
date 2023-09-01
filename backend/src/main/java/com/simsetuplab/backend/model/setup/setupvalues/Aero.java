package com.simsetuplab.backend.model.setup.setupvalues;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "setup_aero")
@Getter
public class Aero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int frontRideHeight;
	private int rearRideHeight;
	private int splitter;
	private int rearWing;
	private int frontBrakeDucts = 3;
	private int rearBrakeDucts = 3;
}
