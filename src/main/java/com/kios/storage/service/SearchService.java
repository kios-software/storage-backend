package com.kios.storage.service;

import java.util.List;

import com.kios.storage.entity.Storage;

public interface SearchService {
	List<Storage> retrieveStorageWithGeolocation(float latitude, float longitude);
}
