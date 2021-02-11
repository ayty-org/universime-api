package org.ayty.hatcher.api.v1.user.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.entity.Profile;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



class RemoveUserImplTest {
	
	@Autowired
	private  UserRepository repositorio = mock(UserRepository.class);
	@Autowired
	private RemoveUserImpl RemoveUser = new RemoveUserImpl(repositorio);

	@Test
	void DeleteUsertest() {
		
		User usuario = new User(1L,"ruan", "ruan", "ruan@gmail.com.br", "ruan", "imagee 1", true, Profile.PROFESSOR);
		when(repositorio.findById(1L)).thenReturn(Optional.of(usuario));
		
		assertDoesNotThrow(() -> RemoveUser.removeUser(1L));
		
	}
	
	@Test
	public void DeleteUsernonexistentTest() {
		
		when(repositorio.findById(10L)).thenReturn(Optional.empty());
		
		User usuario = new User(1L,"ruan", "ruan123", "ruan@gmail.com", "ruan", "imagee 1", false, Profile.ALUNO);
		User usuario2 = new User(2L,"ruan2", "ruan321", "ruan@gmail", "ruan", "imagee 2", true, Profile.PROFESSOR);
		User usuario3 = new User(3L,"ruan3", "ruan147", "ruan@gmail.com.rb", "ruan", "imagee 3", true, Profile.PROFESSOR);
		repositorio.save(usuario);
		repositorio.save(usuario2);
		repositorio.save(usuario3);
		
		assertEquals("ruan3", usuario3.getLogin());
		assertFalse(usuario.isAdmin());
		assertThrows(InvalidData.class, () -> RemoveUser.removeUser(10L)); //usuaio nao existente
		
		
	}



}