package org.ayty.hatcher.api.v1.project.controller;

import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ayty.hatcher.api.v1.project.dto.ProjectDTO;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/projects")
@Slf4j
public class ProjectController {

    private final FindProjectByIdService findProjectByIdService;

    private final FindAllProjectService findAllProjectService;

    private final DeleteProjectService deleteProjectService;

    private final UpdateProjectService updateProjectService;

    private final SaveProjectService saveProjectService;

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

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProjectDTO projectDTO) {
        Project project = fromDTO(projectDTO);
        this.saveProjectService.save(project);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(project.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable Integer id, @RequestBody ProjectDTO projectDTO) {
        Project project = fromDTO(projectDTO);
        project.setId(id);
        updateProjectService.update(project);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        deleteProjectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private Project fromDTO(ProjectDTO projectDTO) {
        return Project.builder()
                .id(projectDTO.getId())
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .logo(projectDTO.getLogo())
                .startDate(projectDTO.getStartDate())
                .endDate(projectDTO.getEndDate())
                .build();
    }
}
