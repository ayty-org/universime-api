package org.ayty.hatcher.api.v1.project.service;

import org.ayty.hatcher.api.v1.project.builder.ProjectBuilder;
import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

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

        when(this.projectRepository.findAll())
                .thenReturn(Arrays.asList(project));

        assertEquals(1, findAllProjectServiceImpl.findAll().size());
    }
}
