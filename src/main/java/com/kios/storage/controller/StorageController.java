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

import com.kios.storage.dto.PropertyStorageRequest;
import com.kios.storage.entity.Storage;
import com.kios.storage.serviceimpl.ProfileServiceImpl;
import com.kios.storage.serviceimpl.StorageServiceImpl;

/* 
 * This controller deals with storage-related queries for the 'storage' entity
 * See: com.kios.storage.entity.Storage
 * 
 */
@RestController
@RequestMapping("/api/storage")
public class StorageController implements CrudController<Storage, Long> {

	@Autowired
	StorageServiceImpl storageService;

	@Autowired
	ProfileServiceImpl profileService;

	@PostMapping("/create")
	public ResponseEntity<Storage> create(@RequestBody Storage request) {
		Storage response = storageService.createEntity(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Storage> retrieve(@PathVariable Long id) {
		Optional<Storage> response = storageService.retrieveEntity(id);
		return new ResponseEntity<>(response.get(), HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Storage> update(@PathVariable Long id, @RequestBody Storage request) {
		Storage response = storageService.updateEntity(id, request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		boolean success = storageService.deleteEntity(id);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	@PostMapping("/storeProperty")
	public ResponseEntity<Storage> storeProperty(@RequestBody PropertyStorageRequest propertyStorageRequest) {
		Storage response = storageService.storeProperty(propertyStorageRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
