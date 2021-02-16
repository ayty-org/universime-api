package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.dto.TokenDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPasswordException;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFoundException;
import org.ayty.hatcher.api.v1.user.exception.UserDoesNotExistException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticateUserServiceImpl implements AuthenticateUserService{

	private final PasswordEncoder encoder;
	private final UserRepository userBD;
	private final LoadUserByUsarname load;

	public UserDetails authenticate(User user) {
		
		UserDetails userDetails = load.loadUserByUsername(user.getLogin());
		
		if (userDetails.getUsername() == null) {
			throw new LoginNotFoundException();
		}
		User usuario = userBD.findByLogin(user.getLogin()).orElseThrow(() -> new UserDoesNotExistException());
		boolean PasswordsMatch = encoder.matches(user.getPassword(), userDetails.getPassword());
		
		if (PasswordsMatch) {
			return userDetails;
		} else {
			throw new IncorrectUserOrPasswordException();
		}
	}
	
	
	
}

