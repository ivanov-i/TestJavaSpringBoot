package com.example.demo.dto;

import java.math.BigDecimal;

public class LaptopDTO extends ProductDTO {
    private Double size;

	public LaptopDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, int quantity, Double size2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.size = size2;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}
}

