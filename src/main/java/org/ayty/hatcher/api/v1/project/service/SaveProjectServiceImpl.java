package org.ayty.hatcher.api.v1.project.service;

import lombok.RequiredArgsConstructor;

import org.ayty.hatcher.api.v1.project.entity.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProjectServiceImpl implements SaveProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public void save(Project project) {
    	
        project.setId(null);
        this.projectRepository.save(project);
    }
}
