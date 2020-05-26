package com.kios.storage.service;

import java.time.LocalDate;
import java.util.List;

import com.kios.storage.entity.Storage;

/* This service is dedicated to various requirements around the actual scheduling of storage and delivery */
public interface SchedulerService {
	List<LocalDate> getAvailableDatesForStorage(Storage storage);
//	List<LocalDate> 
}
