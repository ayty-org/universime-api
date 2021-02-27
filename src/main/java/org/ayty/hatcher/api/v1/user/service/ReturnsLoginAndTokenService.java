package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.dto.TokenDTO;

@FunctionalInterface
public interface ReturnsLoginAndTokenService {
	TokenDTO LoginAndToken(LoginDTO credenciais);
}
