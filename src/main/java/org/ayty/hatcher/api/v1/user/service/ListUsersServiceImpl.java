package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ListUsersServiceImpl implements ListUsersService{
	private final UserRepository userBD;

	@Override
	public Page<User> listOfRegisteredUsers(Pageable pageable) {
		return userBD.findAll(pageable);
	}

	
	
}
