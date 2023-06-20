package com.example.demo.dto;

import java.math.BigDecimal;

public class HardDriveDTO extends ProductDTO {
    private int capacity;

	public HardDriveDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, int quantity,
			int capacity2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.capacity = capacity2;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}

