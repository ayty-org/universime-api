package org.ayty.hatcher.api.v1.competence.service;

import org.ayty.hatcher.api.v1.competence.dto.CompetenceDTO;
import org.ayty.hatcher.api.v1.competence.exception.CompetenceNotFound;
import org.ayty.hatcher.api.v1.competence.jpa.CompetenceRepository;
import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.ayty.hatcher.api.v1.competence.model.Type;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditCompetenceImpl implements EditCompetence {

	private final CompetenceRepository repository;
	
	@Override
	public Competence edit(Long id, CompetenceDTO competenceDto) {
		Competence competence = repository.findById(id)
				.map(c -> {
						c.setDescription(competenceDto.getDescription());
						c.setName(competenceDto.getName());
						c.setType(Type.valueOf(competenceDto.getType().toUpperCase()));
						return c;
					}).orElseThrow(() -> new CompetenceNotFound());
		
		return repository.save(competence);
	}

}
