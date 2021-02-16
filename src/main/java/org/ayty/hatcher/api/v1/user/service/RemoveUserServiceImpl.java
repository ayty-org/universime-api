package org.ayty.hatcher.api.v1.user.service;

import org.ayty.hatcher.api.v1.user.exception.UsernameNotFoundException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RemoveUserServiceImpl implements RemoveUserService {
	private final UserRepository userBD;

	@Override
	public void removeUser(Long id) {
		
		if (userBD.existsById(id)==true) {
			userBD.deleteById(id);
		}
		else {
			throw new UsernameNotFoundException();
		}
	}
}
