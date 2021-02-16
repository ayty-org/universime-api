package org.ayty.hatcher.api.v1.project.service;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindAllProjectServiceImpl implements FindAllProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return this.projectRepository.findAll();
    }
}
