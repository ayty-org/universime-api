package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.entity.User;

@FunctionalInterface
public interface GetUserByCredencialsService {
	
	User fetchData(LoginDTO credenciais);

}
