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
    public ResponseEntity<List<SetupDto>> getAllSetups() {
        List<Setup> setups = setupService.getAllSetups();

        return ResponseEntity.ok(setupService.mapSetupListToSetupDtoList(setups));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetupDto> getSetupById(@PathVariable("id") Long id) {
        Setup setup = setupService.getSetupById(id);

        return ResponseEntity.ok(setup.convertSetupToDto());
    }

    @GetMapping("/default")
    public ResponseEntity<SetupDto> getDefaultSetup(@RequestParam String track, @RequestParam String car) {
        Setup setup = setupService.getDefaultSetup(track, car);
        return ResponseEntity.ok(setup.convertSetupToDto());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SetupDto>> getSetupsByUserId(@PathVariable("userId") Long userId) {
        List<Setup> setupList = setupService.getSetupsByUserId(userId);

        return ResponseEntity.ok(setupService.mapSetupListToSetupDtoList(setupList));
    }

    @GetMapping("/enums")
    @PermitAll
    public EnumData getEnumData() {
        return setupService.getEnumData();
    }

    @PostMapping
    public ResponseEntity<SetupDto> addSetup(@RequestBody SetupDto setupDto) {
        Setup setup = setupService.addOrUpdateSetup(setupDto);

        return ResponseEntity.ok(setup.convertSetupToDto());
    }

    @PutMapping
    public ResponseEntity<SetupDto> updateSetup(@RequestBody SetupDto setupDto) {
        Setup setup = setupService.addOrUpdateSetup(setupDto);

        return ResponseEntity.ok(setup.convertSetupToDto());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSetup(Setup setup) {
        setupService.deleteSetup(setup);
        return ResponseEntity.ok().build();
    }
}
