package org.ayty.hatcher.api.v1.user.dto;

import org.ayty.hatcher.api.v1.user.entity.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class OutRegisterDTO {
	
	private long id;
	private String login;
	private String email;
	private String fullName;
	
	
	public OutRegisterDTO(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.email = user.getEmail();
		this.fullName = user.getFullname();
	}
	
	public static OutRegisterDTO to(User user) {
		return OutRegisterDTO.builder()
		.id(user.getId())
		.login(user.getLogin())
		.email(user.getEmail())
		.fullName(user.getFullname())
		.build();
	}

	
	
}
