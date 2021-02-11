package org.ayty.hatcher.api.v1.project.jpa;

import org.ayty.hatcher.api.v1.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
