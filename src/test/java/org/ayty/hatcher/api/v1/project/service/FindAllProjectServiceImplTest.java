package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.repository.ProjectRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@Tag("service")
@ExtendWith(MockitoExtension.class)
public class FindAllProjectServiceImplTest {

    private FindAllProjectServiceImpl findAllProjectServiceImpl;

    @Mock
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
       this.findAllProjectServiceImpl = new FindAllProjectServiceImpl(projectRepository);
    }

    @Test
    @DisplayName("findAll returns a list of projects when successful")
    void findAll_ReturnsListOfProjects_WhenSuccessful() throws ParseException {

        Project project = ProjectBuilder.createProject();

        BDDMockito.when(this.projectRepository.findAll())
                .thenReturn(Arrays.asList(project));

        Assertions.assertEquals(1, findAllProjectServiceImpl.findAll().size());
    }
}
