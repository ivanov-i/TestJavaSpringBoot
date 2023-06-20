package com.example.demo.dto;

import java.math.BigDecimal;

public class MonitorDTO extends ProductDTO {
    private double diagonal;

	public MonitorDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, int quantity,
			double diagonal2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.diagonal = diagonal2;
	}

	public double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}
}
