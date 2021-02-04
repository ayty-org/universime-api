package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.security.JwtService;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoadUserByUsarname implements UserDetailsService{

	@Autowired
	JwtService jwtService;

	@Autowired
	UserRepository userBD;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userBD.findByLogin(login)
		.orElseThrow(() -> 
		new UsernameNotFoundException("User not found in the database"));
		
		String[] roles = user.isAdmin() ? new String[] {"ADMIN","USER"} : new String[] {"USER"};
		
		return org.springframework.security.core.userdetails.
				User.builder()
				.username(user.getLogin())
				.password(user.getPassword())
				.roles(roles)
				
				.build();
				
	}
	
	

}
