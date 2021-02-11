package org.ayty.hatcher.api.v1.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.ayty.hatcher.api.v1.user.dto.UserListDTO;
import org.ayty.hatcher.api.v1.user.entity.Profile;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;




class ListUsersImplTest {
	
	@Autowired
	private  UserRepository repositorio = mock(UserRepository.class);
	
	private ListUsersImpl lista = new ListUsersImpl(repositorio);

	@Test
	void ListAllUsers() {
		
		
		
		List<UserListDTO> listaUserDTO = new ArrayList<UserListDTO>();
		List<User> userList  = new ArrayList<User>();
		
		
		User usuario = new User(1L,"ruan", "ruan", "ruan@gmail.com.br", "ruan", "imagee 1", true, Profile.PROFESSOR);
		User usuario2 = new User(2L,"cruz", "senha", "ruan@gmail.com", "ruan cruz", "imagee 2", false, Profile.ALUNO);
		User usuario3 = new User(3L,"ruancruz", "ruansenha", "ruancruz@gmail.com", "ruan cruz soares", "imagee 3", false, Profile.ALUNO);
		userList.add(usuario);
		userList.add(usuario2);
		userList.add(usuario3);
		when(repositorio.findAll()).thenReturn(userList);
		
		listaUserDTO = lista.listOfRegisteredUsers();

		
		assertFalse(listaUserDTO.isEmpty()); 
		
		assertEquals("ruan", listaUserDTO.get(0).getLogin());
		assertEquals("cruz", listaUserDTO.get(1).getLogin());
		assertEquals("ruancruz", listaUserDTO.get(2).getLogin());
		
		
		
	
		
		
		
		
		
	}

}