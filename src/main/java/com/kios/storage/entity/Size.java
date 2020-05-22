package com.kios.storage.entity;

public enum Size {
	SMALL(1), MEDIUM(2), LARGE(3), XLARGE(4), XXLARGE(5), SUPER(6);

	public final int value;

	private Size(int value) {
		this.value = value;
	}
}
