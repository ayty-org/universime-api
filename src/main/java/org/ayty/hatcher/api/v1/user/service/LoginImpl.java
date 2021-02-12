package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.entity.User;

import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPassword;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFound;
import org.ayty.hatcher.api.v1.user.exception.UserDoesNotExist;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginImpl implements Login/*UserDetailsService*/ {

	private final PasswordEncoder encoder;
	private final LoadUserByUsarname load;
	private final UserRepository userBD;
	//private final UserServiceImpl userService;

	public UserDetails authenticate(User user) {
		System.out.println("user dentro do authenticate "+user.getLogin());

		UserDetails userDetails = load.loadUserByUsername("admin");
		
		if (userDetails.getUsername() == null) {
			throw new LoginNotFound();
		}
		
		User usuario = userBD.findByLogin(user.getLogin()).orElseThrow(() -> new UserDoesNotExist());
		boolean PasswordsMatch = encoder.matches(user.getPassword(), userDetails.getPassword());
		if (PasswordsMatch) {
			return userDetails;
		} else {
			throw new IncorrectUserOrPassword();
		}
	}
/*
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		System.out.println("dentro do loadUser da classe loginImpl "+login);
		System.out.println(userBD.findByLogin(login));
		
		User user = userBD.findByLogin(login).orElseThrow(() -> new LoginNotFound());
		String[] roles = user.isAdmin() ? new String[] {"ADMIN","USER"} : new String[] {"USER"};		
		
		System.out.println("antes do User builder "+login);
		
		return org.springframework.security.core.userdetails.
				
				User.builder()
				.username(user.getLogin())
				.password(user.getLogin())
				.roles(roles)
				.build();
	}
	*/
}
