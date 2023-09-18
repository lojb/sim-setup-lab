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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.simsetuplab.backend.model.setup.EnumData;
import com.simsetuplab.backend.model.setup.Setup;
import com.simsetuplab.backend.model.setup.SetupDto;
import com.simsetuplab.backend.service.SetupService;

import jakarta.annotation.security.PermitAll;

@RestController
@RequestMapping(path = "api/v1/setup")
public class SetupController {
	private final SetupService setupService;

	@Autowired
	public SetupController(SetupService setupService) {
		this.setupService = setupService;
	}

	@GetMapping
	public ResponseEntity<List<Setup>> getAllSetups() {
		return ResponseEntity.ok(setupService.getAllSetups());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Setup> getSetupById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(setupService.getSetupById(id));
	}

	@GetMapping("/default")
	public ResponseEntity<Setup> getDefaultSetup(@RequestParam String track, @RequestParam String car) {
		return ResponseEntity.ok(setupService.getDefaultSetup(track, car));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Setup>> getSetupsByUserId(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(setupService.getSetupsByUserId(userId));
	}

	@GetMapping("/enums")
	@PermitAll
	public EnumData getEnumData() {
		return setupService.getEnumData();
	}

	@PostMapping
	public ResponseEntity<Setup> addSetup(@RequestBody SetupDto setupDto) {
		return ResponseEntity.ok(setupService.addOrUpdateSetup(setupDto));
	}

	@PutMapping
	public ResponseEntity<Setup> updateSetup(@RequestBody SetupDto setupDto) {
		return ResponseEntity.ok(setupService.addOrUpdateSetup(setupDto));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteSetup(Setup setup) {
		setupService.deleteSetup(setup);
		return ResponseEntity.ok().build();
	}
}
