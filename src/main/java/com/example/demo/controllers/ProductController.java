package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping("/laptops")
	public ResponseEntity<?> createLaptop(@RequestBody Laptop newLaptop) {
		try {
			var result = productService.createLaptop(newLaptop);
			return ResponseEntity.ok(convertToDTO(result));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/monitors")
	public ResponseEntity<?> createMonitor(@RequestBody Monitor newMonitor) {
		try {
			var result = productService.createMonitor(newMonitor);
			return ResponseEntity.ok(convertToDTO(result));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/hdds")
	public ResponseEntity<?> createHardDrive(@RequestBody HardDrive newHardDrive) {
		try {
			var result = productService.createHardDrive(newHardDrive);
			return ResponseEntity.ok(convertToDTO(result));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/desktops/{id}")
	public ResponseEntity<?> updateDesktop(@PathVariable Long id, @RequestBody Desktop newDesktop) {
		try {
			var result = productService.updateDesktop(id, newDesktop);
			return result
				.<ResponseEntity<?>>map(desktop -> ResponseEntity.ok(convertToDTO(desktop)))
			.orElseGet(() -> new ResponseEntity<>("Desktop with id " + id + " was not found.", HttpStatus.NOT_FOUND));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/laptops/{id}")
	public ResponseEntity<?> updateLaptop(@PathVariable Long id, @RequestBody Laptop newLaptop) {
		try {
			var result = productService.updateLaptop(id, newLaptop);
			return result
				.<ResponseEntity<?>>map(laptop -> ResponseEntity.ok(convertToDTO(laptop)))
			.orElseGet(() -> new ResponseEntity<>("Laptop with id " + id + " was not found.", HttpStatus.NOT_FOUND));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/monitors/{id}")
	public ResponseEntity<?> updateMonitor(@PathVariable Long id, @RequestBody Monitor newMonitor) {
		try {
			var result = productService.updateMonitor(id, newMonitor);
			return result
				.<ResponseEntity<?>>map(monitor -> ResponseEntity.ok(convertToDTO(monitor)))
			.orElseGet(() -> new ResponseEntity<>("Monitor with id " + id + " was not found.", HttpStatus.NOT_FOUND));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/hdds/{id}")
	public ResponseEntity<?> updateHardDrive(@PathVariable Long id, @RequestBody HardDrive newHardDrive) {
		try {
			var result = productService.updateHardDrive(id, newHardDrive);
			return result
				.<ResponseEntity<?>>map(hardDrive -> ResponseEntity.ok(convertToDTO(hardDrive)))
			.orElseGet(() -> new ResponseEntity<>("Hard drive with id " + id + " was not found.", HttpStatus.NOT_FOUND));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		return productService.deleteProductById(id)
			? ResponseEntity.ok().build()
			: ResponseEntity.notFound().build();
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

