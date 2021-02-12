package org.ayty.hatcher.api.v1.user.dto;

import org.ayty.hatcher.api.v1.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutRegisterDTO {
	
	private String login;
	private String email;
	private String fullName;
	
	public OutRegisterDTO(User user) {
		this.login = user.getLogin();
		this.email = user.getEmail();
		this.fullName = user.getFullName();
	}
}
