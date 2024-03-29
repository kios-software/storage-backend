package com.kios.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kios.storage.entity.Storage;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

}