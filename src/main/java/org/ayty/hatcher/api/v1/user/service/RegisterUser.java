package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.entity.User;

import org.ayty.hatcher.api.v1.user.dto.*;

@FunctionalInterface
public interface RegisterUser {
	
	//User registre (String token,RegisterUserDTO user);
	
	User save(RegisterUserDTO user);
		
	

}
