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
@Table(name = "setup_dampers")
@Getter
public class Dampers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Setup setup;
	private int frontLeftBump;
	private int frontRightBump;
	private int frontLeftFastBump;
	private int frontRightFastBump;
	private int frontLeftRebound;
	private int frontRightRebound;
	private int frontLeftFastRebound;
	private int frontRightFastRebound;
	private int rearLeftBump;
	private int rearRightBump;
	private int rearLeftFastBump;
	private int rearRightFastBump;
	private int rearLeftRebound;
	private int rearRightRebound;
	private int rearLeftFastRebound;
	private int rearRightFastRebound;
}
