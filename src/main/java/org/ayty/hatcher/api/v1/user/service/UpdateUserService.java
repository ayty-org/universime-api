package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.dto.UpdateUserDTO;
import org.ayty.hatcher.api.v1.user.entity.User;

@FunctionalInterface
public interface UpdateUserService {

	UpdateUserDTO updateUser(Long id, User user);
}