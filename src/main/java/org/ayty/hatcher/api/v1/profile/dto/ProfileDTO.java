package org.ayty.hatcher.api.v1.profile.dto;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProfileDTO {
	@NotBlank()
	private long id;
	//private Course course;
	@NotBlank(message = "Campo deve ter no minimo 10")
	@Size(min=10,max=1000)
	private String about;
	//private Project project;
	
	
}
