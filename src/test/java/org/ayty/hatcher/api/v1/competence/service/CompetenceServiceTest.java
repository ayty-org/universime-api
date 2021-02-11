package org.ayty.hatcher.api.v1.competence.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.ayty.hatcher.api.v1.competence.dto.CompetenceDTO;
import org.ayty.hatcher.api.v1.competence.jpa.CompetenceRepository;
import org.ayty.hatcher.api.v1.competence.model.Competence;
import org.ayty.hatcher.api.v1.competence.model.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CompetenceServiceTest {
	
	@InjectMocks
	private CompetenceService service;
	
	@Mock
	private CompetenceRepository repository;
	
//	@Test
//	public void hello() {
//		List<Competence> competences = repository.findAll();
//		assertTrue(competences.isEmpty());
//	}
	
	@Test
	void getAllCompetencesTest() {
		Mockito.when(this.repository.findAll())
		.thenReturn(competencesList());
		
		List<Competence> competences = this.service.getAll();
		
		assertEquals(3, competences.size());
	}
	
	@Test
	void saveCompetenceTest() {
		Mockito.when(this.repository.save(Mockito.any(Competence.class)))
		.thenReturn(new Competence());
		
		Competence competenceSaved = this.service.save(
				new CompetenceDTO("Trabalho em Equipe",
				"Facilidade com trabalho em equipe",
				"SOFT_SKILLS"));
		
		assertNotNull(competenceSaved);
	}
	
	@Test
	void deleteCompetenceTest() {
		Integer id = 1;
		service.delete(id);
		Mockito.verify(repository).deleteById(id);
	}
	
	@Test
	void getCompetenceById() {
		
		Mockito.when(this.repository.findById(Mockito.any(Integer.class)))
		.thenReturn(Optional.of(new Competence(
				1, "Dev Front End", 
				"Dev Angular e Vue", 
				Type.TECHNIC)));
		
		Optional<Competence> competenceOptional = Optional.of(this.service.getById(1));
		
		Competence competence = competenceOptional.get();
		
		assertEquals(1, competence.getId());
	}
	
	@Test
	void updateCompetenceTest() {
		Competence competence = new Competence(
				1, "Dev Front End", 
				"Dev Angular e Vue", 
				Type.TECHNIC);
		Mockito.when(this.repository.findById(Mockito.any(Integer.class)))
		.thenReturn(Optional.of(competence));
		
		this.service.edit(1, new CompetenceDTO(
				"Dev Front End", 
				"Dev Angular e Vue", 
				"TECHNIC"));
		
		Mockito.verify(this.repository).save(competence);
	}
	
	private List<Competence> competencesList() {
		List<Competence> competences = new ArrayList<>();
		competences.add(new Competence(null, 
				"Dev Back End", 
				"Dev Java (Android e Web)", 
				Type.TECHNIC));
		competences.add(new Competence(null, 
				"Dev Front End", 
				"Dev Angular e Vue", 
				Type.TECHNIC));
		competences.add(new Competence(null, 
				"Trabalho em Equipe", 
				"Facilidade com trabalho em equipe", 
				Type.SOFT_SKILLS));
		return competences;
	}
	
}
