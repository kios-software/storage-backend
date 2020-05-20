package com.kios.storage.dto;

/* 
 * This is the request object the Storage Service uses to actual register 
 * a storage request.
 */
public class PropertyStorageRequest {
	private Long propertyOwnerId;
	private Long propertyId;
	private Long storageId;
	
	public Long getPropertyOwnerId() {
		return propertyOwnerId;
	}
	public void setPropertyOwnerId(Long propertyOwnerId) {
		this.propertyOwnerId = propertyOwnerId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public Long getStorageId() {
		return storageId;
	}
	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}
}
