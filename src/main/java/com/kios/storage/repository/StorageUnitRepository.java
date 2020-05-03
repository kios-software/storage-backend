package com.kios.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kios.storage.entity.StorageUnit;

@Repository
public interface StorageUnitRepository extends JpaRepository<StorageUnit, Long> { }