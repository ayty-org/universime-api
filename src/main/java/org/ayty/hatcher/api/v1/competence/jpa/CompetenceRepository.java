package org.ayty.hatcher.api.v1.competence.jpa;

import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends PagingAndSortingRepository<Competence, Long> {


}
