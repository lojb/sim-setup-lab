package com.simsetuplab.backend.controller;

import java.util.List;
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
import com.simsetuplab.backend.model.setupValidator.ValidateSetup;
import com.simsetuplab.backend.service.ValidateSetupService;

@RestController
@RequestMapping(path = "api/v1/validatesetup")
public class ValidateSetupController {
	private final ValidateSetupService validatorService;

	@Autowired
	public ValidateSetupController(ValidateSetupService validatorService) {
		this.validatorService = validatorService;
	}

	@GetMapping
	public ResponseEntity<List<ValidateSetup>> getAllValidators() {
		return ResponseEntity.ok(validatorService.getAllValidators());
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
	public ResponseEntity<ValidateSetup> updateValidator(@RequestBody ValidateSetup validateSetup) {
		return ResponseEntity.ok(validatorService.addOrUpdateValidator(validateSetup));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteValidator(ValidateSetup validator) {
		validatorService.deleteValidator(validator);
		return ResponseEntity.ok().build();
	}
}
