package com.kios.storage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	private Property property;

	/* TODO: Clearly define the storage sizes somewhere */
	private Size storageSize;

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
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

	public Long getId() {
		return id;
	}
}

enum StorageClass { VEHICLE, BOXES, OTHER }