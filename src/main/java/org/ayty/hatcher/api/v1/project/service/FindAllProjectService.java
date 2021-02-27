package org.ayty.hatcher.api.v1.project.service;

import java.util.List;

import org.ayty.hatcher.api.v1.project.entity.Project;

@FunctionalInterface
public interface FindAllProjectService {

    List<Project> findAll();
}
