package com.simsetuplab.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setupValidator.ValidateSetup;
import com.simsetuplab.backend.repository.ValidateSetupRepository;

@Service
public class ValidateSetupService {
	private final ValidateSetupRepository validatorRepository;

	@Autowired
	public ValidateSetupService(ValidateSetupRepository validatorRepository) {
		this.validatorRepository = validatorRepository;
	}

	public List<ValidateSetup> getAllValidators() {
		return validatorRepository.findAll();
	}

	public ValidateSetup getValidatorByCarType(CarType carType) {
		return validatorRepository.getValidatorByCarType(carType);
	}

	public ValidateSetup addOrUpdateValidator(ValidateSetup validator) {
		return validatorRepository.save(validator);
	}

	public void deleteValidator(ValidateSetup validator) {
		validatorRepository.delete(validator);
	}
}
