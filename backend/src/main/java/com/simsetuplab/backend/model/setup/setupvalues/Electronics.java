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
@Table(name = "setup_electronics")
@Getter
public class Electronics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private Setup setup;
	private int tractionControl;
	private int abs;
	private int ecuMap;
	private int telemetryLaps;
}
