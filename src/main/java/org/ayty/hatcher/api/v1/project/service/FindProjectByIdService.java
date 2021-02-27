package org.ayty.hatcher.api.v1.project.service;

import java.util.Optional;

import org.ayty.hatcher.api.v1.project.entity.Project;

@FunctionalInterface
public interface FindProjectByIdService {

    Optional<Project> findById(Long id);
}
