package org.ayty.hatcher.api.v1.project.controller;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.project.dto.ProjectDTO;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.service.FindAllProjectService;
import org.ayty.hatcher.api.v1.project.service.FindProjectByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/projects")
public class ProjectController {

    private final FindProjectByIdService findProjectByIdService;

    private final FindAllProjectService findAllProjectService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> find(@PathVariable Integer id) {
        Project project = this.findProjectByIdService.findById(id).get();
        return ResponseEntity.ok().body(project);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll() {
        List<Project> projectList = this.findAllProjectService.findAll();
        return ResponseEntity.ok().body(ProjectDTO.from(projectList));
    }

}
