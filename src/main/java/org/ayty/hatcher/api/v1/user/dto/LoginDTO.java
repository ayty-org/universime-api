package org.ayty.hatcher.api.v1.user.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {
	
	
	@NotBlank(message = "{field.login.mandatory}")
	private String login;
	
	@NotBlank(message = "{field.password.mandatory}")
	private String password;

}
