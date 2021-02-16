package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.dto.ProjectDTO;
import org.springframework.data.domain.Page;

@FunctionalInterface
public interface FindProjectPageService {

    public Page<ProjectDTO> findProjectPage(Integer page, Integer linesPerPage, String orderBy, String direction);
}
