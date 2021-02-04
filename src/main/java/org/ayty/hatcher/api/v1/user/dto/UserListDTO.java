package org.ayty.hatcher.api.v1.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserListDTO {
	
	private String login;
	private String nome;
	private String email;
	
	
	

}
