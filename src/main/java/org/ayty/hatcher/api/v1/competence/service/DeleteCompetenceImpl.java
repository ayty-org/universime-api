package org.ayty.hatcher.api.v1.competence.service;

import org.ayty.hatcher.api.v1.competence.jpa.CompetenceRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteCompetenceImpl implements DeleteCompetence{

	private final CompetenceRepository repository;
	
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
