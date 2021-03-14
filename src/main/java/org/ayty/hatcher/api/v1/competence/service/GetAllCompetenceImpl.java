package org.ayty.hatcher.api.v1.competence.service;

import org.ayty.hatcher.api.v1.competence.jpa.CompetenceRepository;
import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GetAllCompetenceImpl implements GetAllCompetence<Competence> {
	
	private final CompetenceRepository repository;

	@Override
	public Page<Competence> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
		
}
