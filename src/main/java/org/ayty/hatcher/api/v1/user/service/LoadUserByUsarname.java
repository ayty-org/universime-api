package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPasswordException;
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
		
		User user = userBD.findByLogin(login).orElseThrow(() -> new IncorrectUserOrPasswordException());
		return org.springframework.security.core.userdetails.
				User.builder().username(user.getLogin())
				.password(user.getPassword()).roles("USER").build();
	}
}
