package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum DesktopFormFactor {
	DESKTOP,
	NETTOP,
	ALL_IN_ONE;

	@JsonCreator
	public static DesktopFormFactor forValue(String value) {
		return DesktopFormFactor.valueOf(value.toUpperCase());
	}
}
