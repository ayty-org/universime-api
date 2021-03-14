package org.ayty.hatcher.api.v1.competence.service;

import org.ayty.hatcher.api.v1.competence.dto.CompetenceDTO;
import org.ayty.hatcher.api.v1.competence.model.Competence;

@FunctionalInterface
public interface EditCompetence {
	
	Competence edit(Long id, CompetenceDTO competenceDto);

}
