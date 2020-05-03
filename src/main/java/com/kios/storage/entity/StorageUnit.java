package com.kios.storage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * This class is a more specific drill down into the storage
 * For example, if StorageClass is StorageClass.VEHICLE, then there will be
 * some more specific details to narrow down what that means in terms of size
 * (small, medium, large, etc.)
 */
@Entity
public class StorageUnit { 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private StorageClass storageClass;
	
	/* TODO: Clearly define the storage sizes somewhere */
	private StorageSize storageSize;

	public StorageClass getStorageClass() {
		return storageClass;
	}

	public void setStorageClass(StorageClass storageClass) {
		this.storageClass = storageClass;
	}

	public StorageSize getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(StorageSize storageSize) {
		this.storageSize = storageSize;
	}

	public Long getId() {
		return id;
	}
}

enum StorageClass { VEHICLE, BOXES, OTHER }
enum StorageSize { SMALL, MEDIUM, LARGE, XLARGE, XXLARGE, SUPER }