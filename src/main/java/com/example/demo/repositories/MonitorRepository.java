package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    // Define custom query methods if needed
}
