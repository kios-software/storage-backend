package com.kios.storage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 * This class is a more specific drill down into the storage
 * For example, if StorageClass is StorageClass.VEHICLE, then there will be
 * some more specific details to narrow down what that means in terms of size
 * (small, medium, large, etc.)
 */
@Entity
public class StorageUnit { 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private StorageClass storageClass;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "storage_id")
	@JsonBackReference(value = "storage-storage-unit")
	private Storage storage;

	@OneToOne
	@JoinColumn(name = "property_id")
	@JsonManagedReference(value = "storage-unit-property")
	private Property property;
	
	/* TODO: Clearly define the storage sizes somewhere */
	private Size size;

	public Long getId() {
		return id;
	}
	public StorageClass getStorageClass() {
		return storageClass;
	}
	public void setStorageClass(StorageClass storageClass) {
		this.storageClass = storageClass;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
}