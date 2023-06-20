package com.example.demo.dto;

import java.math.BigDecimal;

public class MonitorDTO extends ProductDTO {
    private Double diagonal;

	public MonitorDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, int quantity,
			Double diagonal2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.diagonal = diagonal2;
	}

	public Double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(Double diagonal) {
		this.diagonal = diagonal;
	}
}
