package com.kios.storage.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Storage {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;
	
	@OneToMany
	private List<StorageUnit> storageUnits;
	
	@ElementCollection
	private Set<StorageOption> storageOptions;
	
	public Profile getProfile() {
		return profile;
	}
	public void setOwner(Profile profile) {
		this.profile = profile;
	}
	public List<StorageUnit> getStorageUnits() {
		return storageUnits;
	}
	public void setStorageUnits(List<StorageUnit> storageUnits) {
		this.storageUnits = storageUnits;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Long getId() {
		return id;
	}
	public Set<StorageOption> getStorageOptions() {
		return storageOptions;
	}
	public void setStorageOptions(Set<StorageOption> storageOptions) {
		this.storageOptions = storageOptions;
	}
}


enum StorageOption { AIR_CONDITIONING, HEATING, ALWAYS_ACCESSIBLE, SECURITY_ALARMS, GUARDED, EXCLUSIVE }
