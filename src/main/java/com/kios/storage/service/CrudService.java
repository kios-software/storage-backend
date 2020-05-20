package com.kios.storage.service;

import java.util.Optional;

public interface CrudService<T, S> {
	T createEntity(T toSave);
	Optional<T> retrieveEntity(S id);
	T updateEntity(S id, T toUpdate);
	boolean deleteEntity(S id);
}
