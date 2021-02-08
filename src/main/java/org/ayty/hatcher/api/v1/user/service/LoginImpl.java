package org.ayty.hatcher.api.v1.user.service;


import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.IncorrectUserOrPassword;
import org.ayty.hatcher.api.v1.user.exception.LoginNotFound;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginImpl implements Login {

	
	private final PasswordEncoder encoder;
	
	
	private final LoadUserByUsarname load;
	
	
	
	public UserDetails authenticate( User user ){
        UserDetails userDetails = load.loadUserByUsername(user.getLogin());
       
        if(userDetails.getUsername()== null ){
        	throw new LoginNotFound();
        }

        boolean PasswordsMatch = encoder.matches(user.getPassword(),userDetails.getPassword() );

        if(PasswordsMatch){
            return userDetails;
        }
        throw new IncorrectUserOrPassword();
    }
	
	
	

}
