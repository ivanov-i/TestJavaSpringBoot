package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Desktop;
import com.example.demo.entities.HardDrive;
import com.example.demo.entities.Laptop;
import com.example.demo.entities.Monitor;
import com.example.demo.entities.Product;
import com.example.demo.repositories.DesktopRepository;
import com.example.demo.repositories.HardDriveRepository;
import com.example.demo.repositories.LaptopRepository;
import com.example.demo.repositories.MonitorRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final DesktopRepository desktopRepository;
    private final LaptopRepository laptopRepository;
    private final MonitorRepository monitorRepository;
    private final HardDriveRepository hardDriveRepository;

    // constructor
    public ProductService(ProductRepository productRepository, 
                          DesktopRepository desktopRepository, 
                          LaptopRepository laptopRepository, 
                          MonitorRepository monitorRepository, 
                          HardDriveRepository hardDriveRepository) {
        this.productRepository = productRepository;
        this.desktopRepository = desktopRepository;
        this.laptopRepository = laptopRepository;
        this.monitorRepository = monitorRepository;
        this.hardDriveRepository = hardDriveRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Desktop> getAllDesktops() {
        return desktopRepository.findAll();
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public List<Monitor> getAllMonitors() {
        return monitorRepository.findAll();
    }

    public List<HardDrive> getAllHardDrives() {
        return hardDriveRepository.findAll();
    }
}

