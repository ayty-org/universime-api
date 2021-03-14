package org.ayty.hatcher.api.v1.competence.service;

import org.ayty.hatcher.api.v1.competence.model.Competence;

@FunctionalInterface
public interface GetCompetenceById {

	Competence getById(Long id);
	
}
