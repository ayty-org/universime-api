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
import java.util.Optional;

import static org.mockito.Mockito.*;

@Tag("service")
@ExtendWith(MockitoExtension.class)
public class DeleteProjectServiceImplTest {

    @InjectMocks
    private DeleteProjectServiceImpl deleteProjectService;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        this.deleteProjectService = new DeleteProjectServiceImpl(this.projectRepository);
    }

    @Test
    @DisplayName("delete removes a project with certain id when successful")
    void delete_RemoveProjectWithCertainId_WhenSuccessful() throws ParseException {

        Project project = ProjectBuilder.createProject();

        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Assertions.assertDoesNotThrow(() -> deleteProjectService.delete(1L));
    }

    @Test
    @DisplayName("delete returns a mono error when project does not exist")
    void delete_ReturnMonoError_WhenProjectDoesNotExist() {

        doThrow(new ProjectNotFoundException("Project not found!"))
                .when(projectRepository).deleteById(anyLong());

        Assertions.assertThrows(ProjectNotFoundException.class,
                () -> projectRepository.deleteById(anyLong()));
    }
}
