package org.ayty.hatcher.api.v1.user.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.ayty.hatcher.api.v1.user.entity.Profile;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class RegisterUserDTO {
	
	
	@NotBlank(message = "field.login.mandatory")
	private String login;	
	@NotBlank(message = "field.password.mandatory")
	private String password;
	@Email(message = "field.email.invalid")
	private String email;
	@Length(min = 3 ,max = 255)
	private String fullName;
	private String image;
	@Enumerated(EnumType.STRING)
	private Profile profile;
	
}
