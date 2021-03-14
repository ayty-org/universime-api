package org.ayty.hatcher.api.v1.competence.controller;

import javax.validation.Valid;

import org.ayty.hatcher.api.v1.competence.dto.CompetenceDTO;
import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.ayty.hatcher.api.v1.competence.service.DeleteCompetence;
import org.ayty.hatcher.api.v1.competence.service.EditCompetence;
import org.ayty.hatcher.api.v1.competence.service.GetAllCompetence;
import org.ayty.hatcher.api.v1.competence.service.GetCompetenceById;
import org.ayty.hatcher.api.v1.competence.service.SaveCompetence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

	private final GetAllCompetence<Competence> getAllCompetenceService;

	private final GetCompetenceById getCompetenceById;

	private final SaveCompetence saveCompetence;

	private final EditCompetence editCompetence;

	private final DeleteCompetence deleteCompetence;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping()
	public Page<Competence> getAll(Pageable pageable) {
		return getAllCompetenceService.getAll(pageable);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Competence getById(@PathVariable Long id) {
		return getCompetenceById.getById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Competence save(@Valid @RequestBody CompetenceDTO competenceDto) {
		return saveCompetence.save(competenceDto);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Competence edit(@PathVariable Long id, @Valid @RequestBody CompetenceDTO competenceDto) {
		return editCompetence.edit(id, competenceDto);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		deleteCompetence.delete(id);
	}
}
