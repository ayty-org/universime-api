package org.ayty.hatcher.api.v1.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.ayty.hatcher.api.v1.user.dto.UserListDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ListUsersImpl implements ListUsers{
	private final UserRepository userBD;

	@Override
	public List<UserListDTO> listOfRegisteredUsers() {
		List<User> listUser = userBD.findAll();
		List<UserListDTO> dto = listUser.stream().map(x -> new UserListDTO(x)).collect(Collectors.toList());
		return dto;
	}
}
