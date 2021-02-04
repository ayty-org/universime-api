package org.ayty.hatcher.api.v1.user.controller;

import java.util.Optional;



import org.ayty.hatcher.api.v1.security.JwtService;
import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.entity.LoginResponse;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPassword;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFound;
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
//import org.ayty.hatcher.api.v1.user.service.RegisterUserImpl;
//import org.ayty.hatcher.api.v1.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/hatcher")
public class LoginController {
	
	
	
	
	
	/*
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	RegisterUserImpl registerUser;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	UserRepository userBD;
	
	@Value("${security.jwt.token.secret-key}")
	private String expiration;

	@Value("${security.jwt.token.expire-length}")
	private String secretKey;
	
	@RequestMapping(value = "/authenticate", consumes=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public LoginResponse LoginAccess(@RequestBody LoginDTO login) {
		Optional<User> authenticatedUser = userBD.findByLogin(login.getLogin());
		
		if(login.getLogin() == null || login.getPassword()==null) {
			throw new LoginNotFound();
		}
		if(authenticatedUser  == null) {
			throw new UsernameNotFoundException();
		}
		if(!authenticatedUser.get().getPassword().equals(login.getPassword())) {
			throw new IncorrectUserOrPassword();
		}
		String token = jwtService.generateToken(login);
		
		return new LoginResponse(token);
		
	}
*/
	
}
