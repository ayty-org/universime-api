package org.ayty.hatcher.api.v1.profile.service;


import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveProfileImpl implements SaveProfile {
	
	final private ProfileRepository repo;
	
	@Override
	public Profile saveProfile(Profile profile) {
		return repo.save(profile);
	}
}
