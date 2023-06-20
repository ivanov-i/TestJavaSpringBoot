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

	public Desktop createDesktop(Desktop desktop) {
		if (desktop.getId() != null) {
			throw new IllegalArgumentException("New desktop should not have an ID");
		}
		return desktopRepository.save(desktop);
	}

	public Laptop createLaptop(Laptop laptop) {
		if (laptop.getId() != null) {
			throw new IllegalArgumentException("New laptop should not have an ID");
		}
		return laptopRepository.save(laptop);
	}

	public Monitor createMonitor(Monitor monitor) {
		if (monitor.getId() != null) {
			throw new IllegalArgumentException("New monitor should not have an ID");
		}
		return monitorRepository.save(monitor);
	}

	public HardDrive createHardDrive(HardDrive hardDrive) {
		if (hardDrive.getId() != null) {
			throw new IllegalArgumentException("New hard drive should not have an ID");
		}
		return hardDriveRepository.save(hardDrive);
	}

	public Desktop updateDesktop(Long id, Desktop newDesktop) {
		Desktop desktop = desktopRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid desktop ID: " + id));

		desktop = (Desktop) updateProduct(id, newDesktop);

		var newFormFactor = newDesktop.getFormFactor();
		if(newFormFactor != null)
		{
			desktop.setFormFactor(newFormFactor);
		}
		return desktopRepository.save(desktop);
	}

	public Laptop updateLaptop(Long id, Laptop newLaptop) {
		Laptop laptop = laptopRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid laptop ID: " + id));

		laptop = (Laptop) updateProduct(id, newLaptop);

		var newSize = newLaptop.getSize();
		if(newSize != null)
		{
			laptop.setSize(newSize);
		}
		return laptopRepository.save(laptop);
	}

	public Monitor updateMonitor(Long id, Monitor newMonitor) {
		Monitor monitor = monitorRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid monitor ID: " + id));

		monitor = (Monitor) updateProduct(id, newMonitor);

		var newDiagonal = newMonitor.getDiagonal();
		if(newDiagonal != null)
		{
			monitor.setDiagonal(newDiagonal);
		}
		return monitorRepository.save(monitor);
	}

	public HardDrive updateHardDrive(Long id, HardDrive newHardDrive) {
		HardDrive hardDrive = hardDriveRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid hard drive ID: " + id));

		hardDrive = (HardDrive) updateProduct(id, newHardDrive);

		var newCapacity = newHardDrive.getCapacity();
		if(newCapacity != null)
		{
			hardDrive.setCapacity(newCapacity);
		}
		return hardDriveRepository.save(hardDrive);
	}

	private Product updateProduct(Long id, Product newProduct) {
		Product product = productRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));

		var newSerialNumber = newProduct.getSerialNumber();
		if(newSerialNumber != null)
		{
			product.setSerialNumber(newSerialNumber);
		}

		var newManufacturer = newProduct.getManufacturer();
		if(newManufacturer != null)
		{
			product.setManufacturer(newManufacturer);
		}

		var newPrice = newProduct.getPrice();
		if(newPrice != null)
		{
			product.setPrice(newPrice);
		}

		var newQuantity = newProduct.getQuantity();
		if(newQuantity != null)
		{
			product.setQuantity(newQuantity);
		}
		return productRepository.save(product);
	}
}

