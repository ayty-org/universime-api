package org.ayty.hatcher.api.v1.user.service;

import java.util.Optional;

import org.ayty.hatcher.api.v1.user.dto.UpdateUserDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.exception.InvalidDataException;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetUsersIdServiceImpl implements GetUsersIdService{
	private final UserRepository userDB;

	@Override
	public UpdateUserDTO getUsersId(Long id) {
		Optional<User> user = userDB.findById(id);
		if (user.isPresent()) {
			
			return new UpdateUserDTO(user.get());
		} else {
			throw new InvalidDataException();
		}
	}
	
}

