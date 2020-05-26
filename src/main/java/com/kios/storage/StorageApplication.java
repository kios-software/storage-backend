package com.kios.storage;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageApplication.class, args);
	}

	@PostConstruct
    void started() {
        // set JVM timezone as UTC
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
