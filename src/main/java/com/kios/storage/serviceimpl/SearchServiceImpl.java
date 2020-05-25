package com.kios.storage.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kios.storage.entity.Storage;
import com.kios.storage.repository.StorageRepository;
import com.kios.storage.service.SearchService;

/* Elastic Search? */
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	StorageRepository storageRepository;
	
	@Override
	// TODO
	public List<Storage> retrieveStorageWithGeolocation(float latitude, float longitude) {
		List<Storage> storageList = storageRepository.findAll();
		return storageList;
	}

}
