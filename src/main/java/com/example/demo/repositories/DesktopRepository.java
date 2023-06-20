package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Desktop;

public interface DesktopRepository extends JpaRepository<Desktop, Long> {
    // Define custom query methods if needed
}
