package org.ayty.hatcher.api.v1.user.service;

import java.util.List;

import org.ayty.hatcher.api.v1.user.dto.UserListDTO;

@FunctionalInterface
public interface ListUsers {
	
	List<UserListDTO> listOfRegisteredUsers();

}
