package org.ayty.hatcher.api.v1.profile.service;

import java.util.Optional;

import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.exception.NotFoundException;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteProfileImpl implements DeleteProfile {
	
	final private ProfileRepository repo;
	
	
	@Override
	public void deleteProfile(long id) {
		Optional<Profile> found = repo.findById(id);
		if(found.isPresent()){
			repo.delete(found.get());
		}else {
			throw new NotFoundException("Perfil Não Encontrado");
		}
		
	}
	
	
}
