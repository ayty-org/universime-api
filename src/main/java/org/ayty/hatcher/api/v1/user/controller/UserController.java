package org.ayty.hatcher.api.v1.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.ayty.hatcher.api.v1.security.JwtService;
import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.dto.OutRegisterDTO;
import org.ayty.hatcher.api.v1.user.dto.RegisterUserDTO;
import org.ayty.hatcher.api.v1.user.dto.TokenDTO;
import org.ayty.hatcher.api.v1.user.dto.UserListDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPassword;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFound;
import org.ayty.hatcher.api.v1.user.exception.UserAlreadyExists;
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.ayty.hatcher.api.v1.user.service.ListUsersImpl;
import org.ayty.hatcher.api.v1.user.service.LoginImpl;
import org.ayty.hatcher.api.v1.user.service.RegisterUserImpl;
import org.ayty.hatcher.api.v1.user.service.RemoveUserImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hatcher")
public class UserController {
	
	private final LoginImpl loginImpl;
	private final RegisterUserImpl registerImpl;	
	private final PasswordEncoder passwordEncoder;	
	private final JwtService jwtService;	
	private final ListUsersImpl listUserService;	
	private final RemoveUserImpl removeUserService;	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public OutRegisterDTO registerUser(@Valid  @RequestBody RegisterUserDTO user) {
		String EncryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(EncryptedPassword);
		try {
			return registerImpl.save(user);
		}
		catch(UserAlreadyExists e) {
			throw new UserAlreadyExists();
		}
		catch(InvalidData e) {
			throw new InvalidData();
		}
	}
	@PostMapping("/auth")
	@ResponseStatus(HttpStatus.ACCEPTED)
    public TokenDTO authenticate(@Valid  @RequestBody LoginDTO credenciais){
        try{
            User user = User.builder().login(credenciais.getLogin()).password(credenciais.getPassword()).build();				
            UserDetails authenticateUser = loginImpl.authenticate(user);
            String token = jwtService.generateToken(credenciais);
            return new TokenDTO(user.getLogin(), token);   
        } catch (IncorrectUserOrPassword e){
            throw new IncorrectUserOrPassword();
        }
        catch(LoginNotFound e) {
        	throw new LoginNotFound();
        }
    }
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public List<UserListDTO> ListUsers() {
		return listUserService.listOfRegisteredUsers();
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void removeUsers(@PathVariable  Long id) {
		try {
			removeUserService.removeUser(id);
		} catch (UsernameNotFoundException e) {
			throw new InvalidData();
		}
	}
}
