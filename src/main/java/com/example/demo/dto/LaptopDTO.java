package com.example.demo.dto;

import java.math.BigDecimal;

public class LaptopDTO extends ProductDTO {
    private int size;

	public LaptopDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, int quantity, int size2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.size = size2;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

