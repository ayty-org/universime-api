package org.ayty.hatcher.api.v1.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserDTO {
	
	@NotBlank(message = "{field.login.mandatory}")
	private String login;
	
	@NotBlank(message = "{field.password.mandatory}")
	private String password;
	
	@Email(message = "{field.email.invalid}")
	private String email;
	
	private String fullName;
	
	private String image;
	
	private String profile;
	
	private boolean admin;
	
	


}
