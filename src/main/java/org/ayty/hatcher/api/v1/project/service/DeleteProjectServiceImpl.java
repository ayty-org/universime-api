package org.ayty.hatcher.api.v1.project.service;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteProjectServiceImpl implements DeleteProjectService{

    private final ProjectRepository projectRepository;

    @Override
    public void deleteById(Integer id) {
        projectRepository.deleteById(id);
    }
}
