package org.ayty.hatcher.api.v1.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.entity.Profile;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPasswordException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;


class LoadUserByUsarnameTest {
	
	@Autowired
	private UserRepository repositorio = mock(UserRepository.class);
	
	
	private LoadUserByUsarname load = new LoadUserByUsarname(repositorio);
	
	
	@Test
	void UserAdminRolestest() {
		User usuario = new User(2L,"vito", "senha", "ruan@gmail.com", "ruan cruz", "imagee 2",Profile.ALUNO);

		when(repositorio.findByLogin("vito")).thenReturn(Optional.of(usuario));
		
		UserDetails userD = load.loadUserByUsername("vito");
		
	
		
		assertEquals("[ROLE_USER]", userD.getAuthorities().toString());
		
		
		
		
	}

<<<<<<< HEAD
		
		assertEquals("[ROLE_ADMIN, ROLE_USER]", userD.getAuthorities().toString());	
		
	}
=======
>>>>>>> 99c1be54733d7982261023e81b2988827822cbce
	
	@Test
	void UserNamenonexistent() {

		assertThrows(IncorrectUserOrPasswordException.class,() -> load.loadUserByUsername("cleyson"));
	}

}