package org.ayty.hatcher.api.v1.project.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

import org.ayty.hatcher.api.v1.project.entity.Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty
    @NonNull
    private String name;

    @NotEmpty
    @NonNull
    private String description;

   // @NotEmpty
    //@NonNull
    private String logo;

   @NotEmpty
    private LocalDate startDate;


    private LocalDate endDate;

    public static ProjectDTO from(Project project) {
        return ProjectDTO.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .logo(project.getLogo())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .build();
    }

    public static List<ProjectDTO> from(List<Project> projects) {
        return projects.stream().map(ProjectDTO::from).collect(Collectors.toList());
    }
}
