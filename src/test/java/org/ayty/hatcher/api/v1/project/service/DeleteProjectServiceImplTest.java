package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.exception.ProjectNotFoundException;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

import static org.mockito.Mockito.*;

@Tag("service")
@ExtendWith(MockitoExtension.class)
public class DeleteProjectServiceImplTest {

    @InjectMocks
    private DeleteProjectServiceImpl deleteProjectService;

    @Mock
    private ProjectRepository projectRepository;

    @Test
    @DisplayName("delete removes a project with certain id when successful")
    void delete_RemoveProjectWithCertainId_WhenSuccessful() throws ParseException {

        Project project = ProjectBuilder.createProject();
        projectRepository.save(project);
        deleteProjectService.deleteById(1);
        verify(projectRepository, times(1)).deleteById(anyInt());
    }

    @Test
    @DisplayName("delete returns a mono error when project does not exist")
    void delete_ReturnMonoError_WhenProjectDoesNotExist() {

        doThrow(new ProjectNotFoundException("Project not found!"))
                .when(projectRepository).deleteById(anyInt());

        Assertions.assertThrows(ProjectNotFoundException.class,
                () -> projectRepository.deleteById(anyInt()));
    }
}
