package com.aarthi.careerassistant.repository;
import java.util.Optional;
import com.aarthi.careerassistant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
}