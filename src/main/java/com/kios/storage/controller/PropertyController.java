package com.kios.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kios.storage.entity.Property;
import com.kios.storage.service.PropertyService;

@RestController
@RequestMapping("/api/property")
public class PropertyController implements CrudController<Property, Long>{

	@Autowired
	PropertyService propertyService;
	
	@Override
	@PostMapping("/create")
	public ResponseEntity<Property> create(@RequestBody Property request) {
		Property newProperty = propertyService.createEntity(request);
		return new ResponseEntity<>(newProperty, HttpStatus.OK);
	}

	@Override
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Property> retrieve(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/update/{id}")
	public ResponseEntity<Property> update(@PathVariable Long id, @RequestBody Property request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
