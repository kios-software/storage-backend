package com.kios.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kios.storage.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
