package com.kios.storage.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kios.storage.dto.PropertyStorageRequest;
import com.kios.storage.entity.Profile;
import com.kios.storage.entity.Property;
import com.kios.storage.entity.Storage;
import com.kios.storage.entity.StorageUnit;
import com.kios.storage.repository.StorageRepository;
import com.kios.storage.repository.StorageUnitRepository;
import com.kios.storage.service.StorageService;
import com.kios.storage.util.BadRequestException;
import com.kios.storage.util.NoUsableUnitException;
import com.kios.storage.util.ProfileNotFoundException;
import com.kios.storage.util.PropertyNotFoundException;
import com.kios.storage.util.StorageNotFoundException;

@Service
public class StorageServiceImpl implements StorageService {

	private static final Logger LOG = LoggerFactory.getLogger(StorageServiceImpl.class);

	@Autowired
	StorageRepository storageRepository;

	@Autowired
	StorageUnitRepository storageUnitRepository;

	/* My attempt at keeping the two services separate for microservice */
	@Autowired
	ProfileServiceImpl profileService;

	@Autowired
	PropertyServiceImpl propertyService;

	@Override
	public Storage createEntity(Storage toSave) {
		if(toSave.getOwnerId() == null) {
			throw new BadRequestException("Null OwnerId provided");
		} else {
			Profile p = profileService.retrieveEntity(toSave.getOwnerId())
					.orElseThrow(() -> new ProfileNotFoundException("Profile not found"));
			toSave.setProfile(p);
			toSave.getStorageUnits().forEach(s->{
				s.setProperty(null);
				storageUnitRepository.save(s);
			});
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
		//  - Does the storage support this property type?
		// 	- Can this property fit the storage? There should be some front end checking but
		// 	  I should probably check this here. How strict do I want to be about this? What
		//    happens if someone mislabeled their property and it CAN fit in this property?
		//    How can I get a more accurate prediction of sizing?
		//	- Is this storage available during this time frame?
		Property property = propertyService.retrieveEntity(propertyStorageRequest.getPropertyId())
				.orElseThrow(() -> new PropertyNotFoundException("Property was not found"));

		Storage storage = retrieveEntity(propertyStorageRequest.getStorageId())
				.orElseThrow(() -> new StorageNotFoundException("Storage was not found"));

		StorageUnit storageUnit = getApplicableStorageUnit(storage, property);

		StorageUnit fromRepository = storageUnitRepository.getOne(storageUnit.getId());
		fromRepository.setProperty(property);

		storageUnitRepository.save(fromRepository);

		return storage;
	}

	// this will be SUPER restrictive - loosen this up! TODO
	public StorageUnit getApplicableStorageUnit(Storage storage, Property property) {
		List<StorageUnit> applicableUnits = storage.getStorageUnits();

		applicableUnits.removeIf(unit ->
					(unit.getSize() != property.getSize()) ||
					(unit.getStorageClass()  != property.getStorageClass()) ||
					(unit.getProperty() != null) ||
					(storage.getOwnerId() == property.getOwnerId()));

		if(applicableUnits.size() == 0)
			throw new NoUsableUnitException("Unable to find a storage unit which fits given requirements");
		else
			return applicableUnits.get(0);
	}
}
