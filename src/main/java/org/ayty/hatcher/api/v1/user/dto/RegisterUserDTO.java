package org.ayty.hatcher.api.v1.user.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.ayty.hatcher.api.v1.user.entity.Perfil;

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
	
	@NotBlank(message = "{field.fullname.mandatory}")
	@Size(min = 3,max = 50)
	private String fullName;
	
	private String image;
	
	@Enumerated(EnumType.STRING)
	private Perfil perfil;
	
	private boolean admin;
	
	


}
