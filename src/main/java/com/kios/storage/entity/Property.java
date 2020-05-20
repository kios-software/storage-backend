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

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long testId;
	
	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id")
	@JsonBackReference(value = "profile-property")
	private Profile profile;
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	private Size size;

//	@OneToOne
//	private StorageUnit storageUnit;
//	public StorageUnit getStorageUnit() {
//		return storageUnit;
//	}
//
//	public void setStorageUnit(StorageUnit storageUnit) {
//		this.storageUnit = storageUnit;
//	}
	
	private Long storageUnitId;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Long getStorageUnitId() {
		return storageUnitId;
	}

	public void setStorageUnitId(Long storageUnitId) {
		this.storageUnitId = storageUnitId;
	}
}
