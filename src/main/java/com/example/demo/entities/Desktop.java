package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "desktops")
public class Desktop extends Product {
    private String formFactor;
}
