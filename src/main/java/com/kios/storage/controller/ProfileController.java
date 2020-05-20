package com.kios.storage.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kios.storage.entity.Profile;
import com.kios.storage.serviceimpl.ProfileServiceImpl;

@RestController
@RequestMapping("/api/profile")
public class ProfileController implements CrudController<Profile, Long> {

	@Autowired
	ProfileServiceImpl profileService;
	
	@Override
	@PostMapping("/create")
	public ResponseEntity<Profile> create(@RequestBody Profile request) {
		Profile p = profileService.createEntity(request);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@Override
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Profile> retrieve(@PathVariable Long id) {
		Optional<Profile> p = profileService.retrieveEntity(id);
		return new ResponseEntity<>(p.get(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/update/{id}")
	public ResponseEntity<Profile> update(@PathVariable Long id, @RequestBody Profile request) {
		profileService.updateEntity(id, request);
		return null;
	}

	@Override
	@GetMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		profileService.deleteEntity(id);
		return null;
	}

}
