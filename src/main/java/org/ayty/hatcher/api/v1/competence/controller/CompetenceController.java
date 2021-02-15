package org.ayty.hatcher.api.v1.competence.controller;

import java.util.List;

import javax.validation.Valid;

import org.ayty.hatcher.api.v1.competence.dto.CompetenceDTO;
import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.ayty.hatcher.api.v1.competence.service.CompetenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/competence")
@RequiredArgsConstructor
public class CompetenceController {
	
	
	private final CompetenceService service;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Competence> getAll() {
		return service.getAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Competence getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Competence save(@Valid @RequestBody CompetenceDTO competenceDto) {
		return service.save(competenceDto);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public Competence edit(@PathVariable Long id, @Valid @RequestBody CompetenceDTO competenceDto) {
		return service.edit(id, competenceDto);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id ) {
		service.delete(id);
	}
}
