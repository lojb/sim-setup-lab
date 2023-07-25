package com.simsetuplab.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simsetuplab.backend.model.setup.Setup;
import com.simsetuplab.backend.repository.SetupRepository;

@Service
public class SetupService {
	private final SetupRepository setupRepository;

	@Autowired
	public SetupService(SetupRepository setupRepository) {
		this.setupRepository = setupRepository;
	}

	public List<Setup> getAllSetups() {
		return setupRepository.findAll();
	}

	public Setup getSetupById(Long id) {
		return setupRepository.findSetupById(id);
	}

	public List<Setup> getSetupsByUserId(Long id) {
		return setupRepository.findAllByUserId(id);
	}

	public Setup addOrUpdateSetup(Setup setup) {
		return setupRepository.save(setup);
	}

	public void deleteSetup(Setup setup) {
		setupRepository.delete(setup);
	}

}
