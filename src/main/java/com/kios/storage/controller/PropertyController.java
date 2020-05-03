package com.kios.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Property> create(Property request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Property> retrieve(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("/update/{id}")
	public ResponseEntity<Property> update(Long id, Property request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@GetMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
