package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Laptop extends Product {

    @Column(name = "size")
    private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
