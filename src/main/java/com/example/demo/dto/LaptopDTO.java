package com.example.demo.dto;

import java.math.BigDecimal;

public class LaptopDTO extends ProductDTO {
    private double size;

	public LaptopDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, int quantity, double size2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.size = size2;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}
}

