package com.simsetuplab.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simsetuplab.backend.model.setup.Setup;

public interface SetupRepository extends JpaRepository<Setup, Long> {
	Setup findSetupById(Long id);

	List<Setup> findAllByUserId(Long userId);
}
