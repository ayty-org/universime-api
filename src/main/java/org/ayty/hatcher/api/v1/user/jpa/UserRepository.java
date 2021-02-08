package org.ayty.hatcher.api.v1.user.jpa;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByLogin(String login);
	boolean existsByLogin(String login);
	boolean existsByPassword(String password);
	void deleteByLogin(String login);
	
	

}
