package org.ayty.hatcher.api.v1.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.ayty.hatcher.api.v1.user.dto.RegisterUserDTO;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.junit.jupiter.api.Test;

public class RegisterUserImplTest {
	

	
	
	private  UserRepository repositorio = mock(UserRepository.class);
	
	private RegisterUserImpl registro = new RegisterUserImpl(repositorio);
	
	
	
	
	@Test
	final void saveUserTest() {

		RegisterUserDTO user = new RegisterUserDTO("ruancruz", "ruansenha", "ruan@gmail.com", "ruan cruz soares", "imagee", false, "professor");
		
	
		registro.save(user);
		System.out.println(user);
		
		assertEquals(user.getLogin(), "ruancruz");
		assertEquals(user.getEmail(), "ruan@gmail.com");
		assertEquals(user.getFullName(), "ruan cruz soares");
		assertEquals(user.isAdmin(), false);
	
		
		
		
	
	}
	
	@Test
	void nameincorrectTest() {
		RegisterUserDTO usuario = new RegisterUserDTO("login1452", "pass1452", "ruan@gmail.com", "ruan cruz soares", "imagee", false, "professor");
		System.out.println(usuario);
		
		assertThrows(InvalidData.class, () ->  registro.save(usuario)); 
	}

	

}
