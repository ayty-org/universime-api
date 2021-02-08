package org.ayty.hatcher.api.v1.profile.service;

import java.util.Optional;

import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.exception.NotFoundException;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindByIdProfileImpl implements FindByIdProfile{
	
	final private ProfileRepository repo;
	

	@Override
	public Profile findById(long id) {
		Optional<Profile> found = repo.findById(id);
		if(!found.isPresent()) {
			throw new NotFoundException("Perfil Não Encontrado");
		}
		return found.get();
	}
	
	
}
