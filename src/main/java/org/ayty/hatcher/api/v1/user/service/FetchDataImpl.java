package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FetchDataImpl implements FetchData{
	
	
	private final LoginImpl login;
	
	public User fetchData(LoginDTO credenciais) {
		User user = User.builder().login(credenciais.getLogin()).password(credenciais.getPassword()).build();				
        UserDetails authenticateUser = login.authenticate(user);
        return user;
	}

}
