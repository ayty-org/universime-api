package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

@FunctionalInterface
public interface AuthenticateUserService {
	
	UserDetails authenticate( User user );
	
}
