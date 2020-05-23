package com.kios.storage.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kios.storage.entity.Profile;
import com.kios.storage.repository.ProfileRepository;
import com.kios.storage.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Override
	public Profile createEntity(Profile toSave) {
		return profileRepository.save(toSave);
	}

	@Override
	public Optional<Profile> retrieveEntity(Long id) {
		return profileRepository.findById(id);
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
