package com.kios.storage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@ManyToOne
	@JoinColumn(name = "storage_id")
	private Storage storage;
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	private Long propertyId;
	
	/* TODO: Clearly define the storage sizes somewhere */
	private Size storageSize;

	public Long getId() {
		return id;
	}
	public StorageClass getStorageClass() {
		return storageClass;
	}
	public void setStorageClass(StorageClass storageClass) {
		this.storageClass = storageClass;
	}
	public Size getStorageSize() {
		return storageSize;
	}
	public void setStorageSize(Size storageSize) {
		this.storageSize = storageSize;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
}

enum StorageClass { VEHICLE, BOXES, OTHER }