package com.kios.storage.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "profile_id")
	@JsonManagedReference(value = "profile-storage")
	private List<Storage> storage;

	@OneToMany
	@JoinColumn(name = "profile_id")
	@JsonManagedReference(value = "profile-property")
	private List<Property> property;
	
//	private Long userId;
	private ProfileType profileType;

	public List<Storage> getStorage() {
		return storage;
	}

	public void setStorage(List<Storage> storage) {
		this.storage = storage;
	}

	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}

	public Long getId() {
		return id;
	}
	
//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

	public ProfileType getProfileType() {
		return profileType;
	}

	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}
	
//	public Profile(Long userId, ProfileType profileType) {
////		this.userId = userId;
//		this.profileType = profileType;
//	}
//	public Profile(ProfileType profileType) {
//		this.profileType = profileType;
//		this.property = new ArrayList<>();
//		this.storage = new ArrayList<>();
//	}
//	
	public Profile() {
		this.property = new ArrayList<>();
		this.storage = new ArrayList<>();
	}
}

enum ProfileType { USER_PROFILE, PROVIDER_PROFILE }