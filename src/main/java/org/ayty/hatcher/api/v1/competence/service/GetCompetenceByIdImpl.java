package org.ayty.hatcher.api.v1.competence.service;

import org.ayty.hatcher.api.v1.competence.exception.CompetenceNotFound;
import org.ayty.hatcher.api.v1.competence.jpa.CompetenceRepository;
import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetCompetenceByIdImpl implements GetCompetenceById{

	private final CompetenceRepository repository;

	@Override
	public Competence getById(Long id) {
		Competence competence = repository.findById(id)
				.orElseThrow(() -> new CompetenceNotFound());
		return competence;
	}

}
