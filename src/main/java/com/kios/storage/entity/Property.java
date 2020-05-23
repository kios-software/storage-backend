package com.kios.storage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
// When an object is lazy loaded, Hibernate adds some extra data to it to manage
// the interaction. This annotation will make sure that Jackson doesn't serialize
// said data in the client response.
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long ownerId;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id")
	@JsonBackReference(value = "profile-property")
	private Profile profile;

	private Size size;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "storage_id")
	@JsonBackReference(value = "storage-property")
	private Storage storage;

	private StorageClass storageClass;

	public Long getId() {
		return id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public StorageClass getStorageClass() {
		return storageClass;
	}

	public void setStorageClass(StorageClass storageClass) {
		this.storageClass = storageClass;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
