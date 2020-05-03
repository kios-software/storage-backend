package com.kios.storage.service;

public interface CrudService<T, S> {
	T createEntity(T toSave);
	T retrieveEntity(S id);
	T updateEntity(S id, T toUpdate);
	boolean deleteEntity(S id);
}
