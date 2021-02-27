package org.ayty.hatcher.api.v1.user.dto;

import org.ayty.hatcher.api.v1.user.entity.User;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class UserListDTO {
	private Long id;
	private String login;
	private String fullname;
	private String email;
	
	public UserListDTO(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.fullname = user.getFullname();
		this.email = user.getEmail();
	}
	
	
	public static UserListDTO from(User user) {
		return UserListDTO.builder()
		.id(user.getId())
		.login(user.getLogin())
		.email(user.getEmail())
		.fullname(user.getFullname())
		.build();
	}
	
	
	public static Page<UserListDTO> from (Page<User> user){
		return user.map(UserListDTO::from);
	}
}
