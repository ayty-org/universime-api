package org.ayty.hatcher.api.v1.competence.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Competence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message="O campo nome não pode estar vazio")
	@Size(min=10, max=200, message="O nome deve ter entre 10 e 200 caracteres")
	private String name;
	
	@NotEmpty(message="O campo descrição não pode estar vazio")
	@Size(min=10, max=1000, message="A descrição deve ter entre 10 e 1000 caracteres")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@NotEmpty(message="O campo tipo não pode estar vazio")
	private Type type;
	
	//falta o relacionamento com a entidade Projeto
	
}
