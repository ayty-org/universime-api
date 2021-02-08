package org.ayty.hatcher.api.v1.profile.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.ayty.hatcher.api.v1.profile.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
	
}
