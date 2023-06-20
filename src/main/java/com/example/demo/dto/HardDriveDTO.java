package com.example.demo.dto;

import java.math.BigDecimal;

public class HardDriveDTO extends ProductDTO {
    private Integer capacity;

	public HardDriveDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, Integer quantity,
			Integer capacity2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.capacity = capacity2;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
}

