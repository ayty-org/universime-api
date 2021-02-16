package org.ayty.hatcher.api.v1.course.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.ayty.hatcher.api.v1.course.service.CreateCourseServiceImpl;
import org.ayty.hatcher.api.v1.course.service.DeleteCourseServiceImpl;
import org.ayty.hatcher.api.v1.course.service.GetCourseServiceImpl;
import org.ayty.hatcher.api.v1.course.service.ListCourseServiceImpl;
import org.ayty.hatcher.api.v1.course.service.UpdateCourseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin("*")
public final class CourseControllerV1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private final CreateCourseServiceImpl createCourse;
    private final GetCourseServiceImpl getCourse;
    private final ListCourseServiceImpl listCourse;
    private final DeleteCourseServiceImpl deleCourse;
    private final UpdateCourseServiceImpl updateCourse;

    @GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Page<CourseDTO> listAll(
            @RequestParam(value = "idPaged", defaultValue = "true") boolean isPaged,
            @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "ord", defaultValue = "id") String ord,
            @RequestParam(value = "sort", defaultValue = "ASC") String sort) {
        if(isPaged) return CourseDTO.from(this.listCourse.findAll(PageRequest.of(pageNum, pageSize, Sort.by(Sort.Direction.fromString(sort), ord))));
        else return CourseDTO.from(this.listCourse.findAll(Pageable.unpaged()));
    }

    @PatchMapping(value = "/{id}",
            consumes =  MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void update (@PathVariable Long id, @RequestBody Course obj) {
        this.updateCourse.update(id, obj);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public Course findById (@PathVariable Long id){
       return this.getCourse.get(id);
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody Course obj) {
        this.createCourse.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.deleCourse.delete(id);
    }

}
