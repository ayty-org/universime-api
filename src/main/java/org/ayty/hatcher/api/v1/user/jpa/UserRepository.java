package org.ayty.hatcher.api.v1.user.jpa;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByLogin(String login);
	
	Optional<User> findByPassword(String password);
	boolean existsByLogin(String login);
	boolean existsByPassword(String password);
	boolean existsByEmail(String email);
	void deleteByLogin(String login);

}
