package com.simsetuplab.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simsetuplab.backend.enumeration.carsetup.CarType;
import com.simsetuplab.backend.model.setupvalidator.ValidateSetup;
import com.simsetuplab.backend.service.ValidatorService;

@RestController
@RequestMapping(path = "api/v1/setup")
public class ValidateSetupController {
	private final ValidatorService validatorService;

	@Autowired
	public ValidateSetupController(ValidatorService validatorService) {
		this.validatorService = validatorService;
	}

	@GetMapping("/{carType}")
	public ResponseEntity<ValidateSetup> getValidatorByCarType(@PathVariable("carType") String carTypeString) {
		CarType carType = CarType.valueOf(carTypeString);
		return ResponseEntity.ok(validatorService.getValidatorByCarType(carType));
	}

	@PostMapping
	public ResponseEntity<ValidateSetup> addValidator(@RequestBody ValidateSetup validateSetup) {
		return ResponseEntity.ok(validatorService.addOrUpdateValidator(validateSetup));
	}

	@PutMapping
	public ResponseEntity<ValidateSetup> updateSetup(ValidateSetup validateSetup) {
		return ResponseEntity.ok(validatorService.addOrUpdateValidator(validateSetup));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteSetup(ValidateSetup validator) {
		validatorService.deleteValidator(validator);
		return ResponseEntity.ok().build();
	}
}
