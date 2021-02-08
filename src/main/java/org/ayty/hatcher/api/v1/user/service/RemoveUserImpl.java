package org.ayty.hatcher.api.v1.user.service;

import java.util.Optional;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.InvalidData;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RemoveUserImpl implements RemoveUser {

	private final UserRepository userBD;

	@Override
	public void removeUser(Long id) {
		Optional<User> user = userBD.findById(id);
		if (user.isPresent()) {
			userBD.delete(user.get());
		} else {
			throw new InvalidData();
		}

	}

}
