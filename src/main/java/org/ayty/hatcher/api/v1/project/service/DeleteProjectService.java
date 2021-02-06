package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.repository.ProjectRepository;

@FunctionalInterface
public interface DeleteProjectService {

    void deleteById(Integer id);
}
