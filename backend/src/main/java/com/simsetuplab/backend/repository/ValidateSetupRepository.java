package com.simsetuplab.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setupvalidator.ValidateSetup;

public interface ValidateSetupRepository extends JpaRepository<ValidateSetup, Long> {
	ValidateSetup getValidatorByCarType(CarType carType);
}
