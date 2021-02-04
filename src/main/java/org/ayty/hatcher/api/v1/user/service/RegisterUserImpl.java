package org.ayty.hatcher.api.v1.user.service;

import javax.transaction.Transactional;


import org.ayty.hatcher.api.v1.user.dto.RegisterUserDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class RegisterUserImpl implements RegisterUser {

	@Autowired
	private UserRepository userBD;

	
	@Transactional
	public User save(RegisterUserDTO user) {
		
		boolean admin = false;
		if(user.isAdmin() ==true) {
			admin = true;
		}
		return userBD.save(User.builder()
				.login(user.getLogin())
				.password(user.getPassword())
				.email(user.getEmail())
				.fullName(user.getFullName())
				.image(user.getImage())
				.admin(admin)
				.perfil(user.getPerfil())
				.build());
	}
	}






	
	/*

	@Override
	@Transactional
	public User registre(String token, RegisterUserDTO user) {
		
		if(jwtService.validToken(token)==false) {
			throw new InvalidToken();
		}
		if(userBD.existsByLogin(user.getLogin())==true) {
			throw new UserAlreadyExists();
		}
		

		String userToken = jwtService.getUserLogin(token);
		Optional<User> userOpt = userBD.findByLogin(userToken);
		User userImpl = new User();
		if(userOpt.isPresent()&&userOpt.get().isAdmin()) {
			
			userImpl.setLogin(user.getLogin());
			userImpl.setPassword(user.getPassword());
			userImpl.setEmail(user.getEmail());
			userImpl.setFullName(user.getFullName());
			userImpl.setImage(user.getImage());
			userImpl.setPerfil(user.getPerfil());
			
			if(!user.isAdmin()) {
				userImpl.setAdmin(false);
			}
			else {
				userImpl.setAdmin(true);
				
			}
			
		
			userBD.save(userImpl);
		}
		return null;
		
		

	}

}
*/
