package com.kios.storage.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//TODO Better exceptions
//https://www.toptal.com/java/spring-boot-rest-api-error-handling
//^ might be helpful?
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnusableStorageException extends RuntimeException {
	public UnusableStorageException(String message) {
		super(message);
	}
}
