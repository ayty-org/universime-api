package org.ayty.hatcher.api.v1.user.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.entity.Profile;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class RemoveUserServiceImplTest {
	@Mock
	private UserRepository repositorio;
	
	
	@InjectMocks
	private RemoveUserServiceImpl RemoveUser;

	@Test
	void DeleteUsertest() {

		User usuario = new User(1L, "ruan", "ruan", "ruan@gmail.com.br", "ruan", "imagee 1", Profile.PROFESSOR);
		when(repositorio.existsById(1L)).thenReturn(true);
		
		assertDoesNotThrow(() -> RemoveUser.removeUser(1L));

	}

	@Test
	public void DeleteUsernonexistentTest() {

		when(repositorio.existsById(10L)).thenReturn(false);

		User usuario = new User(1L, "ruan", "ruan123", "ruan@gmail.com", "ruan", "imagee 1", Profile.ALUNO);
		User usuario2 = new User(2L, "ruan2", "ruan321", "ruan@gmail", "ruan", "imagee 2", Profile.PROFESSOR);
		User usuario3 = new User(3L, "ruan3", "ruan147", "ruan@gmail.com.rb", "ruan", "imagee 3", Profile.PROFESSOR);
		repositorio.save(usuario);
		repositorio.save(usuario2);
		repositorio.save(usuario3);

		assertEquals("ruan3", usuario3.getLogin());
		assertThrows(UsernameNotFoundException.class, () -> RemoveUser.removeUser(10L)); // usuaio nao existente

	}




}