package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Monitor extends Product {
	@Column(name = "diagonal")
    private Double diagonal;

	public Double getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(Double diagonal) {
		this.diagonal = diagonal;
	}
}
