package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.model.Project;

@FunctionalInterface
public interface SaveProjectService {

    void save(Project project);
}
