package com.kios.storage.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kios.storage.entity.Profile;
import com.kios.storage.entity.Property;
import com.kios.storage.repository.PropertyRepository;
import com.kios.storage.service.PropertyService;
import com.kios.storage.util.BadRequestException;
import com.kios.storage.util.ProfileNotFoundException;

@Service
public class PropertyServiceImpl implements PropertyService {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyService.class);

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	ProfileServiceImpl profileService;

	@Override
	public Property createEntity(Property toSave) {
		LOG.info("Here");
//		if(propertyRepository contains toSave) <-- TODO What checks should I do here?
		if (toSave.getOwnerId() == null) {
			LOG.info("Owner ID: " + toSave.getOwnerId());
			throw new BadRequestException("Null OwnerId provided");
		} else {
			Profile p = profileService.retrieveEntity(toSave.getOwnerId())
					.orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
			toSave.setProfile(p);
			return propertyRepository.save(toSave);
		}
	}

	@Override
	public Optional<Property> retrieveEntity(Long id) {
		Optional<Property> property = propertyRepository.findById(id);
		return property;
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
