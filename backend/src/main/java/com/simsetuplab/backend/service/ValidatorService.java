package com.simsetuplab.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setupvalidator.Validator;
import com.simsetuplab.backend.repository.ValidatorRepository;

@Service
public class ValidatorService {
	private final ValidatorRepository validatorRepository;

	@Autowired
	public ValidatorService(ValidatorRepository validatorRepository) {
		this.validatorRepository = validatorRepository;
	}

	public List<Validator> getAllValidators() {
		return validatorRepository.findAll();
	}

	public Validator getValidatorByCarType(CarType carType) {
		return validatorRepository.getValidatorByCarType(carType);
	}

	public Validator addOrUpdateValidator(Validator validator) {
		return validatorRepository.save(validator);
	}

	public void deleteValidator(Validator validator) {
		validatorRepository.delete(validator);
	}
}
