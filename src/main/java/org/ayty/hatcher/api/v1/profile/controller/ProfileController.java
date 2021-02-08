package org.ayty.hatcher.api.v1.profile.controller;

import org.ayty.hatcher.api.v1.profile.entity.Profile;
import org.ayty.hatcher.api.v1.profile.exception.NotFoundException;
import org.ayty.hatcher.api.v1.profile.service.DeleteProfileImpl;
import org.ayty.hatcher.api.v1.profile.service.FindByIdProfileImpl;
import org.ayty.hatcher.api.v1.profile.service.UpdateProfileImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
	
	final private UpdateProfileImpl updateService;
	final private DeleteProfileImpl deleteService;
	final private FindByIdProfileImpl findService;
	
	@GetMapping("/{id}")
	public Profile getProfile(@PathVariable("id") long id) throws NotFoundException {
		return findService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Profile updateProfile(@PathVariable("id") long id,@RequestBody Profile profile) throws NotFoundException{	
		return updateService.updateProfile(id, profile);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProfile(@PathVariable("id") long id) {
		deleteService.deleteProfile(id);
	}
	
	
}
