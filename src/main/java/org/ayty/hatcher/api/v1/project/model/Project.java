package org.ayty.hatcher.api.v1.project.model;

import lombok.*;
import org.ayty.hatcher.api.v1.project.dto.ProjectDTO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "project_generator", sequenceName = "project_sequence", allocationSize = 1)
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private String logo;

    @NotNull
    @NotEmpty
    private LocalDate startDate;

    @NotNull
    @NotEmpty
    private LocalDate endDate;

//    @ManyToMany(mappedBy = "projects")
//    private List<User> coordenators;

//    @ManyToMany(mappedBy = "competences")
//    private List<Competence> competences;

    public static Project to(ProjectDTO projectDTO) {
        return Project.builder()
                .id(projectDTO.getId())
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .logo(projectDTO.getLogo())
                .startDate(projectDTO.getStartDate())
                .endDate(projectDTO.getEndDate())
                .build();
    }

    public static List<Project> to(List<ProjectDTO> projectDTOList) {
        return projectDTOList.stream().map(Project::to).collect(Collectors.toList());
    }
}
