package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPasswordException;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFoundException;
import org.ayty.hatcher.api.v1.user.exception.UserDoesNotExistException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
<<<<<<< HEAD:src/main/java/org/ayty/hatcher/api/v1/user/service/LoginImpl.java
public class LoginImpl implements Login/*UserDetailsService*/ {
=======
public class AuthenticateUserServiceImpl implements AuthenticateUserService{
>>>>>>> 99c1be54733d7982261023e81b2988827822cbce:src/main/java/org/ayty/hatcher/api/v1/user/service/AuthenticateUserServiceImpl.java

	private final PasswordEncoder encoder;
	private final UserRepository userDB;
	private final LoadUserByUsarname load;
<<<<<<< HEAD:src/main/java/org/ayty/hatcher/api/v1/user/service/LoginImpl.java
	private final UserRepository userBD;
	//private final UserServiceImpl userService;

	public UserDetails authenticate(User user) {
		System.out.println("user dentro do authenticate "+user.getLogin());

		UserDetails userDetails = load.loadUserByUsername("admin");
=======

	public UserDetails authenticate(User user) {
		
		UserDetails userDetails = load.loadUserByUsername(user.getLogin());
>>>>>>> 99c1be54733d7982261023e81b2988827822cbce:src/main/java/org/ayty/hatcher/api/v1/user/service/AuthenticateUserServiceImpl.java
		
		if (userDetails.getUsername() == null) {
			throw new LoginNotFoundException();
		}
		
		User usuario = userDB.findByLogin(user.getLogin()).orElseThrow(() -> new UserDoesNotExistException());
		boolean PasswordsMatch = encoder.matches(user.getPassword(), userDetails.getPassword());
		
		if (PasswordsMatch) {
			return userDetails;
		} 
		else {
			throw new IncorrectUserOrPasswordException();
		}
	}
<<<<<<< HEAD:src/main/java/org/ayty/hatcher/api/v1/user/service/LoginImpl.java
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
=======
	
	
	
>>>>>>> 99c1be54733d7982261023e81b2988827822cbce:src/main/java/org/ayty/hatcher/api/v1/user/service/AuthenticateUserServiceImpl.java
}

