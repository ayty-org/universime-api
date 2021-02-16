package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

@Tag("service")
@ExtendWith(MockitoExtension.class)
public class UpdateProjectServiceImplTest {

    @InjectMocks
    private UpdateProjectServiceImpl updateProjectService;

    @Mock
    private ProjectRepository projectRepository;

    @Test
    @DisplayName("update updates project's data when successful")
    public void update_UpdateProjectData_WhenSuccessful() throws ParseException {

        Project project = ProjectBuilder.createProject();
        projectRepository.save(project);
        project.setName("Projeto Spring Boot 2");

        ArgumentCaptor<Project> captor = ArgumentCaptor.forClass(Project.class);
        BDDMockito.verify(projectRepository).save(captor.capture());
        Project projectResult = captor.getValue();

        Assertions.assertEquals(projectResult.getName(), "Projeto Spring Boot 2");
    }
}
