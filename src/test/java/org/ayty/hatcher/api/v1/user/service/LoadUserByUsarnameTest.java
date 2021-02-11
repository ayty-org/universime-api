package org.ayty.hatcher.api.v1.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.entity.Profile;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
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
		User usuario = new User(2L,"vito", "senha", "ruan@gmail.com", "ruan cruz", "imagee 2", false, Profile.ALUNO);

		when(repositorio.findByLogin("vito")).thenReturn(Optional.of(usuario));
		
		UserDetails userD = load.loadUserByUsername("vito");
		
	
		
		assertEquals("[ROLE_USER]", userD.getAuthorities().toString());
		
		
		
		
	}
	@Test
	void UserRolesTests() {
		User usuario2 = new User(2L,"vito", "senha", "ruan@gmail.com", "ruan cruz", "imagee 2", true, Profile.ALUNO);

		when(repositorio.findByLogin("vito")).thenReturn(Optional.of(usuario2));
		
		UserDetails userD = load.loadUserByUsername("vito");

		
		assertEquals("[ROLE_ADMIN, ROLE_USER]", userD.getAuthorities().toString());
		
		
		
		
	}
	
	
	@Test
	void UserNamenonexistent() {
		
		assertThrows(UsernameNotFoundException.class,() -> load.loadUserByUsername("cleyson"));
	}
	


}