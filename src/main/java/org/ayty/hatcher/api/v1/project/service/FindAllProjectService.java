package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.model.Project;

import java.util.List;

@FunctionalInterface
public interface FindAllProjectService {

    List<Project> findAll();
}
