package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Laptop extends Product {

    @Column(name = "size")
    private Double size;

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

}
