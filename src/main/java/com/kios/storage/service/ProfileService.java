package com.kios.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kios.storage.entity.Profile;
import com.kios.storage.repository.ProfileRepository;

@Service
public class ProfileService implements CrudService<Profile, Long> {

	@Autowired	
	ProfileRepository profileRepository;
	
	@Override
	public Profile createEntity(Profile toSave) {
		return profileRepository.save(toSave);
	}

	@Override
	public Profile retrieveEntity(Long id) {
		return profileRepository.findById(id).get();
	}

	@Override
	public Profile updateEntity(Long id, Profile toUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEntity(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
