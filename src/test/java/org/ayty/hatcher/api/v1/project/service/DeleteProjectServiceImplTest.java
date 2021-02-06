package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.repository.ProjectRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;

@Tag("service")
@ExtendWith(MockitoExtension.class)
public class DeleteProjectServiceImplTest {

    private FindProjectByIdServiceImpl findProjectByIdServiceImpl;

    private DeleteProjectServiceImpl deleteProjectServiceImpl;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        this.findProjectByIdServiceImpl = new FindProjectByIdServiceImpl(projectRepository);
    }

//    @Test
//    @DisplayName("delete removes a project with certain id when successful")
//    void delete_RemoveProjectWithCertainId_WhenSuccessful() throws ParseException {
//
//        Project project = ProjectBuilder.createProject();
//
//        this.projectRepository.save(project);
//        this.deleteProjectServiceImpl.deleteById(1);
//        Assertions.assertNull(findProjectByIdServiceImpl.findById(1));
//    }
}
