package org.ayty.hatcher.api.v1.course.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder(builderClassName = "Builder")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CourseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    private Long id;

    @NonNull
    private String courseName;

    private String description;

    public static CourseDTO from(Course course) {
        return CourseDTO
                .builder()
                .id(course.getId())
                .courseName(course.getName())
                .description(course.getDescription())
                .build();
    }

    public static List<CourseDTO> from(List<Course> courses){
        return courses.stream().map(CourseDTO::from).collect(Collectors.toList());
    }

    public static Page<CourseDTO> from(Page<Course> pages){
        return pages.map(CourseDTO::from);
    }

}
