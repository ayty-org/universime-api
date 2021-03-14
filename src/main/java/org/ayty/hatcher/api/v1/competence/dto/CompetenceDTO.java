package org.ayty.hatcher.api.v1.competence.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.ayty.hatcher.api.v1.competence.model.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CompetenceDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message="O campo nome não pode estar vazio")
	@Size(min=10, max=200, message="O nome deve ter entre 10 e 200 caracteres")
	private String name;
	
	@NotEmpty(message="O campo descrição não pode estar vazio")
	@Size(min=10, max=1000, message="A descrição deve ter entre 10 e 1000 caracteres")
	private String description;
	
	@NotEmpty(message="O campo tipo não pode estar vazio")
	private String type;
	
	public static Competence toCompetence(CompetenceDTO competenceDto) {
		Competence c = Competence.builder()
				.description(competenceDto.getDescription())
				.name(competenceDto.getName())
				.type(Type.valueOf(competenceDto.getType().toUpperCase()))
				.build();
		return c;
	}
	
}
