package com.simsetuplab.backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simsetuplab.backend.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findUserById(Long id);

	Optional<User> findUserByUsername(String username);

	Optional<User> findUserByEmail(String email);
}
