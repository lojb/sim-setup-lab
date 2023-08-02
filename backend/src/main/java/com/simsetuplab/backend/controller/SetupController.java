package com.simsetuplab.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simsetuplab.backend.model.setup.Setup;
import com.simsetuplab.backend.service.SetupService;

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

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Setup>> getSetupsByUserId(@PathVariable("userId") Long userId) {
		return ResponseEntity.ok(setupService.getSetupsByUserId(userId));
	}

	@PostMapping
	public ResponseEntity<Setup> addSetup(Setup setup) {
		return ResponseEntity.ok(setupService.addOrUpdateSetup(setup));
	}

	@PutMapping
	public ResponseEntity<Setup> updateSetup(Setup setup) {
		return ResponseEntity.ok(setupService.addOrUpdateSetup(setup));
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteSetup(Setup setup) {
		setupService.deleteSetup(setup);
		return ResponseEntity.ok().build();
	}
}
