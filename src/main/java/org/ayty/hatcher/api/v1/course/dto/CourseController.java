package org.ayty.hatcher.api.v1.course.dto;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private final CourseService service;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Course>> findAll() {
        List<Course> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findById (@PathVariable Long id){
        Course obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity <Course> update (@PathVariable Long id, @RequestBody Course obj) {
        Course newObj = this.service.update(id, obj);
        return ResponseEntity.ok().body(newObj);

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Course> create(@RequestBody Course obj) {
        Course newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Course> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
