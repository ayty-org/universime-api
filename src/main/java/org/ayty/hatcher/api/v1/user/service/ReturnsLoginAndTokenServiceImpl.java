package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.security.JwtService;
import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.dto.TokenDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReturnsLoginAndTokenServiceImpl implements ReturnsLoginAndTokenService {
	private final GetUserByCredencialsServiceImpl fetch;
	private final JwtService jwtService;	

	
	
	@Override
	public TokenDTO LoginAndToken(LoginDTO credenciais) {
		User user = fetch.fetchData(credenciais);
        String token = jwtService.generateToken(credenciais);
        return new TokenDTO(user.getLogin(), token);
	}

	
}
