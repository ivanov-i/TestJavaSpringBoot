package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Desktop extends Product {

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DesktopFormFactor formFactor;

	public DesktopFormFactor getFormFactor() {
		return formFactor;
	}

	public void setType(DesktopFormFactor formFactor) {
		this.formFactor = formFactor;
	}
}
