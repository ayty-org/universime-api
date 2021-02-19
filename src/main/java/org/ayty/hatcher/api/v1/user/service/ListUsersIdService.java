package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.dto.UpdateUserDTO;

@FunctionalInterface
public interface ListUsersIdService {
	
	UpdateUserDTO listUsersId(Long id);
}
