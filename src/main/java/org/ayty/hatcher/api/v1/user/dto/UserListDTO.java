package org.ayty.hatcher.api.v1.user.dto;

import org.ayty.hatcher.api.v1.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserListDTO {
	private String login;
	private String fullname;
	private String email;
	
	public UserListDTO(User user) {
		this.login = user.getLogin();
		this.fullname = user.getFullName();
		this.email = user.getEmail();
	}
}
