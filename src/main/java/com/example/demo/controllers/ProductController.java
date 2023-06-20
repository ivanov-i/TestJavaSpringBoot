package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ProductService;
import com.example.demo.dto.DesktopDTO;
import com.example.demo.dto.HardDriveDTO;
import com.example.demo.dto.LaptopDTO;
import com.example.demo.dto.MonitorDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Desktop;
import com.example.demo.entities.HardDrive;
import com.example.demo.entities.Laptop;
import com.example.demo.entities.Monitor;
import com.example.demo.entities.Product;

@RestController
public class ProductController {
    
    private final ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return productService
			.getProductById(id)
			.map(this::convertToDTO)
			.<ResponseEntity<?>>map(dto -> ResponseEntity.ok(dto))
			.orElseGet(() -> new ResponseEntity<>("Product with id " + id + " was not found.", HttpStatus.NOT_FOUND));
	}

    private ProductDTO convertToDTO(Product product) {
        if (product instanceof Desktop) {
            Desktop desktop = (Desktop) product;
            return new DesktopDTO(desktop.getId(), desktop.getSerialNumber(), desktop.getManufacturer(), 
                    desktop.getPrice(), desktop.getQuantity(), desktop.getFormFactor());
        } else if (product instanceof Laptop) {
            Laptop laptop = (Laptop) product;
            return new LaptopDTO(laptop.getId(), laptop.getSerialNumber(), laptop.getManufacturer(),
                    laptop.getPrice(), laptop.getQuantity(), laptop.getSize());
        } else if (product instanceof Monitor) {
            Monitor monitor = (Monitor) product;
            return new MonitorDTO(monitor.getId(), monitor.getSerialNumber(), monitor.getManufacturer(),
                    monitor.getPrice(), monitor.getQuantity(), monitor.getDiagonal());
        } else if (product instanceof HardDrive) {
            HardDrive hardDrive = (HardDrive) product;
            return new HardDriveDTO(hardDrive.getId(), hardDrive.getSerialNumber(), hardDrive.getManufacturer(),
                    hardDrive.getPrice(), hardDrive.getQuantity(), hardDrive.getCapacity());
        }
        
        // Return null or throw an exception if needed
        return null;
    }
}

