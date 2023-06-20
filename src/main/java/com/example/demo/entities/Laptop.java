package com.example.demo.entities;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "laptops")
public class Laptop extends Product {
    private int size;
}
