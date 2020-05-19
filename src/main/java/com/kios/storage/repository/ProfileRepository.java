package com.kios.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kios.storage.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}