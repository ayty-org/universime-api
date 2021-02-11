package org.ayty.hatcher.api.v1.competence.jpa;

import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

}
