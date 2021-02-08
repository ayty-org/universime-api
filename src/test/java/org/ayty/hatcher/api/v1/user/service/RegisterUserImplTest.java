package org.ayty.hatcher.api.v1.user.service;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.ayty.hatcher.api.v1.user.dto.RegisterUserDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RegisterUserImplTest {
	
	
	UserRepository userBD = Mockito.mock(UserRepository.class);
	
	RegisterUserImpl register = new RegisterUserImpl(userBD);
	
	
	
	@Test
	final void test() {
		
		
		
		//RegisterUserDTO user = new RegisterUserDTO("ruancruz", "ruansenha", "ruan@gmail.com", "ruan cruz soares", "imagee", Perfil.ALUNO, false);
		
	//	User users = new User(1L,"ruancruz", "ruansenha", "ruan@gmail.com", "ruan cruz soares", "imagee", false, Perfil.ALUNO);

		
	//	when(userBD.save(any(User.class))).thenReturn(users);
		
		//User test = register.save(user);
		
		
		//Assertions.assertEquals("ruancruz",test.getLogin());
		
		//verify(userBD,times(1)).save(any(User.class));
		
		
		
	
	}

}
