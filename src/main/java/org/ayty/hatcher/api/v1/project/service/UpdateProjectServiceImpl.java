package org.ayty.hatcher.api.v1.project.service;

import lombok.RequiredArgsConstructor;

import org.ayty.hatcher.api.v1.project.entity.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateProjectServiceImpl implements UpdateProjectService {

    private final FindProjectByIdServiceImpl findProjectByIdServiceImpl;

    private final ProjectRepository projectRepository;

    @Override
    public Project update(Project project) {
        Project newProject = findProjectByIdServiceImpl.findById(project.getId()).get();
        updateProjectData(newProject, project);
        return projectRepository.save(newProject);
    }

    private void updateProjectData(Project newProject, Project project) {
        newProject.setId(project.getId());
        newProject.setName(project.getName());
        newProject.setDescription(project.getDescription());
        newProject.setLogo(project.getLogo());
        newProject.setStartDate(project.getStartDate());
        newProject.setEndDate(project.getEndDate());
    }

}
