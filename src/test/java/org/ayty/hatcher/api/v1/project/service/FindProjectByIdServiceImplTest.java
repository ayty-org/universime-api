package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.exception.ProjectNotFoundException;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.repository.ProjectRepository;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Optional;

@Tag("service")
@ExtendWith(MockitoExtension.class)
public class FindProjectByIdServiceImplTest {

    private FindProjectByIdServiceImpl findProjectByIdServiceImpl;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
       this.findProjectByIdServiceImpl = new FindProjectByIdServiceImpl(projectRepository);
    }

    @Test
    @DisplayName("findById returns a project with a certain id when successful")
    void findById_ReturnProjectWithCertainId_WhenSuccessful() throws ParseException {

        Project project = ProjectBuilder.createProject();

        BDDMockito.when(this.projectRepository.findById(1))
                .thenReturn(Optional.of(project));

        Assertions.assertEquals(project.getId(), findProjectByIdServiceImpl.findById(project.getId()).get().getId());
        Assertions.assertEquals(project.getName(), findProjectByIdServiceImpl.findById(project.getId()).get().getName());
        Assertions.assertEquals(project.getDescription(), findProjectByIdServiceImpl.findById(project.getId()).get().getDescription());
        Assertions.assertEquals(project.getLogo(), findProjectByIdServiceImpl.findById(project.getId()).get().getLogo());
        Assertions.assertEquals(project.getStartDate(), findProjectByIdServiceImpl.findById(project.getId()).get().getStartDate());
        Assertions.assertEquals(project.getEndDate(), findProjectByIdServiceImpl.findById(project.getId()).get().getEndDate());
    }

    @Test
    @DisplayName("findById returns an error when the project with certain id doesn't exist")
    void findById_ReturnAnError_WhenCertainIdDoesntExist() throws ParseException {

        Project project = ProjectBuilder.createProject();

        BDDMockito.when(this.projectRepository.findById(ArgumentMatchers.anyInt()))
                .thenReturn(Optional.empty());
        Assertions.assertThrows(
                ProjectNotFoundException.class,
                () -> findProjectByIdServiceImpl.findById(ArgumentMatchers.anyInt()).get());
    }
}
