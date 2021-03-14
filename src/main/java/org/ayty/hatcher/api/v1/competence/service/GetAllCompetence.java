package org.ayty.hatcher.api.v1.competence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllCompetence<T> {
	
	Page<T> getAll(Pageable pageable);
	
}
