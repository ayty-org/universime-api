package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@FunctionalInterface
public interface ListUsersService {
	
	Page<User> listOfRegisteredUsers(Pageable pageable);

}
