package org.ayty.hatcher.api.v1.user.service;






import javax.transaction.Transactional;

import org.ayty.hatcher.api.v1.user.dto.RegisterUserDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.InvalidPasswordException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder encoder;
	
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
	 public UserDetails authenticate( User user ){
	        UserDetails userDetails = loadUserByUsername(user.getLogin());
	        boolean PasswordsMatch= encoder.matches( user.getPassword(), userDetails.getPassword() );

	        if(PasswordsMatch){
	            return userDetails;
	        }

	        throw new InvalidPasswordException();
	    }

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
