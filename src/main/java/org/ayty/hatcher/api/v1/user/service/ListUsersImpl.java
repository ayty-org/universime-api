package org.ayty.hatcher.api.v1.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.ayty.hatcher.api.v1.user.dto.UserListDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ListUsersImpl implements ListUsers{
	
	@Autowired
	private UserRepository userBD;

	@Override
	public List<UserListDTO> listOfRegisteredUsers() {
		List<User> listUser = userBD.findAll();
		List<UserListDTO>dto = listUser.stream().map(x -> new UserListDTO(x.getLogin(), 
				x.getFullName(), x.getEmail())).collect(Collectors.toList());
		return dto;
		
	}

}
