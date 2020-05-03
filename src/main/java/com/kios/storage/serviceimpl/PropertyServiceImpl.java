package com.kios.storage.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kios.storage.entity.Property;
import com.kios.storage.repository.PropertyRepository;
import com.kios.storage.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	PropertyRepository propertyRepository;
	
	@Override
	public Property createEntity(Property toSave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property retrieveEntity(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Property updateEntity(Long id, Property toUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEntity(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
