package org.ayty.hatcher.api.v1.profile.service;

import java.util.Optional;

import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.exception.NotFoundException;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateProfileImpl implements UpdateProfile{
	
	final private ProfileRepository repo;
	
	
	
	@Override
	public Profile updateProfile(long id, Profile newProfile) {
		Optional<Profile> found = repo.findById(id);
		if(found.isPresent()){
			Profile uptodate = found.get();
			uptodate.setAbout(newProfile.getAbout());
			//uptodate.setCurso(newProfile.getCurso());
			//uptodate.setProject(newProfile.getProjects());
			return repo.save(uptodate);
		}else {
			throw new NotFoundException("Perfil Não Encontrado");
		}
		
	}
	
}
