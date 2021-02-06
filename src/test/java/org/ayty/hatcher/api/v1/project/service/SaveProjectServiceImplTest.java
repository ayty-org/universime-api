package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.repository.ProjectRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Tag("service")
@ExtendWith(MockitoExtension.class)
public class SaveProjectServiceImplTest {

    private SaveProjectService saveProjectService;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        this.saveProjectService = new SaveProjectServiceImpl(projectRepository);
    }

    @Test
    @DisplayName("save creates a new project when successful")
    public void save_CreateNewProject_WhenSuccessful() throws ParseException {

        Project project = ProjectBuilder.createProject();
        this.projectRepository.save(project);

        ArgumentCaptor<Project> captor = ArgumentCaptor.forClass(Project.class);
        verify(projectRepository).save(captor.capture());
        Project projectResult = captor.getValue();

        assertEquals(projectResult.getName(), "Projeto Spring Boot");
    }
}
