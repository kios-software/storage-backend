package com.kios.storage.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//TODO Better exceptions
//https://www.toptal.com/java/spring-boot-rest-api-error-handling
//^ might be helpful?
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StorageNotFoundException extends RuntimeException {
	public StorageNotFoundException(String message) {
		super(message);
	}
}
