package com.example.demo.dto;

import java.math.BigDecimal;

public class DesktopDTO extends ProductDTO {
    private String formFactor;

	public DesktopDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, int quantity,
			String formFactor2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.formFactor = formFactor2;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}
}
