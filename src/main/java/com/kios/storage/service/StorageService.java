package com.kios.storage.service;

import com.kios.storage.dto.PropertyStorageRequest;
import com.kios.storage.entity.Property;
import com.kios.storage.entity.Storage;

public interface StorageService extends CrudService<Storage, Long> {
	public Storage storeProperty(PropertyStorageRequest propertyStorageRequest);
	public boolean validateIfPropertyCanBeStored(Property property, Storage storage, float newLoadFactor);
	public float calculateLoadFactor(Property property, Storage storage);
}
