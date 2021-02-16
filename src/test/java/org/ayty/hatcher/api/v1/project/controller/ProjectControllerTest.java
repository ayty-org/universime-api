package org.ayty.hatcher.api.v1.project.controller;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.exception.ProjectNotFoundException;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.ayty.hatcher.api.v1.project.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindAllProjectService findAllProjectService;

    @MockBean
    private FindProjectByIdService findProjectByIdService;

    @MockBean
    private DeleteProjectService deleteProjectService;

    @MockBean
    private UpdateProjectService updateProjectService;

    @MockBean
    private SaveProjectService saveProjectService;

    @MockBean
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void find_ReturnProject_WhenSuccessful() throws Exception {

        Project project = ProjectBuilder.createProject();

        when(findProjectByIdService.findById(1L))
                .thenReturn(Optional.of(project));

        mockMvc.perform(get("/api/v1/projects/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Projeto Spring Boot")))
                .andExpect(jsonPath("$.description", is("Projeto para construção de uma API Rest utilizando Spring Boot.")))
                .andExpect(jsonPath("$.logo", is("images/logo.png")))
                .andExpect(jsonPath("$.startDate", is("2021-02-20")))
                .andExpect(jsonPath("$.endDate", is("2021-10-20")));

    }

    @Test
    public void find_ReturnError_WhenProjectDoesNotExist() throws Exception {

        when(findProjectByIdService.findById(-1L))
                .thenThrow(ProjectNotFoundException.class);

        mockMvc.perform(get("/api/v1/projects/{id}", -1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(this.findProjectByIdService, times(1)).findById(-1L);

    }

    @Test
    public void findAll_ReturnListOfProjects_WhenSuccessful() throws Exception {

        mockMvc.perform(get("/api/v1/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(this.findAllProjectService, times(1)).findAll();

    }

    @Test
    public void createProject_SaveProject_WhenSuccessful() throws Exception {

        mockMvc.perform(post("/api/v1/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getJson("SaveProject.json")))
                .andExpect(status().isCreated());

        Project project = ProjectBuilder.createProject();
        project.setId(null);

        verify(saveProjectService, times(1)).save(project);
    }

    @Test
    public void updateProject_WhenSuccessful() throws Exception {

        mockMvc.perform(put("/api/v1/projects/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getJson("UpdateProject.json")))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteAProject_WhenSuccessful() throws Exception {

        mockMvc.perform(delete("/api/v1/projects/{id}", anyLong())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(deleteProjectService, times(1)).delete(anyLong());
    }

    public static String getJson(String fileName) throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/java/resources/json/" + fileName).toAbsolutePath());
        return new String(bytes, StandardCharsets.UTF_8);
    }
}