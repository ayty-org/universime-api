package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.entity.LoginResponse;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

@FunctionalInterface
public interface Login {
	
	UserDetails authenticate( User user );

}
