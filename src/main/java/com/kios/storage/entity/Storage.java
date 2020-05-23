package com.kios.storage.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/* 
 * This class represents the physical storage available to lease out to others
 * The idea is that if you can fit 10 cars in your "storage" (in this case maybe
 * 	 it's just an open field where you're letting people park their cars) then 
 *   you'll have 10 storageUnits, each specified as StorageClass.VEHICLE
 *   and StorageSize.<whatever-size-car-you-can-fit>
 *  
 *  StorageSizing needs to be flexible - maybe you can fit 5 sedans 
 *    or 2 RVs, for example
 * 
 */
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Storage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/* Not needed for persistence */
	private Long ownerId;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	private float latitude;

	private float longitude;

	@JsonProperty(access = Access.READ_ONLY)
	private float loadFactor;

	private float scale;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "profile_id")
	@JsonBackReference(value = "profile-storage")
	private Profile profile;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "storage_id")
	@JsonManagedReference(value = "storage-property")
	private List<Property> property;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@ElementCollection
	private Set<StorageOption> storageOptions;

	public Long getId() {
		return id;
	}

	public float getLoadFactor() {
		return loadFactor;
	}

	public void setLoadFactor(float loadFactor) {
		this.loadFactor = loadFactor;
	}

	public Set<StorageOption> getStorageOptions() {
		return storageOptions;
	}

	public void setStorageOptions(Set<StorageOption> storageOptions) {
		this.storageOptions = storageOptions;
	}

	public List<Property> getProperty() {
		return property;
	}

	public void setProperty(List<Property> property) {
		this.property = property;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public Storage() {
		this.loadFactor = 100.00f;
	}
}

enum StorageOption {
	AIR_CONDITIONING, HEATING, ALWAYS_ACCESSIBLE, SECURITY_ALARMS, GUARDED, EXCLUSIVE
}
