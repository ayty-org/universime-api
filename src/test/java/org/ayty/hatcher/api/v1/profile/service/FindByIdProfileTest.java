package org.ayty.hatcher.api.v1.profile.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import java.util.Optional;



import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.service.FindByIdProfileImpl;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindByIdProfileTest {
	
	final ProfileRepository repo = mock(ProfileRepository.class);
	final FindByIdProfileImpl service = new FindByIdProfileImpl(repo);
	
	@Test
	public void findByIdReturnAProfile() {
		Profile testeVar = new Profile(1L,"Ola, meu nome é tchau");
		when(repo.findById(1L)).thenReturn(Optional.of(testeVar));
		
		Profile testing = service.findById(1L);
		
		Assertions.assertEquals("Ola, meu nome é tchau",testing.getAbout());
		verify(repo,times(1)).findById(any(Long.class));
		
	}
}
