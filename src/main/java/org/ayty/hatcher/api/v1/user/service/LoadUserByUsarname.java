package org.ayty.hatcher.api.v1.user.service;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.entity.User;
<<<<<<< HEAD
=======
import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPasswordException;
>>>>>>> 99c1be54733d7982261023e81b2988827822cbce
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoadUserByUsarname implements UserDetailsService {
	
	private final UserRepository userBD;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
<<<<<<< HEAD
		
		
	
		
		System.out.println("primeira viagem  "+login);
		
		
		
		Optional<User> user = userBD.findByLogin("admin");
				System.out.println("Segunda viagem  "+login);
			//	.orElseThrow(() -> new IncorrectUserOrPassword());
		//String[] roles = user.isAdmin() ? new String[] { "ADMIN", "USER" } : new String[] { "USER" };
				System.out.println("terceira viagem  "+login);

		return org.springframework.security.core.userdetails.
				User.builder().username(user.get().getLogin())
				.password("$2y$04$Hexn6JOpJn8ohHTdX0zJdODijX1ks6JmjUqlgJYJiAuV9KatL3aqS")
					.roles("ADMIN").build();
		
=======
		User user = userBD.findByLogin(login).orElseThrow(() -> new IncorrectUserOrPasswordException());
		return org.springframework.security.core.userdetails.
				User.builder().username(user.getLogin())
				.password(user.getPassword()).roles("USER").build();
	}
>>>>>>> 99c1be54733d7982261023e81b2988827822cbce
}
}

