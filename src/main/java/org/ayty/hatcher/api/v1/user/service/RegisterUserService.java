package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.dto.OutRegisterDTO;
import org.ayty.hatcher.api.v1.user.dto.RegisterUserDTO;

@FunctionalInterface
public interface RegisterUserService {
	OutRegisterDTO save(RegisterUserDTO user);
}
