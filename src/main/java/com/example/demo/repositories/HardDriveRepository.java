package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.HardDrive;

public interface HardDriveRepository extends JpaRepository<HardDrive, Long> {
    // Define custom query methods if needed
}

