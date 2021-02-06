package org.ayty.hatcher.api.v1.project.service;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.repository.ProjectRepository;
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
