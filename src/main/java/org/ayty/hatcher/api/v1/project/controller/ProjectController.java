package org.ayty.hatcher.api.v1.project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ayty.hatcher.api.v1.project.dto.ProjectDTO;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.service.*;
import org.springframework.data.domain.Page;
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

    private final FindProjectPageService findProjectPageService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> find(@PathVariable Long id) {
        Project project = this.findProjectByIdService.findById(id).get();
        return ResponseEntity.ok().body(project);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> findAll() {
        List<Project> projectList = this.findAllProjectService.findAll();
        return ResponseEntity.ok().body(ProjectDTO.from(projectList));
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<ProjectDTO>> findProjectPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="name") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<ProjectDTO> listDto = findProjectPageService.findProjectPage(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody ProjectDTO projectDTO) {
        Project project = fromDTO(projectDTO);
        project.setId(null);
        this.saveProjectService.save(project);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(project.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable Long id, @RequestBody ProjectDTO projectDTO) {
        Project project = fromDTO(projectDTO);
        project.setId(id);
        updateProjectService.update(project);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteProjectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private Project fromDTO(ProjectDTO projectDTO) {
        return Project.builder()
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .logo(projectDTO.getLogo())
                .startDate(projectDTO.getStartDate())
                .endDate(projectDTO.getEndDate())
                .build();
    }
}
