package org.ayty.hatcher.api.v1.project.service;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DeleteProjectServiceImpl implements DeleteProjectService{

    private final ProjectRepository projectRepository;

    private final FindProjectByIdServiceImpl findProjectByIdServiceImpl;

    @Override
    public void deleteById(Integer id) {
//        Optional<Project> project = findProjectByIdServiceImpl.findById(id);
        projectRepository.deleteById(id);
    }
}
