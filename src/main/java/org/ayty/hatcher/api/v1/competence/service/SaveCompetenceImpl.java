package org.ayty.hatcher.api.v1.competence.service;

import org.ayty.hatcher.api.v1.competence.dto.CompetenceDTO;
import org.ayty.hatcher.api.v1.competence.jpa.CompetenceRepository;
import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SaveCompetenceImpl implements SaveCompetence{

	private final CompetenceRepository repository;
	
	@Override
	public Competence save(CompetenceDTO competenceDto) {
		Competence competence = CompetenceDTO.toCompetence(competenceDto);
		return repository.save(competence);
	}

}
