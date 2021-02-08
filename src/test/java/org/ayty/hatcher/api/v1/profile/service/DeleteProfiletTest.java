package org.ayty.hatcher.api.v1.profile.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.exception.NotFoundException;
import org.ayty.hatcher.api.v1.profile.jpa.ProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DeleteProfiletTest {
	
	final ProfileRepository repo = mock(ProfileRepository.class);
	final DeleteProfileImpl service = new DeleteProfileImpl(repo);
	
	@Test
	public void DeleteProfileNotThrows() {
		Profile testeVar = new Profile(1L,"Ola, meu nome é tchau");
		when(repo.findById(1L)).thenReturn(Optional.of(testeVar));
		Assertions.assertDoesNotThrow(() -> service.deleteProfile(1L));
	}
	
	@Test
	public void DeleteProfileThrowsException() {
		when(repo.findById(1L)).thenReturn(Optional.empty());
		Assertions.assertThrows(NotFoundException.class, () -> service.deleteProfile(1L));
	}

}
