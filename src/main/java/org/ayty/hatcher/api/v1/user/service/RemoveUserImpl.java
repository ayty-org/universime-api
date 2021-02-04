package org.ayty.hatcher.api.v1.user.service;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveUserImpl implements RemoveUser{
	
	@Autowired
	private UserRepository userBD;

	@Override
	public void removeUser(String login,String password) {
		Optional<User> userOpt = userBD.findByLogin(login);
		if(!userOpt.isPresent()) {
			throw new UsernameNotFoundException();
		}
		if(userOpt.get().getLogin().equals(login)&&userOpt.get().getPassword().equals(password)) {
			userBD.deleteByLogin(login);
		}

		
	}

}
