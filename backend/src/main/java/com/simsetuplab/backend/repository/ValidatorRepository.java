package com.simsetuplab.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setupvalidator.Validator;

public interface ValidatorRepository extends JpaRepository<Validator, Long> {
	Validator getValidatorByCarType(CarType carType);
}
