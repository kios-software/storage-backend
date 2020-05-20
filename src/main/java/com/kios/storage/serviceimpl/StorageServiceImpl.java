package com.kios.storage.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kios.storage.entity.Profile;
import com.kios.storage.entity.Storage;
import com.kios.storage.repository.StorageRepository;
import com.kios.storage.repository.StorageUnitRepository;
import com.kios.storage.service.ProfileService;
import com.kios.storage.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
	
	private static final Logger LOG = LoggerFactory.getLogger(StorageServiceImpl.class);
	
	@Autowired
	StorageRepository storageRepository;
	
	@Autowired
	StorageUnitRepository storageUnitRepository;
	
	/* My attempt at keeping the two services separate for microservice */
	@Autowired
	ProfileService profileService;
	
	@Override
	public Storage createEntity(Storage toSave) {
		Profile p = profileService.retrieveEntity(toSave.getTestId());
		toSave.setProfile(p);
		toSave.getStorageUnits().forEach(s->{
			storageUnitRepository.save(s);
		});
		return storageRepository.save(toSave);
	}

	@Override
	public Storage retrieveEntity(Long id) {
		return storageRepository.findById(id).get();
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
}
