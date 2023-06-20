package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return productService.getAllProducts()
			.stream()
			.map(this::convertToDTO)
			.collect(Collectors.toList());
    }

    @GetMapping("/desktops")
    public List<DesktopDTO> getAllDesktops() {
		return productService
			.getAllDesktops()
			.stream()
			.map(this::convertToDTO)
			.collect(Collectors.toList());
    }

    @GetMapping("/laptops")
    public List<LaptopDTO> getAllLaptops() {
		return productService
			.getAllLaptops()
			.stream()
			.map(this::convertToDTO)
			.collect(Collectors.toList());
    }

    @GetMapping("/monitors")
    public List<MonitorDTO> getAllMonitors() {
		return productService
			.getAllMonitors()
			.stream()
			.map(this::convertToDTO)
			.collect(Collectors.toList());
    }

    @GetMapping("/hdds")
    public List<HardDriveDTO> getAllHardDrives() {
		return productService.getAllHardDrives()
			.stream()
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

	@PostMapping("/desktops")
	public ResponseEntity<?> createDesktop(@RequestBody Desktop newDesktop) {
		try {
			var result = productService.createDesktop(newDesktop);
			return ResponseEntity.ok(convertToDTO(result));
		    } catch (IllegalArgumentException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	}

    private ProductDTO convertToDTO(Product product) {
        if (product instanceof Desktop) {
            Desktop desktop = (Desktop) product;
            return convertToDTO(desktop);
        } else if (product instanceof Laptop) {
            Laptop laptop = (Laptop) product;
            return convertToDTO(laptop);
        } else if (product instanceof Monitor) {
            Monitor monitor = (Monitor) product;
			return convertToDTO(monitor);
        } else if (product instanceof HardDrive) {
            HardDrive hardDrive = (HardDrive) product;
			return convertToDTO(hardDrive);
        }
        
        return null;
    }
	private DesktopDTO convertToDTO(Desktop desktop) {
            return new DesktopDTO(desktop.getId(), desktop.getSerialNumber(), desktop.getManufacturer(), 
                    desktop.getPrice(), desktop.getQuantity(), desktop.getFormFactor());
	}
	private LaptopDTO convertToDTO(Laptop laptop) {
			return new LaptopDTO(laptop.getId(), laptop.getSerialNumber(), laptop.getManufacturer(), 
					laptop.getPrice(), laptop.getQuantity(), laptop.getSize());
	}
	private HardDriveDTO convertToDTO(HardDrive hardDrive) {
			return new HardDriveDTO(hardDrive.getId(), hardDrive.getSerialNumber(), hardDrive.getManufacturer(), 
					hardDrive.getPrice(), hardDrive.getQuantity(), hardDrive.getCapacity());
	}
	private MonitorDTO convertToDTO(Monitor monitor) {
			return new MonitorDTO(monitor.getId(), monitor.getSerialNumber(), monitor.getManufacturer(), 
					monitor.getPrice(), monitor.getQuantity(), monitor.getDiagonal());
	}
}

