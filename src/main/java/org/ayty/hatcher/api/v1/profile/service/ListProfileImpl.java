package org.ayty.hatcher.api.v1.profile.service;

import java.util.List;

import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListProfileImpl implements ListProfile {
	
	final private ProfileRepository repo;
	
	@Override
	public List<Profile> findAll() {
		return repo.findAll();
	}

	
}
