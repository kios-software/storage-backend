package com.kios.storage.serviceimpl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kios.storage.dto.PropertyStorageRequest;
import com.kios.storage.entity.Profile;
import com.kios.storage.entity.Property;
import com.kios.storage.entity.Storage;
import com.kios.storage.repository.PropertyRepository;
import com.kios.storage.repository.StorageRepository;
import com.kios.storage.service.StorageService;
import com.kios.storage.util.BadRequestException;
import com.kios.storage.util.ProfileNotFoundException;
import com.kios.storage.util.StorageNotFoundException;

@Service
public class StorageServiceImpl implements StorageService {

	private static final Logger LOG = LoggerFactory.getLogger(StorageServiceImpl.class);

	@Autowired
	StorageRepository storageRepository;

	@Autowired
	PropertyRepository propertyRepository;

	/* My attempt at keeping the two services separate for microservice */
	@Autowired
	ProfileServiceImpl profileService;

	@Autowired
	PropertyServiceImpl propertyService;

	@Override
	public Storage createEntity(Storage toSave) {
		toSave.setProperty(new ArrayList<>());
		if (toSave.getOwnerId() == null) {
			throw new BadRequestException("Null OwnerId provided");
		} else {
			Profile p = profileService.retrieveEntity(toSave.getOwnerId())
					.orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
			toSave.setProfile(p);
			return storageRepository.save(toSave);
		}
	}

	@Override
	public Optional<Storage> retrieveEntity(Long id) {
		return storageRepository.findById(id);
	}

	@Override
	public Storage updateEntity(Long id, Storage toUpdate) {
		Storage s = storageRepository.getOne(id);
		s = toUpdate;
		return storageRepository.save(s);
	}

	@Override
	public boolean deleteEntity(Long id) {
		try {
			storageRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return false;
		}
	}

	@Override
	public Storage storeProperty(PropertyStorageRequest propertyStorageRequest) {
		// What needs to be considered? TODO!
		// How can I get a more accurate prediction of sizing?
		// Is this storage available during this time frame?
		Property property = propertyRepository.getOne(propertyStorageRequest.getPropertyId());

		Storage storage = retrieveEntity(propertyStorageRequest.getStorageId())
				.orElseThrow(() -> new StorageNotFoundException("Storage was not found"));

		// TODO
		// Check if the property is already stored elsewhere
		property.setStorage(storage);

		propertyRepository.save(property);
		return storage;
	}

	public float calculateLoadFactor(Storage storage, Property property) {
		throw new RuntimeException("Not yet implemented");
	}
}
