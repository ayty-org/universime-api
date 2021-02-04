package org.ayty.hatcher.api.v1.user.service;


import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements Login {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private LoadUserByUsarname load;
	
	public UserDetails authenticate( User user ){
        UserDetails userDetails = load.loadUserByUsername(user.getLogin());
        boolean PasswordsMatch= encoder.matches( user.getPassword(), userDetails.getPassword() );

        if(PasswordsMatch){
            return userDetails;
        }

        throw new InvalidPasswordException();
    }
	
	
	

}
