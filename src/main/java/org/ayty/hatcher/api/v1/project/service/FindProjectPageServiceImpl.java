package org.ayty.hatcher.api.v1.project.service;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.project.dto.ProjectDTO;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProjectPageServiceImpl implements FindProjectPageService {

    private final ProjectRepository projectRepository;

    @Override
    public Page<ProjectDTO> findProjectPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<Project> list = projectRepository.findAll(pageRequest);
        return list.map(obj -> ProjectDTO.from(obj));
    }
}
