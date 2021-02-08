package org.ayty.hatcher.api.v1.profile.service;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.service.UpdateProfileImpl;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateProfileTest {
	
	final ProfileRepository repo = mock(ProfileRepository.class);
	final UpdateProfileImpl service = new UpdateProfileImpl(repo);
	
	@Test
	public void updateAUserWithIdEquals3() {
		Profile testeVar = new Profile(3L,"Ola, meu nome é tchau");
		when(repo.findById(3L)).thenReturn(Optional.of(testeVar));
		Profile update = Profile.builder().about("Ola, meu nome e oi").build();
		when(repo.save(any(Profile.class))).thenReturn(update);
		
		Profile testing = service.updateProfile(3L, update);
		
		Assertions.assertEquals("Ola, meu nome e oi", testing.getAbout());
		verify(repo,times(1)).findById(3L);
		verify(repo,times(1)).save(any(Profile.class));
	}
}
