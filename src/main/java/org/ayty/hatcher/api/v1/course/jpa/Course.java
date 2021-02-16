package org.ayty.hatcher.api.v1.course.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.ayty.hatcher.api.v1.course.dto.CourseDTO;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(builderClassName = "Builder")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(name = "course_generator", sequenceName = "course_sequence", allocationSize = 1)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String name;

    private String description;

    public static Course to(CourseDTO courseDTO){
        return Course.builder()
                .id(courseDTO.getId())
                .name(courseDTO.getCourseName())
                .description(courseDTO.getDescription())
                .build();
    }

    public static List<Course> to(List<CourseDTO> courses){
        return courses.stream().map(Course::to).collect(Collectors.toList());
    }

    public static Page<Course> to(Page<CourseDTO> pages){
        return pages.map(Course::to);
    }

}
