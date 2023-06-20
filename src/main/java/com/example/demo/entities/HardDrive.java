package com.example.demo.entities;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "hard_drives")
public class HardDrive extends Product {
    private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}

