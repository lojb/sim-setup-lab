package com.simsetuplab.backend.model.setup.setupvalues;

import com.simsetuplab.backend.model.setup.Setup;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "setup_dampers")
public class Dampers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Setup setup;
	private int frontBump;
	private int frontFastBump;
	private int frontRebound;
	private int frontFastRebound;
	private int rearBump;
	private int rearFastBump;
	private int rearRebound;
	private int rearFastRebound;
}
