package org.ayty.hatcher.api.v1.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.ayty.hatcher.api.v1.security.JwtService;
import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.dto.RegisterUserDTO;
import org.ayty.hatcher.api.v1.user.dto.TokenDTO;
import org.ayty.hatcher.api.v1.user.dto.UserListDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.exception.InvalidPasswordException;
import org.ayty.hatcher.api.v1.user.service.ListUsersImpl;
import org.ayty.hatcher.api.v1.user.service.LoginImpl;
import org.ayty.hatcher.api.v1.user.service.RegisterUserImpl;
import org.ayty.hatcher.api.v1.user.service.RemoveUserImpl;
import org.ayty.hatcher.api.v1.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/hatcher")
public class UserController {


	
	@Autowired
	private LoginImpl loginImpl;
	
	@Autowired
	private RegisterUserImpl registerImpl;
	
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private ListUsersImpl listUserService;
	
	@Autowired
	private RemoveUserImpl removeUserService;
	
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public User registerUser(@RequestBody @Valid RegisterUserDTO user) {
		String EncryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(EncryptedPassword);
				
		return registerImpl.save(user);
	}
	
	@PostMapping("/Authenticate")
    public TokenDTO authenticate(@RequestBody LoginDTO credenciais){
        try{
            User user = User.builder()
                    .login(credenciais.getLogin())
                    .password(credenciais.getPassword())
                    .build();				
            UserDetails authenticateUser = loginImpl.authenticate(user);
            String token = jwtService.generateToken(credenciais);
            return new TokenDTO(user.getLogin(), token);
            
        } catch (UsernameNotFoundException | InvalidPasswordException e ){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
	@RequestMapping(value = "/listUsers", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserListDTO>> ListUsers() {

		return new ResponseEntity<List<UserListDTO>>(listUserService.listOfRegisteredUsers(), HttpStatus.OK);

	}
	@RequestMapping(value = "/remove", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void removeUsers(String login, String senha) {
		try {
			removeUserService.removeUser(login, senha);
		} catch (UsernameNotFoundException e) {
			throw new InvalidData();
		}

	}
	
	
/*
	@Autowired
	private RegisterUserImpl registerUserService;

	@Autowired
	private ListUsersImpl listUserService;

	

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registerUser(@RequestBody RegisterUserDTO userDto, String token) {
		User user = registerUserService.registre(token, userDto);
		try {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}catch(UserAlreadyExists e){
			throw new UserAlreadyExists();
		}
	}

	


*/
}
