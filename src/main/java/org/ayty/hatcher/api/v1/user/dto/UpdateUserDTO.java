package org.ayty.hatcher.api.v1.user.dto;

import org.ayty.hatcher.api.v1.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {
	
	private Long id;
	private String login;
	private String fullname;
	private String email;

	
	public UpdateUserDTO(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.fullname = user.getFullname();
		this.email = user.getEmail();
	}
}
