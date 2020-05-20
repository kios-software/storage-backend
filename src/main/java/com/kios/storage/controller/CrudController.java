package com.kios.storage.controller;

import org.springframework.http.ResponseEntity;

public interface CrudController<T, S> {
	ResponseEntity<T> create(T request);
	ResponseEntity<T> retrieve(S id);
	ResponseEntity<T> update(S id, T request); // TODO: Switch to PUT
	ResponseEntity<Boolean> delete(S id);
}
