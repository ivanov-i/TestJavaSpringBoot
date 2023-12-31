package com.example.demo.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = DesktopDTO.class, name = "desktop"),
    @JsonSubTypes.Type(value = LaptopDTO.class, name = "laptop"),
    @JsonSubTypes.Type(value = MonitorDTO.class, name = "monitor"),
    @JsonSubTypes.Type(value = HardDriveDTO.class, name = "hard_drive")
})

public class ProductDTO {
    private Long id;
    private String serialNumber;
    private String manufacturer;
    private BigDecimal price;
    private int quantity;
	public ProductDTO(Long id2, String serialNumber2, String manufacturer2, BigDecimal price2, int quantity2) {
		this.id = id2;
		this.serialNumber = serialNumber2;
		this.manufacturer = manufacturer2;
		this.price = price2;
		this.quantity = quantity2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}


