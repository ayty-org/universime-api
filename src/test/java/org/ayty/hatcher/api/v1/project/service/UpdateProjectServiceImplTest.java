package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@Tag("service")
@ExtendWith(MockitoExtension.class)
public class UpdateProjectServiceImplTest {

    private UpdateProjectServiceImpl updateProjectService;

    @InjectMocks
    private FindProjectByIdServiceImpl findProjectByIdService;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        this.updateProjectService = new UpdateProjectServiceImpl(this.findProjectByIdService, this.projectRepository);
    }

    @Test
    @DisplayName("update updates project's data when successful")
    public void update_UpdateProjectData_WhenSuccessful() throws ParseException {

        Project project = ProjectBuilder.createProject();

        when(this.projectRepository.findById(1)).thenReturn(Optional.of(project));

        this.updateProjectService.update(project);

        ArgumentCaptor<Project> captor = ArgumentCaptor.forClass(Project.class);
        verify(projectRepository).save(captor.capture());
        Project projectResult = captor.getValue();

        assertEquals(projectResult.getName(), "Projeto Spring Boot");
    }
}
