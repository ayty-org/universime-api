package org.ayty.hatcher.api.v1.profile.service;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.service.SaveProfileImpl;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;
import org.ayty.hatcher.api.v1.profile.exception.NotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaveProfileTest {
	
	final ProfileRepository repo = mock(ProfileRepository.class);
	final SaveProfileImpl service = new SaveProfileImpl(repo);
	
	
	@Test
	public void saveProfileWithIdEquals3() {
		Profile testeVar = new Profile(3L,"Ola, meu nome é tchau");
		when(repo.findById(3L)).thenReturn(Optional.of(testeVar));
		when(repo.save(any(Profile.class))).thenReturn(testeVar);
		
		Profile testing = service.saveProfile(testeVar);
		
		Assertions.assertEquals("Ola, meu nome é tchau", testing.getAbout());
		verify(repo,times(1)).findById(any(Long.class));
		verify(repo,times(1)).save(any(Profile.class));
		
	}
	
}
