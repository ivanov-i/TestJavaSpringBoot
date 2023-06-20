package com.example.demo.entities;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "monitors")
public class Monitor extends Product {
    private double diagonal;
}
