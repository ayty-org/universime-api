package org.ayty.hatcher.api.v1.user.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.ayty.hatcher.api.v1.user.entity.Profile;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

class LoginImplTest {

	
	PasswordEncoder passEnc = mock(PasswordEncoder.class);
	LoadUserByUsarname  load = mock(LoadUserByUsarname.class);
	
	private LoginImpl loginImp =  new LoginImpl(passEnc , load, null);

	@Test
	void test() {
		
		String roles ="ADMIN, USER" ;
		User usuario2 = new User(2L,"vito", "senha", "ruan@gmail.com", "ruan cruz", "imagee 2", false, Profile.ALUNO);
		
		UserDetails userD = org.springframework.security.core.userdetails.
				User.builder()
				.username(usuario2.getLogin())
				.password(usuario2.getPassword())
				.roles(roles).build();
		
		
		when(load.loadUserByUsername("vito")).thenReturn(userD);
		
	
		
		System.out.println("-----");
		UserDetails login = loginImp.authenticate(usuario2);
		System.out.println(login.getPassword());
		
		
		
		
		

		
		
	}

}
