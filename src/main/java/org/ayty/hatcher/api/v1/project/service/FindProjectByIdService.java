package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.model.Project;

import java.util.Optional;

@FunctionalInterface
public interface FindProjectByIdService {

    Optional<Project> findById(Long id);
}
