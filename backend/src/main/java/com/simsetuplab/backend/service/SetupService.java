package com.simsetuplab.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simsetuplab.backend.exception.ApiRequestException;
import com.simsetuplab.backend.model.setup.Setup;
import com.simsetuplab.backend.model.setup.SetupDto;
import com.simsetuplab.backend.model.user.User;
import com.simsetuplab.backend.repository.SetupRepository;
import com.simsetuplab.backend.repository.UserRepository;

@Service
public class SetupService {
	private final SetupRepository setupRepository;
	private final UserRepository userRepository;

	@Autowired
	public SetupService(SetupRepository setupRepository, UserRepository userRepository) {
		this.setupRepository = setupRepository;
		this.userRepository = userRepository;
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

	public Setup convertDtoToSetup(SetupDto setupDto) {
		Optional<User> user = userRepository.findUserById(setupDto.getUserId());

		if (user.isPresent()) {
			Setup setup = new Setup(setupDto);
			setup.setUser(user.get());
			return setup;
		} else
			throw new ApiRequestException("User does not exist");
	}
}
