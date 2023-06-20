package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class HardDrive extends Product {
	@Column(name = "capacity")
    private Integer capacity;

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
}

