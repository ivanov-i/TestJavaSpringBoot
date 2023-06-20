package com.example.demo.dto;

import java.math.BigDecimal;
import com.example.demo.entities.DesktopFormFactor;

public class DesktopDTO extends ProductDTO {
    private DesktopFormFactor formFactor;

	public DesktopDTO(Long id, String serialNumber, String manufacturer, BigDecimal price, int quantity,
			DesktopFormFactor formFactor2) {
		super(id, serialNumber, manufacturer, price, quantity);
		this.formFactor = formFactor2;
	}

	public DesktopFormFactor getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(DesktopFormFactor formFactor) {
		this.formFactor = formFactor;
	}
}
