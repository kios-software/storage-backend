package com.kios.storage.service;

import com.kios.storage.entity.Storage;

public interface StorageService extends CrudService<Storage, Long> {
	public Storage storeProperty(PropertyStorageRequest propertyStorageRequest);
}
