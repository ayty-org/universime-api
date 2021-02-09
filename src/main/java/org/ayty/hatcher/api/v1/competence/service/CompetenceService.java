package org.ayty.hatcher.api.v1.competence.service;

import java.util.List;

import org.ayty.hatcher.api.v1.competence.dto.CompetenceDTO;
import org.ayty.hatcher.api.v1.competence.exception.CompetenceNotFound;
import org.ayty.hatcher.api.v1.competence.jpa.CompetenceRepository;
import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.ayty.hatcher.api.v1.competence.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService {
	
	@Autowired
	CompetenceRepository repository;
	
	public List<Competence> getAll() {
		return repository.findAll();
	}

	public Competence save(CompetenceDTO competenceDto) {
		Competence competence = CompetenceDTO.toCompetence(competenceDto);
		return repository.save(competence);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Competence getById(Integer id) {
		
		Competence competence = repository.findById(id)
				.orElseThrow(() -> new CompetenceNotFound());
		
		return competence;
	}

	public Competence edit(Integer id, CompetenceDTO competenceDto) {
		
		Competence competence = (Competence) repository.findById(id)
				.map(c -> {
						c.setDescription(competenceDto.getDescription());
						c.setName(competenceDto.getName());
						c.setType(Type.valueOf(competenceDto.getType().toUpperCase()));
						return c;
					}).orElseThrow(() -> new CompetenceNotFound());
		
		return repository.save(competence);
	}

}
