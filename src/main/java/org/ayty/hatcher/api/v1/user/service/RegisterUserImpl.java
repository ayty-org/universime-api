package org.ayty.hatcher.api.v1.user.service;

import javax.transaction.Transactional;

import org.ayty.hatcher.api.v1.user.dto.OutRegisterDTO;
import org.ayty.hatcher.api.v1.user.dto.RegisterUserDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.exception.UserAlreadyExists;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class RegisterUserImpl implements RegisterUser {


	private final UserRepository userBD;
	
	
	
	@Transactional
	public OutRegisterDTO save(RegisterUserDTO user) {
		
		boolean admin = false;
		if(user.isAdmin() ==true) {
			admin = true;
		}


		if(userBD.existsByLogin(user.getLogin())==true){
			throw new UserAlreadyExists();
			
		}
		if(user.getLogin().matches("[a-zA-Z.]*")) {
		
		userBD.save(User.builder()
				.id(null)
				.login(user.getLogin())
				.password(user.getPassword())
				.email(user.getEmail())
				.fullName(user.getFullName())
				.image(user.getImage())
				.perfil(user.getPerfil())
				.admin(admin)
				.build());
		
		return new OutRegisterDTO(User.builder()
				.login(user.getLogin())
				.email(user.getEmail())
				.fullName(user.getFullName())
				.admin(user.isAdmin())
				.build());
		}
		else {
			throw new InvalidData();
		}
	}
}
		
	


