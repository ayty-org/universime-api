package org.ayty.hatcher.api.v1.user.dto;

import org.ayty.hatcher.api.v1.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutRegisterDTO {
	
	private String login;
	
	private String email;
	
	private String fullName;
	
	private boolean admin;
	
	public OutRegisterDTO(User user) {
		this.login = user.getLogin();
		this.email = user.getEmail();
		this.fullName = user.getFullName();
		this.admin = user.isAdmin();
	}

}
